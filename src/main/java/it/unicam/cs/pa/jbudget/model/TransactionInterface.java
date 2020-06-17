package it.unicam.cs.pa.jbudget.model;

import java.time.LocalDate;
import java.util.List;

public interface TransactionInterface {

    //getters
    int getId();
    List<Category> getTags();
    LocalDate getDate();
    List<MovementInterface> getMovements();

    //setters
    void setId(int id);
    void setTags(List<Category> l);
    void setDate(LocalDate d);

    //other
    double getTotalAmount();
    void addTag(Category c);
    boolean rmTag(Category c);
    void addMovement(MovementInterface m);
    boolean rmMovement(MovementInterface m);
}
