package it.unicam.cs.pa.jbudget;

public class UnknownCommand extends Exception{

    private final String command;

    public UnknownCommand(String command) {
        super("Unknown command: " + command);
        this.command = command;
    }

}

