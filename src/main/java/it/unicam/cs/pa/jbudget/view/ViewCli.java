package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.Controller;
import it.unicam.cs.pa.jbudget.budget.BReportInterface;
import it.unicam.cs.pa.jbudget.model.AccountInterface;
import it.unicam.cs.pa.jbudget.model.TransactionInterface;
import it.unicam.cs.pa.jbudget.saver.SaverInterface;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.TreeSet;

public class ViewCli implements ViewInterface{

    private BufferedReader input;
    private BufferedWriter output;
    //TODO private BufferedWriter err;
    //TODO output seems useless as fk

    private PrintAccInterface printAccount;
    private PrintBReportInterface printReport;
    private PrintMovInterface printMovement;
    private PrintSaveInterface printSaver;
    private PrintTagInterface printTag;
    private PrintTransInterface printTransaction;
    private Controller controller;

    /* TODO la mappa con i comandi riguarda la view, perche' e' lei che dovra' chiamare ogni printer per fargli fare la sua
        azione, per poi inviare al controller i vari cambiamenti */


    public ViewCli(Controller controller){
        this.input = new BufferedReader( new InputStreamReader(System.in));
        this.output = new BufferedWriter(new OutputStreamWriter(System.out));
        //TODO err scrive insieme ad output oppure su log ?

        this.printAccount = new PrintAccount();
        this.printReport = new PrintBReport();
        this.printMovement = new PrintMovement();
        this.printSaver = new PrintSaver();
        this.printTag = new PrintTag();
        this.printTransaction = new PrintTransaction();
        this.controller = controller;
    }

    @Override
    public void printHello() {
        System.out.println("\n");
        System.out.println("\nWelcome to .. ");
        System.out.println("\n       _ _               _            _   ");
        System.out.println("      | | |             | |          | |  ");
        System.out.println("      | | |__  _   _  __| | __ _  ___| |_ ");
        System.out.println("  _   | | '_ \\| | | |/ _` |/ _` |/ _ \\ __|");
        System.out.println(" | |__| | |_) | |_| | (_| | (_| |  __/ |_ ");
        System.out.println("  \\____/|_.__/ \\__,_|\\__,_|\\__, |\\___|\\__|");
        System.out.println("                            __/ |         ");
        System.out.println("                           |___/          ");
        System.out.println("\n");
        System.out.println("\n\nTo visualize the commands type : help\nIf u need more help type : tutorial");
    }

    @Override
    public void printGoodbye() {
        System.out.println("\n\nBye Sir !");
    }

    @Override
    public void printCommands(TreeSet set){
        TreeSet<String> words = new TreeSet<>(set);
        String[] wordsArray = words.toArray(new String[] {});
        System.out.println("Commands: "+ Arrays.toString(wordsArray));
    }

    @Override
    public void printState() {
        if(this.controller.getAccounts().isEmpty())
            return;
        System.out.println("\n-------------------------------------------------------------");
        for(AccountInterface a : this.controller.getAccounts()){
            printAccount.printAccount(a);
        }
        if(this.controller.getReports() != null){
            for(BReportInterface rep : this.controller.getReports()){
                printReport.printReport(rep);
            }
        }
        System.out.println("\n-------------------------------------------------------------");
    }

    @Override
    public void rmMovement() {
//TODO
    }

    @Override
    public String getCommand() {
        printState();
        System.out.print("\n");
        System.out.println("command > ");
        String toReturn = "";
        try {
            toReturn = returnLine();
        } catch (IOException e) {
            System.out.println("\nUnknown command!");
        }finally {
            return toReturn;
        }
    }

    @Override
    public void printTutorial() {
        System.out.println("Per poter utilizzare correttamente il programma devono essere inizializzati alcuni oggetti" +
                "\n[1] addAccount -- necessario per inserire movimenti" +
                "\n[2] addTag -- ");
    }

    private String returnLine() throws IOException {
        String line = input.readLine();
        return line;
    }
    @Override
    public void addAccount(){
        AccountInterface a = this.printAccount.addAccount(controller);
        if(a!= null)
            controller.addAccount(a);
        else{
            System.out.println("\n\nFailed insertion :(");
        }
        return;
    }
    @Override
    public void rmAccount(){
        if(controller.rmAccount(this.printAccount.rmAccount(controller))){
            System.out.println("\nAccount removed !");
        }else{
            System.out.println("\nThe Account was not removed..");
        }
    }

    @Override
    public void printSave(SaverInterface save) {
        this.printSaver.save(this.controller,save);
    }

    @Override
    public void printLoad(SaverInterface save) {
        this.printSaver.load(this.controller,save);
    }

    @Override
    public void addTransaction() { this.controller.addTransaction(this.printTransaction.addTransaction(this.controller)); }

    @Override
    public void rmTransaction() {
        if(this.controller.rmTransaction(this.printTransaction.rmTransaction(this.controller))){
            System.out.println("\nTransaction removed !");
        }else{
            System.out.println("\nThe Transaction was not removed...");
        }
    }

    @Override
    public void addTag() {  this.controller.addTag(this.printTag.addTag(this.controller)); }

    @Override
    public void rmTag() {
        if(this.controller.rmTag(this.printTag.rmTag(this.controller))){
            System.out.println("\nTag removed !");
        }else {
            System.out.println("\nThe Tag was not removed...");
        }
    }

    @Override
    public void addBudget() { this.controller.addBudget(this.printReport.addBudget(this.controller)); }

    @Override
    public void rmBudget() {
        if(this.controller.rmBudgetAndReport(this.printReport.rmBudget(this.controller))){
            System.out.println("\nBudget removed !");
        }else {
            System.out.println("\nThe Budget was not removed...");
        }
    }
}