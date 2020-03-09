/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MBFG.util;

import MBFG.model.PalavraTop;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author willi
 */
public class MyArrayTest {
    
    private MyArray a;
    
    @Before
    public void setUp() {
        a = new MyArray(2);
    }

    @Test
    public void testAdd() {
        PalavraTop p = new PalavraTop("Alemanha");
        PalavraTop p2 = new PalavraTop("Eliminada");
        assertTrue(a.isEmpty());
        a.add(p);
        assertFalse(a.isEmpty());
        assertEquals(1, a.size());
        a.add(p2);
        assertEquals(2, a.size());
    }

    @Test
    public void testGet() {
        PalavraTop p = new PalavraTop("Argentina");
        PalavraTop p2 = new PalavraTop("Eliminada");
        a.add(p);
        a.add(p2);
        assertEquals(p, a.get(p));
        assertEquals(p2, a.get(p2));
    }

    @Test
    public void testContains() {
        PalavraTop p = new PalavraTop("Polonia");
        PalavraTop p2 = new PalavraTop("Eliminada");
        a.add(p);
        assertFalse(a.contains(p2));
        a.add(p2);
        assertTrue(a.contains(p));
        assertTrue(a.contains(p2));
    }

    @Test
    public void testSize() {
        PalavraTop p = new PalavraTop("Espanha");
        PalavraTop p2 = new PalavraTop("Eliminada");
        assertEquals(0, a.size());
        a.add(p);
        assertEquals(1, a.size());
        a.add(p2);
        assertEquals(2, a.size());
    }

    @Test
    public void testIsEmpty() {
        PalavraTop p = new PalavraTop("Dinamarca");
        PalavraTop p2 = new PalavraTop("Eliminado");
        assertTrue(a.isEmpty());
        a.add(p);
        assertFalse(a.isEmpty());
    }

    @Test
    public void testOrdenar() {
        PalavraTop p = new PalavraTop("Portugal");
        PalavraTop p2 = new PalavraTop("Eliminada");
        p.setVezesBuscadasMaisUm();
        a.add(p);
        a.add(p2);
        a.ordenar();
        Iterador it = a.iterator();        
        PalavraTop p3 = (PalavraTop) it.proximo();
        assertEquals(p2, p3);
        p3 = (PalavraTop) it.proximo();
        assertEquals(p, p3);
        assertFalse(it.temProximo());
        PalavraTop p4 = new PalavraTop("Portugues");
        p4.setVezesBuscadasMaisUm();
        a.add(p4);
        a.ordenar();
        it = a.iterator();        
        p3 = (PalavraTop) it.proximo();
        assertEquals(p2, p3);
        p3 = (PalavraTop) it.proximo();
        assertEquals(p, p3);
        p3 = (PalavraTop) it.proximo();
        assertEquals(p4, p3);
        assertFalse(it.temProximo());
        
    }

    @Test
    public void testIterator() {
        PalavraTop p = new PalavraTop("Japao");
        PalavraTop p2 = new PalavraTop("Eliminada");
        a.add(p);
        a.add(p2);        
        Iterador it = a.iterator();        
        PalavraTop p3 = (PalavraTop) it.proximo();
        assertEquals(p, p3);
        p3 = (PalavraTop) it.proximo();
        assertEquals(p2, p3);
        assertFalse(it.temProximo());
    }
    
}
