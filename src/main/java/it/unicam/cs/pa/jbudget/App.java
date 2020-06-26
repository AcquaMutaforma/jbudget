package it.unicam.cs.pa.jbudget;

import it.unicam.cs.pa.jbudget.model.*;
import it.unicam.cs.pa.jbudget.saver.*;
import it.unicam.cs.pa.jbudget.view.*;
import it.unicam.cs.pa.jbudget.budget.*;

import java.util.Map;
import java.util.function.Consumer;

public class App{

    private LedgeInterface ledge;
    private ViewInterface view;
    private BudgetMInterface budgetManager;
    private IDManager idmanager;
    private SaverInterface saver;

    private Map<String, Consumer<? extends LedgeInterface>> commands;

    public App(LedgeInterface l, ViewInterface vi, SaverInterface s){
        this.ledge = l;
        this.view = vi;
        this.budgetManager = new BudgetManager();
        this.idmanager = new IDManager();
        this.saver = s;
    }

    public static void main(String[] args) {

    }

}