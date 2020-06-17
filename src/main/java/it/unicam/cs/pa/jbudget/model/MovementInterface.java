package it.unicam.cs.pa.jbudget.model;

import java.time.LocalDate;
import java.util.List;

public interface MovementInterface {

    //getters
    int getId();
    String getMotivation();
    double getValue();
    MovementType getType();
    List<Category> getTags();
    LocalDate getDate();
    AccountInterface getAccount();

    //setters
    void setId(int id);
    void setMotivation(String m);
    void setValue(double d);
    void setType(MovementType mt);
    void setTags(List<Category> l);
    void setDate(LocalDate d);
    void setAccount(AccountInterface a);

    void addTag(Category c);
    boolean rmTag(Category c);

}