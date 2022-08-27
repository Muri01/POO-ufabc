import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class main {

    private static Scanner scan;
    private static RandomAccessFile raf;
    private static RandomAccessFile raf2;

    public static void main(String[] args) throws IOException {
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        ArrayList<Votacao> listaVotacao = new ArrayList<Votacao>();
        String linhaUsuario[], nome, senha, flag, Controle1 = "0", Controle2 = "0", linhaVotacao[], nomeVotacao, canditado1, canditado2;
        int numVotos1, numVotos2, num;
        File file = new File(
                "/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/User.csv");
        File file2 = new File(
                "/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/votacao.csv");

        
        raf = new RandomAccessFile(file, "rw");
        raf2 = new RandomAccessFile(file2, "rw");
        scan = new Scanner(System.in);

        //instanciar todos os usuarios usuario a guardar em listaUsuarios
        while (raf.getFilePointer() < raf.length()) { 
            linhaUsuario = raf.readLine().split(",");
            nome = linhaUsuario[0];
            senha = linhaUsuario[1];
            flag = linhaUsuario[2];

            Usuario U = new Usuario(nome, senha, flag);
            listaUsuarios.add(U);
        }
        
        //instanciar todos as votacoes a guardar em listaVotacao
        while (raf2.getFilePointer() < raf2.length()) { 
            linhaVotacao = raf2.readLine().split(",");
            nomeVotacao = linhaVotacao[0];
            canditado1 = linhaVotacao[1];
            numVotos1 = 1;
            canditado2 = linhaVotacao[3];
            numVotos2 = 1;

            // Votacao V = new Votacao(nomeVotacao, canditado1, canditado2, numVotos1, numVotos2);
            // listaVotacao.add(V);
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


        if (VerificaADM(listaUsuarios, nome)) {
            //instâncias Usuario ADMIN Auntenticado
            flag = "true";
            Usuario u1 = new Usuario(nome, senha, flag);
            System.out.println("Bem vindo " + u1.nomeUsuario);

            while (!Controle1.equals("0")) {
                Controle2 = "0";
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
                        System.out.println("Sair: 0");
                        System.out.println("");

                        Controle2 = scan.nextLine();

                        if (Controle2.equals("1")) {
                            System.out.println("Executou função adicionar candidato");
                            // função adicionar candidato


                        } else if (Controle2.equals("2")) {
                            System.out.println("Executou função excluir candidato");
                            // função excluir candidato
                        }
                    }
                }

                //GERENCIAR VOTAÇÃO
                else if (Controle1.equals("2")) {
                    while (!Controle2.equals("0")) {
                        System.out.println("Adicionar Votação: 1");
                        System.out.println("Excluir Votação: 2");
                        System.out.println("Sair: 0");
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
                        System.out.println("Sair: 0");
                        System.out.println("");
                        Controle2 = scan.nextLine();
                        if (Controle2.equals("1")) {
                            System.out.println("Executou adição de usuario");
                            // adiciona usuario
                        } else if (Controle2.equals("2")) {
                            System.out.println("Executou exclusão");
                            // função excluir usuário
                        }
                    }
                }

                //VOTAR ADM
                else if (Controle1.equals("4")) {
                    while (!Controle2.equals("0")) {
                        System.out.println("Votar: 1 ");
                        System.out.println("Sair: 0");
                        System.out.println("");
                        Controle2 = scan.nextLine();
                        if (Controle2.equals("1")) {
                            System.out.println("Executou função votar");
                            // chama função votar
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
                System.out.println("Bem vindo " + u2.nomeUsuario + " você não é admin");
                System.out.println("Digite um dos números abaixo ");
                System.out.println("Votar: 1 ");
                System.out.println("Cosultar resultados: 2");
                System.out.println("Sair da aplicacao: 0");
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
        System.out.println("LOGIN ERRADO");
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
