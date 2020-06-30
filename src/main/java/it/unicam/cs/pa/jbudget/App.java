package it.unicam.cs.pa.jbudget;

import it.unicam.cs.pa.jbudget.model.*;
import it.unicam.cs.pa.jbudget.saver.*;
import it.unicam.cs.pa.jbudget.view.*;
import it.unicam.cs.pa.jbudget.budget.*;

import javax.swing.text.View;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class App{

    private final LedgeInterface ledge;
    private final ViewInterface view;
    private final BManagerInterface budgetManager;
    private final IDManager idmanager;
    private final SaverInterface saver;

    private Map<String, Consumer<App>> commands;

    public App(LedgeInterface l, ViewInterface vi, SaverInterface s){
        this.ledge = l;
        this.view = vi;
        this.budgetManager = new BudgetManager();
        this.idmanager = new IDManager();
        this.saver = s;
    }

    public static void main(String[] args) {
        start();
    }

    public static void start(){
        App app = new App(new Ledge(), new ViewCli(), new Saver());
        app.createCommands();
        while (true) {
            String command = app.view.getCommand();
            Consumer<App> action = app.commands.get(command);
            action.accept(app);
            if(command == "bye")
                break;
        }
    }

    private void createCommands(){
        commands = new HashMap<>();
        commands.put("hi", s -> s.view.printHello());
        commands.put("help",s-> s.view.printGoodbye());
    }
    /*
    Conclusioni del pomeriggio del cazzo:
    View si deve occupare dei comandi diretti, ma in questo modo il controller non puo' lanciare questi comandi
    a tutti i pezzi del model come idmanager o budgetmanager... forse questo puo fare da controller e un altro main
    in un altra classe si occupa di lanciare i comandi tra lui e view, quindi questo e' il controller dei vari model(?)
    non lo so, qui sopra abbiamo fatto delle prove con il consumer, ma view e app sono troppo legati A(B) e B(A)
    forse c'e' un altra soluzione, pensaci meglio, tvb <3 byeee
     */
}