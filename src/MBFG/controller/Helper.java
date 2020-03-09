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
package MBFG.controller;

import MBFG.model.*;
import MBFG.util.*;
import java.io.FileNotFoundException;
import java.io.Serializable;

/**
 * Ajuda alguns métodos do controller.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class Helper implements Serializable{
    private MyArray arquivos; 
    private Arquivo arquivo;
    private ArvoreAVL arvore;
    private MyArray palavraTop;
    private MyArray paginaTop;
    
    /**
     * Cria um auxiliar do controller.
     */
    public Helper(){
        arquivo = new Arquivo();
        arquivos = new MyArray(2);
        arvore = new ArvoreAVL();
        palavraTop = new MyArray(2);
        paginaTop = new MyArray(2);
        arquivo.criarDiretorio("resources");
    }

    /**
     * Busca a palavra no banco de dados.
     * @param s Palavra desejado.
     */
    public void buscarPalavra(String s) {
        PalavraTop p1 = new PalavraTop(s);
        if(palavraTop.contains(p1)){
            ((PalavraTop) palavraTop.get(p1)).setVezesBuscadasMaisUm();
        } else{
            palavraTop.add(p1);
        }
        if(!arvore.isEmpty()){
            Palavra p = new Palavra(s);
            p = (Palavra) arvore.busca(p);
            if(p != null){    
                MyArray ma = p.getArquivos();
                Iterador it = ma.iterator();
                while(it.temProximo()){
                    Pagina p2 = (Pagina) it.proximo();
                    System.out.print(p.toString());
                    System.out.println(p2.toString());
                }
            } else {
                System.out.println("Palavra não encontrada.");
            }
        } else 
            System.out.println("reposítorio está vazio");
    }
    
    /**
     * Exibe o top 10 dos arquivos.
     * @param code Código da ordem de exibição.
     */
    public void top10Arquivos(int code) {       
        if(code == 1){ // mais
            paginaTop.top10();
        } else{ // menos
            paginaTop.ordenar();
            Iterador it = paginaTop.iterator();
            for(int i = 0; i < 10 && it.temProximo(); i++){
                PaginaTop p = (PaginaTop) it.proximo();
                System.out.println(p.toString());
            }
        }   
    }
    
    /**
     * Exibe a pesquisa da palavra ordenado.
     * @param code Código da ordem de exibição.
     * @param procura Palavra procurada.
     */
    public void ordenar(int code, String procura) {
        Palavra p = new Palavra(procura);
        p = (Palavra) arvore.busca(p);
        if(p != null){    
            MyArray achou = p.getArquivos();
            MyArray resultados = new MyArray(2);
            Iterador it = achou.iterator();
            while(it.temProximo()){
                Pagina p2 = (Pagina) it.proximo();
                String s = p.toString() + p2.toString();
                resultados.add(s);
            }
            resultados.ordenar();
            it = resultados.iterator();
            int i = 0;
            String[] s = new String[resultados.size()];
            while(it.temProximo()){
                s[i] = (String) it.proximo();
                i++;
            }
            if(code == 1){ // mais
                for(String t: s){
                    System.out.println(t);
                }
            } else{ // menos
                for(i = s.length-1; i >=0; i--){
                    System.out.println(s[i]);
                }
            }
        } else {
            System.out.println("Não é possível ordenar nenhum resultado");
        }
    }
    
    /**
     * Exibe o top 10 das palavras.
     * @param code Código da ordem de exibição.
     */
    public void top10Palavras(int code) {
        if(code == 1){ // mais
            palavraTop.top10();
        } else{ // menos
            palavraTop.ordenar();
            Iterador it = palavraTop.iterator();
            for(int i = 0; i < 10 && it.temProximo(); i++){
                PalavraTop p = (PalavraTop) it.proximo();
                System.out.println(p.toString());
            }
        }
    }

    /**
     * Permite o usuário visitar a pagina.
     * @param palavra Nome do arquivo visitado.
     */
    public void visitarPagina(String palavra) {
        String[] s = arquivo.listarArquivosEmDiretorio("repositorio");
        MyArray arquivosNovos = new MyArray(2);
        for(String add: s){
            arquivosNovos.add(add);
        }
        arquivos = arquivosNovos;
        if(arquivos.contains(palavra)){    
            PaginaTop p1 = new PaginaTop(palavra);
            if(paginaTop.contains(p1)){
                ((PaginaTop) paginaTop.get(p1)).setVisitasMaisUm();
            } else{
                paginaTop.add(p1);
            }
            try{
                arquivo.ExibirArquivo(palavra);
            } catch(FileNotFoundException ex){
                System.out.println("Arquivo não encontrado");
            }
            
        } else{
            System.out.println("O arquivo foi removido");
        }
    }
    
    /**
     * Atualizar arquivos e banco de dados.
     * @throws java.io.FileNotFoundException
     */
    public void atualizar() throws FileNotFoundException {
        System.out.println("Aguarde um momento...\nIsso pode levar alguns minutos...");
        String[] s = arquivo.listarArquivosEmDiretorio("repositorio");
        MyArray arquivosNovos = new MyArray(2);
        if(s != null){
            for(String add: s){
                arquivosNovos.add(add);
            }
            arquivos = arquivosNovos;
            arvore = arquivo.lerArquivoTXT("repositorio", s);
            System.out.println("Quantidade de palavras encontradas: " 
                            + arvore.tamanho() + " em " + s.length
                            + " arquivos.");
        }        
    }
    
    /**
     * Carrega os arquivos salvos.
     * @throws java.io.FileNotFoundException Arquivo não encontrado.
     */
    public void carregarDados() throws FileNotFoundException {
        ArvoreAVL aux = new ArvoreAVL();
        try {
            aux = (ArvoreAVL) arquivo.lerArquivo("resources", "arvore.avl");
            MyArray arrayAux1 = (MyArray) arquivo.lerArquivo("resources", "palavraTop.plv");
            MyArray arrayAux2 = (MyArray) arquivo.lerArquivo("resources", "paginaTop.pag");
            
            arvore = aux;
            palavraTop = arrayAux1;
            paginaTop = arrayAux2;
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao recuperar arquivo");
        }
        if(aux == null){
            this.atualizar();
        }
    }
    
    /**
     * Salvar o banco de dados no disco rígido e encerrar o programa.
     */
    public void sairDoProgama() {
        arquivo.apagarArquivosDe("resources");        
        arquivo.salvarArquivo(arvore, "resources", "arvore", "avl");
        arquivo.salvarArquivo(palavraTop, "resources", "palavraTop", "plv");
        arquivo.salvarArquivo(paginaTop, "resources", "paginaTop", "pag");
    }
    
    /**
     * Verifica se o diretorio está vazio.
     * @param diretorio -  recebe o nome de um diretorio
     * @return true se nao existir nenhum arquivo nesse diretorio
     */
    public boolean diretorioVazio(String diretorio){
        return arquivo.diretorioVazio(diretorio);
    }

       
}
