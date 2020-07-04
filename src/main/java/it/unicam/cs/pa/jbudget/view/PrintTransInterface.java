package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.Controller;
import it.unicam.cs.pa.jbudget.model.TransactionInterface;

public interface PrintTransInterface {

    void printTransaction(TransactionInterface tra);
    TransactionInterface addTransaction(Controller controller);
    TransactionInterface rmTransaction(Controller controller);
}
