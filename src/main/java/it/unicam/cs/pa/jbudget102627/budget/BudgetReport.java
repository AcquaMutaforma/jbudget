package it.unicam.cs.pa.jbudget102627.budget;

import it.unicam.cs.pa.jbudget102627.ledge.LedgeInterface;
import it.unicam.cs.pa.jbudget102627.ledge.TagInterface;
import it.unicam.cs.pa.jbudget102627.ledge.TransactionInterface;

import java.util.*;

public class BudgetReport implements BReportInterface{

    private final int id;
    private final BudgetInterface budget;
    private final LedgeInterface ledge;
    private Map<TagInterface,Double> report;

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
    public Map<TagInterface, Double> getReport() { return this.report; }

    @Override
    public BudgetInterface getBudget() { return this.budget; }

    @Override
    public List<TagInterface> getTags() {
        //TODO check if it really works
        return new ArrayList<>(report.keySet());
    }

    @Override
    public double getValueOf(TagInterface c) {return report.get(c);}

    @Override
    public void addTransaction(TransactionInterface tra) {
        List<TagInterface> filter = getBudget().getFilter();
        if(tra.getTags().containsAll(filter)){
            for (TagInterface t : this.report.keySet()) {
                if (tra.getTags().contains(t))
                    editBalance(tra.getTotalAmount(), t);
            }
        }
    }

    @Override
    public boolean rmTransaction(TransactionInterface tra) {
        List<TagInterface> filter = getBudget().getFilter();
        if(tra.getTags().containsAll(filter)){
            for (TagInterface t : this.report.keySet()) {
                if (tra.getTags().contains(t))
                    editBalance(-1 * tra.getTotalAmount(), t);
            }
            return true;
        }
        return false;
    }


    private void editBalance(Double value, TagInterface tag) {
        double old = this.report.get(tag);
        old += value;
        this.report.put(tag,old);
    }

    /**
     * Analizza tutte le transazioni presenti nel ledge e ogni volta che trova transazioni
     * legate al budget le elabora andando a modificare il "totale" del tag legato
     */
    private void generate() {
        this.report.putAll(getBudget().getMap());
        //TODO check if it works & if it sucks or not
        for(TagInterface t : getBudget().getFilter()){
            report.remove(t);
        }
        for(TagInterface t : report.keySet()){
            report.put(t,0.0);
        }
        for(TransactionInterface tra : ledge.getTransactions()){
            addTransaction(tra);
        }
    }
}
