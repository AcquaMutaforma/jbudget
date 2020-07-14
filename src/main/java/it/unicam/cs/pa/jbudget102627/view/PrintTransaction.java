package it.unicam.cs.pa.jbudget102627.view;

import it.unicam.cs.pa.jbudget102627.Controller;
import it.unicam.cs.pa.jbudget102627.ledge.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrintTransaction extends Printer implements PrintTransInterface{
    @Override
    public void printTransaction(TransactionInterface tra) {
        PrintMovInterface printmov = new PrintMovement();
        PrintTagInterface printtag = new PrintTag();
        System.out.println("\nTransaction -- id: "+tra.getId()+" date:"+tra.getDate()+"----");
        for(TagInterface t: tra.getTags()){
            System.out.println("\nWith tags: ");
            printtag.printTag(t);
        }
        for(MovementInterface mov : tra.getMovements()){
            printmov.printMovement(mov);
        }
        System.out.println("\n-------------------------------------------------------");
    }

    @Override
    public TransactionInterface addTransaction(Controller controller) {
        TransactionInterface tra;
        PrintTagInterface printTag = new PrintTag();
        PrintMovInterface printMovement = new PrintMovement();
        List<TagInterface> taglist = new ArrayList<>();
        List<MovementInterface> movlist = new ArrayList<>();
        LocalDate date;

        System.out.println("\nAdding a new Transaction..");
        try{
            System.out.println("\nInsert the date [yyyy-mm-dd] :");
            date = LocalDate.parse(returnLine());
            System.out.println("\nHow much tags do you want to add ? :");
            int contatore = Integer.parseInt(returnLine());
            for(TagInterface tag : controller.getTags()){
                printTag.printTag(tag);
            }
            for(int i = 0; i < contatore; i++){
                System.out.println("\nInsert the id of the tag:");
                int t = Integer.parseInt(returnLine());
                taglist.add(controller.getTag(t));
            }
            System.out.println("\nHow much movements do you want to add ? :");
            contatore = Integer.parseInt(returnLine());
            for(int i = 0; i < contatore; i++){
                movlist.add(printMovement.addMovement(controller,date,taglist));
            }
        }catch (IOException e){
            return null;
        }
        int id = controller.generateIDof("transaction");
        tra = new Transaction(id,date);
        tra.setTags(taglist);
        for(MovementInterface mov : movlist){
            tra.addMovement(mov);
        }
        return tra;
    }

    @Override
    public TransactionInterface rmTransaction(Controller controller) {
        System.out.println("\nRemoving a Transaction..");
        try{
            System.out.println("\nInsert the ID of the Transaction to remove : ");
            int id = Integer.parseInt(returnLine());
            TransactionInterface a = controller.getTransaction(id);
            return a;
        }catch (IOException e){
            System.out.println("\nTransaction with the insert id was not found..");
            return null;
        }
    }
}