package it.unicam.cs.pa.jbudget.model;

import java.util.List;
import java.util.function.Predicate;

public interface AccountInterface {

    //getters
    int getId();
    double getBalance();
    double getOpeningBalance();
    String getName();
    String getDescription();
    List<MovementInterface> getMovements();
    AccountType getType();

    //setters
    void setOpeningBalance(double ob);
    void setName(String n);
    void setDescription(String d);

    //Specific methods
    void addMovement(MovementInterface m);
    boolean rmMovement(MovementInterface m);
    List<MovementInterface> getMovements(Predicate<MovementInterface> p);
}
