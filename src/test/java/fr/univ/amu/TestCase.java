package fr.univ.amu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestCase {
    @Test
    public void testCreationCase(){
        Case c1 = new Case(12);
        assertEquals(c1.getValeur(),12);
        assertFalse(c1.estUtilise());
    }

    @Test
    public void changementStatutCase(){
        Case c1 = new Case(23);
        c1.utilisationCase();
        assertTrue(c1.estUtilise());
    }

    @Test
    public void changementStatutCaseDeValeur1(){
        Case c1 = new Case(1);
        c1.utilisationCase();
        assertFalse(c1.estUtilise());
        c1.utilisationCase();
        assertTrue(c1.estUtilise());
    }
}
