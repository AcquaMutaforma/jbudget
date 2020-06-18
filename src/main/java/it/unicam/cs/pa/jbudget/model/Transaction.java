package it.unicam.cs.pa.jbudget.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Transaction implements TransactionInterface {

    private int id;
    private List<TagInterface> tagList;
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
    public List<TagInterface> getTags() {return this.tagList;}

    @Override
    public LocalDate getDate() {return this.date;}

    @Override
    public List<MovementInterface> getMovements() {return this.movList;}

    @Override
    public void setId(int id) {this.id = id;}

    @Override
    public void setTags(List<TagInterface> l) {this.tagList = l;}

    @Override
    public void setDate(LocalDate d) {this.date = d;}

    @Override
    public double getTotalAmount() {return this.balance;}

    @Override
    public void addTag(TagInterface c) {
        if(!getTags().contains(c)) {
            getTags().add(c);
            fixTags();
        }
    }

    public void addTag(List<TagInterface> lt) {
        for(TagInterface c : lt){
            addTag(c);
            fixTags();
        }
    }

    @Override
    public boolean rmTag(TagInterface c) {
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
            this.tagList = new ArrayList<TagInterface>();
            for(MovementInterface mi : getMovements()){
                addTag(mi.getTags());
            }
            editBalance(m,false);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean rmMovement(Predicate<MovementInterface> p){
        //TODO forse il try-catch è un po forzato, pensaci meglio
        boolean alo = false;
        try{
            for(MovementInterface mov : getMovements()){
                if(p.test(mov)) {
                    rmMovement(mov);
                    alo = true;
                }
            }
        }catch (Exception e){
            //TODO
        }finally {
            return alo;
        }
    }

    private void editBalance(MovementInterface m, boolean aor){
        if(m.getType() == MovementType.CREDIT && aor ||
                m.getType() == MovementType.DEBIT && !aor){
            this.balance += m.getValue();
        }else
            this.balance -= m.getValue();
    }
 //TODO check equals e hashcode di questo, movement, account, tag
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
