package it.unicam.cs.pa.jbudget.model;

import java.util.List;
import java.util.function.Predicate;

public interface ScheduledInterface {
    /* funge da manager di transazioni future*/
    
    //getters

    List<TransactionInterface> getTransactions();
    List<TransactionInterface> getTransactions(Predicate<Transaction> p);

    //TODO transazioni o serie di transazioni, che deve fare questa interfaccia ??
    //setters
    //generic methods
    boolean isComplete();
}
