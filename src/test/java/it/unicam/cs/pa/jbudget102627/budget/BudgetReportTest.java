package it.unicam.cs.pa.jbudget102627.budget;

import it.unicam.cs.pa.jbudget102627.ledge.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BudgetReportTest {

    @Test
    void getReport() {
        BudgetInterface bud = new Budget("prova",1);
        TagInterface t1 = new Tag(1,"auto");
        TagInterface t2 = new Tag(2,"2020");
        List<Integer> taglist = new ArrayList<>();
        taglist.add(t1.getId());
        taglist.add(t2.getId());
        LedgeInterface ledge = new Ledge();
        TransactionInterface tra = new Transaction(1,LocalDate.now());
        AccountInterface a = new Account(1,0,"test","desc",AccountType.ASSET);
        MovementInterface m1 = new Movement(1,12,"prova",MovementType.CREDIT,taglist,LocalDate.now(),a);
        ledge.addAccount(a);
        tra.addMovement(m1);
        ledge.addTag(t1);
        ledge.addTag(t2);
        ledge.addTransaction(tra);
        bud.set(t1.getId(),100.0);
        bud.set(t2.getId(),0.0);

        BReportInterface rep = new BudgetReport(1,bud,ledge);
        Map<Integer,Double> map = rep.getReport();

        assertFalse(map.isEmpty());
        assertEquals(map.get(t1.getId()),m1.getValue());
        assertNull(map.get(t2.getId()));
    }
}