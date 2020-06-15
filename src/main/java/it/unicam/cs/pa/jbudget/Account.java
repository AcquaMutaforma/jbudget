package it.unicam.cs.pa.jbudget;

import java.util.List;
import java.util.function.Predicate;

public class Account implements AccountInterface{
    private int id;
    private double balance;
    private double openingbalance;
    private String name;
    private String description;
    private List<MovementInterface> movlist;
    private AccountType type;

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

    @Override
    public void addMovement(MovementInterface m) {
        //inserisco il movimento e incremento il balance del valore del movimento
        //in base al tipo di account, se è ASSET sommo altrimenti sottraggo
        try{
            this.movlist.add(m);
            this.editBalance(m.getValue());
        }catch (Exception e){
            //TODO specificare l'exception, forse meglio throw ?
            System.out.println("\nErrore Account.addMovement");
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
            //TODO qua non mi piace per niente, vedi di inventarti qualcos'altro
            this.editBalance(-1 * m.getValue());
            return true;
        }catch (Exception e){
            //TODO specificare l'exception, forse meglio throw ?
            System.out.println("\nErrore Account.rmMovement");
        }
        return false;
    }

    public List<Movement> getMovements(Predicate<Movement> p){
        //TODO
        return null;
    }

    private void editBalance(double value){
        if(getType() == AccountType.ASSET){
            this.balance += value;
        }else{
            this.balance -= value;
        }
    }

}
