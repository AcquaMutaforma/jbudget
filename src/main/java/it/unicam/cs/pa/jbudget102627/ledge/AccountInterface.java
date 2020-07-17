package it.unicam.cs.pa.jbudget102627.ledge;

import java.util.List;
import java.util.function.Predicate;

public interface AccountInterface {

    //getters
    int getId();
    double getBalance();
    double getOpeningBalance();
    String getName();
    String getDescription();
    List<Integer> getMovements();
    AccountType getType();

    //setters
    void setOpeningBalance(double ob);
    void setName(String n);
    void setDescription(String d);

    //Specific methods
    void addMovement(MovementInterface m);
    boolean rmMovement(MovementInterface m);

    //load needs
    void setMovements(List<MovementInterface> mov);
    void balanceToOpening();
}
