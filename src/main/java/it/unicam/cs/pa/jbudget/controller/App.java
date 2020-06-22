package it.unicam.cs.pa.jbudget.controller;

import it.unicam.cs.pa.jbudget.model.*;
import it.unicam.cs.pa.jbudget.saver.SaverInterface;
import it.unicam.cs.pa.jbudget.view.*;
import it.unicam.cs.pa.jbudget.budget.*;

import java.util.Hashtable;
import java.util.function.Consumer;

public class App{

    private LedgeInterface ledge;
    private ViewInterface view;
    private BgtManager bgtManager;
    private IdManager idmanager;
    //private SaverInterface saver;

    private Hashtable<String, Consumer<? extends LedgeInterface>> commands;

    public App(LedgeInterface l, ViewInterface vi, SaverInterface s){
        this.ledge = l;
        this.view = vi;
        this.bgtManager = new BudgetManager();
        this.idmanager = new IdManager();
        //this.saver = s;
    }

    public static void main(String[] args) {
    }

}
