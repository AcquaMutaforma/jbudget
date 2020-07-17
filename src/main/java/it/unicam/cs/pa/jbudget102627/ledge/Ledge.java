package it.unicam.cs.pa.jbudget102627.ledge;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ledge implements LedgeInterface{


    private final List<TransactionInterface> translist;
    private final List<TagInterface> taglist;
    private final List<AccountInterface> accountlist;
    private final List<ScheduledInterface> scheduledlist;
    private final List<MovementInterface> movlist;

    public Ledge(){
        this.translist = new ArrayList<>();
        this.taglist = new ArrayList<>();
        this.accountlist = new ArrayList<>();
        this.scheduledlist = new ArrayList<>();
        this.movlist = new ArrayList<>();
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
    public List<MovementInterface> getMovements() {
        return this.movlist;
    }

    @Override
    public void addTransaction(TransactionInterface t) {
        if(t.getMovements().isEmpty())
            throw new NullPointerException("transazione senza movimenti"); //todo logger ?
        if(!getTransactions().contains(t)) {
            if(t.getDate().isAfter(LocalDate.now())){
                addTransactionToScheduled(t);
            }else {
                this.translist.add(t);
                for (int m : t.getMovements()) {
                    MovementInterface mov = getMovement(m);
                    getAccount(mov.getAccountId()).addMovement(mov);
                }
            }
        }
    }

    @Override
    public boolean rmTransaction(TransactionInterface t) {
        if(getTransactions().contains(t)){
            if (!t.getMovements().isEmpty()) {
                for (int mov : t.getMovements()) {
                    MovementInterface m = getMovement(mov);
                    getAccount(m.getAccountId()).rmMovement(m);
                    this.movlist.remove(mov);
                }
            }
            this.translist.remove(t);
            return true;
        }
        if(!getScheduled().isEmpty()){
            for(ScheduledInterface sched : getScheduled()){
                sched.rmTransaction(t);
            }
            return true;
        }
        return false;
    }

    @Override
    public void addTag(TagInterface c) {
        if(getTags().contains(c))
            return;
        if(getTag(c.getName()) != null)
            return;
        this.taglist.add(c);
    }

    @Override
    public boolean rmTag(TagInterface t) {
        if(getTags().contains(t)){
            for(TransactionInterface tra : getTransactions()){
                tra.rmTag(t);
            }
            for(ScheduledInterface sched : getScheduled()){
                for(TransactionInterface tra : sched.getTransactions()){
                    tra.rmTag(t);
                }
            }
            for(MovementInterface mov : this.movlist){
                mov.rmTag(t);
            }
            this.taglist.remove(t);
            return true;
        }else
            return false;
    }

    @Override
    public void addAccount(AccountInterface a) {
        if(getAccounts().contains(a))
            return;
        if(getAccount(a.getName()) != null)
            return;
        this.accountlist.add(a);
    }
    @Override
    public boolean rmAccount(AccountInterface a) {
        if (getAccounts().contains(a)) {
            this.accountlist.remove(a);
            for(int mov : a.getMovements()){
                for(TransactionInterface tra : getTransactions()){
                    tra.rmMovement(getMovement(mov));
                    if(tra.getMovements().isEmpty())
                        rmTransaction(tra);
                }
                for(ScheduledInterface sched : getScheduled()){
                    for(TransactionInterface tra2 : sched.getTransactions()){
                        tra2.rmMovement(getMovement(mov));
                        if(tra2.getMovements().isEmpty())
                            sched.addTransaction(tra2);
                    }
                }
            }
            return true;
        }
        return false;
    }

    //se la data di oggi e' > di scheduled.getdate allora inserisco le transazioni e la cancello
    //TODO inserirla nel controller !!
    @Override
    public void checkScheduled(){
        if(getScheduled().isEmpty())
            return;
        for(ScheduledInterface s : getScheduled(x -> x.getDate().isBefore(LocalDate.now().plusDays(1)))){
            for(TransactionInterface t : s.getTransactions()){
                addTransaction(t);
                s.rmTransaction(t);
                if(s.isComplete())
                    rmScheduled(s);
            }
        }
    }

    @Override
    public boolean addMovement(MovementInterface m) {
        if(!movlist.contains(m)){
            this.movlist.add(m);
            getAccount(m.getAccountId()).addMovement(m);
            return true;
        }
        return false;
    }

    @Override
    public boolean rmMovement(MovementInterface m) {
        for(TransactionInterface tra: getTransactions()){
            if(tra.getMovements().contains(m.getId())) {
                tra.rmMovement(m);
                getAccount(m.getAccountId()).rmMovement(m);
                this.movlist.remove(m);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<TransactionInterface> getScheduledTransactions() {
        List<TransactionInterface> list = new ArrayList<>();
        for(ScheduledInterface sched : getScheduled()){
            list.addAll(sched.getTransactions());
        }
        return list;
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

    @Override
    public AccountInterface getAccount(int id) {
        for(AccountInterface a: getAccounts()){
            if(a.getId() == id)
                return a;
        }
        return null;
    }

    @Override
    public TransactionInterface getTransaction(int id) {
        for(TransactionInterface t: getTransactions()){
            if(t.getId() == id)
                return t;
        }
        return null;
    }

    @Override
    public TagInterface getTag(int id) {
        for(TagInterface t: getTags()){
            if(t.getId() == id)
                return t;
        }
        return null;
    }

    @Override
    public MovementInterface getMovement(int id) {
        for(MovementInterface mov : getMovements()){
            if(mov.getId() == id)
                return mov;
        }
        return null;
    }

    @Override
    public AccountInterface getAccount(String s) {
        AccountInterface acc = null;
        for(AccountInterface a : getAccounts()){
            if(a.getName().toLowerCase().equals(s.toLowerCase())) {
                acc = a;
                break;
            }
        }
        return acc;
    }

    @Override
    public TagInterface getTag(String s) {
        TagInterface tag = null;
        for(TagInterface t : getTags()){
            if(t.getName().toLowerCase().equals(s.toLowerCase())){
                tag = t;
            }
        }
        return tag;
    }

    @Override
    public ArrayList<Period> generatePeriod() {
        //TODO "list is always empty"
        ArrayList<Period> list = new ArrayList<>();
        for(TransactionInterface tra : getTransactions()){
            if(list.isEmpty()) {
                list.add(new Period(tra.getDate().getYear(), tra.getDate().getMonthValue(), tra.getTotalAmount()));
            }
            for(Period p : list){
                if(tra.getDate().getYear() == p.getYear() && tra.getDate().getMonthValue() == p.getMonth())
                    p.addValue(tra.getTotalAmount());
                else
                    list.add(new Period(tra.getDate().getYear(),tra.getDate().getMonthValue(),tra.getTotalAmount()));
            }
        }
        return list;
    }

    private void addTransactionToScheduled(TransactionInterface t){
        List<ScheduledInterface> l = getScheduled(x -> x.getDate() == t.getDate());
        if(!l.isEmpty()) {
            l.get(0).addTransaction(t);
        }else{
            ScheduledInterface s = new Scheduled(t.getDate());
            s.addTransaction(t);
            addScheduled(s);
        }
    }

}
