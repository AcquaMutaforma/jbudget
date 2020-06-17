package it.unicam.cs.pa.jbudget.controller;

import it.unicam.cs.pa.jbudget.model.Ledge;
import it.unicam.cs.pa.jbudget.view.*;
import it.unicam.cs.pa.jbudget.service.*;

public class Controller<T extends ViewInterface,K extends Ledge> {

    private Ledge ledge;
    private ViewInterface view;
    private BgtManager bgtManager;

    public Controller(ViewInterface vi, Ledge l){
        this.ledge = l;
        this.view = vi;
        this.bgtManager = new BudgetManager();
    }

}
