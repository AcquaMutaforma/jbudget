package it.unicam.cs.pa.jbudget;

import java.util.List;

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
    void setType(AccountType at);

    //Specific methods
    void addMovement(MovementInterface m);
    boolean rmMovement(MovementInterface m);
}
