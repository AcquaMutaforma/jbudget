package it.unicam.cs.pa.jbudget102627.view;

import it.unicam.cs.pa.jbudget102627.Controller;
import it.unicam.cs.pa.jbudget102627.budget.BReportInterface;
import it.unicam.cs.pa.jbudget102627.budget.BudgetInterface;

public interface PrintBReportInterface {

    void printReport(BReportInterface report, Controller controller);
    BudgetInterface addBudget(Controller controller);
    BReportInterface rmBudget(Controller controller);

}
