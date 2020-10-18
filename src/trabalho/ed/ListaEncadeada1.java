package trabalho.ed;

//import Aula8_RemoçãoLista.*;

import java.util.Iterator;

//import Aula7_InsercaoEBusca.*;
//import Aula6_ListaEncadeada.*;

/**
 *
 * @author Bruno
 */
public class ListaEncadeada1 {
    public No ini;
    
    //O construtor serve para criar uma lista vazia ou seja, inicio nulo, não olha pra nenhum endereço de memória
    public ListaEncadeada1(){
        this.ini = null;
    }
    
    public boolean isEmpty(){ //verifica se a lista tá vazia
        return this.ini == null;
    }

    public void insereInicio(String elemento){ //insere nós no inicio e empurra os demais
        No novo = new No(elemento, ini);
        ini = novo;
    }
    
    
    @Override
    public String toString() {
        //mostra os elementos dos nós da lista
        String strLista = "";
        No temp = ini;
        
        while(temp != null){
            strLista = strLista + temp.getElemento() + " ";
            temp = temp.getProx();
        }
        return strLista;
        //return "ListaEncadeada{" + "ini=" + ini + '}';
    }
    
    public void insereFinal(String elemento){
        No novo = new No(elemento, null);
        No temp = ini;
                
        if(temp == null) //lista vazia
            ini = novo;
        else { //a lista tem pelo menos 1 nó
        while(temp.getProx() != null)
            temp = temp.getProx();
        
        temp.setProx(novo);
        }
    }
    /*
    public void insereFinalR(int elemento){
        insereFinalR(ini, elemento);
    }
    public void insereFinalR(No temp, int elemento){
        //lista vazia
        if(temp == null){
            No novo = new No(elemento, null);
            ini = novo;
        } else {
            //já estar no último nó
            if (temp.getProx() == null){
                No novo = new No(elemento, null);
                temp.setProx(novo);
            } else {
                insereFinalR(temp.getProx(), elemento); //fazer o temp andar é pegar o próximo prox
            }
        }
    }
    */
    /*
    public void insereOrdenado(int elemento){
        No novo = new No(elemento, ini);
        No temp = ini;
        No anterior = null;
        
        while (temp != null && temp.getElemento() < elemento){ // ou novo.getElemento()
            anterior = temp;
            temp = temp.getProx();
        }
        //caso de lista vazia e inserção no inicio
        if (anterior == null){
            ini = novo;
        } else {
            //inserir entre dois nós e inserir no final
            novo.setProx(temp);
            anterior.setProx(novo);
        }
    }
    
    public void insereOrdenadoR(int elemento){
        insereOrdenadoR(null, ini, elemento);
    }
    public void insereOrdenadoR(No anterior, No temp, int elemento){
        //lista vazia
        if (temp == null && anterior == null){ //ou ini == null
            insereInicio(elemento);
            return;
        }
        No novo = new No(elemento, ini);
        
        // inserir entre dois nós
        if (temp == null && anterior.getProx() == null){
            anterior.setProx(novo);
            novo.setProx(null);
            return;
        }
        if(anterior == null && temp.getElemento() > novo.getElemento()){
            novo.setProx(ini);
            ini = novo;
            return;
        }
        if (anterior != null && temp.getElemento() > novo.getElemento()){
            novo.setProx(temp);
            anterior.setProx(novo);
            return;
        }
        insereOrdenadoR(temp, temp.getProx(), elemento);
    }
    
   */
    
    
    public boolean buscaLinearIT(String x){
        No temp = ini;
        
        while (temp != null){
            if(temp.getElemento() == x)
                return true;
            temp = temp.getProx();
        }
        return false;
    }
    
     public int buscaLinearITint(String f){
        No temp = ini;
        int cont = 1;
        while (temp != null){
            if(temp.getElemento() == f){
                return cont;
            }
            if(temp.getElemento() != f){
                temp = temp.getProx();
                cont++;
            }          
        }
        return cont;
    }
     
    /*
    public boolean buscaLinearR(int x){
        return buscaLinearR(ini, x);
    }
    public boolean buscaLinearR(No temp, int x) {
        if (temp == null)
            return false;
        if(temp.getElemento() == x)
            return true;
        
        return buscaLinearR(temp.getProx(), x);
    }
    */
    
   public No buscaLinearIT2(String x){
        No temp = ini;
        
        while (temp != null){
            if(temp.getElemento() == x)
                return temp;
            temp = temp.getProx();
        }
        return null;
    }
    
    /*
    public No buscaLinearR2(int x){
        return buscaLinearR2(ini, x);
    }
    public No buscaLinearR2(No temp, int x) {
        if (temp == null || temp.getElemento() == x)
            return temp;
        
        return buscaLinearR2(temp.getProx(), x);
    }
    
    
    public void removeDoInicio(){
        if (isEmpty()){
            System.out.println("Lista vazia!");
            return;
        }
        //a lista possui pelo menos um nó, remover o primeiro nó
        ini = ini.getProx();
    }
    */
    
    public void removeDoFinal(){
        if (isEmpty()){
            System.out.println("Lista vazia!");
            return;
        }
        No temp = ini;
        No anterior = null;
        
        while(temp.getProx() != null){
            anterior = temp;
            temp = temp.getProx();
        }
        //apenas um nó
        if(anterior == null){
            ini = null; //lista passou a ficar vazia
            return;
        } 
        //lista com mais de um nó
        anterior.setProx(null);
    }
    
    
    public void removeDoFinalR(){
        removeDoFinalR(null, ini);
    }
    public void removeDoFinalR(No anterior, No temp){
        if (isEmpty()){
            System.out.println("Lista vazia!");
            return;
        }
        //tá no primeiro e unico nó
        if(anterior == null && temp.getProx() == null){
            ini = null; //lista passou a ficar vazia
            return;
        }
        //tá no ultimo nó
        if(temp.getProx() == null){
        anterior.setProx(null);
        return;
        }
        removeDoFinalR(temp, temp.getProx());
    }
    
    public void inverterLista (ListaEncadeada1 lista){
        No temp = ini;
        No anterior = null;
        No posterior = null;
        
        while (temp.getProx() != null){
            posterior = anterior;
            anterior = temp;
            temp = temp.getProx();
            anterior.setProx(posterior);
        }
        ini = temp;
        temp.setProx(anterior);//temp olha pra tras
    }
    
    public int tamanho (){
        No temp = ini;
        int cont = 0;
        if(temp == null){
            return cont;
        }
        while (temp.getProx() != null){
            temp = temp.getProx();
            cont++;
        }
        return cont+1;
    }
       
}
