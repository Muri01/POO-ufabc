import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExclusaoAdicao {

    public static void main(String args[]) throws IOException {
        String nome ="Muri2 teste"; // variavel de mudança
        String senha ="senha teste"; // variavel de mudança

        File originalFile = new File("/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/user-test.csv");
        BufferedReader br = new BufferedReader(new FileReader(originalFile));

        // Construct the new file that will later be renamed to the original
        // filename.
        File tempFile = new File("/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/tempfile.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

        String line = null;
        // Read from the original file and write to the new
        // unless content matches data to be removed.
        while ((line = br.readLine()) != null) {

            if (!line.contains("Muri2")) {
                pw.println(line); // se quisermos exluir, omitimos a interação 
                System.out.println(line);
                // pw.flush();
                }
            }
            // pw.println(nome+","+senha);// adicionamos conteudo
            // pw.flush(); //adicionamos conteudo
        
        pw.close();
        br.close();
    
        // Delete the original file
        if (!originalFile.delete()) {
            System.out.println("Could not delete file");
            return;
        }

        // Rename the new file to the filename the original file had.
        if (!tempFile.renameTo(originalFile))
            System.out.println("Could not rename file");
    }
}