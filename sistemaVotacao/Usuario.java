
import java.util.Scanner;
import javax.print.FlavorException;
import java.util.Random;
import java.util.Date;

public class Usuario {
    int idUsuario;
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
        Random gerador = new Random();  //gerar um codigo aleatorio para o ID
        this.idUsuario = gerador.nextInt(9);

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

    //metodo pra testar imprimir as informações da classe
    public void status() {
        System.out.println("Informações do usuário");
        System.out.println("Id: " + this.idUsuario);
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

    
}


//talvez faça sentido usar o Getter e Sets para cada atruibuto
    // public void getNomeUsuario() {}
    // public void setNomeUsuario(String nome) {}
    // public void getSenha() {}
    // public void setSenha(String senha) {}
    // public void getFlagAdmin() {}
    // public void setFlagAdmin(String flaf) {}


