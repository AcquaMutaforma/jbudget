package it.unicam.cs.pa.jbudget.budget;

import it.unicam.cs.pa.jbudget.model.LedgeInterface;
import it.unicam.cs.pa.jbudget.model.TransactionInterface;

import java.util.List;

public interface BManagerInterface {

    List<BudgetInterface> getBudgets();
    List<BReportInterface> getReports();

    void addBudget(BudgetInterface b);
    boolean rmBudget(BudgetInterface b);
    void addReport(BReportInterface r);
    boolean rmReport(BReportInterface r);

    void generateReport(int id,BudgetInterface b, LedgeInterface l);
    //todo add e remove transaction ? forse un metodo con boolean o 2 metodi
    void aorTransaction(TransactionInterface tra,boolean aor);
}
