package it.unicam.cs.pa.jbudget102627.view;

import it.unicam.cs.pa.jbudget102627.Controller;
import it.unicam.cs.pa.jbudget102627.ledge.TransactionInterface;

public interface PrintTransInterface {

    void printTransaction(TransactionInterface tra);
    TransactionInterface addTransaction(Controller controller);
    TransactionInterface rmTransaction(Controller controller);
}
