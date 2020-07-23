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
        List<Integer> tag = new ArrayList<>();
        tag.add(t.getId());
        Movement m1 = new Movement(1,20,"",MovementType.CREDIT,tag,null,a);

        assertEquals(a.getBalance(),0);
        a.addMovement(m1);
        assertFalse(a.getBalance() <= 0);
        assertEquals(a.getBalance(), m1.getValue());
        a.rmMovement(m1);
        assertEquals(a.getBalance(),0);
    }

}