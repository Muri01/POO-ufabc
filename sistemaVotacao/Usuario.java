import java.util.Date;

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

    public void adicionarUsuario(String p){
    }
    
    public void excluirUsuario(String p){
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
