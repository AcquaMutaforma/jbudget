package it.unicam.cs.pa.jbudget102627.saver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.unicam.cs.pa.jbudget102627.Controller;
import it.unicam.cs.pa.jbudget102627.IDManager;
import it.unicam.cs.pa.jbudget102627.budget.BudgetManager;
import it.unicam.cs.pa.jbudget102627.ledge.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Loader implements LoadInterface{
    @Override
    public Controller loadController(String path) throws IOException {
        path = path.concat("/jbudget_saves");
        Controller c = new Controller(new Ledge(),new BudgetManager(), new IDManager());
        //loadAccounts(path,c);
        loadTags(path,c);
        return c;
    }

    @Override
    public boolean checkSave(String s) {
        return new File(s.concat("/jbudget_saves")).exists();
    }

    private void loadAccounts(String s,Controller c) throws IOException {
        File f = new File(s.concat("/accounts.txt"));
        Scanner scanner = new Scanner(f);
        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
        while(scanner.hasNextLine()){
            AccountInterface acc = gson.fromJson(scanner.nextLine(), Account.class);
            c.addAccount(acc);
        }
    }

    private void loadTags(String s,Controller c) throws IOException {
        File f = new File(s.concat("/accounts.txt"));
        Scanner scanner = new Scanner(f);
        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
        while(scanner.hasNextLine()){
            TagInterface tag = gson.fromJson(scanner.nextLine(), TagInterface.class);
            c.addTag(tag);
        }
    }

}
