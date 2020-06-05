package it.unicam.cs.pa.jbudget;

import java.util.List;

public interface Asset {

    //getters
    int getId();
    double getBalance();
    double getOpeningBalance();
    String getName();
    String getDescription();
    List<Movement> getMovements(); //TODO List<Movement> getMovements(Predicate<Movement> p);

    //setters
    //TODO

}
