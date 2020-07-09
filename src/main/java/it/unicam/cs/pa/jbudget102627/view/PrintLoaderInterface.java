package it.unicam.cs.pa.jbudget102627.view;

import it.unicam.cs.pa.jbudget102627.Controller;
import it.unicam.cs.pa.jbudget102627.saver.LoadInterface;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface PrintLoaderInterface {

    Controller load(LoadInterface load) throws IOException;
}
