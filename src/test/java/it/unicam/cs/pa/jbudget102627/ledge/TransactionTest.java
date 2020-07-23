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
        List<Integer> tag = new ArrayList<>();
        tag.add(t.getId());
        Movement m = new Movement(0,20,"",MovementType.CREDIT,tag,null,null);

        assertEquals(tra.getTotalAmount(), 0);
        tra.addMovement(m);
        assertFalse(tra.getMovements().isEmpty());
        assertEquals(tra.getTotalAmount(),m.getValue());
        tra.rmMovement(m);
        assertFalse(tra.getTotalAmount()>0);
    }

}