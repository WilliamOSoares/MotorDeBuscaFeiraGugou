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

import java.io.FileNotFoundException;

/**
 * Controla o sistema.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class ControllerGeral {

    private Helper helper;
    
    /**
     * Cria um controlador, inicializando os atributos e tratando os erros.
     */
    public ControllerGeral(){
        try{
            helper = new Helper();
        } catch(Exception io){
            System.out.println("Deu merda");
        }
    }

    /**
     * Busca a palavra no banco de dados.
     * @param s Palavra desejado.
     */
    public void buscarPalavra(String s) {
        try{
            helper.buscarPalavra(s);
        } catch (Exception e){
            System.out.println("Erro não esperado");
        }
    }
    
    /**
     * Exibe o top 10 dos arquivos.
     * @param code Código da ordem de exibição.
     * @return 0 se ocorreu como o esperado e 1 se não.
     */
    public int top10Arquivos(int code) {
        try{
            helper.top10Arquivos(code);
            return 0;
        } catch (Exception e){
            System.out.println("Erro não esperado");
            return 1;
        }
    }
    
    /**
     * Exibe a pesquisa da palavra ordenado.
     * @param code Código da ordem de exibição.
     * @param procura palavra procurada.
     * @return 0 se ocorreu como o esperado e 1 se não.
     */
    public int ordenar(int code, String procura) {
        try{
            helper.ordenar(code, procura);
            return 0;
        } catch (Exception e){
            System.out.println("Erro nÃ£o esperado");
            return 1;
        }
    }
    
    /**
     * Salvar o banco de dados no disco rígido e encerrar o programa.
     */
    public void sairDoPrograma() {
        try{
            helper.sairDoProgama();
        } catch (Exception e){
            System.out.println("Erro não esperado");
        }
    }
    
    /**
     * Exibe o top 10 das palavras.
     * @param code Código da ordem de exibição.
     * @return 0 se ocorreu como o esperado e 1 se não.
     */
    public int top10Palavras(int code) {
        try{
            helper.top10Palavras(code);
            return 0;
        } catch (Exception e){
            System.out.println("Erro não esperado");
            return 1;
        }
    }
    
    /**
     * Permite o usuário visitar a pagina.
     * @param arquivo Arquivo a ser visitado.
     * @return 0 se ocorreu como o esperado e 1 se não.
     */
    public int visitarPagina(String arquivo) {
        try{
            helper.visitarPagina(arquivo);
            return 0;
        } catch (Exception e){
            System.out.println("Erro não esperado");
            return 1;
        }
    }
    
    /**
     * Atualizar arquivos e banco de dados.
     */
    public void atualizar() {
        try{
            helper.atualizar();
        } catch (FileNotFoundException e){
            System.out.println("Erro não esperado");
        }
    }
    /**
     * Carrega os arquivos salvos.
     */
    public void carregarDados() {
        try{
            helper.carregarDados();
        } catch (FileNotFoundException ex){
            System.out.println("Nenhum arquivo encontrado no reposítorio");
        } catch (Exception e){
            System.out.println("Erro não esperado");
        }
    }
    
    /**
     * Verifica se o diretorio está vazio.
     * @param diretorio -  recebe o nome de um diretorio
     * @return true se nao existir nenhum arquivo nesse diretorio
     */
    public boolean diretorioVazio(String diretorio){
        return helper.diretorioVazio(diretorio);
    }
}
