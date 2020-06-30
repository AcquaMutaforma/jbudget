package it.unicam.cs.pa.jbudget.budget;

import it.unicam.cs.pa.jbudget.model.*;
import org.junit.jupiter.api.Test;

import javax.security.auth.login.CredentialException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class BudgetReportTest {

    @Test
    void getReport() {
        BudgetInterface bud = new Budget("prova",1);
        TagInterface t1 = new Tag(1,"auto");
        TagInterface t2 = new Tag(2,"2020");
        List<TagInterface> taglist = new ArrayList<>();
        taglist.add(t1);
        taglist.add(t2);
        LedgeInterface ledge = new Ledge();
        TransactionInterface tra = new Transaction(1,LocalDate.now());
        AccountInterface a = new Account(1,0,"test","desc",AccountType.ASSET);
        MovementInterface m1 = new Movement(1,12,"prova",MovementType.CREDIT,taglist,LocalDate.now(),a);
        tra.addMovement(m1);
        ledge.addAccount(a);
        ledge.addTag(t1);
        ledge.addTag(t2);
        ledge.addTransaction(tra);
        bud.set(t1,100.0);
        bud.set(t2,0.0);

        BReportInterface rep = new BudgetReport(1,bud,ledge);
        Map<TagInterface,Double> map = rep.getReport();

        assertFalse(map.isEmpty());
        assertEquals(map.get(t1),m1.getValue());
        assertNull(map.get(t2));
    }
}