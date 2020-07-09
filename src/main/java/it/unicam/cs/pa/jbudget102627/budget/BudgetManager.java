package it.unicam.cs.pa.jbudget102627.budget;

import it.unicam.cs.pa.jbudget102627.ledge.LedgeInterface;
import it.unicam.cs.pa.jbudget102627.ledge.TransactionInterface;

import java.util.List;

public class BudgetManager implements BManagerInterface {

    private List<BudgetInterface> budgetlist;
    private List<BReportInterface> reportlist;

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
        /*per future implementazioni lo lasciamo cosi',
        senno' avrebbe potuto avere lo stesso id del budget */
        BReportInterface rep = new BudgetReport(id,b,l);
        addReport(rep);
    }

    @Override
    public void aorTransaction(TransactionInterface tra, boolean aor) {
        if(tra == null)
            return;
        if(aor) {
            for (BReportInterface rep : getReports()) {
                rep.addTransaction(tra);
            }
        }else{
            for(BReportInterface rep : getReports()){
                rep.rmTransaction(tra);
            }
        }
        for(BReportInterface rep: getReports()){

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
}
