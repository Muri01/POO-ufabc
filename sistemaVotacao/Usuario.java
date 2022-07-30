package sistemaVotacao;
import java.util.Scanner;
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

    //metodo construtor, que é chamado automaticamente sempre que um objeto é instanciado (não sei se precisa fazer)
    public Usuario (String n, String e, String s){
        Random gerador = new Random();  //gerar um codigo aleatorio para o ID
        this.idUsuario = gerador.nextInt(9);
        this.nomeUsuario = n;
        this.email = e;
        this.senha = s;
        Date data = new Date(); // Gera uma data
        this.dataCriacaoUsuario = data;
    }

    public void adicionarUsuario(Usuario p){
            System.out.println("Digite o nome do usuario novo:");
            Scanner n = new Scanner(System.in);
            this.nomeUsuario = n.nextLine();

            System.out.println("Username is: " + this.nomeUsuario);
    }
    
    public void status() {
        System.out.println("sobre o usuario");
        System.out.println("Id: " + this.idUsuario);
        System.out.println("Nome: " + this.nomeUsuario);
        System.out.println("E-mail: " + this.email);
        System.out.println("Senha: " + this.senha);
        System.out.println("data de Criação: " + this.dataCriacaoUsuario);
    }

    public void excluirUsuario(Usuario p) {}
}