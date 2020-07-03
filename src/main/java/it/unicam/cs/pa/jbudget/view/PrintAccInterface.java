package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.Controller;
import it.unicam.cs.pa.jbudget.model.AccountInterface;

public interface PrintAccInterface {

    void printAccount(AccountInterface a);
    AccountInterface addAccount(Controller controller);
    AccountInterface rmAccount(Controller controller);
}
