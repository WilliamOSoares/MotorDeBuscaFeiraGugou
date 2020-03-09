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

/**
 * Interface que auxilia no armazenamento de dados.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public interface IArvoreBinariaAVL {
    
    /**
     * Insere um objeto na árvore AVL.
     * @param k Objeto a ser inserido.
     * @param arquivo Nome do arquivo que contém a palavra.
     */
    public void inserir(Comparable k, String arquivo);
    /**
     * Remove um objeto da árvore caso o encontre.
     * @param k Objeto a ser removido.
     */
    public void remover(Comparable k);
    /**
     * Busca um objeto na árvore.
     * @param buscada Objeto que será buscado.
     * @return Objeto encontrado, se não for, é retornado nulo.
     */
    public Comparable busca(Comparable buscada);
    /**
     * Verifica se a árvore está vazia.
     * @return true se estiver vazia, false se não.
     */
    public boolean isEmpty();
    /**
     * Retorna o tamanho da árvore.
     * @return Quantidade de objetos na árvore.
     */
    public int tamanho();
    
    
}
