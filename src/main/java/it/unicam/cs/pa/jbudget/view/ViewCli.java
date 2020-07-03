package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.Controller;

import java.io.*;
import java.util.HashMap;
import java.util.function.Consumer;

public class ViewCli implements ViewInterface{

    private BufferedReader input;
    private BufferedWriter output;
    //TODO private BufferedWriter err;

    private PrintAccInterface printAccount;
    private PrintBReportInterface printReport;
    private PrintMovInterface printMovement;
    private PrintSaveInterface printSaver;
    private PrintTagInterface printTag;
    private PrintTransInterface printTransaction;

    /* TODO la mappa con i comandi riguarda la view, perche' e' lei che dovra' chiamare ogni printer per fargli fare la sua
        azione, per poi inviare al controller i vari cambiamenti */
    private HashMap<String,Consumer<ViewInterface>> commands;


    public ViewCli(Controller controller){
        this.input = new BufferedReader( new InputStreamReader(System.in));
        this.output = new BufferedWriter(new OutputStreamWriter(System.out));
        //TODO err scrive insieme ad output oppure su log ?

        this.printAccount = new PrintAccount();

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

    private String returnLine() throws IOException {
        String line = input.readLine();
        return line;
    }
    @Override
    public void addAccount(Controller controller){ controller.addAccount(this.printAccount.addAccount(controller)); }
    @Override
    public void rmAccount(Controller controller){ controller.rmAccount(this.printAccount.rmAccount(controller));  }
}