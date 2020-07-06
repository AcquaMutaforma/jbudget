package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.Controller;
import it.unicam.cs.pa.jbudget.model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class PrintMovement extends Printer implements PrintMovInterface{
    @Override
    public void printMovement(MovementInterface m) {
        System.out.println("\n | Movement -- id: "+m.getId()+" motivation: "+m.getMotivation()
        +" type: "+m.getType()+" value:"+m.getValue());
    }

    @Override
    public MovementInterface addMovement(Controller controller, LocalDate date, List<TagInterface> tags){
        double value = 0.0;
        String motiv = "";
        MovementType type = null;
        AccountInterface acc = null;

        System.out.println("\nAdding a new Movement..");
        MovementInterface mov = null;
        try{
            System.out.println("\nInsert the motivation :");
            motiv = returnLine();
            System.out.println("\nInsert the value :");
            value = Double.parseDouble(returnLine());
            System.out.println("\nInsert the type [c/d] :");
            String typechar = returnLine();
            if(typechar == "c"){
                type = MovementType.CREDIT;
            }
            if(typechar == "d"){
                type = MovementType.DEBIT;
            }
            System.out.println("\nInsert the id of the Account for this movement :");
            acc = controller.getAccount(Integer.parseInt(returnLine()));
        }catch (IOException e){
            return null;
        }
        int id = controller.generateIDof("movement");
        if(tags == null || date == null || acc == null )
            return null;
        return new Movement(id,value,motiv,type,tags,date,acc);
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
}