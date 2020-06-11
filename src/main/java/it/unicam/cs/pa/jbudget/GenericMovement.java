package it.unicam.cs.pa.jbudget;

import java.time.LocalDate;
import java.util.List;

public class GenericMovement implements Movement{

    private int id;
    private double value;
    private String motivation;
    private MovementType type;
    private List<Category> tagList;
    private LocalDate date;
    private Account account;

    public GenericMovement(int i, double val,String motiv,MovementType mt,
                           List<Category> category, LocalDate ld,Account a ){
        setId(i);
        setValue(val);
        setMotivation(motiv);
        setType(mt);
        setTags(category);
        setDate(ld);
        setAccount(a);
    }

    @Override
    public int getId() {return this.id;}

    @Override
    public String getMotivation() {return this.motivation;}

    @Override
    public double getValue() {return this.value;}

    @Override
    public MovementType getType() {return this.type;}

    @Override
    public List<Category> getTags() {return this.tagList;}

    @Override
    public LocalDate getDate() {return this.date;}

    @Override
    public Account getAccount() {return this.account;}

    @Override
    public void setId(int id) {this.id = id;}

    @Override
    public void setMotivation(String m) {this.motivation = m;    }

    @Override
    public void setValue(double d) {this.value = d;}

    @Override
    public void setType(MovementType mt) {this.type = mt;}

    @Override
    public void setTags(List<Category> l) {this.tagList = l;}

    @Override
    public void setDate(LocalDate d) {this.date = d;}

    @Override
    public void setAccount(Account a) {this.account = a;}
}
