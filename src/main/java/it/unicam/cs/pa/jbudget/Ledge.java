package it.unicam.cs.pa.jbudget;

import java.util.List;

public interface Ledge {

    List<Transaction> getTransactions();
    List<Category> getTags();
    List<Account> getAccounts();
    List<ScheduledTransaction> getScheduledTransactions();
    //  List<Transaction> getTransactions(Predicate<Transaction> p)  //TODO

    void addTransaction(Transaction t);
    void addTag(Category c);
    void addAccount(Account a);
    void addScheduledTransaction(ScheduledTransaction st);

    boolean rmTransaction(Transaction t);
    boolean rmTag(Category c);
    boolean rmAccount(Account a);
    boolean rmScheduledTransaction(ScheduledTransaction st);

}
