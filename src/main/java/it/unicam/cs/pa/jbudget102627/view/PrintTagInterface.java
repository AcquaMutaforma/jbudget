package it.unicam.cs.pa.jbudget102627.view;

import it.unicam.cs.pa.jbudget102627.Controller;
import it.unicam.cs.pa.jbudget102627.ledge.TagInterface;

public interface PrintTagInterface {

    void printTag(TagInterface t);
    TagInterface addTag(Controller controller);
    TagInterface rmTag(Controller controller);
}
