package it.unicam.cs.pa.jbudget.view;

import it.unicam.cs.pa.jbudget.Controller;
import it.unicam.cs.pa.jbudget.budget.BReportInterface;
import it.unicam.cs.pa.jbudget.budget.Budget;
import it.unicam.cs.pa.jbudget.budget.BudgetInterface;
import it.unicam.cs.pa.jbudget.model.TagInterface;

import java.io.IOException;

public class PrintBReport extends Printer implements PrintBReportInterface{

    @Override
    public void printReport(BReportInterface report) {
        System.out.println("\nBudget -- id: "+report.getId()+"\tname: "+report.getName()+"\n");
        for(TagInterface t : report.getTags()){
            System.out.println("\ttag: "+t.getName()+"value: "+report.getValueOf(t));
        }
    }

    @Override
    public BudgetInterface addBudget(Controller controller) {
        System.out.println("\nAdding a new Budget...");
        String name = "";
        BudgetInterface b = null;
        try{
            System.out.println("\nInsert the name of the budget: ");
            name = returnLine();
            System.out.println("\nHow much tags do you want to add ?: ");
            int a = Integer.parseInt(returnLine());

            b = new Budget(name,controller.generateIDof("budget"));
            for(int i = 0; i < a; i++){
                System.out.println("\nInsert the id of the tag to add at the budget: ");
                TagInterface t = controller.getTag(Integer.parseInt(returnLine()));
                System.out.println("\nInsert the expected value of this tag: ");
                double v = Double.parseDouble(returnLine());
                b.set(t,v);
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
