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
package MBFG.util;

import MBFG.model.Palavra;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste da árvore.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class ArvoreAVLTest {
    
    private ArvoreAVL tree;
    private Palavra p;
    private Palavra p1;
    private Palavra p2;
    
    @Before
    public void setUp() {
        tree = new ArvoreAVL();
        p = new Palavra("aaa");
        p1 = new Palavra("bbb");
        p2 = new Palavra("ddd");
    }

    @Test
    public void testIsEmpty() {
        assertTrue(tree.isEmpty());
        tree.inserir(p, "arquivo");
        assertFalse(tree.isEmpty());
        tree.remover(p);
        assertTrue(tree.isEmpty());
    }

    @Test
    public void testTamanho() {
        assertEquals(0, tree.tamanho());
        tree.inserir(p, "arquivo");
        tree.inserir(p1, "arquivo");
        tree.inserir(p2, "arquivo");
        assertEquals(3, tree.tamanho());
        tree.remover(p);
        assertEquals(2, tree.tamanho());
        tree.remover(p1);
        tree.remover(p2);
        assertEquals(0, tree.tamanho());
    }

    @Test
    public void testInserir() {
        tree.inserir(p, "arquivo");
        tree.inserir(p1, "arquivo");
        tree.inserir(p2, "arquivo");
        assertEquals(p, tree.busca(p));
        assertEquals(p1, tree.busca(p1));
        assertEquals(p2, tree.busca(p2));
        tree.remover(p1);
        assertEquals(null, tree.busca(p1));
    }

    @Test
    public void testRemover() {
        tree.inserir(p, "arquivo");
        tree.inserir(p1, "arquivo");
        tree.inserir(p2, "arquivo");
        assertEquals(p, tree.busca(p));
        tree.remover(p);
        assertEquals(null, tree.busca(p));
        assertEquals(p2, tree.busca(p2));
        tree.remover(p2);
        assertEquals(null, tree.busca(p2));
        assertEquals(p1, tree.busca(p1));
        tree.remover(p1);
        assertEquals(null, tree.busca(p1));
        assertTrue(tree.isEmpty());
    }

    @Test
    public void testBusca() {
        tree.inserir(p, "arquivo");
        assertEquals(p, tree.busca(p));
    }

    @Test
    public void testExibirEmOrdem() {
        tree.inserir(p, "arquivo");
        tree.inserir(p1, "arquivo");
        tree.inserir(p2, "arquivo");
        System.out.println("Ordem certa\n"
                           + "aaa\n"
                           + "bbb\n"
                           + "ddd\n");
        System.out.println("Ordem da árvore");
        tree.exibirEmOrdem();
    }
}
