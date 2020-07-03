package it.unicam.cs.pa.jbudget;

import it.unicam.cs.pa.jbudget.budget.BudgetManager;
import it.unicam.cs.pa.jbudget.model.IDManager;
import it.unicam.cs.pa.jbudget.model.Ledge;
import it.unicam.cs.pa.jbudget.saver.Saver;
import it.unicam.cs.pa.jbudget.saver.SaverInterface;
import it.unicam.cs.pa.jbudget.view.ViewCli;
import it.unicam.cs.pa.jbudget.view.ViewInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.function.Consumer;

public class App {
    /*TODO il main crea i comandi<Controller> x-> x.addTransaction(t) che vengono chiamati da view,
       perche ricevo da input un comando e in base al comando il main chiama controller o view
       mica posso usare lo switch >_<  */

    private Controller controller;
    private ViewInterface view;
    private SaverInterface saver;
    private HashMap<String,Consumer<ViewInterface>> commands;

    public App() {
        this.saver = new Saver();
        this.controller = saver.loadController();
        if(this.controller == null)
            this.controller = new Controller(new Ledge(),new BudgetManager(),new IDManager());
        this.view = new ViewCli(this.controller);
        this.commands = new HashMap<>();
    }

    public static void main(String[] args) throws UnknownCommand {
        App app = new App();
        app.createCommands();
        app.saver.saveControllerInLocal();

        app.start();
    }

    public void start() throws UnknownCommand {
        this.view.printHello();
        while (true) {
            String command = this.view.getCommand();
            Consumer<ViewInterface> action = this.commands.get(command);
            if(action == null){
                throw new UnknownCommand(command);
            }
            action.accept(this.view);
            if(command.equals("exit"))
                break;
        }
        System.exit(0);
    }

    private void createCommands(){
        HashMap<String,Consumer<ViewInterface>> commands = new HashMap<>();
        commands.put("hi", s -> s.printHello());
        commands.put("help",s-> s.printCommands());
        commands.put("addAccount", s -> s.addAccount(this.controller));
        commands.put("rmAccount", x-> x.rmAccount(this.controller));


        commands.put("exit", x -> x.printGoodbye());
        this.commands = commands;
    }
}
