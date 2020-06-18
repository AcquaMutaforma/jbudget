package it.unicam.cs.pa.jbudget.model;

import java.time.LocalDate;
import java.util.List;

public interface ScheduledInterface {
    /* funge da manager di transazioni future*/
    
    //getters
    LocalDate getDate();
    List<TransactionInterface> getTransactions();


    //setters
    //generic methods
    boolean isComplete();
}
