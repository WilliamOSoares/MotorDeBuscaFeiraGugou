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

import java.io.Serializable;
import java.util.Objects;

/**
 * Representa a palavra que será parte do top 10.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class PalavraTop implements Comparable, Serializable{
    private String nome;
    private int vezesBuscadas;
    
    /**
     * Cria uma palavra para o top 10.
     * @param nome palavra procurada.
     */
    public PalavraTop(String nome) {
        this.nome = nome;
        this.vezesBuscadas = 1;
    }
    
    /**
     * Retorna o nome guardado.
     * @return Nome atribuído ao objeto.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Retorna o numero de vezes buscada da palavra.
     * @return Numero de vezes em que a palavra foi buscada.
     */
    public int getVezesBuscadas() {
        return vezesBuscadas;
    }
    
    /**
     * Acrescenta mais um ao numero de vezes buscada.
     */
    public void setVezesBuscadasMaisUm() {
        this.vezesBuscadas ++;
    }
    
    /**
     * Compara a quantidade de vezes procuradas e se forem iguais é comparado a 
     * palavra do objeto recibido se é maior, menor ou igual.
     * @param t Objeto a ser comparado.
     * @return 1 se for maior, -1 se for menor ou 0 se forem iguais.
     */
    @Override
    public int compareTo(Object t) {
        PalavraTop p = (PalavraTop) t;
        if(vezesBuscadas > p.getVezesBuscadas()){
            return 1;
        } else if(vezesBuscadas < p.getVezesBuscadas()) {
            return -1;
        } else{
            if(nome.compareToIgnoreCase(p.getNome()) > 0)
                return 1;
            else if(nome.compareToIgnoreCase(p.getNome()) < 0)
                return -1;
            else
                return 0;
        }
    }
    
    /**
     * Exibição dos atributos.
     * @return Uma mensagem que informa o que foi salvo no objeto.
     */
    @Override
    public String toString() {
        return vezesBuscadas == 1? " A palavra " + nome + " foi buscada " + vezesBuscadas + " vez": 
                                   " A palavra " + nome + " foi buscada " + vezesBuscadas + " vezes";
    }
    
    /**
     * Ver se os nomes são iguais de dois objetos.
     * @param obj Objeto a ser comparado.
     * @return True se forem iguais, false se forem diferente.
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
        final PalavraTop other = (PalavraTop) obj;
        if (this.nome.equals(other.nome)) {
            return true;
        }
        return false;
    }
}
