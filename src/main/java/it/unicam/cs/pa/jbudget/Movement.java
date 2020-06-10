package it.unicam.cs.pa.jbudget;

import java.time.LocalDate;
import java.util.List;

public interface Movement {

    //getters
    int getId();
    String getMotivation();
    double getValue();
    MovementType getType();
    List<Category> getTags();
    LocalDate getDate();
    Account getAccount();

    //setters
    void setId(int id);
    void setMotivation(String m);
    void setValue(double d);
    void setType(MovementType mt);
    void setTags(List<Category> l);
    void setDate(LocalDate d);
    void setAccount(Account a);

}