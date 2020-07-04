package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.Controller;
import it.unicam.cs.pa.jbudget.model.MovementInterface;

public class PrintMovement extends Printer implements PrintMovInterface{
    @Override
    public void printMovement(MovementInterface m) {
        System.out.println("\n | Movement -- id: "+m.getId()+" motivation: "+m.getMotivation()
        +" type: "+m.getType()+" value:"+m.getValue());
    }

    @Override
    public MovementInterface addMovement(Controller controller) {
        //TODO
        return null;
    }

    @Override
    public MovementInterface rmMovement(Controller controller) {
        //TODO
        return null;
    }
}
