package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.App;

import java.io.*;

public class ViewCli implements ViewInterface{

    private BufferedReader input;
    private BufferedWriter output;
    //TODO private BufferedWriter err;

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
    public String getCommand() {
        System.out.print("\n");
        System.out.println("comando > ");
        String toReturn = "";
        try {
            toReturn = returnLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return toReturn;
        }
    }

    private String returnLine() throws IOException {
        String line = input.readLine();
        return line;
    }


}