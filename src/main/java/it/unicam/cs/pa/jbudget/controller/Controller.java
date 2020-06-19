package it.unicam.cs.pa.jbudget.controller;

import it.unicam.cs.pa.jbudget.model.*;
import it.unicam.cs.pa.jbudget.view.*;
import it.unicam.cs.pa.jbudget.service.*;

import java.io.*;
import java.util.Hashtable;
import java.util.function.Consumer;

public class Controller{

    private LedgeInterface ledge;
    private ViewInterface view;
    private BgtManager bgtManager;

    private Hashtable<String, Consumer<? extends LedgeInterface>> commands;

    public Controller(LedgeInterface l, ViewInterface vi){
        this.ledge = l;
        this.view = vi;
        this.bgtManager = new BudgetManager();
    }

    public static void main(String[] args) {

        PrintStream output = new PrintStream(System.out);
        LedgeInterface l = new Ledge();
        ViewInterface vi = new ViewCli(input,output,output);
        Controller controller = new Controller(l,vi);

    }

}
