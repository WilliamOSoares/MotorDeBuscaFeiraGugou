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

/**
 * Classe que reprezenta a pagina web, que nesse caso é o arquivo txt, para
 * fazer a contagem do top 10.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class PaginaTop implements Comparable, Serializable{
    
    private String nome;
    private int visitas;
    
    /**
     * Cria uma pagina para o top 10.
     * @param nome Nome do arquivo.
     */
    public PaginaTop(String nome) {
        this.nome = nome;
        this.visitas = 1;
    }

    /**
     * Retorna o nome do arquivo guardado.
     * @return Nome atribuído ao objeto.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Pega a quantidade de visitas a pagina.
     * @return Numero de visitas.
     */
    public int getVisitas() {
        return visitas;
    }

    /**
     * Adiciona mais um ao contador de visitas.
     */
    public void setVisitasMaisUm() {
        this.visitas++;
    }

    /**
     * Compara a quantidade de visitas se forem iguais é comparado a palavra do
     * objeto recibido se é maior, menor ou igual.
     * @param t Objeto a ser comparado.
     * @return 1 se for maior, -1 se for menor ou 0 se forem iguais.
     */
    @Override
    public int compareTo(Object t) {
        PaginaTop p = (PaginaTop) t;
        if(visitas > p.getVisitas()){
            return 1;
        } else if(visitas < p.getVisitas()) {
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
        return visitas == 1? " A pagina " + nome + " foi visitada " + visitas + " vez": 
                             " A pagina " + nome + " foi visitada " + visitas + " vezes";
    }

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
        final PaginaTop other = (PaginaTop) obj;
        if (this.nome.equals(other.nome)) {
            return true;
        }
        return false;
    }    
}
