package it.unicam.cs.pa.jbudget102627.ledge;

import java.time.LocalDate;

/**
 * Ha la responsabilita' di rappresentare un mese di un certo anno e contenere il valore
 * di tutte le transazioni appartenenti a questo arco di tempo.
 */
public class Period{

    private double value;
    private final LocalDate date;

    public Period(int y, int m,double v){
        this.date = LocalDate.of(y,m,1);
        this.value = v;
    }

    public void addValue(double v){
        this.value += v;
    }

    public int getYear(){
        return this.date.getYear();
    }

    public int getMonth(){
        return this.date.getMonthValue();
    }

    public String getMonthName(){return  this.date.getMonth().toString(); }

    public double getValue(){
        return this.value;
    }
}
