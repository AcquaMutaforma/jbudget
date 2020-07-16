package it.unicam.cs.pa.jbudget102627.saver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.unicam.cs.pa.jbudget102627.Controller;
import it.unicam.cs.pa.jbudget102627.IDManager;
import it.unicam.cs.pa.jbudget102627.budget.Budget;
import it.unicam.cs.pa.jbudget102627.budget.BudgetInterface;
import it.unicam.cs.pa.jbudget102627.budget.BudgetManager;
import it.unicam.cs.pa.jbudget102627.ledge.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Scanner;

public class Loader implements LoadInterface{
    @Override
    public Controller loadController(String path) throws IOException {
        path = path.concat("/jbudget_saves");
        Controller c = new Controller(new Ledge(),new BudgetManager(), new IDManager());
        loadAccounts(path,c);
        loadTags(path,c);
        loadBudgets(path,c);
        loadTransactions(path,c);

        return c;
    }

    @Override
    public boolean checkSave(String s) {
        return new File(s.concat("/jbudget_saves")).getAbsoluteFile().exists();
    }

    private void loadAccounts(String s,Controller c) throws IOException {
        File f = new File(s.concat("/accounts.txt"));
        if(!f.getAbsoluteFile().exists())
            return;
        Scanner scanner = new Scanner(f);
        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
        while(scanner.hasNextLine()){
            AccountInterface acc = gson.fromJson(scanner.nextLine(), Account.class);
            acc.setMovements(new ArrayList<>());
            acc.balanceToOpening();
            c.addAccount(acc);
        }
    }

    private void loadTags(String s,Controller c) throws IOException {
        File f = new File(s.concat("/tags.txt"));
        if(!f.getAbsoluteFile().exists())
            return;
        Scanner scanner = new Scanner(f);
        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
        while(scanner.hasNextLine()){
            TagInterface tag = gson.fromJson(scanner.nextLine(), Tag.class);
            c.addTag(tag);
        }
    }

    private void loadTransactions(String s,Controller c) throws IOException {
        File f = new File(s.concat("/transactions.txt"));
        if(!f.getAbsoluteFile().exists())
            return;
        Scanner scanner = new Scanner(f);
        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
        while(scanner.hasNextLine()){
            Transaction tra = gson.fromJson(scanner.nextLine(), Transaction.class);
            c.addTransaction(tra);
        }
    }

    private void loadBudgets(String s,Controller c) throws IOException {
        File f = new File(s.concat("/budgets.txt"));
        if(!f.getAbsoluteFile().exists())
            return;
        Scanner scanner = new Scanner(f);
        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
        while(scanner.hasNextLine()){
            BudgetInterface bud = gson.fromJson(scanner.nextLine(), Budget.class);
            c.addBudget(bud);
        }
    }


}
