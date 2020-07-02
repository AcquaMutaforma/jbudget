package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.model.AccountInterface;

import java.util.List;

public interface PrintAccInterface {

    void printAccount(AccountInterface a);
    AccountInterface addAccount();
    AccountInterface rmAccount();
}
