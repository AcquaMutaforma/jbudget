package it.unicam.cs.pa.jbudget102627.view;

import it.unicam.cs.pa.jbudget102627.Controller;
import it.unicam.cs.pa.jbudget102627.ledge.Tag;
import it.unicam.cs.pa.jbudget102627.ledge.TagInterface;

import java.io.IOException;

public class PrintTag extends Printer implements PrintTagInterface{

    @Override
    public void printTag(TagInterface t) {
        String s = ("\nTag -- id: "+t.getId()+"\tname: "+t.getName());
        System.out.println(s);
    }

    @Override
    public TagInterface addTag(Controller controller) {
        String name;
        try{
            System.out.println("\nAdding a new Tag..");
            System.out.println("\nInsert name : ");
            name = returnLine();
        }catch (IOException e) {
            return null;
        }
        if(controller.getTag(name) != null) {

            System.out.println("\nTag not inserted, same name as an existing one..");
            return null;
        }
        int id = controller.generateIDof("tag");
        TagInterface t = new Tag(id,name);
        System.out.println("\nTag insert successfully !");
        return t;
    }

    @Override
    public TagInterface rmTag(Controller controller) {
        System.out.println("\nRemoving a Tag..");
        try{
            System.out.println("\nInsert the ID of the tag to remove : ");
            int id = Integer.parseInt(returnLine());
            TagInterface t = controller.getTag(id);
            System.out.println("\nTag with id ' "+id+" ' has been removed successfully!");
            return t;
        }catch (IOException e){ return null; }
    }
}
