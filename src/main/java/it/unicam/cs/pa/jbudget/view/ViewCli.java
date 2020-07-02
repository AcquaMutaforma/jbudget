package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.Controller;
import it.unicam.cs.pa.jbudget.model.Account;

import java.io.*;
import java.util.function.Consumer;

public class ViewCli implements ViewInterface/*,PrintAccInterface,PrintBReportInterface,PrintMovInterface,
        PrintSaveInterface,PrintTagInterface,PrintTransInterface*/{
    //TODO probabilemente e' sbagliato, viene una classe immensa, forse questa fara' da view manager e potrebbe creare un oggetto per ogni tipo
    //TODO di cosa da stampare, mmh

    private BufferedReader input;
    private BufferedWriter output;
    //TODO private BufferedWriter err;

    private PrintAccInterface printAccount;
    private PrintBReportInterface printReport;
    private PrintMovInterface printMovement;
    private PrintSaveInterface printSaver;
    private PrintTagInterface printTag;
    private PrintTransInterface printTransaction;


    public ViewCli(){
        this.input = new BufferedReader( new InputStreamReader(System.in));
        this.output = new BufferedWriter(new OutputStreamWriter(System.out));
        //TODO err scrive insieme ad output oppure su log ?

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
        System.out.println("\n\nPer visualizzare i comandi disponibili digita: help ");
    }

    @Override
    public void printGoodbye() {
        System.out.println("\n\nBye Sir !");
    }

    @Override
    public void printCommands(){

    }

    @Override
    public void printState(Controller controller) {
    }

    @Override
    public String getCommand() {
        System.out.print("\n");
        System.out.println("comando > ");
        String toReturn = "";
        try {
            toReturn = returnLine();
        } catch (IOException e) {
            //TODO
        }finally {
            return toReturn;
        }
    }

    public void commandsHandler(String command){
        Consumer<ViewInterface> consumer = this.commands.get(command);
    }

    private String returnLine() throws IOException {
        String line = input.readLine();
        return line;
    }

    public void addAccount(Controller controller){
        controller.addAccount(this.printAccount.addAccount());
        //lui avra la stampa a video, con gestione di input

        //TODO forse con l'id si fa prima, magari nel controller dopo aver fatto il get fai remove(getAccount(int id)))
        controller.rmAccount(this.printAccount.rmAccount(controller.getSingleAccount(int id)));
    }

}