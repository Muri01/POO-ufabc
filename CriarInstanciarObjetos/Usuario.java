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
    Usuario (String nome,String senha, Boolean admin){
        this.nomeUsuario = nome;
        this.senha = senha;
        this.flagAdmin = admin;

    }

    //metodo pra testar imprimir as informações da classe
    public void status() {
        System.out.println("Informações do usuário");
        System.out.println("Nome: " + this.nomeUsuario);
        System.out.println("Senha: " + this.senha);
        System.out.println("é administrador?' " + this.flagAdmin);
    }

    public String getNomeUsuario(){
        return nomeUsuario;
    }
    //public void setNomeUsuario(String nomeUsuario){
//
   // }

    
}