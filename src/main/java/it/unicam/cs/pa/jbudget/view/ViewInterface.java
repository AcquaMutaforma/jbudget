package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.model.LedgeInterface;

public interface ViewInterface {

    //output generici
    void printHello();
    void printGoodbye();
    void printCommands();

    String getCommand();

    //input

    //generic methods
    //<T extends LedgeInterface> void start(T l);

}
