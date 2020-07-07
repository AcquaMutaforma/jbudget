package it.unicam.cs.pa.jbudget.saver;

import it.unicam.cs.pa.jbudget.Controller;

import java.io.FileNotFoundException;

public interface LoadInterface {

    Controller loadController(String path) throws FileNotFoundException;
    boolean checkSave(String s);
}
