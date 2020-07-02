package it.unicam.cs.pa.jbudget;

import it.unicam.cs.pa.jbudget.budget.BudgetManager;
import it.unicam.cs.pa.jbudget.model.IDManager;
import it.unicam.cs.pa.jbudget.model.Ledge;
import it.unicam.cs.pa.jbudget.saver.Saver;
import it.unicam.cs.pa.jbudget.saver.SaverInterface;
import it.unicam.cs.pa.jbudget.view.ViewCli;
import it.unicam.cs.pa.jbudget.view.ViewInterface;

public class App {

    private Controller controller;
    private ViewInterface view;
    private SaverInterface saver;

    public App(ViewInterface view, SaverInterface saver) {
        this.view = view;
        this.saver = saver;
        this.controller = saver.loadController();
        if(this.controller == null)
            this.controller = new Controller(new Ledge(),new BudgetManager(),new IDManager());
    }

    public static void main(String[] args) {
        App app = start();
        app.viewStart();
    }

    public static App start(){
        ViewInterface view = new ViewCli();
        SaverInterface save = new Saver();
        return new App(view,save);
    }

    public void viewStart(){
        //todo probabilmente non deve stare qui
        this.view.printHello();
        /* todo: qui la view chiede a spam il getCommand, quando ha finito qui gli dico di fare print goodbye
        *
        * todo: qua nella app ci saranno i comandi <string,consumer<controller>> che verranno passati alla view ?
        *  beh almeno per fare il print poi dopo si vedra' come farglieli eseguire  */
    }
}
