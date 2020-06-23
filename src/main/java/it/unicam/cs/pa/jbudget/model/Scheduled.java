package it.unicam.cs.pa.jbudget.model;

import java.util.List;
import java.util.function.Predicate;

public class Scheduled implements ScheduledInterface{
    @Override
    public List<TransactionInterface> getTransactions() {
        return null;
    }

    @Override
    public List<TransactionInterface> getTransactions(Predicate<TransactionInterface> p) {
        return null;
    }

    @Override
    public boolean isComplete() {
        return false;
    }
}
