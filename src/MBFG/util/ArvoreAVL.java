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
import java.io.Serializable;

/**
 * Classe que auxilia no armazenamento de dados.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class ArvoreAVL implements IArvoreBinariaAVL, Serializable{
    private Celula raiz;
    private int tamanho = 0;
    
    @Override
    public boolean isEmpty(){
        return tamanho == 0;
    }
    
    @Override
    public int tamanho(){
        return tamanho;
    }   
    
    @Override
    public void inserir(Comparable k, String arquivo) { //Comparable
        Celula n = new Celula(k);
        inserirArvoreAVL(this.raiz, n, arquivo); // Comparable devolve = 
        tamanho++;
        //return devolve;
    }
    
    /**
     * Ajuda o método inserir, inserindo na árvore no lugar certo, e verificando
     * o balanceamento.
     * @param aComparar Geralmente a raiz da árvore completa e das sub-árvores.
     * @param aInserir O objeto a ser inserido.
     * @return Objeto inserido se for igual, ou o comparado.
     */
    private void inserirArvoreAVL(Celula aComparar, Celula aInserir, String arquivo) {
        if (aComparar == null) {
            this.raiz = aInserir;
        } else {
            if (aInserir.getConteudo().compareTo(aComparar.getConteudo()) < 0) {
                if (aComparar.getEsquerda() == null) {
                    aComparar.setEsquerda(aInserir);
                    aInserir.setPai(aComparar);
                    verificarBalanceamento(aComparar);
                    ((Palavra)aComparar.getConteudo()).iguais(arquivo);
                } else {
                    inserirArvoreAVL(aComparar.getEsquerda(), aInserir, arquivo);
                }
            } else if (aInserir.getConteudo().compareTo(aComparar.getConteudo()) > 0) {
                if (aComparar.getDireita() == null) {
                    aComparar.setDireita(aInserir);
                    aInserir.setPai(aComparar);
                    verificarBalanceamento(aComparar);
                    ((Palavra)aComparar.getConteudo()).iguais(arquivo);
                } else {
                    inserirArvoreAVL(aComparar.getDireita(), aInserir, arquivo);
                }
            } else {
                ((Palavra)aComparar.getConteudo()).iguais(arquivo);
            }
        }
    }

    /**
     * Verifica o balanceamento do nó passado como parâmetro.
     * @param atual Nó a ser verificado.
     */
    private void verificarBalanceamento(Celula atual) {
        setBalanceamento(atual);
        int balanceamento = atual.getBalanceamento();

        if (balanceamento == -2) {
            if (altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita())) {
                atual = rotacaoDireita(atual);
            } else {
                atual = duplaRotacaoEsquerdaDireita(atual);
            }
        } else if (balanceamento == 2) {
            if (altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda())) {
                atual = rotacaoEsquerda(atual);
            } else {
                atual = duplaRotacaoDireitaEsquerda(atual);
            }
        }

        if (atual.getPai() != null) {
            verificarBalanceamento(atual.getPai());
        } else {
            this.raiz = atual;
        }
    }

    @Override
    public void remover(Comparable k) {
        removerArvoreAVL(this.raiz, k);
        tamanho--;
    }
    
    /**
     * Auxilia o método remover, removendo o objeto na árvore.
     * @param atual Raiz da árvore e das sub-árvores, ou o objeto a ser removido.
     * @param k Objeto a ser removido.
     */
    private void removerArvoreAVL(Celula atual, Comparable k) {
        if (atual == null) {
            //Do nothimg;
        } else {
            if (atual.getConteudo().compareTo(k) > 0) {
                removerArvoreAVL(atual.getEsquerda(), k);
            } else if (atual.getConteudo().compareTo(k) < 0) {
                removerArvoreAVL(atual.getDireita(), k);
            } else if (atual.getConteudo().compareTo(k) == 0) {
                removerEncontrado(atual);
            }
        }
    }

    /**
     * Remove o objeto encontrado, fazendo os devidos tratamentos.
     * @param aRemover Objeto a ser removido.
     */
    private void removerEncontrado(Celula aRemover) {
        Celula r;

        if (aRemover.getEsquerda() == null || aRemover.getDireita() == null) {
            if (aRemover.getPai() == null) {
                this.raiz = null;
                aRemover.setConteudo(null);
                return;
            }
            r = aRemover;
        } else {
            r = sucessor(aRemover);
            aRemover.setConteudo(r.getConteudo());
        }

        Celula p;
        if (r.getEsquerda() != null) {
            p = r.getEsquerda();
        } else {
            p = r.getDireita();
        }
        if (p != null) {
            p.setPai(r.getPai());
        }
        if (r.getPai() == null) {
            this.raiz = p;
        } else {
            if (r == r.getPai().getEsquerda()) {
                r.getPai().setEsquerda(p);
            } else {
                r.getPai().setDireita(p);
            }
            verificarBalanceamento(r.getPai());
        }
        r.setConteudo(null);
    }

    /**
     * Rotação da árvore à esquerda.
     * @param inicial Ponto a ser balanceado.
     * @return Objeto após a rotação.
     */
    private Celula rotacaoEsquerda(Celula inicial) {
        Celula direita = inicial.getDireita();
        direita.setPai(inicial.getPai());

        inicial.setDireita(direita.getEsquerda());

        if (inicial.getDireita() != null) {
            inicial.getDireita().setPai(inicial);
        }

        direita.setEsquerda(inicial);
        inicial.setPai(direita);

        if (direita.getPai() != null) {
            if (direita.getPai().getDireita() == inicial) {
                direita.getPai().setDireita(direita);
            } else if (direita.getPai().getEsquerda() == inicial) {
                direita.getPai().setEsquerda(direita);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(direita);

        return direita;
    }

    /**
     * Rotação da árvore à direita.
     * @param inicial Ponto a ser balanceado.
     * @return Objeto após a rotação. 
     */
    private Celula rotacaoDireita(Celula inicial) {
        Celula esquerda = inicial.getEsquerda();
        esquerda.setPai(inicial.getPai());

        inicial.setEsquerda(esquerda.getDireita());

        if (inicial.getEsquerda() != null) {
            inicial.getEsquerda().setPai(inicial);
        }

        esquerda.setDireita(inicial);
        inicial.setPai(esquerda);

        if (esquerda.getPai() != null) {
            if (esquerda.getPai().getDireita() == inicial) {
                esquerda.getPai().setDireita(esquerda);
            } else if (esquerda.getPai().getEsquerda() == inicial) {
                esquerda.getPai().setEsquerda(esquerda);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(esquerda);

        return esquerda;
    }

    /**
     * Rotação da árvore à esquerda e depois a direita.
     * @param inicial Ponto a ser balanceado.
     * @return Objeto após a rotação.
     */
    private Celula duplaRotacaoEsquerdaDireita(Celula inicial) {
        inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
        return rotacaoDireita(inicial);
    }
    
    /**
     * Rotação da árvore à direita e depois a esquerda.
     * @param inicial Ponto a ser balanceado.
     * @return Objeto após a rotação. 
     */
    private Celula duplaRotacaoDireitaEsquerda(Celula inicial) {
        inicial.setDireita(rotacaoDireita(inicial.getDireita()));
        return rotacaoEsquerda(inicial);
    }

    /**
     * Procura o nó que sucede o outro.
     * @param q nó da árvore.
     * @return nó sucessor.
     */
    private Celula sucessor(Celula q) {
        if (q.getDireita() != null) {
            Celula r = q.getDireita();
            while (r.getEsquerda() != null) {
                r = r.getEsquerda();
            }
            return r;
        } else {
            Celula p = q.getPai();
            while (p != null && q == p.getDireita()) {
                q = p;
                p = q.getPai();
            }
            return p;
        }
    }

    /**
     * Verifica a altura da árvore.
     * @param atual Raiz da árvore.
     * @return altura da árvore.
     */
    private int altura(Celula atual) {
        if (atual == null) {
            return -1;
        }
        if (atual.getEsquerda() == null && atual.getDireita() == null) {
            return 0;
        } else if (atual.getEsquerda() == null) {
            return 1 + altura(atual.getDireita());
        } else if (atual.getDireita() == null) {
            return 1 + altura(atual.getEsquerda());
        } else {
            return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
        }
    }

    /**
     * Altera o balanceamento do nó.
     * @param no Nó a ter o balanceamento alterado.
     */
    private void setBalanceamento(Celula no) {
        no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
    }
    
    @Override
    public Comparable busca(Comparable buscada){
        return busca(buscada, raiz);
    }
    
    /**
     * Auxilia o método de busca.
     * @param buscada Palavra buscada.
     * @param n Nó em que está sendo procurado.
     * @return O objeto encontrado, se não, retorna nulo.
     */
    private Comparable busca(Comparable buscada, Celula n){
        if(n == null)
            return null;
        if(buscada.compareTo(n.getConteudo())<0){
            return busca(buscada, n.getEsquerda());
        }else if(buscada.compareTo(n.getConteudo())>0){
            return busca(buscada, n.getDireita());
        }else{
            return n.getConteudo();
        }
    }
    
    /**
     * Exibe a lista em ordem crescente.
     */
    public void exibirEmOrdem(){
        exibirEmOrdem(raiz);
    }
    /**
     * Exibe a lista em ordem crescente.
     * @param n Raiz da árvore ou das sub-árvores.
     */
    private void exibirEmOrdem(Celula n){
        if(n.getEsquerda()!= null){
            exibirEmOrdem(n.getEsquerda());
        }
        System.out.println(n.getConteudo().toString());
        if(n.getDireita()!= null){
            exibirEmOrdem(n.getDireita());
        }
    }
    
    public class Celula implements Serializable{
	private Celula esquerda;
	private Celula direita;
	private Celula pai;
	private Comparable conteudo;
	private int balanceamento;

	public Celula(Comparable o) {
            this.pai = null;
            this.direita = null;
            this.esquerda = null;
            this.balanceamento = 0;
            this.conteudo = o;
	}

        @Override
	public String toString() {
            return getConteudo().toString();
	}

	public Comparable getConteudo() {
            return conteudo;
	}

	public void setConteudo(Comparable chave) {
            this.conteudo = chave;
	}

	public int getBalanceamento() {
            return balanceamento;
	}

	public void setBalanceamento(int balanceamento) {
            this.balanceamento = balanceamento;
	}

	public Celula getPai() {
            return pai;
	}

	public Celula setPai(Celula pai) {
            this.pai = pai;
            return pai;
	}

	public Celula getDireita() {
            return direita;
	}

	public Celula setDireita(Celula direita) {
            this.direita = direita;
            return direita;
	}

	public Celula getEsquerda() {
            return esquerda;
	}

	public void setEsquerda(Celula esquerda) {
            this.esquerda = esquerda;
	}
    }
}
