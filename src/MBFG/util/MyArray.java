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

import java.io.Serializable;

/**
 * Classe que auxilia no armazenamento de dados em um array que duplica 
 * automaticamente.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class MyArray implements Serializable, IMyArray{
    private Comparable[] myArray;
    private int proximo;
    
    /**
     * Inicia com um array de comparable e com 0 de quantidade.
     * @param size numero do length do array natural.
     */
    public MyArray (int size){
        myArray = new Comparable[size];
        proximo = 0;
    }
    
    @Override
    public void add(Object obj) {
        if(proximo==myArray.length){
            int size = myArray.length * 2; //duplica
            Comparable[] temp = new Comparable[size];
            for(int i=0;i<proximo;i++){
                temp[i] = myArray[i];
            }
            myArray = temp;
        }
        myArray[proximo] = (Comparable)obj;
        proximo = proximo + 1;
    }

    @Override
    public Object get(Object obj) {
        for(int i=0;i<proximo;i++){
           if(myArray[i].equals(obj))
               return myArray[i];
        }
        return null;
    }

    @Override
    public boolean contains(Object obj) {
        for(int i=0;i<proximo;i++){
           if(myArray[i].equals(obj))
               return true;
        }
        return false;
    }

    @Override
    public int size() {
        return proximo;
    }

    @Override
    public boolean isEmpty() {
        return proximo == 0;
    }
    
    @Override
    public void ordenar(){
        ordenar(myArray, 0, proximo-1);
    }
    
    /**
     * Ordenação crescente, utilizando o quickSort.
     * @param a Array de objetos.
     * @param esquerda Ponto inicial da ordenação.
     * @param direita Ponto final da ordenação.
     */
    private void ordenar(Comparable[] a, int esquerda, int direita){
        if(esquerda < direita){
            int left = esquerda;
            int right = direita-1;
            int pivot = direita;
            while(left <= right){
                while(left <= right && a[left].compareTo(a[pivot]) < 0)
                    left++;
                while(left <= right && a[right].compareTo(a[pivot]) > 0)
                    right--;
                if(left <= right)
                    swap(a, left++, right--);
            }
            swap(a, pivot, left);
            ordenar(a, esquerda, left-1);
            ordenar(a, left+1, direita);
        }        
    }
    /**
     * Troca a posição dos objetos.
     * @param a Array onde ocorre a troca.
     * @param pos1 posição que ocorrerá a troca.
     * @param pos2 posição que ocorrerá a troca.
     */
    private void swap(Comparable[] a, int pos1, int pos2){
        Comparable aux = a[pos1];
        a[pos1] = a[pos2];
        a[pos2] = aux;
    }    
    
    /**
     * Mostra as 10 primeiras palavras.
     */
    public void top10(){
        this.ordenar();
        for(int i = proximo-1; i>=proximo-11 && i>=0; i--){
            System.out.println(myArray[i].toString());
        }
    }
    
    @Override
    public Iterador iterator() {
        return new MyIterador();
    }
    
    private class MyIterador implements Iterador{
        int cursor;
        
        public MyIterador(){
            cursor = 0;
        }
        
        @Override
        public boolean temProximo() {
            return cursor < proximo;
        }

        @Override
        public Object proximo() {
            return myArray[cursor++];
        }
    
    }
}
