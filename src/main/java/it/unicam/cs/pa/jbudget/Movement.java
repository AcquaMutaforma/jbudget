package it.unicam.cs.pa.jbudget;

import java.time.LocalDate;
import java.util.List;

public interface Movement {

    //getters
    int getId();
    String getMotivation();
    double getValue();
    TypeOfMovement getType();
    List<Category> getTags();
    LocalDate getDate();
    Asset getAsset();

    //setters
    //TODO
}