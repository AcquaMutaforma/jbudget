package it.unicam.cs.pa.jbudget.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LedgeTest {

    @Test
    void removingAccount() {
        Account a = new Account(0,0.0,"aa","aa",AccountType.ASSET);
        Ledge ledge = new Ledge();
        assertTrue(ledge.getAccounts().isEmpty());
        ledge.addAccount(a);
        assertFalse(ledge.getAccounts().isEmpty());
        ledge.rmAccount(a);
        assertFalse(ledge.getAccounts().contains(a));
        assertTrue(ledge.getAccounts().isEmpty());
    }
}