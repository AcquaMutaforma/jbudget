package it.unicam.cs.pa.jbudget.model;

import java.util.List;
import java.util.function.Predicate;

public interface LedgeInterface {

    //getters
    List<TransactionInterface> getTransactions();
    List<TransactionInterface> getTransactions(Predicate<TransactionInterface> p);
    List<TagInterface> getTags();
    List<AccountInterface> getAccounts();
    List<ScheduledInterface> getScheduledTransactions();

    void addTransaction(TransactionInterface t);
    boolean rmTransaction(TransactionInterface t);
    void addTag(TagInterface c);
    boolean rmTag(TagInterface c);
    void addAccount(AccountInterface a);
    boolean rmAccount(AccountInterface a);
    void addScheduledTransaction(ScheduledInterface st);
    boolean rmScheduledTransaction(ScheduledInterface st);
    void checkScheduled();

}
