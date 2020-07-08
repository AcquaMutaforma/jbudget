package it.unicam.cs.pa.jbudget102627;

public class UnknownCommand extends Exception{

    private final String command;

    public UnknownCommand(String command) {
        super("Unknown command: " + command);
        this.command = command;
    }

}

