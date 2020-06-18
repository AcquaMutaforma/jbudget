package it.unicam.cs.pa.jbudget.service;

import it.unicam.cs.pa.jbudget.model.TagInterface;

import java.util.List;
import java.util.Map;

public interface BgtReport {

    Map<TagInterface,Double> getReport();
    BudgetInterface getBudget();
    List<TagInterface> getTags();
    double getValueOf(TagInterface c);
}
