package it.unicam.cs.pa.jbudget102627.view;

import it.unicam.cs.pa.jbudget102627.App;
import it.unicam.cs.pa.jbudget102627.Controller;
import it.unicam.cs.pa.jbudget102627.saver.LoadInterface;
import it.unicam.cs.pa.jbudget102627.saver.SaverInterface;

import java.io.IOException;
import java.util.TreeSet;

public interface ViewInterface {

    void setController(Controller c);

    //output generici
    void printHello();
    void printGoodbye();

    String getCommand();
    void printTutorial();

    //I/O comandi controller
    void addAccount();
    void rmAccount();
    void printSave(SaverInterface save);
    void printLoad(LoadInterface save, App app) throws IOException;
    void addTransaction();
    void rmTransaction();
    void addTag();
    void rmTag();
    void addBudget();
    void rmBudget();
    void printCommands(TreeSet<String> set);
    void printState();
    void rmMovement();

    void printPeriodList();
    void getTransactions();
    void getScheduled( );
    void getAllMovements();
    void getMovementsOf( ) throws IOException;
    void newPrestito( );

    void checkScheduleds();
}
