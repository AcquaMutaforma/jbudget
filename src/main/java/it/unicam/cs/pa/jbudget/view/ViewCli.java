package it.unicam.cs.pa.jbudget.view;

import java.io.*;

public class ViewCli implements ViewInterface{

    private Reader in;
    private Writer out;
    private Writer err;

    public ViewCli(){
    }

    @Override
    public void printHello() {
        System.out.println("\n       _ _               _            _   ");
        System.out.println("      | | |             | |          | |  ");
        System.out.println("      | | |__  _   _  __| | __ _  ___| |_ ");
        System.out.println("  _   | | '_ \\| | | |/ _` |/ _` |/ _ \\ __|");
        System.out.println(" | |__| | |_) | |_| | (_| | (_| |  __/ |_ ");
        System.out.println("  \\____/|_.__/ \\__,_|\\__,_|\\__, |\\___|\\__|");
        System.out.println("                            __/ |         ");
        System.out.println("                           |___/          ");
        System.out.println("\n");
    }

    @Override
    public void printGoodbye() {
        System.out.println("\nBye Sir !");
    }

    @Override
    public void printCommands() {

    }
}
