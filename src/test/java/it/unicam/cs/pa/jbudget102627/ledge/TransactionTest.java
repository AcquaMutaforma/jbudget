package it.unicam.cs.pa.jbudget102627.ledge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void getTotalAmount() {
        Transaction tra = new Transaction(0,null);
        Tag t = new Tag(0,"test");
        List<TagInterface> tag = new ArrayList<>();
        tag.add(t);
        Movement m = new Movement(0,20,"",MovementType.CREDIT,tag,null,null);

        assertTrue(tra.getTotalAmount() == 0);
        tra.addMovement(m);
        assertFalse(tra.getMovements().isEmpty());
        assertTrue(tra.getTotalAmount() == m.getValue());
        tra.rmMovement(m);
        assertFalse(tra.getTotalAmount()>0);
    }

    @Test
    void getMovementsWithPredicate() {
        Transaction tra = new Transaction(0,null);
        Tag t = new Tag(0,"test");
        List<TagInterface> tag = new ArrayList<>();
        tag.add(t);
        Movement m1 = new Movement(1,20,"",MovementType.CREDIT,tag,null,null);
        Movement m2 = new Movement(2,2.5,"",MovementType.CREDIT,tag,null,null);

        tra.addMovement(m1);
        tra.addMovement(m2);
        assertFalse(tra.getMovements(x -> x.getId() > 0).isEmpty());
        assertTrue(tra.getMovements(x-> x.getId() == 5).isEmpty());
        assertEquals(tra.getMovements(x->x.getId() == 1).size(),1);
    }

    @Test
    void rmMovementWithPredicate() {
        Transaction tra = new Transaction(0,null);
        Tag t = new Tag(0,"test");
        List<TagInterface> tag = new ArrayList<>();
        tag.add(t);
        Movement m1 = new Movement(1,20,"",MovementType.CREDIT,tag,null,null);
        Movement m2 = new Movement(2,2.5,"",MovementType.CREDIT,tag,null,null);

        tra.addMovement(m1);
        tra.addMovement(m2);
        assertEquals(tra.getMovements().size(),2);
        tra.rmMovement(x->x.getId() == 1);
        assertNotEquals(tra.getMovements().size(),2);
    }
}