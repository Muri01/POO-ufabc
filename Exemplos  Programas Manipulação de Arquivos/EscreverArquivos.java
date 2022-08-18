import java.util.*;
import java.io.*;
import java.io.FileWriter;

public class EscreverArquivos {
    
    public static void main(String[] args){
        List<String> lista = new ArrayList<String>();
        lista.add("ID,nome,senha,email,data de criação, criado por, flagAdmin");
        lista.add("1,user,senha,user@ufabc.com.br");
        lista.add("2,humberto,admin,humberto@ufabc.com.br");
        lista.add("3,murilo,admin,murilo@ufabc.com.br,");
        try{
        FileWriter fw = new FileWriter(new File("/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/User.csv"));
        PrintWriter pw = new PrintWriter(fw);
        for (int i = 0; i<4; i++){
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




