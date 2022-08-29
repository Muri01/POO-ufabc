import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Usuario {
    String nomeUsuario;
    String senhaUsuario;
    String email;
    Date dataCriacaoUsuario;
    String criadoPor;
    String flagAdmin; //mudei pra string pra ficar mais facil de ler o arquivo csv


    //metodo construtor, que é chamado automaticamente sempre que um objeto é instanciado (não sei se precisa fazer)
    public Usuario(String nome, String senha, String flag) {
        nomeUsuario = nome;
        senhaUsuario = senha;
        flagAdmin = flag;
        Date data = new Date(); // Gera uma data
        this.dataCriacaoUsuario = data;
    }

    public void adicionarUsuario(String nome, String senha, String flag) throws IOException{
        File originalFile = new File("/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/User.csv");
        BufferedReader br = new BufferedReader(new FileReader(originalFile));

        File tempFile = new File("/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/tempfile.txt");
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
            pw.println(nome+","+senha+","+flag);// adicionamos conteudo
            pw.flush(); //adicionamos conteudo
        
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
    
    public void excluirUsuario(String p) throws IOException{
        File originalFile = new File("/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/User.csv");
        BufferedReader br = new BufferedReader(new FileReader(originalFile));

        // Construct the new file that will later be renamed to the original filename.
        File tempFile = new File("/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/tempfile.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

        String line = null;
        while ((line = br.readLine()) != null) {
            if (!line.contains(p)) {
                    pw.println(line);
                }
            }
        
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

    //metodo pra testar imprimir as informações da classe
    public void status() {
        System.out.println("Informações do usuário");
        System.out.println("Nome: " + this.nomeUsuario);
        System.out.println("E-mail: " + this.email);
        System.out.println("Senha: " + this.senhaUsuario);
        System.out.println("data de Criação: " + this.dataCriacaoUsuario);
        System.out.println("é administrador?' " + this.flagAdmin);
    }

    public String getNomeUsuario(){
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario){

    }
}
