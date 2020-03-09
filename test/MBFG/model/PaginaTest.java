// Motor de Busca Feira Gugou
/*******************************************************************************
Autores: Samuel Ramos dos Santos e William Oliveira Soares
Componente Curricular: MI Programação
Concluido em: 29/06/2018
Declaro que este código foi elaborado por nós de forma coletiva e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não seja a nossa está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
***************************************************************************************/
package MBFG.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste da Pagina.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class PaginaTest {
    
    private Pagina p;
    private Pagina p1;
    private Pagina p2;
    @Before
    public void setUp() {
        p = new Pagina("GloboLixo");
        p1 = new Pagina("SBosTa");
        p2 = new Pagina("Recocord");
    }

    @Test
    public void testGetNome() {
        assertEquals("GloboLixo", p.getNome());
        assertEquals("SBosTa", p1.getNome());
        assertEquals("Recocord", p2.getNome());
    }

    @Test
    public void testCompareTo() {
        assertEquals(-1, p.compareTo(p2));
        assertEquals(1, p1.compareTo(p));
        assertEquals(0, p.compareTo(p));
    }

    @Test
    public void testGetVezes() {
        assertEquals(1, p.getVezes());
        p.setVezesMaisUm();
        assertEquals(2, p.getVezes());
        p.setVezesMaisUm();
        p.setVezesMaisUm();
        assertEquals(4, p.getVezes());
    }

    @Test
    public void testSetVezesMaisUm() {
        assertEquals(1, p.getVezes());
        p.setVezesMaisUm();
        p.setVezesMaisUm();
        p.setVezesMaisUm();
        assertEquals(4, p.getVezes());
    }

    @Test
    public void testToString() {
        assertEquals("1 vez em GloboLixo", p.toString());
        p.setVezesMaisUm();
        assertEquals("2 vezes em GloboLixo", p.toString());
        assertEquals("1 vez em SBosTa", p1.toString());
        assertEquals("1 vez em Recocord", p2.toString());
    }

    @Test
    public void testEquals() {
        p = p1;
        assertTrue(p.equals(p1));
        assertFalse(p2.equals(p));
        p = p2;
        assertFalse(p.equals(p1));
        assertTrue(p2.equals(p));
        
    }   
}
