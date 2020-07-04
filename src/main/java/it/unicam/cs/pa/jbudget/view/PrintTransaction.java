package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.Controller;
import it.unicam.cs.pa.jbudget.model.MovementInterface;
import it.unicam.cs.pa.jbudget.model.TagInterface;
import it.unicam.cs.pa.jbudget.model.TransactionInterface;

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
       //TODO
    }

    @Override
    public TransactionInterface rmTransaction(Controller controller) {
       //TODO
    }
}
