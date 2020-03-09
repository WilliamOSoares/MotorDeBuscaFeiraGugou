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

import java.io.File;
import java.io.Serializable;

/**
 * Classe que reprezenta a pagina web, que nesse caso é o arquivo txt.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class Pagina implements Comparable, Serializable{
    private String nome;
    private long ultimaModificacao;
    private int vezes;

    /**
     * Cria uma pagina com um nome e a quantidade de vezes que a palavra se 
     * repete.
     * @param nome Nome do arquivo.
     */
    public Pagina(String nome) {
        this.nome = nome;
        this.vezes = 1;
        File f = new File(nome);
        ultimaModificacao = f.lastModified();
    }
    
    /**
     * Retorna o nome do arquivo guardado.
     * @return Nome atribuído ao objeto.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Verifica se o arquivo foi modificado.
     * @return True se foi modificado e False se não foi.
     */
    public boolean foiModificado(){
        Pagina p = new Pagina(nome);
        if(this.ultimaModificacao == p.getUltimaModificacao()){
            return false;
        }
        return true;
    }
    /**
     * Retorna a data da ultima modificação do arquivo.
     * @return Data da ultima modificação.
     *
    */
    public long getUltimaModificacao() {
        return ultimaModificacao;
    }
    
    /**
     * Retorna a árvore de palavras no qual se encontra o arquivo.
     * @return Árvore AVL de palavras.
     */
    public int getVezes(){
        return vezes;
    }
    
    /**
     * Aumenta a quantidade de vezes, em um.
     */
    public void setVezesMaisUm(){
        this.vezes = vezes + 1;
    }
    
    /**
     * Compara se a palavra do objeto recibido é maior, menor ou igual.
     * @param o Objeto a ser comparado.
     * @return 1 se for maior, -1 se for menor ou 0 se forem iguais.
     */
    @Override
    public int compareTo(Object o) {
        Pagina x = (Pagina) o;
        if(this.nome.compareToIgnoreCase(x.getNome())>0){
            return 1;
        }else if(this.nome.compareToIgnoreCase(x.getNome())<0){
            return -1;
        }
        return 0;
    }
    
    /**
     * Exibição dos atributos.
     * @return Uma mensagem que informa o que foi salvo no objeto.
     */
    @Override
    public String toString() {
        return vezes == 1 ? vezes + " vez em " + nome: vezes + " vezes em " + nome;
    }
    
    /**
     * Verifica a igualdade entre dois objetos.
     * @param obj Objeto em ser comparado.
     * @return Sim se forem iguais, não se não forem.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pagina other = (Pagina) obj;
        if (this.nome.equals(other.nome)) {
            return true;
        }
        return false;
    }
    
}
