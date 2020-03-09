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
package MBFG.view;

import MBFG.controller.*;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Interface por linha de comando.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class ViewConsole {
    
    public static void main(String[] args) throws FileNotFoundException {
        ControllerGeral controller = new ControllerGeral();
        Scanner input = new Scanner(System.in);
        boolean estaVazia = controller.diretorioVazio("resources");
        
        if(!estaVazia){
            controller.carregarDados();           
        }else{
            controller.atualizar();             
        }
        
        int escolhaMenu = 0;
        String palavra;
        int code = 0;
        boolean flag;
        do{    
            System.out.println("------------------------------------------------\n"
                             + "[1] BUSCAR PALAVRA\n"
                             + "[2] TOP 10\n"
                             + "[3] ATUALIZAR\n"
                             + "[4] SAIR\n"
                             + "------------------------------------------------");

            do{
                try{
                    escolhaMenu = input.nextInt();

                    System.out.println("------------------------------------------------");
                    flag = false;
                } catch(InputMismatchException ex){
                    flag = true;
                    System.out.println("################################################\n"
                                     + "Por favor utilize apenas o teclado numerico\n"
                                     + "################################################");
                    input = new Scanner(System.in);
                }
            }while(flag);


            switch(escolhaMenu){
                case 0: 
                    System.out.println("Menu principal");
                break;

                case 1:
                    System.out.println("------------------------------------------------\n"
                             + "[1] INSIRA A PALAVRA DESEJADA\n"
                             + "------------------------------------------------");
                    input = new Scanner(System.in);
                    palavra = input.nextLine();
                    String[] palavras = palavra.split(" ");
                    controller.buscarPalavra(palavras[0]);                    
                    System.out.println("------------------------------------------------\n"
                             + "[1] ORDEM CRESCENTE\n"
                             + "[2] ORDEM DECRESCENTE\n"
                             + "[3] VISITAR PAGINA\n"
                             + "[4] VOLTAR AO MENU\n"
                             + "------------------------------------------------");
                    do{    
                        do{
                            try{
                                code = input.nextInt();

                                System.out.println("------------------------------------------------");
                                flag = false;
                            } catch(InputMismatchException ex){
                                flag = true;
                                System.out.println("################################################\n"
                                                 + "Por favor utilize apenas o teclado numerico\n"
                                                 + "################################################");
                                input = new Scanner(System.in);
                            }
                        }while(flag);
                    } while(!(code == 1 || code == 2 || code == 3 || code == 4));                 
                    if(code != 3)
                        escolhaMenu = code==4? 0: controller.ordenar(code, palavra);
                    else{
                        System.out.println("------------------------------------------------\n"
                             + "[1] INSIRA O NOME DO ARQUIVO\n"
                             + "------------------------------------------------");
                        input = new Scanner(System.in);
                        palavra = input.nextLine();
                        escolhaMenu = controller.visitarPagina(palavra);
                    }
                break;

                case 2:
                    System.out.println("------------------------------------------------\n"
                             + "[1] PALAVRAS\n"
                             + "[2] ARQUIVOS\n"
                             + "------------------------------------------------");
                    do{    
                        do{
                            try{
                                code = input.nextInt();

                                System.out.println("------------------------------------------------");
                                flag = false;
                            } catch(InputMismatchException ex){
                                flag = true;
                                System.out.println("################################################\n"
                                                 + "Por favor utilize apenas o teclado numerico\n"
                                                 + "################################################");
                                input = new Scanner(System.in);
                            }
                        }while(flag);
                    } while(!(code == 1 || code == 2));
                    if(code == 1){
                        System.out.println("------------------------------------------------\n"
                             + "[1] MAIS BUSCADAS\n"
                             + "[2] MENOS BUSCADAS\n"
                             + "------------------------------------------------");
                        do{    
                            do{
                                try{
                                    code = input.nextInt();

                                    System.out.println("------------------------------------------------");
                                    flag = false;
                                } catch(InputMismatchException ex){
                                    flag = true;
                                    System.out.println("################################################\n"
                                                     + "Por favor utilize apenas o teclado numerico\n"
                                                     + "################################################");
                                    input = new Scanner(System.in);
                                }
                            }while(flag);
                        } while(!(code == 1 || code == 2));
                        escolhaMenu = controller.top10Palavras(code);
                    } else{
                        System.out.println("------------------------------------------------\n"
                             + "[1] MAIS VISITADAS\n"
                             + "[2] MENOS VISITADAS\n"
                             + "------------------------------------------------");
                        do{    
                            do{
                                try{
                                    code = input.nextInt();

                                    System.out.println("------------------------------------------------");
                                    flag = false;
                                } catch(InputMismatchException ex){
                                    flag = true;
                                    System.out.println("################################################\n"
                                                     + "Por favor utilize apenas o teclado numerico\n"
                                                     + "################################################");
                                    input = new Scanner(System.in);
                                }
                            }while(flag);
                        } while(!(code == 1 || code == 2));
                        escolhaMenu = controller.top10Arquivos(code);
                    }             
                break;

                case 3:
                    controller.atualizar();
                    escolhaMenu = 0;
                break;
                
                case 4:
                    System.out.println("Até logo!!");
                    controller.sairDoPrograma();
                break;
                
                default:
                    System.out.println("Ops, escolha invalida\n"
                                     + "Tenta novamente ai");
                    escolhaMenu = 0;
                break;
            }
        }while(escolhaMenu == 0);
    }
}
