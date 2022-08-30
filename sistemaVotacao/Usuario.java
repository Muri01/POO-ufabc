import java.io.File;
// import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class Usuario {
    String nomeUsuario;
    String senhaUsuario;
    Date dataCriacaoUsuario;
    String flagAdmin; // mudei pra string pra ficar mais facil de ler o arquivo csv

    private static Scanner scan;
    private static RandomAccessFile raf;

    public Usuario(String nome, String senha, String flag) {
        nomeUsuario = nome;
        senhaUsuario = senha;
        flagAdmin = flag;
        Date data = new Date(); // Gera uma data
        this.dataCriacaoUsuario = data;
    }

    public void adicionarUsuario(String nome, String senha, String flag) throws IOException {
        File originalFile = new File(
                "/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/User.csv");
        BufferedReader br = new BufferedReader(new FileReader(originalFile));

        File tempFile = new File(
                "/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/tempfile.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

        String line = null;
        while ((line = br.readLine()) != null) {
            if (!line.contains("fim")) {
                pw.println(line);
                pw.flush();
            }
        }
        pw.println(nome + ";" + senha + ";" + flag);
        pw.flush();

        pw.close();
        br.close();

        // Delete the original file
        if (!originalFile.delete()) {
            System.out.println("Could not delete file");
            return;
        }

        // Rename the new file to the filename the original file had.
        if (!tempFile.renameTo(originalFile)){
            System.out.println("Could not rename file");
        }
        System.out.println("Novo usuário adicionado com sucesso! O que desaja fazer agora?");
    }

    public void excluirUsuario(String p) throws IOException {
        File originalFile = new File(
                "/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/User.csv");
        BufferedReader br = new BufferedReader(new FileReader(originalFile));

        // Construct the new file that will later be renamed to the original filename.
        File tempFile = new File(
                "/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/tempfile.txt");
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
        if (!tempFile.renameTo(originalFile)){
            System.out.println("Could not rename file");
        }
        System.out.println("Usuário excluido com sucesso! O que desaja fazer agora?");
    }

    public void adicionarCandidato(String nome, String info) throws IOException {
        File originalFile = new File(
                "/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/Candidato.csv");
        BufferedReader br = new BufferedReader(new FileReader(originalFile));

        File tempFile = new File(
                "/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/tempfile.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

        String line = null;
        while ((line = br.readLine()) != null) {
            if (!line.contains("fim")) {
                pw.println(line);
                pw.flush();
            }
        }
        Date dataCandidato = new Date(); // Gera uma data
        pw.println(nome + ";" + info + ";" + dataCandidato);
        pw.flush();

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

    public void excluirCandidato(String n) throws IOException {
        File originalFile = new File(
                "/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/Candidato.csv");
        BufferedReader br = new BufferedReader(new FileReader(originalFile));

        // Construct the new file that will later be renamed to the original filename.
        File tempFile = new File(
                "/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/tempfile.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

        String line = null;
        while ((line = br.readLine()) != null) {
            if (!line.contains(n)) {
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
        if (!tempFile.renameTo(originalFile)){
            System.out.println("Could not rename file");
        }
        
    }

    public void votar(String n, String c) throws IOException {
        File originalFile = new File(
            "/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/votacao.csv");
    BufferedReader br = new BufferedReader(new FileReader(originalFile));

    // Construct the new file that will later be renamed to the original filename.
    File tempFile = new File(
            "/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/tempfile.txt");
    PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

    String line = null;
    String linhaVotacao[], candidatos, listaCanditados;
    ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();


    raf = new RandomAccessFile(originalFile, "rw");
    scan = new Scanner(System.in);

    linhaVotacao = raf.readLine().split(";");
    
    candidatos = linhaVotacao[3]; // [Candidato1, Candidato2, Candidato3] String
    
    System.out.println(candidatos);
    for(int i = 0; i < candidatos.length(); i++){
        if (candidatos == n){

        }
    }
        // while (raf.getFilePointer() < raf.length()) { 
        //     linhaVotacao = raf.readLine().split(";");
        //     candidatos = linhaVotacao[3];
        //     System.out.println(candidatos);

        //     // Usuario U = new Usuario(nome, senha, flag);
        //     // listaUsuarios.add(U);
        // }

        // for (int i = 0; i < listaUsuarios.size(); i++) {
        //     if (U.equals(listaUsuarios.get(i).nomeUsuario) ) {
        //         System.out.println("CADASTRO DE ADMIN REALIZADO COM SUCESSO");
        //     }
        // }

    // List<Integer> votos = new ArrayList<Integer>();
    //     votos.add(3);
    //     votos.add(110);
    //     votos.add(7);

    //     List<String> Candidatos = new ArrayList<String>();
    //     Candidatos.add("Bolsonaro");
    //     Candidatos.add("Lula");
    //     Candidatos.add("Candidato3");
    // while ((line = br.readLine()) != null) {
    //     if (!line.contains("n")) {

    //         pw.println(line);
    //         pw.flush();
    //     }
    // }
    // pw.println(n);
    // pw.flush();

    // pw.close();
    // br.close();

    // // Delete the original file
    // if (!originalFile.delete()) {
    //     System.out.println("Could not delete file");
    //     return;
    // }

    // // Rename the new file to the filename the original file had.
    // if (!tempFile.renameTo(originalFile))
    //     System.out.println("Could not rename file");
     

    }

    public void status() {
        System.out.println("Informações do usuário");
        System.out.println("Nome: " + this.nomeUsuario);
        System.out.println("Senha: " + this.senhaUsuario);
        System.out.println("data de Criação: " + this.dataCriacaoUsuario);
        System.out.println("é administrador?' " + this.flagAdmin);
    }

}
