package it.unicam.cs.pa.jbudget102627.view;

import it.unicam.cs.pa.jbudget102627.Controller;
import it.unicam.cs.pa.jbudget102627.ledge.Account;
import it.unicam.cs.pa.jbudget102627.ledge.AccountInterface;
import it.unicam.cs.pa.jbudget102627.ledge.AccountType;

import java.io.IOException;

public class PrintAccount extends Printer implements PrintAccInterface{

    @Override
    public void printAccount(AccountInterface a) {
        String s = ("\nAccount -- id: "+a.getId()+"\tname: "+a.getName()+"\tbalance: "+a.getBalance()+"\ttype: "+a.getType());
        System.out.println(s);
    }

    @Override
    public AccountInterface addAccount(Controller controller) {
        double openingbalance = 0.0;
        String name;
        String description;
        AccountType type = null;
        try{
            System.out.println("\nAdding a new Account..");
            System.out.println("\nInsert name : ");
            name = returnLine();
            if(controller.getAccount(name) != null){
                System.out.print("\nAccount not inserted, same name as an existing one..");
                return null;
            }
            System.out.println("\nInsert description : ");
            description = returnLine();
            System.out.println("\nInsert type of account, asset or liability [a / l] : ");
            String t = returnLine();
            if(t.contains("a")) {
                type = AccountType.ASSET;
            }
            if(t.toLowerCase() == "l"){
                type = AccountType.LIABILITIES;
            }
            System.out.println("\nInsert the opening balance : ");
            openingbalance = Double.parseDouble(returnLine());
        } catch (IOException e) {
            return null;
        }
        int id = controller.generateIDof("account");
        AccountInterface a = new Account(id,openingbalance,name,description,
                type);
        printAccount(a);
        System.out.println("\nAccount insert correctly!");
        return a;
    }

    @Override
    public AccountInterface rmAccount(Controller controller) {
        System.out.println("\nRemoving a Account..");
        try{
            System.out.println("\nInsert the ID of the account to remove : ");
            int id = Integer.parseInt(returnLine());
            AccountInterface a = controller.getAccount(id);
            return a;
        }catch (IOException e){
            System.out.println("\nAccount with the insert id was not found..");
            return null; }
    }

}
