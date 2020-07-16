package it.unicam.cs.pa.jbudget102627.budget;

import it.unicam.cs.pa.jbudget102627.ledge.LedgeInterface;
import it.unicam.cs.pa.jbudget102627.ledge.TagInterface;
import it.unicam.cs.pa.jbudget102627.ledge.TransactionInterface;

import java.util.*;

public class BudgetReport implements BReportInterface{

    private final int id;
    private final BudgetInterface budget;
    private final LedgeInterface ledge;
    private Map<Integer,Double> report;

    public BudgetReport(int id, BudgetInterface budget, LedgeInterface ledge) {
        this.id = id;
        this.budget = budget;
        this.ledge = ledge;
        this.report = new HashMap<>();
        generate();
    }

    @Override
    public int getId() {return this.id;}

    @Override
    public String getName() {return this.getBudget().getName();}

    @Override
    public Map<Integer, Double> getReport() { return this.report; }

    @Override
    public BudgetInterface getBudget() { return this.budget; }

    @Override
    public List<Integer> getTags() {
        return new ArrayList<>(report.keySet());
    }

    @Override
    public double getValueOf(TagInterface c) {return report.get(c.getId());}

    @Override
    public double getValueOf(int c) {
        return this.report.get(c);
    }

    @Override
    public void addTransaction(TransactionInterface tra) {
        List<Integer> filter = getBudget().getFilter();
        if(tra.getTags().containsAll(filter)){
            for (int t : this.report.keySet()) {
                if (tra.getTags().contains(t))
                    editBalance(t, tra.getTotalAmount(),true);
            }
        }
    }

    @Override
    public boolean rmTransaction(TransactionInterface tra) {
        List<Integer> filter = getBudget().getFilter();
        if(tra.getTags().containsAll(filter)){
            for (int t : this.report.keySet()) {
                if (tra.getTags().contains(t))
                    editBalance(t, tra.getTotalAmount(),false);
            }
            return true;
        }
        return false;
    }


    private void editBalance(int tag, double value,boolean aor) {
        double old = this.report.get(tag);
        if(aor)
            old += value;
        else
            old -= value;
        this.report.put(tag,old);
    }

    /**
     * Analizza tutte le transazioni presenti nel ledge e ogni volta che trova transazioni
     * legate al budget le elabora andando a modificare il "totale" del tag legato
     */
    private void generate() {
        this.report.putAll(getBudget().getMap());
        for(Integer t : getBudget().getFilter()){
            report.remove(t);
        }
        for(TransactionInterface tra : ledge.getTransactions()){
            addTransaction(tra);
        }
    }
}
