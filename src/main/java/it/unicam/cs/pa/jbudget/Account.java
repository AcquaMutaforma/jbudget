package it.unicam.cs.pa.jbudget;

import java.util.List;
/**
 * Questa interfaccia descrive gli asset come la cassa e il conto corrente
 * */
public interface Account {

    //getters
    int getId();
    double getBalance();
    double getOpeningBalance();
    String getName();
    String getDescription();
    List<Movement> getMovements();
    //TODO List<Movement> getMovements(Predicate<Movement> p);

    //setters
    //void setId(); meglio di no
    //void setBalance(); NOPE
    void setOpeningBalance(double ob);
    void setName(String n);
    void setDescription(String d);

    //Specific methods
    void addMovement(Movement m);
    boolean rmMovement(Movement m);
    boolean rmMovement(int id);
}
