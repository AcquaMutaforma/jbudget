package it.unicam.cs.pa.jbudget102627;

public class IDManager implements IdManagerInterface {

    private int idmovement;
    private int idtransaction;
    private int idaccount;
    private int idbudget;
    private int idtag;
    private int idreport;

    public IDManager() {
        this.idmovement = 0;
        this.idtransaction = 0;
        this.idaccount = 0;
        this.idbudget = 0;
        this.idtag = 0;
        this.idreport = 0;
    }
    @Override
    public int getIdmovement() {     return idmovement;    }
    @Override
    public int getIdtransaction() {    return idtransaction;    }
    @Override
    public int getIdaccount() { return idaccount; }
    @Override
    public int getIdbudget() { return idbudget; }
    @Override
    public int getIdtag() { return idtag; }
    @Override
    public int getIdreport(){ return idreport; }

    @Override
    public int generateIdOf(String s) {
        switch (s){
            case "movement": this.idmovement++; return getIdmovement();
            case "transaction": this.idtransaction++; return getIdtransaction();
            case "account":  this.idaccount++; return getIdaccount();
            case "budget":  this.idbudget++; return getIdbudget();
            case "tag":  this.idtag++; return getIdtag();
            case "report": this.idreport++; return getIdreport();
            default: return -1;
        }
    }

}