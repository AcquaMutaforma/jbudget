package it.unicam.cs.pa.jbudget102627;

import it.unicam.cs.pa.jbudget102627.budget.BManagerInterface;
import it.unicam.cs.pa.jbudget102627.budget.BReportInterface;
import it.unicam.cs.pa.jbudget102627.budget.BudgetInterface;
import it.unicam.cs.pa.jbudget102627.ledge.*;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 * Responsabile di coordinare tutti gli elementi appartenenti al Model del pattern MVC.
 */
public class Controller {

    private final LedgeInterface ledge;
    private final BManagerInterface budgetManager;
    private final IdManagerInterface idmanager;

    public Controller(LedgeInterface l, BManagerInterface bm, IdManagerInterface idm) {
        this.ledge = l;
        this.budgetManager = bm;
        this.idmanager = idm;
    }

    public void addTransaction(TransactionInterface tra){
        if(tra == null)
            return;
        this.ledge.addTransaction(tra);
        if(this.ledge.getTransaction(tra.getId()) != null && this.budgetManager.getBudgets() != null)
            this.budgetManager.addTransaction(tra);
    }
    public boolean rmTransaction(TransactionInterface tra){
        if(tra == null)
            return false;
        if(this.ledge.rmTransaction(tra)){
            this.budgetManager.rmTransaction(tra);
            return true;
        }else{
            return false;
        }
    }

    public void addAccount(AccountInterface a){
        if(a == null)
            return;
        this.ledge.addAccount(a);
    }
    public boolean rmAccount(AccountInterface a){
        if(a != null){
            return this.ledge.rmAccount(a);
        }else{
        return false; }
    }

    public void addTag(TagInterface t){
        if(t == null)
            return;
        this.ledge.addTag(t);
    }
    public boolean rmTag(TagInterface t){
        if(t == null)
            return false;
        return this.ledge.rmTag(t); }

    public void addBudget(BudgetInterface b){
        if(b == null)
            return;
        this.budgetManager.addBudget(b);
        this.budgetManager.generateReport(generateIDof("report"),b,this.ledge);
    }
    public boolean rmBudgetAndReport(BReportInterface r){
        if(r == null)
            return false;
        if(this.budgetManager.rmReport(r)){
            this.budgetManager.rmBudget(r.getBudget());
            return true;
        }else{
            return false;
        }
    }

    public void addMovement(MovementInterface mov) {
        this.ledge.addMovement(mov);
    }

    public boolean rmMovement(MovementInterface m){
        if(m == null)
            return false;
        return this.ledge.rmMovement(m);
    }

    public int generateIDof(String s){ return this.idmanager.generateIdOf(s); }

    //GETTERS
    public AccountInterface getAccount(int id){ return this.ledge.getAccount(id); }
    public MovementInterface getMovement(int id){ return this.ledge.getMovement(id); }
    public TransactionInterface getTransaction(int id){ return this.ledge.getTransaction(id); }
    public TagInterface getTag(int id){ return this.ledge.getTag(id); }
    public BReportInterface getReport(int id){ return this.budgetManager.getReport(id);}

    public IdManagerInterface getIDManager(){ return this.idmanager; }
    public List<MovementInterface> getMovements(){ return this.ledge.getMovements(); }
    public List<AccountInterface> getAccounts(){ return this.ledge.getAccounts(); }
    public List<TransactionInterface> getTransactions(){ return this.ledge.getTransactions(); }
    public List<TransactionInterface> getTransactions(Predicate<TransactionInterface> p){ return this.ledge.getTransactions(p); }
    public List<TransactionInterface> getScheduledTransactions(){ return this.ledge.getScheduledTransactions(); }
    public List<BReportInterface> getReports(){ return this.budgetManager.getReports(); }
    public List<TagInterface> getTags(){  return this.ledge.getTags();  }
    public List<BudgetInterface> getBudgets(){ return this.budgetManager.getBudgets();}
    public AccountInterface getAccount(String s){ return ledge.getAccount(s); }
    public TagInterface getTag(String s) { return ledge.getTag(s); }
    public List<Period> getPeriod(){ return this.ledge.generatePeriod(); }
    public List<ScheduledInterface> getScheduled() {return this.ledge.getScheduled(); }

    public List<MovementInterface> getMovementsOf(AccountInterface a){
        return this.ledge.getMovements( x -> x.getAccountId() == a.getId());
    }

}
