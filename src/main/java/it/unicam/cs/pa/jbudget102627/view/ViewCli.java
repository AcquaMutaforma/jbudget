package it.unicam.cs.pa.jbudget102627.view;

import it.unicam.cs.pa.jbudget102627.App;
import it.unicam.cs.pa.jbudget102627.Controller;
import it.unicam.cs.pa.jbudget102627.budget.BReportInterface;
import it.unicam.cs.pa.jbudget102627.ledge.*;
import it.unicam.cs.pa.jbudget102627.saver.LoadInterface;
import it.unicam.cs.pa.jbudget102627.saver.SaverInterface;

import java.io.*;
import java.util.Arrays;
import java.util.TreeSet;

public class ViewCli implements ViewInterface{

    private final BufferedReader input;

    private final PrintAccInterface printAccount;
    private final PrintBReportInterface printReport;
    private final PrintMovInterface printMovement;
    private final PrintSaveInterface printSaver;
    private final PrintTagInterface printTag;
    private final PrintTransInterface printTransaction;
    private final PrintLoaderInterface printLoader;
    private final PrintPeriod printperiod;

    private Controller controller;

    public ViewCli(Controller controller){
        this.input = new BufferedReader( new InputStreamReader(System.in));

        this.printAccount = new PrintAccount();
        this.printReport = new PrintBReport();
        this.printMovement = new PrintMovement();
        this.printSaver = new PrintSaver();
        this.printTag = new PrintTag();
        this.printTransaction = new PrintTransaction();
        this.printLoader = new PrintLoader();
        this.printperiod = new PrintPeriod();

        this.controller = controller;
    }

    public void setController(Controller c){
        this.controller = c;
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
    public void printCommands(TreeSet<String> set){
        TreeSet<String> words = new TreeSet<>(set);
        String[] wordsArray = words.toArray(new String[] {});
        System.out.println("Commands: "+ Arrays.toString(wordsArray));
    }

    @Override
    public void printState() {
        System.out.println("\n-------------------------------------------------------------");
        if(this.controller.getAccounts() != null) {
            for(AccountInterface a : this.controller.getAccounts()){
                this.printAccount.printAccount(a);
            }
        }
        if(this.controller.getReports() != null){
            for(BReportInterface rep : this.controller.getReports()){
                this.printReport.printReport(rep);
            }
        }
        if(this.controller.getTags() != null){
            for(TagInterface tag : this.controller.getTags()){
                this.printTag.printTag(tag);
            }
        }
        System.out.println("\n-------------------------------------------------------------");
    }



    @Override
    public String getCommand() {
        printState();
        System.out.print("\n");
        System.out.println("command > ");
        String toReturn = "";
        try {
            toReturn = input.readLine();
        } catch (IOException e) {
            System.out.println("\nUnknown command!");
        }return toReturn;
    }

    @Override
    public void printTutorial() {
        System.out.println("Per poter utilizzare correttamente il programma devono essere inizializzati alcuni oggetti:" +
                "\n[1] addAccount -- Necessario per inserire movimenti." +
                "\n[2] addTag -- Necessario per utilizzare i budget."+
                "\n[3] save -- Crea un nuovo salvataggio con tutti gli elementi presenti, se erano presenti altri file vengono sovrascritti !"+
                "si consiglia di utilizzare questo come ultimo comando prima di uscire dall'applicazione."+
                "\n[4] load -- Carica i file che vengono trovati, se vegono eseguite delle azioni prima del caricamento, verranno sovrascitte "+
                "si consiglia di utilizzare questo come primo comando.");
    }

    @Override
    public void addAccount(){
        AccountInterface a = this.printAccount.addAccount(controller);
        if(a!= null)
            controller.addAccount(a);
        else{
            System.out.println("\n\nFailed insertion :(");
        }
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
    public void printLoad(LoadInterface load, App app) {
        try {
            app.loadController(this.printLoader.load(load));
        }catch (IOException e){
            System.out.println("\nLoad failed, files not found...");
        }
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
    public void rmMovement() {
        if(this.controller.rmMovement(this.printMovement.rmMovement(this.controller)))
            System.out.println("\nMovement removed !");
        else
            System.out.print("\nThe Movement was not removed...");
    }

    @Override
    public void addTag() {
        TagInterface t  = this.printTag.addTag(this.controller);
        if(t != null)
            this.controller.addTag(t);
    }

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

    @Override
    public void printPeriodList() {
        //TODO check
        for(Period p : controller.getPeriod()){
            this.printperiod.printPeriod(p);
        }
    }

    @Override
    public void getTransactions() {
        System.out.print("\n-- Transazioni -------------------");
        for(TransactionInterface tra : controller.getTransactions()){
            this.printTransaction.printTransaction(tra);
        }
        System.out.print("\n----------------------------------");
    }

    @Override
    public void getScheduled() {
        System.out.print("\n-- Scheduled ---------------------");
        for(TransactionInterface sched : controller.getScheduledTransactions()){
            this.printTransaction.printTransaction(sched);
        }
        System.out.print("\n----------------------------------");
    }

    @Override
    public void getMovementsOf() throws IOException {
        printMovement.printMovementOf(controller);
    }

    @Override
    public void newPrestito() {
        System.out.println("\nPer descrivere un prestito si deve creare un account di tipo LIABILITY," +
                " con il valore del prestito come bilancio iniziale.. ");
        controller.addAccount(this.printAccount.addAccount(controller));
    }
}