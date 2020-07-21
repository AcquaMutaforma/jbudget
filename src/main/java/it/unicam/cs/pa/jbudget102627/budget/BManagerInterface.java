package it.unicam.cs.pa.jbudget102627.budget;

import it.unicam.cs.pa.jbudget102627.ledge.LedgeInterface;
import it.unicam.cs.pa.jbudget102627.ledge.TransactionInterface;

import java.util.List;

/**
 * definisce i metodi necessari ad un budget manager
 * @author Pallotta Alessandro - 102627
 */
public interface BManagerInterface {

    List<BudgetInterface> getBudgets();
    List<BReportInterface> getReports();

    void addBudget(BudgetInterface b);
    boolean rmBudget(BudgetInterface b);
    void addReport(BReportInterface r);
    boolean rmReport(BReportInterface r);

    void generateReport(int id,BudgetInterface b, LedgeInterface l);
    void addTransaction(TransactionInterface tra);
    void rmTransaction(TransactionInterface tra);

    BReportInterface getReport(int id);

}
