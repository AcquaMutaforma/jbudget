package it.unicam.cs.pa.jbudget.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Account implements AccountInterface{
    private int id;
    private double balance;
    private double openingbalance;
    private String name;
    private String description;
    private List<MovementInterface> movlist;
    private AccountType type;

    public Account(int id,double ob,String n, String desc,AccountType at){
        this.id = id;
        setOpeningBalance(ob);
        setName(n);
        setDescription(desc);
        setType(at);
        this.movlist = new ArrayList<MovementInterface>();
    }

    @Override
    public int getId() {return this.id;}

    @Override
    public double getBalance() {return this.balance;}

    @Override
    public double getOpeningBalance() {return this.openingbalance;}

    @Override
    public String getName() {return this.name;}

    @Override
    public String getDescription() {return this.description;}

    @Override
    public List<MovementInterface> getMovements() {return this.movlist; }

    @Override
    public AccountType getType() {return this.type;}

    @Override
    public void setOpeningBalance(double ob) { this.openingbalance = ob;}

    @Override
    public void setName(String n) {this.name = n; }

    @Override
    public void setDescription(String d) {this.description = d;    }

    @Override
    public void setType(AccountType at) {this.type = at;}

    //TODO equals & hashcode

    @Override
    public void addMovement(MovementInterface m) {
        //inserisco il movimento e incremento il balance del valore del movimento
        //in base al tipo di account, se è ASSET sommo altrimenti sottraggo
        if(!getMovements().contains(m)) {
            this.movlist.add(m);
            this.editBalance(m,true);
        }
    }

    @Override
    public boolean rmMovement(MovementInterface m) {
        //se non è presente il movimento ritorno false
        //idem se c'è qualche errore nell'esecuzione
        //poi lo rimuovo e scalo dal balance il valore del movimento
        if(!getMovements().contains(m))
            return false;
        try{
            getMovements().remove(m);
            this.editBalance(m,false);
            return true;
        }catch (Exception e){
            //TODO
        }
        return false;
    }

    public List<Movement> getMovements(Predicate<Movement> p){
        //TODO
        return null;
    }

    private void editBalance(MovementInterface m,boolean aor){
        if(((getType() == AccountType.ASSET)&&(m.getType() == MovementType.CREDIT) && aor) ||
                (getType() == AccountType.LIABILITIES)&&(m.getType() == MovementType.DEBIT)&&aor){
            this.balance += m.getValue();
        }else{
            this.balance -= m.getValue();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return getId() == account.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    //TODO toString
}