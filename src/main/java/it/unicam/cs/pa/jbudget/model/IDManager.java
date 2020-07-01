package it.unicam.cs.pa.jbudget.model;

public class IDManager implements IdManagerInterface {

    /*TODO magari puoi togliere i set, tanto saver carica un altro oggetto, e i getters sono usati
       solamente da generateIDof() */

    private int idmovement;
    private int idtransaction;
    private int idaccount;
    private int idbudget;
    private int idtag;

    public IDManager() {
        setIdmovimenti(0);
        setIdtransaction(0);
        setIdaccount(0);
        setIdbudget(0);
        setIdtag(0);
    }

    public int getIdmovement() {     return idmovement;    }

    public void setIdmovimenti(int idmovimenti) {    this.idmovement = idmovimenti;    }

    public int getIdtransaction() {    return idtransaction;    }

    public void setIdtransaction(int idtransaction) {   this.idtransaction = idtransaction; }

    public int getIdaccount() { return idaccount; }

    public void setIdaccount(int idaccount) { this.idaccount = idaccount; }

    public int getIdbudget() { return idbudget; }

    public void setIdbudget(int idbudget) { this.idbudget = idbudget; }

    public int getIdtag() { return idtag; }

    public void setIdtag(int idtag) { this.idtag = idtag; }

    @Override
    public int generateIdOf(String s) {
        switch (s){
            case "movement": this.idmovement++; return getIdmovement();
            case "transaction": this.idtransaction++; return getIdtransaction();
            case "account":  this.idaccount++; return getIdaccount();
            case "budget":  this.idbudget++; return getIdbudget();
            case "tag":  this.idtag++; return getIdtag();
            default: return -1;
        }
    }

}