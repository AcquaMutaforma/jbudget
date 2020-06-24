package it.unicam.cs.pa.jbudget.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Account implements AccountInterface{

    private final int id;
    private double balance;
    private double openingbalance;
    private String name;
    private String description;
    private List<MovementInterface> movlist;
    private final AccountType type;

    public Account(int id,double ob,String n, String desc,AccountType at){
        this.id = id;
        setOpeningBalance(ob);
        setName(n);
        setDescription(desc);
        this.type = at;
        this.movlist = new ArrayList<>();
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

    /**
     * questo metodo aggiunge un movimento all'account ne modifica il bilancio tramite editBalance
     * @param m movimento che andremo ad inserire
     */
    @Override
    public void addMovement(MovementInterface m) {
        if(!getMovements().contains(m)) {
            this.movlist.add(m);
            this.editBalance(m,true);
        }
    }

    /**
     * questo metodo verifica la presenza del movimento, se presente verra' rimosso e il bilancio
     * verra' aggiornato tramite editBalance()
     * @param m movimento da rimuovere dall'account
     * @return false se non e' presente il movimento , true se e' presente
     */
    @Override
    public boolean rmMovement(MovementInterface m) {
        if(!getMovements().contains(m))
            return false;
        getMovements().remove(m);
        this.editBalance(m,false);
        return true;
    }

    @Override
    public List<MovementInterface> getMovements(Predicate<MovementInterface> p){
        return getMovements().stream().filter(p).collect(Collectors.toList());
    }

    /**
     * metodo per la modifica del bilancio invocato da addMovement e rmMovement
     * @param m movimento legato all'azione di add o remove
     * @param aor AddOrRemove, true se sto aggiungendo il movimento, false se lo sto eliminando
     */
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

}