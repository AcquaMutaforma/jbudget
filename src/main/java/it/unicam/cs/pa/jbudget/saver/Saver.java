package it.unicam.cs.pa.jbudget.saver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.unicam.cs.pa.jbudget.Controller;
import it.unicam.cs.pa.jbudget.model.TagInterface;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Saver implements SaverInterface{


    @Override
    public Controller loadController(String s) {
        return null;
    }

    @Override
    public void saveController(String s, Controller controller) throws IOException {
        s = s.concat("/jbudget_saves");
        File file = new File(s);
        file.mkdir();
        saveTags(s,controller.getTags());
    }

    @Override
    public boolean checkSave(String s) {
        s = s.concat("/jbudget_saves");
        return new File(s).exists();
    }

    private void saveTags(String s, List<TagInterface> taglist) throws IOException {
        s = s.concat("/tags.txt");
        String toadd = "";
        File file = new File(s);
        FileWriter writer = new FileWriter(s,true);
        Gson gson = new Gson();

        for(TagInterface t : taglist){
            toadd = gson.toJson(t).concat("\n");
        }
        flushSaves(s);
        writeXtoY(toadd,s);

        //TODO forse puoi trasformare gli oggetti in stringhe con un solo metodo e poi chiamare
        //questo metodo qui per salvare il tutto
    }

    private void writeXtoY(String obj, String filename) throws IOException {
        File file = new File(filename);
        FileWriter writer = new FileWriter(filename,true);
        writer.append(obj);
        writer.close();
    }

    private void flushSaves(String filename) throws IOException {
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
