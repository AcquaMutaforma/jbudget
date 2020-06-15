package it.unicam.cs.pa.jbudget;

import java.time.LocalDate;
import java.util.List;

public class Transaction implements TransactionInterface {

    private int id;
    private List<Category> tagList;
    private LocalDate date;
    private List<MovementInterface> movList;
    private double balance;

    @Override
    public int getId() { return this.id;}

    @Override
    public List<Category> getTags() {return this.tagList;}

    @Override
    public LocalDate getDate() {return this.date;}

    @Override
    public List<MovementInterface> getMovements() {return this.movList;}

    @Override
    public void setId(int id) {this.id = id;}

    @Override
    public void setTags(List<Category> l) {this.tagList = l;}

    @Override
    public void setDate(LocalDate d) {this.date = d;}

    @Override
    public double getTotalAmount() {return this.balance;}

    @Override
    public void addTag(Category c) {
        if(!contains(c))
            this.tagList.add(c);
    }

    @Override
    public boolean rmTag(Category c) {
        if(contains(c)){
            this.tagList.remove(c);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void addMovement(MovementInterface m) {
        if(!this.contains(m))
            this.movList.add(m);
    }

    @Override
    public boolean rmMovement(MovementInterface m) {
        if(contains(m)){
            this.movList.remove(m);
            return true;
        }else{
            return false;
        }
    }

    //TODO ma va bene o viene considerato copia incolla ?
    //TODO ci sono anche ---> addTag/Mov && rmTag/rmMov
    public boolean contains(Category c){
        return this.tagList.contains(c);
    }

    public boolean contains(MovementInterface m){
        return this.movList.contains(m);
    }
}
