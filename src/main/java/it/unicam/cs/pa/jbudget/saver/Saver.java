package it.unicam.cs.pa.jbudget.saver;

import it.unicam.cs.pa.jbudget.Controller;

import java.io.File;

public class Saver implements SaverInterface{


    @Override
    public Controller loadController(String s) {
        return null;
    }

    @Override
    public void saveController(String s, Controller controller) {
        File file = new File(s);
        file.mkdir();

    }

    @Override
    public boolean checkSave() {
        return new File("/jbudget").exists();
    }
}
