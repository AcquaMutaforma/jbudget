package it.unicam.cs.pa.jbudget102627.ledge;

import java.time.LocalDate;
import java.util.List;

public interface MovementInterface {

    //getters
    int getId();
    String getMotivation();
    double getValue();
    MovementType getType();
    List<Integer> getTags();
    LocalDate getDate();
    int getAccountId();

    //setters
    void setMotivation(String m);
    void setValue(double d);
    void setType(MovementType mt);
    void setTags(List<Integer> l);
    void setDate(LocalDate d);
    void setAccount(AccountInterface a);

    void addTag(TagInterface c);
    boolean rmTag(TagInterface c);
    void addTag(int c);
    boolean rmTag(int c);

}