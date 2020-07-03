package it.unicam.cs.pa.jbudget.saver;

import it.unicam.cs.pa.jbudget.Controller;

import java.io.File;

public class Saver implements SaverInterface{
    @Override
    public Controller loadController() {
        return null;
    }

    @Override
    public void saveControllerInLocal(String s) {
        File file = new File(s);
        file.mkdir();

        

    }

    @Override
    public boolean checkSave() {
        return false;
    }
}
