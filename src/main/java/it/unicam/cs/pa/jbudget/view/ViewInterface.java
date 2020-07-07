package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.App;
import it.unicam.cs.pa.jbudget.Controller;
import it.unicam.cs.pa.jbudget.saver.LoadInterface;
import it.unicam.cs.pa.jbudget.saver.SaverInterface;

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
    void printLoad(LoadInterface save, App app);
    void addTransaction();
    void rmTransaction();
    void addTag();
    void rmTag();    //todo: getTag(string)
    void addBudget();
    void rmBudget();
    void printCommands(TreeSet set);
    void printState();
    void rmMovement();
    /*todo: questo metodo stampa ogni volta che si esegue un comando lo stato del ledge e budget manager,
       quindi gli account e reports, come la "home" dell'app su smartphone pe capisse*/

    //TODO edit acc,trans,tag,budget
}
