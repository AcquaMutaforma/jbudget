package it.unicam.cs.pa.jbudget102627.view;

import it.unicam.cs.pa.jbudget102627.Controller;
import it.unicam.cs.pa.jbudget102627.ledge.AccountInterface;

public interface PrintAccInterface {

    void printAccount(AccountInterface a);
    AccountInterface addAccount(Controller controller);
    AccountInterface rmAccount(Controller controller);
}
