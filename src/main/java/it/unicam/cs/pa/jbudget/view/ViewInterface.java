package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

public interface ViewInterface {

    //output generici
    void printHello();
    void printGoodbye();

    String getCommand();

    //I/O comandi controller
    void addAccount();
    void rmAccount();

    void printSave();
    void addTransaction();
    void rmTransaction();
    void addTag();
    void rmTag();    //todo: getTag(string)
    void addBudget();
    void rmBudget();
    void printCommands(TreeSet set);
    void printState();
    /*todo: questo metodo stampa ogni volta che si esegue un comando lo stato del ledge e budget manager,
       quindi gli account e reports, come la "home" dell'app su smartphone pe capisse*/

    //TODO edit acc,trans,tag,budget
}
