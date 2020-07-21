package it.unicam.cs.pa.jbudget102627;

public interface IdManagerInterface {

    //getters
    int getIdmovement();
    int getIdtransaction();
    int getIdaccount();
    int getIdbudget();
    int getIdtag();
    int getIdreport();

    //other methods
    int generateIdOf(String s);
}
