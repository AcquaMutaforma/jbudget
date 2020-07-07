package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.Controller;
import it.unicam.cs.pa.jbudget.saver.SaverInterface;

import java.io.IOException;

public class PrintSaver extends Printer implements PrintSaveInterface {

    @Override
    public void save(Controller controller, SaverInterface save) {
        System.out.println("\nInserisci il percorso dove salvare i file : ");
        try {
            String s = returnLine();
            System.out.println("\nValid Path! I am saving the data ...");
            save.saveController(s,controller);
            System.out.println("\nSave completed!");
        } catch (IOException e) {
            System.out.println("\nInvalid Path :(");
        }
    }

}
