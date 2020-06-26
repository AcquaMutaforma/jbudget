package it.unicam.cs.pa.jbudget.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    public List<TransactionInterface> getTransactions(Predicate<TransactionInterface> p) {
        return getTransactions().stream().filter(p).collect(Collectors.toList());
    }

    @Override
    public List<TagInterface> getTags() {return this.taglist; }

    @Override
    public List<AccountInterface> getAccounts() {return this.accountlist; }

    @Override
    public List<ScheduledInterface> getScheduled() {return this.scheduledlist; }

    @Override
    public List<ScheduledInterface> getScheduled(Predicate<ScheduledInterface> p) {
        return getScheduled().stream().filter(p).collect(Collectors.toList());
    }

    @Override
    public void addTransaction(TransactionInterface t) {
        //todo update per scheduled, check if it really works
        if(t.getMovements().isEmpty())
            throw new NullPointerException("transazione senza movimenti"); //todo logger ?
        if(!getTransactions().contains(t)) {
            if(t.getDate().isAfter(LocalDate.now())){
                addTransactionToScheduled(t);
            }else {
                this.translist.add(t);
                for (MovementInterface m : t.getMovements()) {
                    m.getAccount().addMovement(m);
                }
            }
        }
    }

    @Override
    public boolean rmTransaction(TransactionInterface t) {
        //todo update per scheduled
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
    public void addTag(TagInterface c) {
        if(!getTags().contains(c))
            this.taglist.add(c);
    }

    @Override
    public boolean rmTag(TagInterface t) {
        //todo update per scheduled
        if(getTags().contains(t)){
            for(TransactionInterface tra : getTransactions()){
                tra.rmTag(t);
            }
            this.taglist.remove(t);
            return true;
        }else
            return false;
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
    public boolean rmAccount(AccountInterface a) {
        //TODO non sono sicuro che funzioni al 100%
        //todo update per scheduled
        if (getAccounts().contains(a)) {
            if(getTransactions().isEmpty()) {
                this.accountlist.remove(a);
                return true;
            }
            for (TransactionInterface tra : getTransactions()) {
                tra.rmMovement(x -> x.getAccount().equals(a));
                if(tra.getMovements().isEmpty())
                    rmTransaction(tra);
            }
            return true;
        }
        return false;
    }

    //se la data di oggi e' > di scheduled.getdate allora inserisco le transazioni e la cancello
    @Override
    public void checkScheduled(){

    }
    @Override
    public void addScheduled(ScheduledInterface st) {
        if(!getScheduled().contains(st))
            getScheduled().add(st);
    }

    @Override
    public boolean rmScheduled(ScheduledInterface st) {
        if(getScheduled().contains(st)) {
            getScheduled().remove(st);
            return true;
        }
        return false;
    }

    private void addTransactionToScheduled(TransactionInterface t){
        /*TODO ho fatto un casino con le responsabilità, chi si deve occupare di inserire
           le transazioni dentro le scheduled ? e chi deve aggiungere nuovi scheduled ?
           l'utente crea lo scheduled o lo crea il sistema ?*/
        List<ScheduledInterface> l = getScheduled(x -> x.getDate() == t.getDate());
        if(!l.isEmpty()) {
            l.get(1).addTransaction(t);
        }else{
            ScheduledInterface s = new Scheduled(t.getDate());
            s.addTransaction(t);
            addScheduled(s);
        }
    }

}
