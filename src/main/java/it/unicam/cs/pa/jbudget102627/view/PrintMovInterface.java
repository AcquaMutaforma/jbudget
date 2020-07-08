package it.unicam.cs.pa.jbudget102627.view;

import it.unicam.cs.pa.jbudget102627.Controller;
import it.unicam.cs.pa.jbudget102627.ledge.MovementInterface;
import it.unicam.cs.pa.jbudget102627.ledge.TagInterface;

import java.time.LocalDate;
import java.util.List;

/**Questa interfaccia definisce i metodi che deve andare ad implementare la relativa view quando si sta creando
 * un movimento all'interno di una transazione */
public interface PrintMovInterface {

    void printMovement(MovementInterface m );
    MovementInterface addMovement(Controller controller, LocalDate date, List<TagInterface> tags);
    MovementInterface rmMovement(Controller controller);
}
