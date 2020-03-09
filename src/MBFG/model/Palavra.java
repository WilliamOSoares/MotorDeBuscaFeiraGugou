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

import MBFG.util.IIguais;
import MBFG.util.MyArray;
import java.io.Serializable;

/**
 * Representa a palavra que será buscada ou não.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class Palavra implements Comparable, Serializable, IIguais{
    private String nome;
    private MyArray arquivos;
    
    /**
     * Cria uma nova instância de palavra com uma arvore de arquivos.
     * @param nome Nome que será guardado.
     */
    public Palavra(String nome){
        this.nome = nome;
        this.arquivos = new MyArray(2);
    }

    /**
     * Retorna o nome guardado.
     * @return Nome atribuído ao objeto.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Retorna a árvore de arquivos no qual se encontra o nome.
     * @return Árvore AVL de arquivos.
     */
    public MyArray getArquivos(){
        return arquivos;
    }   

    /**
     * Compara se a palavra do objeto recibido é maior, menor ou igual.
     * @param o Objeto a ser comparado.
     * @return 1 se for maior, -1 se for menor ou 0 se forem iguais.
     */
    @Override
    public int compareTo(Object o) {
        Palavra x = (Palavra) o;
        if(this.nome.compareToIgnoreCase(x.getNome())>0){
            return 1;
        }else if(this.nome.compareToIgnoreCase(x.getNome())<0){
            return -1;
        }else{
            return 0;
        }
    }
    
    /**
     * Exibição dos atributos.
     * @return Uma mensagem que informa o que foi salvo no objeto.
     */
    @Override
    public String toString() {
        return "A palavra " + nome + " foi encontrada ";
    }

    @Override
    public void iguais(String arquivo) {
        Pagina p = new Pagina(arquivo);
        if(arquivos.contains(p)){
            ((Pagina) arquivos.get(p)).setVezesMaisUm();
        } else{
            arquivos.add(p);
        }
    }
    
}
