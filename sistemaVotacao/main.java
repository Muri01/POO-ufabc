import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class main {

    private static Scanner scan;
    private static RandomAccessFile raf;

    public static void main(String[] args) throws IOException {
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        String linhaUsuario[], nome, senha, flag, Controle1 = "9", Controle2 = "9";
        File file = new File(
                "/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/User.csv");
        raf = new RandomAccessFile(file, "rw");
        scan = new Scanner(System.in);

        //instanciar todos os usuarios usuario a guardar em listaUsuarios
        while (raf.getFilePointer() < raf.length()) { 
            linhaUsuario = raf.readLine().split(";");
            nome = linhaUsuario[0];
            senha = linhaUsuario[1];
            flag = linhaUsuario[2];

            Usuario U = new Usuario(nome, senha, flag);
            listaUsuarios.add(U);
        }

        //processo de perguntar o login
        System.out.println("Insira o seu nome de Usuário: ");
        nome = scan.nextLine();
        System.out.println("Insira sua Senha: ");
        senha = scan.nextLine();

        //AUTENTICAÇÃO
        while (!Autenticao(listaUsuarios, nome, senha)) {
            System.out.println("Credenciais incorretas, insira novamente seu usuario e senha: ");
            System.out.println("Insira o seu nome de Usuário: ");
            nome = scan.nextLine();
            System.out.println("Insira sua Senha: ");
            senha = scan.nextLine();
            
        }

        // USUARIO ADMIN
        if (VerificaADM(listaUsuarios, nome)) {
            //instâncias Usuario ADMIN Auntenticado
            flag = "true";
            Usuario u1 = new Usuario(nome, senha, flag);
            System.out.println("Bem vindo " + u1.nomeUsuario);

            while (!Controle1.equals("0")) {
                Controle2 = "9";
                System.out.println("Digite um dos números abaixo ");
                System.out.println("Gerenciar Candidatos: 1");
                System.out.println("Gerenciar Votações: 2");
                System.out.println("Gerenciar Usuários: 3");
                System.out.println("Votar: 4");
                System.out.println("Sair: 0");
                System.out.println("");
                Controle1 = scan.nextLine();

                //GERENCIAR CANDIDATOS
                if (Controle1.equals("1")) {

                    while (!Controle2.equals("0")) {
                        System.out.println("Adicionar Candidado: 1");
                        System.out.println("Excluir Candidato: 2");
                        System.out.println("Voltar: 0");
                        System.out.println("");
                        Controle2 = scan.nextLine();

                        if (Controle2.equals("1")) { // função adicionar candidato
                            System.out.println("Insira o nome do novo candidato: ");
                            nome = scan.nextLine();
                            System.out.println("Insira alguma informação do novo candidato:");
                            String info = scan.nextLine();
                            u1.adicionarCandidato(nome,info);
                            System.out.println("Candidato Criado com sucesso! O que deseja fazer agora?");

                        } else if (Controle2.equals("2")) { // função excluir candidato
                            System.out.println("Digite o nome de Candidato que deseja excluir:");
                            String nomeCandidato = scan.nextLine();
                            u1.excluirCandidato(nomeCandidato);
                            System.out.println("Candidato excluido com sucesso! O que desaja fazer agora?");
                        }
                    }
                }

                //GERENCIAR VOTAÇÃO
                else if (Controle1.equals("2")) {
                    while (!Controle2.equals("0")) {
                        System.out.println("Adicionar Votação: 1");
                        System.out.println("Excluir Votação: 2");
                        System.out.println("Voltar: 0");
                        System.out.println("");
                        Controle2 = scan.nextLine();
                        if (Controle2.equals("1")) {
                            System.out.println("Executou função adicionar  Votação");
                            // função adicionar Votação
                        } else if (Controle2.equals("2")) {
                            System.out.println("Executou função excluir  Votação");
                            // função excluir Votação
                        }
                    }

                } 
                
                //GERENCIAR USUÁRIOS
                else if (Controle1.equals("3")) {
                    while (!Controle2.equals("0")) {
                        System.out.println("Adicionar Usuário: 1");
                        System.out.println("Excluir Usuário: 2");
                        System.out.println("Voltar: 0");
                        System.out.println("");
                        Controle2 = scan.nextLine();
                        if (Controle2.equals("1")) { //Adicionar usuario
                            System.out.println("Insira o NOME do novo usuário: ");
                            nome = scan.nextLine();
                            System.out.println("Insira a SENHA do novo usuário: ");
                            senha = scan.nextLine();
                            System.out.println("o novo usuário é admin? ");
                            flag = scan.nextLine();
                            u1.adicionarUsuario(nome, senha, flag);
                            System.out.println("Novo usuário adicionado com sucesso! O que desaja fazer agora?");
                        } else if (Controle2.equals("2")) { //excluir usuário
                            System.out.println("Digite o nome de usuário que deseja excluir:");
                            nome = scan.nextLine();
                            u1.excluirUsuario(nome);
                            System.out.println("Usuário excluido com sucesso! O que desaja fazer agora?");
                        }
                    }
                }

                //VOTAR ADM
                else if (Controle1.equals("4")) {
                    while (!Controle2.equals("0")) {
                        System.out.println("Votar: 1 ");
                        System.out.println("Voltar: 0");
                        System.out.println("");
                        Controle2 = scan.nextLine();
                        if (Controle2.equals("1")) { // chama função votar
                            u1.votar();
                            
                        }
                    }
                }
            }
        } 
        
        // USUARIO COMUM
        else {
            //instâncias Usuario COMUM Auntenticado
            flag = "true";
            Usuario u2 = new Usuario(nome, senha, flag);
            System.out.println("Bem vindo " + u2.nomeUsuario);
            while (!Controle2.equals("0")) {
                System.out.println("Digite um dos números abaixo ");
                System.out.println("Votar: 1 ");
                System.out.println("Cosultar resultados: 2");
                System.out.println("Sair da aplicação: 0");
                System.out.println("");
                Controle2 = scan.nextLine();

                //VOTAR
                if (Controle2.equals("1")) {
                    System.out.println("Executou função VOTAR");
                    // chama função votar

                } else if (Controle2.equals("2")) {
                    System.out.println("Executou função consultar resultados");
                    // chama função votar
                }
            }
        }
    }

    private static Boolean Autenticao(ArrayList<Usuario> listaUsuarios, String U, String S) {
        for (int i=0; i < listaUsuarios.size(); i++) {
            if (U.equals(listaUsuarios.get(i).nomeUsuario) && S.equals(listaUsuarios.get(i).senhaUsuario)){
                System.out.println("CADASTRO REALIZADO COM SUCESSO");
                return true;
            }
        }
        return false;
    }

    private static Boolean VerificaADM(ArrayList<Usuario> listaUsuarios, String U) {
        String flagVerifica = "true";
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (U.equals(listaUsuarios.get(i).nomeUsuario) && flagVerifica.equals(listaUsuarios.get(i).flagAdmin)) {
                System.out.println("CADASTRO DE ADMIN REALIZADO COM SUCESSO");
                return true;
            }
        }
        System.out.println("VOCE NAO É ADMIN");
        return false;
    }
}
