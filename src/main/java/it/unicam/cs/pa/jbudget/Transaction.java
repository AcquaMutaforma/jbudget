package it.unicam.cs.pa.jbudget;

import java.time.LocalDate;
import java.util.List;

public interface Transaction {

    //getters
    int getId();
    List<Category> getTags();
    LocalDate getDate();
    List<Movement> getMovements();

    //setters
    void setId(int id);
    void setTags(List<Category> l);
    void setDate(LocalDate d);

    //other
    double getTotalAmount();
    void addTag(Category c);
    boolean rmTag(Category c);
    void addMovement(Movement m);
    boolean rmMovement(Movement m);
}
