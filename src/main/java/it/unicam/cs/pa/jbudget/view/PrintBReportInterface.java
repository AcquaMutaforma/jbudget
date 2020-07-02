package it.unicam.cs.pa.jbudget.view;

public interface PrintBReportInterface {

    void printReport();
    //piu report vengono chiamati con questo metodo dentro un foreach in viewCli
    void addBudget();
    void rmBudget();
}
