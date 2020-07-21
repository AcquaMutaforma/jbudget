package it.unicam.cs.pa.jbudget102627.budget;

import it.unicam.cs.pa.jbudget102627.ledge.TagInterface;

import java.util.List;
import java.util.Map;

/**
 * definisce le azioni di un budget
 * @author Pallotta Alessandro - 102627
 */
public interface BudgetInterface {

    String getName();
    int getId();
    List<Integer> getTags();
    double getValueOf(TagInterface c);
    double getValueOf(int c);
    void set(int c, double expected);
    Map<Integer, Double> getMap();
    List<Integer> getFilter();

}
