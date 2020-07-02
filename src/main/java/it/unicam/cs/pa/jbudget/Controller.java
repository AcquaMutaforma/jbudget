package it.unicam.cs.pa.jbudget;

import it.unicam.cs.pa.jbudget.budget.BManagerInterface;
import it.unicam.cs.pa.jbudget.budget.BReportInterface;
import it.unicam.cs.pa.jbudget.budget.BudgetInterface;
import it.unicam.cs.pa.jbudget.model.*;

import java.util.List;
import java.util.function.Predicate;

public class Controller {


    private final LedgeInterface ledge;
    private final BManagerInterface budgetManager;
    private final IdManagerInterface idmanager;

    public Controller(LedgeInterface l, BManagerInterface bm, IdManagerInterface idm) {
        /*TODO appunto: saver cerca di caricare i dati, ovvero questi signori qui sopra,
           altrimenti il main crea un controller con new l, new bm, new idm */
        this.ledge = l;
        this.budgetManager = bm;
        this.idmanager = idm;
    }

    //TODO la view si occupa di prendere input e creare oggetti per poi passarli al controller
    /*TODO il main crea i comandi<Controller> x-> x.addTransaction(t) che vengono chiamati da view,
       perche ricevo da input un comando e in base al comando il main chiama controller o view
       mica posso usare lo switch >_<  */

    public void addTransaction(TransactionInterface tra){
        this.ledge.addTransaction(tra);
        //TODO fix: ledge scarta le transazioni sbagliate, il budget manager ?
        this.budgetManager.aorTransaction(tra,true);
    }

    public boolean rmTransaction(TransactionInterface tra){
        if(this.ledge.rmTransaction(tra)){
            this.budgetManager.aorTransaction(tra,false);
            return true;
        }else{
            return false;
        }
    }

    public void addAccount(AccountInterface a){ this.ledge.addAccount(a);  }
    public boolean rmAccount(AccountInterface a){ return this.ledge.rmAccount(a);    }
    public void addTag(TagInterface t){ this.ledge.addTag(t); }
    public boolean rmTag(TagInterface t){ return this.ledge.rmTag(t); }
    public void addBudget(BudgetInterface b){
        /*TODO note: la view crea il budget e fa inserire all'utente i vari tag e valori
        *  il controller si occupa solamente di inserirlo nel manager e creare il suo report*/
        this.budgetManager.addBudget(b);
        this.budgetManager.generateReport(generateIDof("report"),b,this.ledge);
    }
    public boolean rmReportAndBudget(BReportInterface r){
        if(this.budgetManager.rmReport(r)){
            this.budgetManager.rmBudget(r.getBudget());
            return true;
        }else{
            return false;
        }
    }

    public int generateIDof(String s){ return this.idmanager.generateIdOf(s); }

    //Getters
    //TODO fa comodo anche un getSingleX() cosi la view non deve lavorare con le liste ma solo con i singoli oggetti
    public List<AccountInterface> getAccounts(){
        return this.ledge.getAccounts();
    }

    public List<TransactionInterface> getTransactions(){
        return this.ledge.getTransactions();
    }

    public List<TransactionInterface> getTransactions(Predicate<TransactionInterface> p){
        return this.ledge.getTransactions(p);
    }

    public List<TransactionInterface> getScheduledTransactions(){
        return this.ledge.getScheduledTransactions();
    }

    public List<BReportInterface> getReports(){
        return this.budgetManager.getReports();
    }

    public List<TagInterface> getTags(){  return this.ledge.getTags();  }

    public List<MovementInterface> getMovementsOf(AccountInterface a){
        return a.getMovements();
    }

    //TODO EDIT section (budget.set account.setname tag.setname etc..

}
