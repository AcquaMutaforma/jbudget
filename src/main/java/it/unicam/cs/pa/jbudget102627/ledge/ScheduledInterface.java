package it.unicam.cs.pa.jbudget102627.ledge;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public interface ScheduledInterface {
    
    //getters
    LocalDate getDate();
    List<TransactionInterface> getTransactions();

    //setters
    void setDate(LocalDate ld);

    //generic methods
    void addTransaction(TransactionInterface t);
    boolean rmTransaction(TransactionInterface t);
    boolean rmTransaction(Predicate<TransactionInterface> p);
    boolean isComplete();
}
