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



    public void addTransaction(TransactionInterface tra){
        this.ledge.addTransaction(tra);
        //TODO fix: ledge scarta le transazioni sbagliate, il budget manager ?
        if(this.ledge.getTransaction(tra.getId()) != null)
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

    public void addAccount(AccountInterface a){ if(a != null){this.ledge.addAccount(a);}  }
    public boolean rmAccount(AccountInterface a){
        if(a != null){
            return this.ledge.rmAccount(a);
        }else{
        return false; }
    }

    public void addTag(TagInterface t){ this.ledge.addTag(t); }
    public boolean rmTag(TagInterface t){ return this.ledge.rmTag(t); }

    public void addBudget(BudgetInterface b){
        this.budgetManager.addBudget(b);
        this.budgetManager.generateReport(generateIDof("report"),b,this.ledge);
    }
    public boolean rmBudgetAndReport(BReportInterface r){
        if(this.budgetManager.rmReport(r)){
            this.budgetManager.rmBudget(r.getBudget());
            return true;
        }else{
            return false;
        }
    }

    public boolean rmMovement(MovementInterface m){ return this.ledge.rmMovement(m); }

    public int generateIDof(String s){ return this.idmanager.generateIdOf(s); }

    //Getters

    public AccountInterface getAccount(int id){ return this.ledge.getAccount(id); }
    public MovementInterface getMovement(int id){ return this.ledge.getMovement(id); }
    public TransactionInterface getTransaction(int id){ return this.ledge.getTransaction(id); }
    public TagInterface getTag(int id){ return this.ledge.getTag(id); }
    public BReportInterface getReport(int id){ return this.budgetManager.getReport(id);}

    public List<AccountInterface> getAccounts(){ return this.ledge.getAccounts(); }
    public List<TransactionInterface> getTransactions(){ return this.ledge.getTransactions(); }
    public List<TransactionInterface> getTransactions(Predicate<TransactionInterface> p){ return this.ledge.getTransactions(p); }
    public List<TransactionInterface> getScheduledTransactions(){ return this.ledge.getScheduledTransactions(); }
    public List<BReportInterface> getReports(){ return this.budgetManager.getReports(); }
    public List<TagInterface> getTags(){  return this.ledge.getTags();  }
    public List<MovementInterface> getMovementsOf(AccountInterface a){ return a.getMovements(); }

    //TODO EDIT section (budget.set account.setname tag.setname etc..
    //TODO NOTA !! brutto scemo hai i get, dalla view bastera' fare controller.getaccount.set(blabla)
    //TODO SCEMO ! violi il contratto di open closed
}
