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

import MBFG.util.MyArray;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste da palavra.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class PalavraTest {
    
    private Palavra p;
    private MyArray m;
    @Before
    public void setUp() {
        p = new Palavra("abc");
        m = new MyArray(2);
    }

    @Test
    public void testGetNome() {
        assertEquals("abc", p.getNome());
        p = new Palavra("cba");
        assertEquals("cba", p.getNome());
    }

    @Test
    public void testGetArquivos() {
        assertTrue(p.getArquivos().isEmpty());
        p.iguais("arq");
        assertFalse(p.getArquivos().isEmpty());        
    }

    @Test
    public void testCompareTo() {
        Palavra p1 = new Palavra("aaa");
        Palavra p2 = new Palavra("bbbS");
        assertEquals(1, p.compareTo(p1));
        assertEquals(-1, p.compareTo(p2));
        assertEquals(0, p.compareTo(p));
    }

    @Test
    public void testToString() {
        assertEquals("A palavra abc foi encontrada ", p.toString());
    }

    @Test
    public void testIguais() {
        assertEquals(0, p.getArquivos().size());
        p.iguais("arq");
        assertEquals(1, p.getArquivos().size());
        p.iguais("arq");
        assertEquals(1, p.getArquivos().size());
        p.iguais("arquivo");
        assertEquals(2, p.getArquivos().size());
    }
    
}
