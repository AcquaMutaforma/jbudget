package it.unicam.cs.pa.jbudget;

import java.util.List;

public interface Account {

    //getters
    int getId();
    double getBalance();
    double getOpeningBalance();
    String getName();
    String getDescription();
    List<Movement> getMovements();
    AccountType getType();
    //List<Movement> getMovements(Predicate<Movement> p); //TODO fuori interfaccia

    //setters
    //void setId(); meglio di no
    void setOpeningBalance(double ob);
    void setName(String n);
    void setDescription(String d);
    void setType(AccountType at);

    //Specific methods
    void addMovement(Movement m);
    boolean rmMovement(Movement m);
    //boolean rmMovement(int id); //TODO fuori interfaccia
}
