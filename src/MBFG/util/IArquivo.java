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
public interface IArquivo {
    /**
     * Cria um diretório.
     * 
     * @param diretorio Nome do diretório que será criado.
     */
    public void criarDiretorio(String diretorio);
    
    /**
     * Ler o conteúdo de um arquivo.
     * 
     * @param diretorio Nome do diretório onde está o arquivo.
     * @param nome Nome do arquivo.
     * @return Objeto recuperado do arquivo.
     * @throws ClassNotFoundException 
     */
    public Object lerArquivo(String diretorio, String nome) throws ClassNotFoundException;
    
    /**
     * Lista os arquivos do diretorio.
     * 
     * @param diretorio Nome do diretório.
     * @return array com a lista de arquivos do diretorio;
     */
    public String[] listarArquivosEmDiretorio(String diretorio);
    
    /**
     * Salvar o objeto no arquivo.
     * 
     * @param obj Objeto que será salvo.
     * @param diretorio Nome do diretório onde será salvo.
     * @param nome Nome do arquivo que vai guarda o objeto.
     * @param extensao Extensão do arquivo.
     */
    public void salvarArquivo(Object obj, String diretorio, String nome, String extensao);
    
}
