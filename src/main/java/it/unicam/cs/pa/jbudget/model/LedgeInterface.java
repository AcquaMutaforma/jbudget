package it.unicam.cs.pa.jbudget.model;

import java.util.List;
import java.util.function.Predicate;

public interface LedgeInterface {

    //getters
    List<TransactionInterface> getTransactions();
    List<TransactionInterface> getTransactions(Predicate<TransactionInterface> p);
    List<TagInterface> getTags();
    List<AccountInterface> getAccounts();
    List<ScheduledInterface> getScheduled();
    List<ScheduledInterface> getScheduled(Predicate<ScheduledInterface> p);

    void addTransaction(TransactionInterface t);
    boolean rmTransaction(TransactionInterface t);
    void addTag(TagInterface c);
    boolean rmTag(TagInterface c);
    void addAccount(AccountInterface a);
    boolean rmAccount(AccountInterface a);
    void addScheduled(ScheduledInterface st);
    boolean rmScheduled(ScheduledInterface st);
    void checkScheduled();

}
