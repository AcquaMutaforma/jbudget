package it.unicam.cs.pa.jbudget102627.budget;

import it.unicam.cs.pa.jbudget102627.ledge.TagInterface;
import it.unicam.cs.pa.jbudget102627.ledge.TransactionInterface;

import java.util.List;
import java.util.Map;

/**
 * definisce le azioni base di un report
 * @author Pallotta Alessandro - 102627
 */
public interface BReportInterface {

    int getId();
    String getName();
    Map<Integer,Double> getReport();
    BudgetInterface getBudget();
    List<Integer> getTags();
    double getValueOf(TagInterface c);
    double getValueOf(int c);
    void addTransaction(TransactionInterface tra);
    boolean rmTransaction(TransactionInterface tra);

}
