package it.unicam.cs.pa.jbudget.model;

import java.util.List;

public interface Ledge {

    List<MovementInterface> getMovements();
    List<Category> getTags();
    List<AccountInterface> getAccounts();
    List<ScheduledInterface> getScheduledTransactions();
    //  List<Transaction> getTransactions(Predicate<Transaction> p)  //TODO

    void addTransaction(TransactionInterface t);
    void addTag(Category c);
    void addAccount(AccountInterface a);
    void addScheduledTransaction(ScheduledInterface st);

    boolean rmTransaction(TransactionInterface t);
    boolean rmTag(Category c);
    boolean rmAccount(AccountInterface a);
    boolean rmScheduledTransaction(ScheduledInterface st);

}
