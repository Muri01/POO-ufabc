import java.io.File;
// import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
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

    public void votar(String votacaoEscolhida, String candidatoEscolhido) throws IOException {
        
        
        File originalFile = new File(
            "/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/votacao.csv");
    BufferedReader br = new BufferedReader(new FileReader(originalFile));

    // Construct the new file that will later be renamed to the original filename.
    File tempFile = new File(
            "/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/tempfile.txt");
    PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

    String line = null;
    String linhaVotacao[];

    // Votacao v1 = new Votacao(nome, candidato1, candidato2, numVotos1, numVotos2)
    // raf = new RandomAccessFile(originalFile, "rw");
    // scan = new Scanner(System.in);

        // List<String> lista = new ArrayList<String>();
        // lista.add("ID,nome,senha,email,data de criação, criado por, flagAdmin");
        // lista.add("1,user,senha,user@ufabc.com.br");
        // lista.add("2,humberto,admin,humberto@ufabc.com.br");

        // try{
        //     FileWriter fw = new FileWriter(new File("/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/user-test.csv"));
        //     PrintWriter pw = new PrintWriter(fw);
        //     for (int i = 0; i<4; i++){
        //     String linha= lista.get(i);
        //     pw.println(linha);
        //     }
        //     pw.close(); 
        // }
        // catch(IOException ioe){
        //    ioe.printStackTrace();
        // }

    
    // escolher votação
    while ((line = br.readLine()) != null) {
            if (!line.contains(votacaoEscolhida)) { //Não é a linha de votação escolhida
                pw.println(line);
                System.out.println(line+"copiado para o arquivo novo");
            }
            else{ //Encontrei a linha da votação // escolher candidato
                System.out.println("A linha de votação é "+line);
                linhaVotacao = line.split(";");
                String[] candidatosArray = linhaVotacao[3].replaceAll("\\[|\\]", "").split(",");
                
                for(int i = 0; i < candidatosArray.length; i++){ // varrer todo array de candidato
                    System.out.println(candidatosArray[i]);
                    if (candidatoEscolhido.equals(candidatosArray[i])){ 
                        System.out.println("aqui!!!");
                        String numeroString = linhaVotacao[i+4];
                        int numeroNumber = Integer.parseInt(numeroString);

                        numeroNumber += 1;

                        numeroString = Integer.toString(numeroNumber);
                        linhaVotacao[i+4] = numeroString;

                        System.out.println("você votou no candidato " + candidatosArray[i]+" e o seu total de votos é "+numeroString);
                        System.out.println(linhaVotacao);
                        System.out.println(linhaVotacao.length);
                        System.out.println(line);
                    }
                }
                String newLine = "";
                for(int j = 0; j < linhaVotacao.length; j++){
                    newLine = newLine + linhaVotacao[j] + ";";
                    System.out.println("a linha editada"+newLine);
                }
                System.out.println("a linha COMPLETA editada"+newLine);
                pw.println(newLine); // --------> pensar em como reescrever a linha!!!!!!!!!! <-------------
            }
        }

        //Acho que nao vou usar, serve mais para ler todas as linhas, não editar elas
    // while (raf.getFilePointer() < raf.length()) { 
    //     linhaVotacao = raf.readLine().split(";");
    //     // escolher candidato
    //     candidatos = linhaVotacao[3];
    //     System.out.println(candidatos); // "[Candidato1, Candidato2, Candidato3]" String
    //     String[] candidatosArray = linhaVotacao[3].replaceAll("\\[|\\]", "").split(",");
    //     System.out.println(candidatosArray[0]);
        

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
    // pw.println();
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

    public void status() {
        System.out.println("Informações do usuário");
        System.out.println("Nome: " + this.nomeUsuario);
        System.out.println("Senha: " + this.senhaUsuario);
        System.out.println("data de Criação: " + this.dataCriacaoUsuario);
        System.out.println("é administrador?' " + this.flagAdmin);
    }

}
