package it.unicam.cs.pa.jbudget.budget;

import it.unicam.cs.pa.jbudget.model.TagInterface;

import java.util.List;
import java.util.Map;

public interface BudgetRepInterface {

    Map<TagInterface,Double> getReport();
    BudgetInterface getBudget();
    List<TagInterface> getTags();
    double getValueOf(TagInterface c);
}
