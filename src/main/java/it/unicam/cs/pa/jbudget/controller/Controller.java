package it.unicam.cs.pa.jbudget.controller;

import it.unicam.cs.pa.jbudget.model.LedgeInterface;
import it.unicam.cs.pa.jbudget.service.BudgetManager;
import it.unicam.cs.pa.jbudget.view.ViewInterface;
import it.unicam.cs.pa.jbudget.service.BgtManager;

public class Controller<T extends ViewInterface,K extends LedgeInterface> {

    private LedgeInterface ledge;
    private ViewInterface view;
    private BgtManager bgtManager;

    public Controller(LedgeInterface l, ViewInterface vi){
        this.ledge = l;
        this.view = vi;
        this.bgtManager = new BudgetManager();
    }

}
