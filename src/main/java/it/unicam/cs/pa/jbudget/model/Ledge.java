package it.unicam.cs.pa.jbudget.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ledge implements LedgeInterface{


    private List<TransactionInterface> translist;
    private List<TagInterface> taglist;
    private List<AccountInterface> accountlist;
    private List<ScheduledInterface> scheduledlist;

    public Ledge(){
        this.translist = new ArrayList<>();
        this.taglist = new ArrayList<>();
        this.accountlist = new ArrayList<>();
        this.scheduledlist = new ArrayList<>();

    }

    @Override
    public List<TransactionInterface> getTransactions() { return this.translist; }

    @Override
    public List<Transaction> getTransactions(Predicate<Transaction> p) {
        //TODO
        return null;
    }

    @Override
    public List<TagInterface> getTags() {return this.taglist; }

    @Override
    public List<AccountInterface> getAccounts() {return this.accountlist; }

    @Override
    public List<ScheduledInterface> getScheduledTransactions() {return this.scheduledlist; }

    @Override
    public void addTransaction(TransactionInterface t) {
        if(!getTransactions().contains(t))
            this.translist.add(t);
    }

    @Override
    public void addTag(TagInterface c) {
        if(!getTags().contains(c))
            this.taglist.add(c);
    }

    @Override
    public void addAccount(AccountInterface a) {
        if(!getAccounts().contains(a))
            this.accountlist.add(a);
        //todo forse serve un throw ? o semplicemente non lo aggiungo ?
        //magari controllo dalla view se i nomi non sono uguali, in quel caso risponde subito
        //senza passare per il controller e model
    }

    @Override
    public void addScheduledTransaction(ScheduledInterface st) {
        //TODO
    }

    /*
    TODO vedi se è corretto
    per ogni movimento, se stesso chiama l'account collegato e si rimuove
    poi cancello la transazione */
    @Override
    public boolean rmTransaction(TransactionInterface t) {
        if(getTransactions().contains(t)){
            if (!t.getMovements().isEmpty()) {
                for (MovementInterface mov : t.getMovements()) {
                    mov.getAccount().rmMovement(mov);
                }
            }
            this.translist.remove(t);
            return true;
        }else
            return false;
    }

    @Override
    public boolean rmTag(TagInterface c) {
        if(getTags().contains(c)){
            for(TransactionInterface tra : getTransactions()){
                tra.rmTag(c);
            }
            return true;
        }else
            return false;
    }

    @Override
    public boolean rmAccount(AccountInterface a) {
        //TODO non sono sicuro che funzioni al 100%
        if (getAccounts().contains(a)) {
            boolean alo = false;
            for (TransactionInterface tra : getTransactions()) {
                alo = tra.rmMovement(x -> x.getAccount().equals(a));
            }
            return alo;
        }
        return false;
    }

    @Override
    public boolean rmScheduledTransaction(ScheduledInterface st) {
        //TODO
        return false;
    }
}
