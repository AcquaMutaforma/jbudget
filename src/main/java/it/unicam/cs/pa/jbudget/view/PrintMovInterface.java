package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.Controller;
import it.unicam.cs.pa.jbudget.model.MovementInterface;
import it.unicam.cs.pa.jbudget.model.TagInterface;

import java.time.LocalDate;
import java.util.List;

/**Questa interfaccia definisce i metodi che deve andare ad implementare la relativa view quando si sta creando
 * un movimento all'interno di una transazione */
public interface PrintMovInterface {

    void printMovement(MovementInterface m );
    MovementInterface addMovement(Controller controller, LocalDate date, List<TagInterface> tags);
    MovementInterface rmMovement(Controller controller);
}
