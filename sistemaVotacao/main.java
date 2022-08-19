
//import javax.lang.model.util.ElementScanner14;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;

public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String Usuario, Senha, Flag, Controle1 = "0", Controle2 = "0";

        // autenticação
        System.out.println("Insira o seu nome de Usuário: ");
        Usuario = scan.nextLine();
        System.out.println("Insira sua Senha: ");
        Senha = scan.nextLine();

        while (!Autenticao(Usuario, Senha)) {
            System.out.println("Credenciais incorretas, insira novamente seu usuario e senha: ");
            System.out.println("Insira o seu nome de Usuário: ");
            Usuario = scan.nextLine();
            System.out.println("Insira sua Senha: ");
            Senha = scan.nextLine();
        }

        if (VerificaADM(Usuario, Flag)) {
            while (!Controle1.equals("4")) {
                Controle2 = "0";
                System.out.println("Gerenciar Candidatos: 1");
                System.out.println("Gerenciar Votações: 2");
                System.out.println("Gerenciar Usuários: 3");
                System.out.println("Sair: 4");
                System.out.println("");

                Controle1 = scan.nextLine();

                if (Controle1.equals("1")) {

                    while (!Controle2.equals("4")) {
                        System.out.println("Adicionar Candidado: 1");
                        System.out.println("Excluir Candidato: 2");
                        System.out.println("Sair: 4");
                        System.out.println("");

                        Controle2 = scan.nextLine();

                        if (Controle2.equals("1")) {
                            System.out.println("Executou função adicionar  candidato");
                            // função adicionar candidato
                        } else if (Controle2.equals("2")) {
                            System.out.println("Executou função excluir candidato");
                            // função excluir candidato
                        }
                    }

                }

                else if (Controle1.equals("2")) {
                    while (!Controle2.equals("4")) {
                        System.out.println("Adicionar Votação: 1");
                        System.out.println("Excluir Votação: 2");
                        System.out.println("Sair: 4");
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

                } else if (Controle1.equals("3")) {
                    while (!Controle2.equals("4")) {
                        System.out.println("Adicionar Usuário: 1");
                        System.out.println("Excluir Usuário: 2");
                        System.out.println("Sair: 4");
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

                else if (Controle1.equals("3")) {
                    while (!Controle2.equals("4")) {
                        System.out.println("Votar: 1 ");
                        System.out.println("Sair: 4");
                        System.out.println("");
                        Controle2 = scan.nextLine();
                        if (Controle2.equals("1")) {
                            System.out.println("Executou função votar");
                            // chama função votar
                        }
                    }

                }
            }
        } else {
            while (!Controle2.equals("4")) {
                System.out.println("Votar: 1 ");
                System.out.println("Cosultar resultados: 2");
                System.out.println("Sair da aplicacao: 4");
                System.out.println("");
                Controle2 = scan.nextLine();

                if (Controle2.equals("1")) {
                    System.out.println("Executou função voltar");
                    // chama função votar

                } else if (Controle2.equals("2")) {
                    System.out.println("Executou função consultar resultados");
                    // chama função votar
                }
            }

        }
    }

    public static Boolean Autenticao(String U, String S) {
        try {
            String buscaUsuario;
            String array[] = new String[7];

            File file = new File(
                    "/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/User.csv");

            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            // buscaUsuario = raf.readLine();
            // array = buscaUsuario.split(",");

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

    public static Boolean VerificaADM(String U, String F) {
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
