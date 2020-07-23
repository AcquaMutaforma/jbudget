package it.unicam.cs.pa.jbudget102627.ledge;

import java.time.LocalDate;
import java.util.List;

public interface TransactionInterface {

    //getters
    int getId();
    List<Integer> getTags();
    LocalDate getDate();
    List<Integer> getMovements();

    //setters
    void setId(int id);
    void setTags(List<Integer> l);
    void setDate(LocalDate d);

    //other
    double getTotalAmount();
    void addTag(TagInterface c);
    boolean rmTag(TagInterface c);
    void addMovement(MovementInterface m);
    boolean rmMovement(MovementInterface m);

    void addTag(int c);
    boolean rmTag(int c);



}
