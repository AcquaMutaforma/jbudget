package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.Controller;
import it.unicam.cs.pa.jbudget.budget.BReportInterface;
import it.unicam.cs.pa.jbudget.budget.BudgetInterface;

public interface PrintBReportInterface {

    void printReport(BReportInterface report);
    BudgetInterface addBudget(Controller controller);
    BudgetInterface rmBudget(Controller controller);

}
