package it.unicam.cs.pa.jbudget;

import it.unicam.cs.pa.jbudget.budget.BManagerInterface;
import it.unicam.cs.pa.jbudget.budget.BReportInterface;
import it.unicam.cs.pa.jbudget.model.AccountInterface;
import it.unicam.cs.pa.jbudget.model.IdManagerInterface;
import it.unicam.cs.pa.jbudget.model.LedgeInterface;
import it.unicam.cs.pa.jbudget.model.TransactionInterface;

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


    //metodi per le azioni che l'utente puo' fare ( add / rm cose)
    //todo i get sono dei print, quindi se ne occupa la view (?)
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

    public int generateIDof(String s){
        return this.idmanager.generateIdOf(s);
    }

    //Getters
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


}
