package it.unicam.cs.pa.jbudget102627.ledge;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Transaction implements TransactionInterface {

    private int id;
    private List<Integer> tagList;
    private LocalDate date;
    private final List<Integer> movList;
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
    public List<Integer> getTags() {return this.tagList;}

    @Override
    public LocalDate getDate() {return this.date;}

    @Override
    public List<Integer> getMovements() {return this.movList;}

    @Override
    public void setId(int id) {this.id = id;}

    @Override
    public void setTags(List<Integer> l) {  this.tagList = l;}

    @Override
    public void setDate(LocalDate d) {this.date = d;}

    @Override
    public double getTotalAmount() {return this.balance;}

    @Override
    public void addTag(TagInterface c) {
        if(!getTags().contains(c.getId())) {
            getTags().add(c.getId());
        }
    }

    public void addTag(List<Integer> lt) {
        for(int c : lt){
            addTag(c);
        }
    }

    @Override
    public boolean rmTag(TagInterface c) {
        if(getTags().contains(c.getId())){
            getTags().remove(c.getId());
            return true;
        }else{
            return false;
        }
    }

    /*todo: il ledge si deve occupare di farlo, perche non ne è responsabile
    private void fixTags(){
        if(getMovements().isEmpty() || getTags().isEmpty())
            return;
        for(MovementInterface mi : getMovements()){
            mi.setTags(getTags());
        }
    }
    */

    @Override
    public void addMovement(MovementInterface m) {
        if(!getMovements().contains(m.getId())){
            getMovements().add(m.getId());
            addTag(m.getTags());
            editBalance(m,true);
        }
    }

    @Override
    public boolean rmMovement(MovementInterface m) {
        if(getMovements().contains(m.getId())){
            this.movList.remove(m.getId());
            editBalance(m,false);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void addTag(int c) {
        if(!this.tagList.contains(c))
            this.tagList.add(c);
    }

    @Override
    public boolean rmTag(int c) {
        if(this.tagList.contains(c)){
            this.tagList.remove(c);
            return true;
        }
        return false;
    }
/*
    @Override
    public void addMovement(int m) {
        if(!this.movList.contains(m))
            this.movList.add(m);
    }

    @Override
    public boolean rmMovement(int m) {
        if(this.movList.contains(m)){
            this.movList.remove(m);
            return true;
        }
        return false;
    }

 */

    private void editBalance(MovementInterface m, boolean aor){
        if((m.getType() == MovementType.CREDIT && aor) ||
                (m.getType() == MovementType.DEBIT && !aor)){
            this.balance += m.getValue();
        }else
            this.balance -= m.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
