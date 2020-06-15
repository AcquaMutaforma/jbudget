package it.unicam.cs.pa.jbudget;

import java.util.List;

public interface Ledge {

    List<TransactionInterface> getTransactions();
    List<Category> getTags();
    List<AccountInterface> getAccounts();
    List<ScheduledTransaction> getScheduledTransactions();
    //  List<Transaction> getTransactions(Predicate<Transaction> p)  //TODO

    void addTransaction(TransactionInterface t);
    void addTag(Category c);
    void addAccount(AccountInterface a);
    void addScheduledTransaction(ScheduledTransaction st);

    boolean rmTransaction(TransactionInterface t);
    boolean rmTag(Category c);
    boolean rmAccount(AccountInterface a);
    boolean rmScheduledTransaction(ScheduledTransaction st);

}
