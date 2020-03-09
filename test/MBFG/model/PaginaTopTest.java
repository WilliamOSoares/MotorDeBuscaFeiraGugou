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
 * Teste da pagina do top.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class PaginaTopTest {
    
    private PaginaTop p;
    
    @Before
    public void setUp() {
        p = new PaginaTop("arquivo");
    }

    @Test
    public void testGetNome() {
        assertEquals("arquivo", p.getNome());
    }

    @Test
    public void testGetVisitas() {
        assertEquals(1, p.getVisitas());
        p.setVisitasMaisUm();
        assertEquals(2, p.getVisitas());
        p.setVisitasMaisUm();
        p.setVisitasMaisUm();
        p.setVisitasMaisUm();
        assertEquals(5, p.getVisitas());
    }

    @Test
    public void testSetVisitasMaisUm() {
        assertEquals(1, p.getVisitas());
        p.setVisitasMaisUm();
        assertEquals(2, p.getVisitas());
        p.setVisitasMaisUm();
        assertEquals(3, p.getVisitas());
    }

    @Test
    public void testCompareTo() {
        PaginaTop p2 = new PaginaTop("aaa");
        PaginaTop p3 = new PaginaTop("zzz");
        p.setVisitasMaisUm();
        p.setVisitasMaisUm();
        p2.setVisitasMaisUm();
        p3.setVisitasMaisUm();
        assertEquals(1, p.compareTo(p2));
        assertEquals(-1, p2.compareTo(p));
        assertEquals(1, p3.compareTo(p2));
        assertEquals(0, p.compareTo(p));
    }
    
}
