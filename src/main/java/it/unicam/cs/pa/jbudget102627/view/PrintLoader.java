package it.unicam.cs.pa.jbudget102627.view;

import it.unicam.cs.pa.jbudget102627.Controller;
import it.unicam.cs.pa.jbudget102627.saver.LoadInterface;

import java.io.IOException;

/**
 * responsabile di guidare l'utente nel caricamento dei dati.
 */
public class PrintLoader extends Printer implements PrintLoaderInterface {

    @Override
    public Controller load(LoadInterface load) throws IOException {
        String path;
        Controller c;
        try {
            System.out.println("\nInsert the path of the directory to load : ");
            path = returnLine();
        } catch (IOException e) {
            System.out.println("\nInserted Path is not valid!");
            return null;
        }
        System.out.println("\nLooking for data on the disk...");
        if (load.checkSave(path)) {
            System.out.println("\nSave found! I am loading the previous data..");
            c = load.loadController(path);
            System.out.println("\nAll done! ");
            return c;
        } else {
            System.out.println("\nI am sorry.. i didn't found anything :(");
            return null;
        }
    }
}
