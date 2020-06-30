package it.unicam.cs.pa.jbudget.budget;

import it.unicam.cs.pa.jbudget.model.TagInterface;
import it.unicam.cs.pa.jbudget.model.TransactionInterface;

import java.util.List;
import java.util.Map;

public interface BReportInterface {

    int getId();
    String getName();
    Map<TagInterface,Double> getReport();
    BudgetInterface getBudget();
    List<TagInterface> getTags();
    double getValueOf(TagInterface c);
    void addTransaction(TransactionInterface tra);
    boolean rmTransaction(TransactionInterface tra);

}
