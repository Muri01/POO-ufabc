import java.util.Scanner;
import javax.print.FlavorException;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

public class Usuario {
    String nomeUsuario;
    String senha;
    String email;
    Date dataCriacaoUsuario;
    String criadoPor;
    Boolean flagAdmin;

    public void adicionarUsuario(String p){
    }
    
    public void excluirUsuario(String p){
    }


    //metodo construtor, que é chamado automaticamente sempre que um objeto é instanciado (não sei se precisa fazer)
    public Usuario (){
        System.out.println("Digite o nome do novo usuário:");
        Scanner nome = new Scanner(System.in);
        this.nomeUsuario = nome.nextLine();

        System.out.println("Digite o e-mail do novo usuário:");
        Scanner email = new Scanner(System.in);
        this.email = email.nextLine();

        System.out.println("Digite a senha do novo usuário:");
        Scanner senha = new Scanner(System.in);
        this.senha = senha.nextLine();

        Date data = new Date(); // Gera uma data
        this.dataCriacaoUsuario = data;

        //  NÃO ESTOU CONSEGUIDO ACESSAR O VALOR DO SYSTEM.IN PARA DEFINIR SE É VERDADEIRO OU NÃO
        // System.out.println("O novo usuário é adiministrador?(digite S ou N)");
        // Scanner flagAdminIn = new Scanner(System.in);
        // this.senha = flagAdminIn.nextLine();
        // System.out.println(flagAdminIn);
        // if (flagAdminIn.equals("S")){
        //     this.flagAdmin = true;
        // } else if (flagAdminIn.equals("N")){
        //     this.flagAdmin = false;
        // } 
    }

    public Usuario(String string, String string2, boolean b) {
    }

    //metodo pra testar imprimir as informações da classe
    public void status() {
        System.out.println("Informações do usuário");
        System.out.println("Nome: " + this.nomeUsuario);
        System.out.println("E-mail: " + this.email);
        System.out.println("Senha: " + this.senha);
        System.out.println("data de Criação: " + this.dataCriacaoUsuario);
        System.out.println("é administrador?' " + this.flagAdmin);
    }

    public String getNomeUsuario(){
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario){

    }

    private static Boolean Autenticao(String U, String S) {
        try {
            String buscaUsuario;
            String array[] = new String[7];

            File file = new File(
                    "/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/User.csv");

            RandomAccessFile raf = new RandomAccessFile(file, "rw");

            while (raf.getFilePointer() < raf.length()) {
                buscaUsuario = raf.readLine();
                array = buscaUsuario.split(",");
                // System.out.println(array[1]);
                // System.out.println(array[2]);

                if (U.equals(array[1]) && S.equals(array[2])) {
                    System.out.println("CADASTRO REALIZADO COM SUCESSO");
                    return true;
                }
                // else{
                // System.out.println("LOGIN ERRADO");
                // return false;
                // }
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
            return false;
        }
        System.out.println("LOGIN ERRADO");
        return false;
    }

    private static Boolean VerificaADM(String U) {
        try {
            String buscaUsuarioAdmin, flagAdmin;
            String array[] = new String[7];

            File file = new File(
                    "/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/User.csv");

            RandomAccessFile raf = new RandomAccessFile(file, "rw");

            while (raf.getFilePointer() < raf.length()) {
                buscaUsuarioAdmin = raf.readLine();
                array = buscaUsuarioAdmin.split(",");
                flagAdmin = array[6];

                if (flagAdmin.equals("S")) {
                    System.out.println("CADASTRO REALIZADO COM SUCESSO");
                    return true;
                }
                // else{
                // System.out.println("LOGIN ERRADO");
                // return false;
                // }
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
            return false;
        }
        System.out.println("LOGIN ERRADO");
        return false;

    //     if (U.equals("user") && S.equals("senha")) {
    //         return true;
    //     } else {
    //         return false;
    //     }
    }

    
}


//talvez faça sentido usar o Getter e Sets para cada atruibuto
    // public void getNomeUsuario() {}
    // public void setNomeUsuario(String nome) {}
    // public void getSenha() {}
    // public void setSenha(String senha) {}
    // public void getFlagAdmin() {}
    // public void setFlagAdmin(String flaf) {}


