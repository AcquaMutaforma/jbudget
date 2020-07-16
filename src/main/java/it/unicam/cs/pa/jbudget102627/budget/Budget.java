package it.unicam.cs.pa.jbudget102627.budget;

import it.unicam.cs.pa.jbudget102627.ledge.TagInterface;

import java.util.*;

public class Budget implements BudgetInterface{

    /*
    Il budget conterra' dei tag con un valore e quelli, nel report, verranno calcolati
    con le transazioni, ma si potra aggiungere tag con valore 0 per usarli da filtro,
    il report cosi' andra' a cercare solo movimenti per ogni tag + i tag(=0),
    tipo l'anno o tag descrittivi
     */

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
        //TODO check if it works
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
    //TODO serve davvero ?
    public Map<Integer, Double> getMap() {
        return this.budgetmap;
    }

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
