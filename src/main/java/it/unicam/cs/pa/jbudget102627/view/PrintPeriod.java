package it.unicam.cs.pa.jbudget102627.view;

import it.unicam.cs.pa.jbudget102627.ledge.Period;

import java.util.List;

public class PrintPeriod {

    public void printPeriod(List<Period> p){
        if(p == null || p.isEmpty()) {
            System.out.print("\nCannot calculate the statistics..."+
                    " Maybe you have not insert any transaction");
            return;
        }
        System.out.print("\nBalance month by month-----");
        for(Period per : p){
            System.out.print("\n"+per.getYear()+"  "+per.getMonthName()+"  balance: "+per.getValue());
        }
        System.out.print("\n----------------------------");
    }
}
