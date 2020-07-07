package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.Controller;
import it.unicam.cs.pa.jbudget.saver.SaverInterface;

public interface PrintSaveInterface {

    void save(Controller controller, SaverInterface save);

}
