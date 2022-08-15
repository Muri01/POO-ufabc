import java.util.*;
import java.io.*;
import java.io.FileWriter;

public class EscreverArquivos {
    
    public static void main(String[] args){
        List<String> lista = new ArrayList<String>();
        lista.add("Humberto;24 anos;santoandre");
        lista.add("Murilo;27 anos;saopaulo");
        try{
        FileWriter fw = new FileWriter(new File("/Users/humberto.t.marinho/OneDrive - Accenture/Desktop/ler arquivos no java/teste.csv"));
        PrintWriter pw = new PrintWriter(fw);
        for (int i = 0; i<2; i++){
        String linha= lista.get(i);
        pw.println(linha);
        }
        pw.close(); 
        }
        catch(IOException ioe){
           ioe.printStackTrace();
        }

    }



}




