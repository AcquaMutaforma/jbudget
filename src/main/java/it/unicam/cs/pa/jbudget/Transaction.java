package it.unicam.cs.pa.jbudget;

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
            for(MovementInterface mi : getMovements()){
                mi.addTag(c);
            }
        }
    }

    public void addTag(List<Category> lt) {
        for(Category c : lt){
            addTag(c);
        }
    }

    @Override
    public boolean rmTag(Category c) {
        if(getTags().contains(c)){
            getTags().remove(c);
            for(MovementInterface mi : getMovements()){
                mi.rmTag(c);
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void addMovement(MovementInterface m) {
        //TODO modificare balance
        if(!getMovements().contains(m)){
            getMovements().add(m);
            for(Category c: m.getTags()){
                addTag(c);
            }
        }
    }

    @Override
    public boolean rmMovement(MovementInterface m) {
        //TODO modificare balance
        if(getMovements().contains(m)){
            this.movList.remove(m);
            this.tagList = new ArrayList<Category>();
            for(MovementInterface mi : getMovements()){
                addTag(mi.getTags());
                //TODO
                /*
                in questo modo la transazione cancella e "riappara" tutti i tag dei movimenti

                 */
            }
            return true;
        }else{
            return false;
        }
    }


    //TODO ma va bene o viene considerato copia incolla ?
    //TODO ci sono anche ---> addTag/Mov && rmTag/rmMov

}
