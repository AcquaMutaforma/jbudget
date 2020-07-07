package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.Controller;
import it.unicam.cs.pa.jbudget.saver.LoadInterface;

public interface PrintLoaderInterface {

    Controller load(LoadInterface load);
}
