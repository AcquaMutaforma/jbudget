package it.unicam.cs.pa.jbudget102627.budget;

import it.unicam.cs.pa.jbudget102627.ledge.TagInterface;
import it.unicam.cs.pa.jbudget102627.ledge.TransactionInterface;

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
