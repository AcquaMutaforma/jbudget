package it.unicam.cs.pa.jbudget;

import it.unicam.cs.pa.jbudget.budget.BudgetManager;
import it.unicam.cs.pa.jbudget.model.Ledge;
import it.unicam.cs.pa.jbudget.saver.LoadInterface;
import it.unicam.cs.pa.jbudget.saver.Loader;
import it.unicam.cs.pa.jbudget.saver.Saver;
import it.unicam.cs.pa.jbudget.saver.SaverInterface;
import it.unicam.cs.pa.jbudget.view.ViewCli;
import it.unicam.cs.pa.jbudget.view.ViewInterface;

import java.util.HashMap;
import java.util.TreeSet;
import java.util.function.Consumer;

public class App {
    /*TODO il main crea i comandi<Controller> x-> x.addTransaction(t) che vengono chiamati da view,
       perche ricevo da input un comando e in base al comando il main chiama controller o view
       mica posso usare lo switch >_<  */

    private Controller controller;
    private ViewInterface view;
    private SaverInterface saver;
    private HashMap<String,Consumer<ViewInterface>> commands;
    private LoadInterface loader;

    public App() {
        this.loader = new Loader();
        this.saver = new Saver();
        this.controller = new Controller(new Ledge(),new BudgetManager(),new IDManager());
        this.view = new ViewCli(this.controller);
        createCommands();
    }

    public static void main(String[] args) throws UnknownCommand {
        App app = new App();
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
        commands.put("help",s-> s.printCommands(new TreeSet(commands.keySet())));
        commands.put("addAccount", s -> s.addAccount());
        commands.put("rmAccount", x-> x.rmAccount());
        commands.put("addTransaction", x-> x.addTransaction());
        commands.put("rmTransaction", x -> x.rmTransaction());
        commands.put("addTag", t -> t.addTag());
        commands.put("rmTag", t -> t.rmTag());
        commands.put("addBudget", s -> s.addBudget());
        commands.put("rmBudget", x-> x.rmBudget());
        commands.put("rmMovement", x-> x.rmMovement());
        /*
        commands.put("editAccount")
        commands.put("editTransaction")
        commands.put("editTag")
        commands.put("editBudget")
        */
        commands.put("save", x -> x.printSave(this.saver));
        commands.put("load", x-> x.printLoad(this.loader,this));

        commands.put("tutorial", x-> x.printTutorial());
        commands.put("exit", x -> x.printGoodbye());
        this.commands = commands;
    }

    public void loadController(Controller c){
        if(c != null){
            this.controller = c;
            this.view.setController(c);
        }
    }
}
