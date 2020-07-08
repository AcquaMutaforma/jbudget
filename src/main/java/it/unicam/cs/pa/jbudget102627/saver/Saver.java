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
        saveTags(s,controller.getTags());
        saveAccounts(s,controller.getAccounts());
        //TODO il resto
    }

    @Override
    public boolean checkSave(String s) {
        return new File(s.concat("/jbudget_saves")).exists();
    }

    private void saveTags(String s, List<TagInterface> taglist) throws IOException {
        s = s.concat("/tags.txt");
        String toadd = "";
        File file = new File(s);
        FileWriter writer = new FileWriter(s,true);
        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();

        for(TagInterface t : taglist){
            toadd = gson.toJson(t).concat("\n");
        }
        eraseLastSaves(s);
        writeXtoY(toadd,s);

    }

    private void saveAccounts(String s, List<AccountInterface> acclist) throws IOException{
        s = s.concat("/accounts.txt");
        String toadd = "";
        File file = new File(s);
        FileWriter writer = new FileWriter(s,true);
        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
        for(AccountInterface acc : acclist){
            toadd = gson.toJson(acc).concat("\n");
        }
        eraseLastSaves(s);
        writeXtoY(toadd,s);
    }

    private void writeXtoY(String obj, String filename) throws IOException {
        File file = new File(filename);
        FileWriter writer = new FileWriter(filename,true);
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
