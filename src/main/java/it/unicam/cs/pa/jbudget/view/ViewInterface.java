package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.Controller;

import java.io.IOException;
import java.util.function.Consumer;

public interface ViewInterface {

    //output generici
    void printHello();
    void printGoodbye();
    void printCommands();
    void printState(Controller controller);
    /*todo: questo metodo stampa ogni volta che si esegue un comando lo stato del ledge e budget manager,
       quindi gli account e reports, come la "home" dell'app su smartphone pe capisse*/

    String getCommand();

    void addAccount(Controller controller);
    void rmAccount(Controller controller);


}
