package it.unicam.cs.pa.jbudget.model;

import java.time.LocalDate;
import java.util.List;

public interface ScheduledInterface {
    
    //getters
    LocalDate getDate();
    List<TransactionInterface> getTransactions();

    //setters
    void setDate(LocalDate ld);

    //generic methods
    void addTransaction(TransactionInterface t);
    boolean rmTransaction(TransactionInterface t);
    boolean isComplete();
}
