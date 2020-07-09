package it.unicam.cs.pa.jbudget102627.saver;

import it.unicam.cs.pa.jbudget102627.Controller;

import java.io.IOException;

public interface LoadInterface {

    Controller loadController(String path) throws IOException;
    boolean checkSave(String s);
}
