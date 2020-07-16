package it.unicam.cs.pa.jbudget102627.view;

import it.unicam.cs.pa.jbudget102627.Controller;
import it.unicam.cs.pa.jbudget102627.ledge.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class PrintMovement extends Printer implements PrintMovInterface{
    @Override
    public void printMovement(MovementInterface m) {
        System.out.println("\n | Movement -- id: "+m.getId()+" motivation: "+m.getMotivation()
        +" type: "+m.getType()+" value:"+m.getValue()+" date: "+m.getDate());
    }

    @Override
    public MovementInterface addMovement(Controller controller, LocalDate date, List<TagInterface> tags){
        double value;
        String motiv;
        MovementType type = null;
        AccountInterface acc;

        System.out.println("\nAdding a new Movement..");
        try{
            System.out.println("\nInsert the motivation :");
            motiv = returnLine();
            System.out.println("\nInsert the value :");
            value = Double.parseDouble(returnLine());
            System.out.println("\nInsert the type, credit or debit [c/d] :");
            String typechar = returnLine().toLowerCase();
            if(typechar.equals("c")){
                type = MovementType.CREDIT;
            }
            if(typechar.equals("d")){
                type = MovementType.DEBIT;
            }
            System.out.println("\nInsert the id of the Account for this movement :");
            acc = controller.getAccount(Integer.parseInt(returnLine()));
        }catch (IOException e){
            return null;
        }
        if(tags == null || date == null || acc == null || type == null)
            return null;
        int id = controller.generateIDof("movement");
        MovementInterface m = new Movement(id,value,motiv,type,tags,date,acc);
        printMovement(m);
        return m;
    }

    @Override
    public MovementInterface rmMovement(Controller controller) {
        System.out.println("\nRemoving a Movement..");
        try{
            System.out.println("\nInsert the ID of the Movement to remove : ");
            int id = Integer.parseInt(returnLine());
            MovementInterface a = controller.getMovement(id);
            return a;
        }catch (IOException e){
            System.out.println("\nMovement with the insert id was not found..");
            return null;
        }
    }

    @Override
    public void printMovementOf(Controller controller) {
        System.out.println("\nInsert the id of the Account :");
        try {
            AccountInterface acc = controller.getAccount(Integer.parseInt(returnLine()));
            if (acc.getMovements().isEmpty())
                System.out.println("\nNo Movements in this account...");
            System.out.print("\n-- Movements -------------------------------");
            for (MovementInterface mov : acc.getMovements()) {
                printMovement(mov);
            }
            System.out.print("\n--------------------------------------------");
        }catch (IOException e){
            System.out.print("\nAccount not found...");
        }
    }
}