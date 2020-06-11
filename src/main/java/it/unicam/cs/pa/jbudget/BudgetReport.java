package it.unicam.cs.pa.jbudget;

import java.util.List;
import java.util.Map;

public interface BudgetReport {

    Map<Category,Double> getReport();
    Budget getBudget();
    List<Category> getTags();
    double getValueOf(Category c);
}
