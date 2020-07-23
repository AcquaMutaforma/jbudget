package it.unicam.cs.pa.jbudget102627.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Responsabile di gestire l'input. Utilizzato per non ripetere codice in ogni classe
 * appartenente alla View.
 */
public class Printer {

    private final BufferedReader input;

    public Printer() {
        this.input = new BufferedReader( new InputStreamReader(System.in));
    }

    protected String returnLine() throws IOException {
        return input.readLine();
    }
}
