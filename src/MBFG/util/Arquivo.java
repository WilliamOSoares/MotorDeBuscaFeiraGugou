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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Auxilia no armazenamento de dados.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class Arquivo implements IArquivo, Serializable{
    
    
    /**
     * Le um arquivo de texto.
     * @param diretorio
     * @param nomes
     * @return Retorna uma arvore de palavras. 
     * @throws FileNotFoundException 
     */
    public ArvoreAVL lerArquivoTXT(String diretorio, String[] nomes) throws FileNotFoundException{
        ArvoreAVL a = new ArvoreAVL();
        for(int i = 0; i < nomes.length; i++){
            FileReader f = new FileReader(diretorio + "//" + nomes[i]);
            BufferedReader lendoArq = new BufferedReader(f);

            String palavra;
            try {
                while(lendoArq.ready()){
                    palavra = lendoArq.readLine();
                    palavra = palavra.replaceAll("[áàâãäÀÁÂÃÄ]", "a");
                    palavra = palavra.replaceAll("[éèêëÉÈÊË]", "e");                    
                    palavra = palavra.replaceAll("[íìîïÍÌÎÏ]", "i");
                    palavra = palavra.replaceAll("[óòôõöÓÒÔÕÖ]", "o");
                    palavra = palavra.replaceAll("[úùûüÚÙÛÜ]", "u");
                    palavra = palavra.replaceAll("[ç]", "c");
                    palavra = palavra.replaceAll("[#,.;!?)(:_]", "");
                    //palavra = palavra.replaceAll("[^A-Za-z0-9]", "");
                    palavra = palavra.replaceAll("[^\\w][\\s]", ""); //Expressão regular 
                    String[] palavras = palavra.split(" ");
                    for(String n: palavras){
                        Palavra p = new Palavra(n);
                        a.inserir(p, nomes[i]);
                    }
                }
            } catch (IOException ex) {
                System.out.println("Falha ao ler o diretorio");
            }
        }
        return a;
    }

    @Override
    public void criarDiretorio(String diretorio) {
        File arquivo = new File(diretorio);
        if(!arquivo.exists() || !arquivo.isDirectory()){
            boolean success = new File(diretorio).mkdir();
            if(!success){
                System.out.println("Falha ao criar o diretorio");
            }
        }
    }

    @Override
    public Object lerArquivo(String diretorio, String nome) throws ClassNotFoundException {
        Object obj = null;        
        try{
            FileInputStream file = new FileInputStream(diretorio+"//"+nome);
            ObjectInputStream recuperar = new ObjectInputStream(file);
            obj = recuperar.readObject();
            
        }catch (IOException ex){
            System.out.println("Erro ao ler o arquivo");
        }
        return obj;
    }

    @Override
    public String[] listarArquivosEmDiretorio(String diretorio) {
        File arq = new File(diretorio);
        if(arq.exists()){
            if(arq.isDirectory()){
                String listarDiretorio[] = arq.list();
                return listarDiretorio;
            }
        }
        return null;
    }
    
    
    /**
     * Exibe um arquivo de texto
     * @param arquivo
     * @throws FileNotFoundException 
     */
    public void ExibirArquivo(String arquivo) throws FileNotFoundException {
        FileReader f = new FileReader("repositorio//" + arquivo);
        BufferedReader lendoArq = new BufferedReader(f);
        String palavra;
        try {
            while(lendoArq.ready()){
                palavra = lendoArq.readLine();
                System.out.println(palavra);
            } 
        } catch (IOException ex) {
            System.out.println("Falha ao ler o arquivo");
        }
    }

    @Override
    public void salvarArquivo(Object obj, String diretorio, String nome, String extensao) {
        try{
            FileOutputStream file = new FileOutputStream(diretorio + "//"+ nome+"."+extensao);
            ObjectOutputStream save = new ObjectOutputStream(file);
            
            save.writeObject(obj);
            file.close();
        }catch (IOException ex){
            System.out.println("Erro ao criar o arquivo");
        }
    }
    /**
     * Apaga todos os arquivos de um diretorio
     * @param diretorio 
     */
    public void apagarArquivosDe(String diretorio){
        File f = new File(diretorio);
        if(f.exists() && f.isDirectory()){
            File[] arquivos = f.listFiles();
            for(int i = 0; i<arquivos.length; i++){
                arquivos[i].delete();
            }
        }
    }
    /**
     * Verifica se o diretorio está vazio.
     * @param diretorio -  recebe o nome de um diretorio
     * @return true se nao existir nenhum arquivo nesse diretorio
     */
    public boolean diretorioVazio(String diretorio) {
        File dir = new File(diretorio);
        if(dir.exists()&& dir.isDirectory()){
            String[] arquivosDir = dir.list();
            for(String n: arquivosDir){
                System.out.println(n);
            }
            if(arquivosDir.length == 0){
                return true;
            }
        }        
        return false;
    }
}
