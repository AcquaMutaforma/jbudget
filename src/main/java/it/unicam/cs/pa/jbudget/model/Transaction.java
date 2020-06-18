package it.unicam.cs.pa.jbudget.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Transaction implements TransactionInterface {

    private int id;
    private List<Category> tagList;
    private LocalDate date;
    private List<MovementInterface> movList;
    private double balance;

    public Transaction(int id, LocalDate date){
        setId(id);
        setDate(date);
        this.balance = 0.0;
        tagList = new ArrayList<>();
        movList = new ArrayList<>();
    }

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
        if(!getTags().contains(c)) {
            getTags().add(c);
            fixTags();
        }
    }

    public void addTag(List<Category> lt) {
        for(Category c : lt){
            addTag(c);
            fixTags();
        }
    }

    @Override
    public boolean rmTag(Category c) {
        if(getTags().contains(c)){
            getTags().remove(c);
            fixTags();
            return true;
        }else{
            return false;
        }
    }

    private void fixTags(){
        if(getMovements().isEmpty())
            return;
        for(MovementInterface mi : getMovements()){
            mi.setTags(getTags());
        }
    }
    @Override
    public void addMovement(MovementInterface m) {
        if(!getMovements().contains(m)){
            getMovements().add(m);
            addTag(m.getTags());
            editBalance(m,true);
        }
    }

    @Override
    public boolean rmMovement(MovementInterface m) {
        if(getMovements().contains(m)){
            this.movList.remove(m);
            this.tagList = new ArrayList<Category>();
            for(MovementInterface mi : getMovements()){
                addTag(mi.getTags());
            }
            editBalance(m,false);
            return true;
        }else{
            return false;
        }
    }

    private void editBalance(MovementInterface m, boolean aor){
        if(m.getType() == MovementType.CREDIT && aor ||
                m.getType() == MovementType.DEBIT && !aor){
            this.balance += m.getValue();
        }else
            this.balance -= m.getValue();
    }

}
