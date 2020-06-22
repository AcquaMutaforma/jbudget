package it.unicam.cs.pa.jbudget.controller;

public class IDManager implements IdManagerInterface{

    private int idmovimenti;
    private int idtransazioni;
    private int idaccount;
    private int idbudget;
    private int idtag;


    public int getIdmovimenti() {     return idmovimenti;    }

    public void setIdmovimenti(int idmovimenti) {    this.idmovimenti = idmovimenti;    }

    public int getIdtransazioni() {    return idtransazioni;    }

    public void setIdtransazioni(int idtransazioni) {   this.idtransazioni = idtransazioni; }

    public int getIdaccount() { return idaccount; }

    public void setIdaccount(int idaccount) { this.idaccount = idaccount; }

    public int getIdbudget() { return idbudget; }

    public void setIdbudget(int idbudget) { this.idbudget = idbudget; }

    public int getIdtag() { return idtag; }

    public void setIdtag(int idtag) { this.idtag = idtag; }

    @Override
    public int generateIdOf(String s) {
        switch (s){
            case "movimenti": this.idmovimenti++; return getIdmovimenti();
            case "transazioni": this.idtransazioni++; return getIdtransazioni();
            case "account":  this.idaccount++; return getIdaccount();
            case "budget":  this.idbudget++; return getIdbudget();
            case "tag":  this.idtag++; return getIdtag();
            default: return -1;
        }
    }
}