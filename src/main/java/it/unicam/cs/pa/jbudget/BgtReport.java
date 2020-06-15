package it.unicam.cs.pa.jbudget;

import java.util.List;
import java.util.Map;

public interface BgtReport {

    Map<Category,Double> getReport();
    BudgetInterface getBudget();
    List<Category> getTags();
    double getValueOf(Category c);
}
