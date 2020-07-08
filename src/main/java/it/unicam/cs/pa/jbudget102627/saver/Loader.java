package it.unicam.cs.pa.jbudget102627.saver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.unicam.cs.pa.jbudget102627.Controller;
import it.unicam.cs.pa.jbudget102627.ledge.AccountInterface;
import it.unicam.cs.pa.jbudget102627.ledge.TagInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loader implements LoadInterface{
    @Override
    public Controller loadController(String path) throws FileNotFoundException {
        path = path.concat("/jbudget_saves");
        Controller c = null;


        return c;
    }

    @Override
    public boolean checkSave(String s) {
        return new File(s.concat("/jbudget_saves")).exists();
    }

    private List<AccountInterface> loadAccounts(String s) throws IOException {
        List<AccountInterface> accountlist = new ArrayList<>();
        File f = new File(s.concat("/accounts.txt"));
        Scanner scanner = new Scanner(f);
        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
        while(scanner.hasNextLine()){
            AccountInterface acc = gson.fromJson(scanner.nextLine(), AccountInterface.class);
            accountlist.add(acc);
        }
        return accountlist;
    }

    private List<TagInterface> loadTags(String s) throws IOException {
        List<TagInterface> taglist = new ArrayList<>();
        File f = new File(s.concat("/accounts.txt"));
        Scanner scanner = new Scanner(f);
        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
        while(scanner.hasNextLine()){
            TagInterface tag = gson.fromJson(scanner.nextLine(), TagInterface.class);
            taglist.add(tag);
        }
        return taglist;
    }
}
