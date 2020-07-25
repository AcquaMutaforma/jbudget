package it.unicam.cs.pa.jbudget102627;

public class UnknownCommand extends Exception{

    public UnknownCommand(String command) {
        super("Unknown command: " + command);
    }

}

