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
    void addTag(TagInterface c);
    void addAccount(AccountInterface a);
    void addScheduledTransaction(ScheduledInterface st);

    boolean rmTransaction(TransactionInterface t);
    boolean rmTag(TagInterface c);
    boolean rmAccount(AccountInterface a);
    boolean rmScheduledTransaction(ScheduledInterface st);

}
