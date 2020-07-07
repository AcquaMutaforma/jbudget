package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.Controller;
import it.unicam.cs.pa.jbudget.saver.LoadInterface;

import java.io.IOException;

public class PrintLoader extends Printer implements PrintLoaderInterface {

    @Override
    public Controller load(LoadInterface load){
        String path = "";
        Controller c = null;
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
        } else {
            System.out.println("\nI am sorry.. i didn't found anything :(");
            return null;
        }
        return c;
    }
}
