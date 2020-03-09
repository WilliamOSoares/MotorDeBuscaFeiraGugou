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
 * Teste da palavra do top.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class PalavraTopTest {
    
    private PalavraTop p;
    
    @Before
    public void setUp() {
       p = new PalavraTop("busca"); 
    }

    @Test
    public void testGetNome() {
        assertEquals("busca", p.getNome());
    }

    @Test
    public void testGetVezesBuscadas() {
        assertEquals(1, p.getVezesBuscadas());
        p.setVezesBuscadasMaisUm();
        assertEquals(2, p.getVezesBuscadas());
        p.setVezesBuscadasMaisUm();
        assertEquals(3, p.getVezesBuscadas());
    }

    @Test
    public void testSetVezesBuscadasMaisUm() {
        assertEquals(1, p.getVezesBuscadas());
        p.setVezesBuscadasMaisUm();
        assertEquals(2, p.getVezesBuscadas());
        p.setVezesBuscadasMaisUm();
        p.setVezesBuscadasMaisUm();
        p.setVezesBuscadasMaisUm();
        assertEquals(5, p.getVezesBuscadas());
    }

    @Test
    public void testCompareTo() {
        PalavraTop p1 = new PalavraTop("aaa");
        PalavraTop p2 = new PalavraTop("bbbS");
        p.setVezesBuscadasMaisUm();
        p.setVezesBuscadasMaisUm();
        p1.setVezesBuscadasMaisUm();
        p2.setVezesBuscadasMaisUm();
        assertEquals(1, p.compareTo(p1));
        assertEquals(-1, p1.compareTo(p));
        assertEquals(1, p2.compareTo(p1));
        assertEquals(0, p.compareTo(p));
    }
    
}
