package it.unicam.cs.pa.jbudget102627.saver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.unicam.cs.pa.jbudget102627.Controller;
import it.unicam.cs.pa.jbudget102627.ledge.AccountInterface;
import it.unicam.cs.pa.jbudget102627.ledge.TagInterface;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.List;

public class Saver implements SaverInterface{

    @Override
    public void saveController(String s, Controller controller) throws IOException {
        s = s.concat("/jbudget_saves");
        File file = new File(s);
        file.mkdir();
        saveAccounts(s,controller.getAccounts());
        saveTags(s,controller.getTags());
    }

    @Override
    public boolean checkSave(String s) {
        return new File(s.concat("/jbudget_saves")).exists();
    }

    private void saveTags(String s, List<TagInterface> taglist) throws IOException {
        s = s.concat("/tags.txt");
        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
        eraseLastSaves(s);
        for(TagInterface t : taglist){
            writeXtoY(gson.toJson(t).concat("\n"),s);
        }

    }

    private void saveAccounts(String s, List<AccountInterface> acclist) throws IOException{
        s = s.concat("/accounts.txt");
        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
        eraseLastSaves(s);
        for(AccountInterface acc : acclist){
            writeXtoY(gson.toJson(acc).concat("\n"),s);
        }
    }

    private void writeXtoY(String obj, String filename) throws IOException {
        File file = new File(filename);
        FileWriter writer = new FileWriter(file,true);
        writer.append(obj);
        writer.close();
    }

    private void eraseLastSaves(String filename) throws IOException {
        File file = new File(filename);
        FileWriter writer= new FileWriter(filename);
        if(file.exists()) {
            writer.write("");
        }else{
            file.createNewFile();
        }
        writer.close();
    }
}
