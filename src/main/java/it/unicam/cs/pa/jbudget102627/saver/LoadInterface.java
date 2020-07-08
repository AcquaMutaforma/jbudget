package it.unicam.cs.pa.jbudget102627.saver;

import it.unicam.cs.pa.jbudget102627.Controller;

import java.io.FileNotFoundException;

public interface LoadInterface {

    Controller loadController(String path) throws FileNotFoundException;
    boolean checkSave(String s);
}
