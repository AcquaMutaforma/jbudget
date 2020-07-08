package it.unicam.cs.pa.jbudget102627.ledge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void getBalance() {
        AccountInterface a = new Account(1,0,"aa","aa",AccountType.ASSET);
        Tag t = new Tag(0,"test");
        List<TagInterface> tag = new ArrayList<>();
        tag.add(t);
        Movement m1 = new Movement(1,20,"",MovementType.CREDIT,tag,null,a);

        assertEquals(a.getBalance(),0);
        a.addMovement(m1);
        assertFalse(a.getBalance() <= 0);
        assertEquals(a.getBalance(), m1.getValue());
        a.rmMovement(m1);
        assertEquals(a.getBalance(),0);
    }

    @Test
    void getMovementsWithPredicate() {
        AccountInterface a = new Account(1,0,"aa","aa",AccountType.ASSET);
        Tag t = new Tag(0,"test");
        List<TagInterface> tag = new ArrayList<>();
        tag.add(t);
        Movement m1 = new Movement(1,20,"",MovementType.CREDIT,tag,null,a);
        Movement m2 = new Movement(2,20,"",MovementType.CREDIT,tag,null,a);
        Movement m3 = new Movement(3,20,"",MovementType.CREDIT,tag,null,a);
        a.addMovement(m1);
        a.addMovement(m2);
        a.addMovement(m3);

        assertTrue(a.getMovements(x->x.getId() > 4).isEmpty());
        assertFalse(a.getMovements(g -> g.getId() > 0).isEmpty());
        assertEquals(a.getMovements(k -> k.getId() == 2).size(),1);
        a.rmMovement(m2);
        assertTrue(a.getMovements(x->x.getId() == 2).isEmpty());
    }
}