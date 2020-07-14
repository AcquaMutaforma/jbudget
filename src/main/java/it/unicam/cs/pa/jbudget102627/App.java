package it.unicam.cs.pa.jbudget102627;

import it.unicam.cs.pa.jbudget102627.budget.BudgetManager;
import it.unicam.cs.pa.jbudget102627.ledge.Ledge;
import it.unicam.cs.pa.jbudget102627.saver.LoadInterface;
import it.unicam.cs.pa.jbudget102627.saver.Loader;
import it.unicam.cs.pa.jbudget102627.saver.Saver;
import it.unicam.cs.pa.jbudget102627.saver.SaverInterface;
import it.unicam.cs.pa.jbudget102627.view.ViewCli;
import it.unicam.cs.pa.jbudget102627.view.ViewInterface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.function.Consumer;

public class App {

    private Controller controller;
    private final ViewInterface view;
    private final SaverInterface saver;
    private HashMap<String,Consumer<ViewInterface>> commands;
    private final LoadInterface loader;

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
        commands.put("help",s-> s.printCommands(new TreeSet<String>(commands.keySet())));
        commands.put("addAccount", ViewInterface::addAccount);
        commands.put("rmAccount", ViewInterface::rmAccount);
        commands.put("addTransaction", ViewInterface::addTransaction);
        commands.put("rmTransaction", ViewInterface::rmTransaction);
        commands.put("addTag", ViewInterface::addTag);
        commands.put("rmTag", ViewInterface::rmTag);
        commands.put("addBudget", ViewInterface::addBudget);
        commands.put("rmBudget", ViewInterface::rmBudget);
        commands.put("rmMovement", ViewInterface::rmMovement);

        commands.put("statistics", ViewInterface::printPeriodList);
        commands.put("getTransactions", ViewInterface::getTransactions);
        commands.put("getScheduled", ViewInterface::getScheduled);
        commands.put("getMovements", x -> {
            try {
                x.getMovementsOf();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        commands.put("creaPrestito",ViewInterface::newPrestito);

        commands.put("save", x -> x.printSave(this.saver));
        commands.put("load", x-> {
            try {
                x.printLoad(this.loader,this);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        commands.put("tutorial", ViewInterface::printTutorial);
        commands.put("exit", ViewInterface::printGoodbye);
        this.commands = commands;
    }

    public void loadController(Controller c){
        if(c != null){
            this.controller = c;
            this.view.setController(c);
        }
    }
}
