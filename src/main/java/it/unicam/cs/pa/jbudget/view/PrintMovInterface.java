package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.Controller;
import it.unicam.cs.pa.jbudget.model.MovementInterface;

/**Questa interfaccia definisce i metodi che deve andare ad implementare la relativa view quando si sta creando
 * un movimento all'interno di una transazione */
public interface PrintMovInterface {

    void printMovement(MovementInterface m );
    MovementInterface addMovement(Controller controller);
    MovementInterface rmMovement(Controller controller);
}
