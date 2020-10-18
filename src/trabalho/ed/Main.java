package trabalho.ed;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        compactarArquivo("/Users/ivanyuratakano/NetBeansProjects/Trabalho ED 2/src/trabalho/ed/When your legs don.txt");
        
        /*
        ListaEncadeada1 lista = new ListaEncadeada1();
        lista.insereFinal("bruno");
        lista.insereFinal("joao");
        lista.insereFinal("lucas");
        lista.insereFinal("ivan");
        System.out.println(lista.buscaLinearITint(""));
*/
    }
    
    public static void compactarArquivo (String arquivo){
        String arquivoSaida = "saida.txt";
        String line = null;
        ListaEncadeada1 lista = new ListaEncadeada1();
        String saida = null;
        
        try {
            FileReader fr = new FileReader(arquivo);
            BufferedReader reader = new BufferedReader(fr);
            
            while ((line = reader.readLine()) != null){ //enquanto houver linhas
                String [] tokens = line.split(" "); //pega as linhas e divide em palavras
               
                for (int i = 0; i<tokens.length; i++){
                    String palavra = tokens[i];
                    if (saida == null){
                        saida = tokens[i];
                    }
                    Pattern p = Pattern.compile(palavra);
                    Matcher m = p.matcher(saida);
                    No temp = lista.ini;
                    
                    while (m.find()) {
                        // teste para mostra palavras que estão se repetindo
                        System.out.println("palavra que repete: " + m.group());
                    
                    }
                        
                    saida = saida +" " +tokens[i];
                    lista.insereInicio(tokens[i]); //pega as palavras e coloca na lista
                    /*
                    a cada palavra inserida precisa percorrer a lista toda procurando por ela,
                    se for a primeira vez que a palavra é inserida, coloca ela no arquivo de saída,
                    se não for, a posição dela na lista é copiada para o arquivo de saída, e o nó da palavra é movido para o início da lista
                    
                    */
                }
            }
            reader.close();
            //System.out.println(lista);
        }
        catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado.");        
        }
        catch(IOException ex) {
            System.out.println("Erro lendo o arquivo");
        }
        
        try {
            FileWriter fw = new FileWriter(arquivoSaida);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write("oi");
            writer.close();
            // instrução para escrever
            
        } catch (IOException ex) {
            System.out.println("Erro de escrita");
        }
        System.out.println(saida);
    }
}
