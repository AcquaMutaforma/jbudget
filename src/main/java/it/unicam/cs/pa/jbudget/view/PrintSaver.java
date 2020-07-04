package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.Controller;
import it.unicam.cs.pa.jbudget.saver.SaverInterface;

import java.io.IOException;

public class PrintSaver extends Printer implements PrintSaveInterface {

    @Override
    public void save(Controller controller, SaverInterface save) {
        if (!controller.getAccounts().isEmpty()) {
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

    @Override
    public void load (Controller controller, SaverInterface save){
        try {
            System.out.println("\nInsert the path of the directory to load : ");
            String path = returnLine();
        } catch (IOException e) {
            System.out.println("\nInserted Path is not valid!");
            return;
        }
        System.out.println("\nLooking for data on the disk...");
        if (save.checkSave()) {
            System.out.println("\nSave found! I am loading the previous data..");
            save.loadController();
            System.out.println("\nAll done! ");
        } else {
            System.out.println("\nI am sorry.. i didn't found anything :(");
        }
    }

}
