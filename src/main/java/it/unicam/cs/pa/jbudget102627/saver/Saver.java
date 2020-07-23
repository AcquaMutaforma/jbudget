package it.unicam.cs.pa.jbudget102627.saver;

import com.google.gson.Gson;
import it.unicam.cs.pa.jbudget102627.Controller;
import it.unicam.cs.pa.jbudget102627.budget.BudgetInterface;
import it.unicam.cs.pa.jbudget102627.ledge.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * ha la responsabilita' di salvare tutti i dati presenti nel programma sul disco.
 */
public class Saver implements SaverInterface{

    /**
     * crea una cartella nel percorso inserito e va a salvare tutti gli oggetti
     * attraverso Gson in file txt
     * @param s percorso in cui salvare i dati
     * @param controller attuale istanza del programma.
     * @throws IOException se non si hanno permessi di scrittura nel percorso inserito
     */
    @Override
    public void saveController(String s, Controller controller) throws IOException {
        s = s.concat("/jbudget_saves");
        File file = new File(s);
        file.mkdir();
        saveIDManager(s,controller);

        if(!controller.getAccounts().isEmpty())
            saveAccounts(s,controller.getAccounts());
        if(!controller.getTags().isEmpty())
            saveTags(s,controller.getTags());
        if(!controller.getTransactions().isEmpty()) {
            saveMovements(s,controller.getMovements());
            saveTransactions(s, controller.getTransactions());
        }
        if(!controller.getScheduledTransactions().isEmpty())
            saveScheduled(s,controller.getScheduledTransactions());
        if(!controller.getBudgets().isEmpty())
            saveBudget(s,controller.getBudgets());
    }

    @Override
    public boolean checkSave(String s) {
        return new File(s.concat("/jbudget_saves")).exists();
    }

    private void saveIDManager(String s,Controller controller) throws IOException {
        s = s.concat("/idmanager.txt");
        Gson gson = new Gson();
        eraseLastSaves(s);
        writeXtoY(gson.toJson(controller.getIDManager()).concat("\n"),s);
    }

    private void saveTags(String s, List<TagInterface> taglist) throws IOException {
        s = s.concat("/tags.txt");
        Gson gson = new Gson();
        eraseLastSaves(s);
        for(TagInterface t : taglist){
            writeXtoY(gson.toJson(t).concat("\n"),s);
        }
    }

    private void saveAccounts(String s, List<AccountInterface> acclist) throws IOException{
        s = s.concat("/accounts.txt");
        Gson gson = new Gson();
        eraseLastSaves(s);
        for(AccountInterface acc : acclist){
            writeXtoY(gson.toJson(acc).concat("\n"),s);
        }
    }

    private void saveTransactions(String s, List<TransactionInterface> translist) throws IOException{
        s = s.concat("/transactions.txt");
        Gson gson = new Gson();
        eraseLastSaves(s);
        for(TransactionInterface tra : translist){
            writeXtoY(gson.toJson(tra).concat("\n"),s);
        }
    }

    private void saveScheduled(String s, List<TransactionInterface> schedlist) throws IOException{
        s = s.concat("/scheduleds.txt");
        Gson gson = new Gson();
        eraseLastSaves(s);
        for(TransactionInterface sched : schedlist){
            writeXtoY(gson.toJson(sched).concat("\n"),s);
        }
    }

    private void saveBudget(String s, List<BudgetInterface> budlist) throws IOException{
        s = s.concat("/budgets.txt");
        Gson gson = new Gson();
        eraseLastSaves(s);
        for(BudgetInterface acc : budlist){
            writeXtoY(gson.toJson(acc).concat("\n"),s);
        }
    }

    private void saveMovements(String s, List<MovementInterface> movlist) throws IOException{
        s = s.concat("/movements.txt");
        Gson gson = new Gson();
        eraseLastSaves(s);
        for(MovementInterface mov : movlist){
            writeXtoY(gson.toJson(mov).concat("\n"),s);
        }
    }

    /**
     * Responsabile di scrivere l'oggetto trasformato in stringa attraverso Gson nel file
     * @param s oggetto sotto forma di stringa
     * @param filename percorso del file in cui scrivere
     * @throws IOException se non riesce a scrivere sul file.
     */
    private void writeXtoY(String s, String filename) throws IOException {
        File file = new File(filename);
        FileWriter writer = new FileWriter(file,true);
        writer.append(s);
        writer.close();
    }

    /**
     * Cancella i salvataggi precedenti presenti nel file.
     * @param filename percorso del file da resettare
     * @throws IOException se non riesce a scrivere sul file
     */
    private void eraseLastSaves(String filename) throws IOException {
        FileWriter writer= new FileWriter(filename);
        writer.write("");
        writer.close();
    }
}
