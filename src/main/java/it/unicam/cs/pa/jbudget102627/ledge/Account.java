package it.unicam.cs.pa.jbudget102627.ledge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Ha la responsabilita' di rappresentare un conto in modo generico, cosi' da utilizzarlo per
 * diversi scopi, come un portafogli o un prestito in banca.
 */
public class Account implements AccountInterface{

    private final int id;
    private double balance;
    private double openingbalance;
    private String name;
    private String description;
    private final AccountType type;
    private List<Integer> movlist;

    public Account(int id,double ob,String n, String desc,AccountType at){
        this.id = id;
        setOpeningBalance(ob);
        setName(n);
        setDescription(desc);
        this.type = at;
        this.movlist = new ArrayList<>();
        this.balance = this.openingbalance;
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
    public List<Integer> getMovements() {return this.movlist; }

    @Override
    public AccountType getType() {return this.type;}

    @Override
    public void setOpeningBalance(double ob) { this.openingbalance = ob;}

    @Override
    public void setName(String n) {this.name = n; }

    @Override
    public void setDescription(String d) {this.description = d;    }

    @Override
    public void balanceToOpening() {
        this.balance = openingbalance;
    }

    /**
     * questo metodo aggiunge un movimento all'account ne modifica il bilancio tramite editBalance
     * @param m movimento che andremo ad inserire
     */
    @Override
    public void addMovement(MovementInterface m) {
        if(!getMovements().contains(m.getId())) {
            this.movlist.add(m.getId());
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
        if(!getMovements().contains(m.getId()))
            return false;
        getMovements().remove(m.getId());
        this.editBalance(m,false);
        return true;
    }

    @Override
    public void setMovements(List<MovementInterface> mov) {
        List<Integer> mlist = new ArrayList<>();
        for(MovementInterface m : mov){
            mlist.add(m.getId());
        }
        this.movlist = mlist;
    }

    /**
     * metodo per la modifica del bilancio invocato da addMovement e rmMovement
     * @param m movimento legato all'azione di add o remove
     * @param aor AddOrRemove, true se sto aggiungendo il movimento, false se lo sto eliminando
     */
    private void editBalance(MovementInterface m,boolean aor){
        if(((getType() == AccountType.ASSET)&&(m.getType() == MovementType.CREDIT)) ||
                (getType() == AccountType.LIABILITIES)&&(m.getType() == MovementType.DEBIT)) {
            if (aor) {
                this.balance += m.getValue();
            } else {
                this.balance -= m.getValue();
            }
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