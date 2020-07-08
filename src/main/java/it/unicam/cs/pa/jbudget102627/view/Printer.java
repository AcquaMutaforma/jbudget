package it.unicam.cs.pa.jbudget102627.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Printer {

    private BufferedReader input;

    public Printer() {
        this.input = new BufferedReader( new InputStreamReader(System.in));
    }

    protected String returnLine() throws IOException {
        String line = input.readLine();
        return line;
    }
}
