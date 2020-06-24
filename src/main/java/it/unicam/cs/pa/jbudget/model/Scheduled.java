package it.unicam.cs.pa.jbudget.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Scheduled implements ScheduledInterface{

    private List<TransactionInterface> translist;
    private LocalDate date;

    public Scheduled(LocalDate date) {
        this.date = date;
        this.translist = new ArrayList<>();
    }

    @Override
    public LocalDate getDate() {return this.date;}

    @Override
    public List<TransactionInterface> getTransactions() {return this.translist; }

    @Override
    public void setDate(LocalDate ld) {this.date = ld;}

    @Override
    public void addTransaction(TransactionInterface t) {
        if(!translist.contains(t) && t.getDate().equals(getDate()))
            this.translist.add(t);
    }

    @Override
    public boolean rmTransaction(TransactionInterface t) {
        if(!getTransactions().contains(t))
            return false;
        this.translist.remove(t);
        return true;
    }

    @Override
    public boolean isComplete() {
        return this.translist.isEmpty();
    }
}
