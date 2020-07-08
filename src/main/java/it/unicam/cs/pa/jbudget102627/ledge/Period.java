package it.unicam.cs.pa.jbudget102627.ledge;

public class Period{

    private final int year;
    private final int month;
    private double value;

    public Period(int y, int m,double v){
        this.year = y;
        this.month = m;
        this.value = v;
    }

    public void addValue(double v){
        this.value += v;
    }

    public int getYear(){
        return this.year;
    }

    public int getMonth(){
        return this.month;
    }
}
