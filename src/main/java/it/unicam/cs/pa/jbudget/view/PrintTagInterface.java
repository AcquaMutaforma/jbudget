package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.Controller;
import it.unicam.cs.pa.jbudget.model.TagInterface;

public interface PrintTagInterface {

    void printTag(TagInterface t);
    TagInterface addTag(Controller controller);
    TagInterface rmTag(Controller controller);
}
