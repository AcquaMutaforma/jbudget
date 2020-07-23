package it.unicam.cs.pa.jbudget102627.view;

import it.unicam.cs.pa.jbudget102627.Controller;
import it.unicam.cs.pa.jbudget102627.budget.BReportInterface;
import it.unicam.cs.pa.jbudget102627.budget.Budget;
import it.unicam.cs.pa.jbudget102627.budget.BudgetInterface;
import it.unicam.cs.pa.jbudget102627.ledge.TagInterface;

import java.io.IOException;

/**
 * Responsabile della rappresentazione grafica dei budget e dei report.
 */
public class PrintBReport extends Printer implements PrintBReportInterface{

    @Override
    public void printReport(BReportInterface report, Controller controller) {
        System.out.println("\nBudget -- id: "+report.getId()+"\tname: "+report.getName()+"\n");
        for(int tag : report.getTags()){
            TagInterface t = controller.getTag(tag);
            System.out.println("|\ttag: "+t.getName()+"\tvalue: "+report.getValueOf(t));
        }
    }

    @Override
    public BudgetInterface addBudget(Controller controller) {
        PrintTag printtag = new PrintTag();
        System.out.println("\nAdding a new Budget...");
        String name;
        BudgetInterface b;
        try{
            System.out.println("\nInsert the name of the budget: ");
            name = returnLine();
            System.out.println("\nYou can use the tags as a filter, for example to ignore too old transactions you can use a tag with the year 2020\n"+
                    "and set his expected value as 0, it will not be calculated.\n\nHow much tags do you want to add ?: ");
            int a = Integer.parseInt(returnLine());
            b = new Budget(name,controller.generateIDof("budget"));
            for(TagInterface t : controller.getTags()){
                printtag.printTag(t);
            }
            for(int i = 0; i < a; i++){
                System.out.println("\nInsert the id of the tag to add at the budget: ");
                TagInterface t = controller.getTag(Integer.parseInt(returnLine()));
                System.out.println("\nInsert the expected value of this tag: ");
                double v = Double.parseDouble(returnLine());
                b.set(t.getId(),v);
            }
        }catch (IOException e){
            System.out.println("\nOne or more of the insert values was incorrect..");
            return null;
        }
        return b;
    }

    @Override
    public BReportInterface rmBudget(Controller controller) {
        System.out.println("\nRemoving a budget..");
        int id;
        try{
            System.out.println("\nInsert the id of the budget to remove: ");
            id = Integer.parseInt(returnLine());
        }catch (IOException e){
            return null;
        }
        return controller.getReport(id);
    }
}
