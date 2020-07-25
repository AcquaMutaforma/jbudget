package it.unicam.cs.pa.jbudget102627.budget;

import it.unicam.cs.pa.jbudget102627.ledge.LedgeInterface;
import it.unicam.cs.pa.jbudget102627.ledge.TagInterface;
import it.unicam.cs.pa.jbudget102627.ledge.TransactionInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestisce i Budget e i BudgetReport
 * @author Pallotta Alessandro - 102627
 */
public class BudgetManager implements BManagerInterface {

    private final List<BudgetInterface> budgetlist;
    private final List<BReportInterface> reportlist;

    public BudgetManager() {
        this.budgetlist = new ArrayList<>();
        this.reportlist = new ArrayList<>();
    }

    @Override
    public List<BudgetInterface> getBudgets() {return this.budgetlist; }

    @Override
    public List<BReportInterface> getReports() {return this.reportlist; }

    @Override
    public void addBudget(BudgetInterface b) {
        if(!getBudgets().contains(b))
            this.budgetlist.add(b);
    }

    @Override
    public boolean rmBudget(BudgetInterface b) {
        if(getBudgets().contains(b)){
            getReports().removeIf(rep -> rep.getBudget().equals(b));
            getBudgets().remove(b);
            return true;
        }
        return false;
    }

    @Override
    public void addReport(BReportInterface r) {
        if(!getReports().contains(r))
            this.reportlist.add(r);
    }

    @Override
    public boolean rmReport(BReportInterface r) {
        if(getReports().contains(r)){
            getReports().remove(r);
            return true;
        }
        return false;
    }

    @Override
    public void generateReport(int id,BudgetInterface b, LedgeInterface l) {
        BReportInterface rep = new BudgetReport(id,b,l);
        addReport(rep);
    }

    @Override
    public void addTransaction(TransactionInterface tra){
        if(tra == null)
            return;
        for (BReportInterface rep : getReports()) {
            rep.addTransaction(tra);
        }
    }

    @Override
    public void rmTransaction(TransactionInterface tra) {
        if( tra == null)
            return;
        for (BReportInterface rep : getReports()) {
            rep.rmTransaction(tra);
        }
    }
    @Override
    public BReportInterface getReport(int id) {
        for(BReportInterface rep : getReports()){
            if(rep.getId() == id)
                return rep;
        }
        return null;
    }

    @Override
    public void rmTag(TagInterface t) {
        for(BudgetInterface bud : getBudgets()){
            bud.rmTag(t);
        }
        for(BReportInterface rep : getReports()){
            rep.rmTag(t);
        }
        rmEmptyBudgets();
    }

    private void rmEmptyBudgets() {
        this.budgetlist.removeIf(x -> x.getMap().isEmpty());
    }
}
