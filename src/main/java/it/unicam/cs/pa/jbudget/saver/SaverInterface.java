package it.unicam.cs.pa.jbudget.saver;

import it.unicam.cs.pa.jbudget.Controller;
/**Questa interfaccia definisce i metodi della classe saver, che si occupera' della gestione dei dati in memoria
 * con le funzioni di salvataggio e caricamento di questi */
public interface SaverInterface {


    Controller loadController();

    void saveController(String s, Controller controller);

    boolean checkSave();
}
