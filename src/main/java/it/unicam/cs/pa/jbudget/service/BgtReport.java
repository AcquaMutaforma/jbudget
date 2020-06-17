package it.unicam.cs.pa.jbudget.service;

import it.unicam.cs.pa.jbudget.model.Category;

import java.util.List;
import java.util.Map;

public interface BgtReport {

    Map<Category,Double> getReport();
    BudgetInterface getBudget();
    List<Category> getTags();
    double getValueOf(Category c);
}
