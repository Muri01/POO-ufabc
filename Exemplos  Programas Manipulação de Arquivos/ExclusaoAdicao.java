import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExclusaoAdicao {

    public static void main(String args[]) throws IOException {
        String pID ="Humberto"; // variavel de mudança

        File originalFile = new File("/Users/humberto.t.marinho/OneDrive - Accenture/Desktop/ler arquivos no java/contatos.txt");
        BufferedReader br = new BufferedReader(new FileReader(originalFile));

        // Construct the new file that will later be renamed to the original
        // filename.
        File tempFile = new File("/Users/humberto.t.marinho/OneDrive - Accenture/Desktop/ler arquivos no java/tempfile.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

        String line = null;
        // Read from the original file and write to the new
        // unless content matches data to be removed.
        while ((line = br.readLine()) != null) {

            if (!line.contains("Mais um 4")) {
                pw.println(line); // se quisermos exluir, omitimos a interação 
                pw.flush();
                }

            }
            //pw.println("Mais um 4");// adicionamos conteudo
            //pw.flush(); //adicionamos conteudo
        
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