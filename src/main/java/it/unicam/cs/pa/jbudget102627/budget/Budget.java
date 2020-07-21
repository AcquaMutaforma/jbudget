package it.unicam.cs.pa.jbudget102627.budget;

import it.unicam.cs.pa.jbudget102627.ledge.TagInterface;

import java.util.*;

/**
 * definisce un valore per ogni tag, se il valore impostato e' zero allora quel tag
 * verra' utilizzato come filtro nelle transazioni; per esempio potremmo utilizzare il tag 2020
 * con valore zero, per calcolare le transazioni escludendo quelle aventi tag 2019
 * @author Pallotta Alessandro - 102627
 */
public class Budget implements BudgetInterface{

    private String nome;
    private final int id;
    private Map<Integer,Double> budgetmap;

    public Budget(String nome, int id) {
        this.nome = nome;
        this.id = id;
        this.budgetmap = new TreeMap<>();
    }

    @Override
    public String getName() {return this.nome;}

    @Override
    public int getId() {return this.id;}

    @Override
    public List<Integer> getTags() {
        return new ArrayList<>(budgetmap.keySet());
    }

    @Override
    public double getValueOf(TagInterface c) {
        return this.budgetmap.get(c.getId());
    }

    @Override
    public double getValueOf(int c) {
        return this.budgetmap.get(c);
    }

    @Override
    public void set(int c, double expected) {
        this.budgetmap.put(c,expected);
    }

    @Override
    public Map<Integer, Double> getMap() {
        return this.budgetmap;
    }

    /**
     * Restituisce una lista dei tag che hanno valore atteso zero, che verranno usati
     * come filtro dal BudgetReport
     * @return filterlist   lista degli id dei tag da usare come filtro per le transazioni
     * @see Budget's javadoc
     */
    @Override
    public List<Integer> getFilter() {
        List<Integer> filterlist = new ArrayList<>();
        for(int t : getTags()){
            if(getValueOf(t) == 0)
                filterlist.add(t);
        }
        return filterlist;
    }
}
