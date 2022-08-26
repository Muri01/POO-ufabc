import java.util.Scanner;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) throws IOException {
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        String linhaUsuario[], nome, senha, flag;
        File file = new File(
                "/Users/murilosousa/Library/CloudStorage/GoogleDrive-murilodesousag@gmail.com/Meu Drive/_UFABC/_2022.2/POO - Programação Orientada a Objeto/PROJETO/POO-ufabc/sistemaVotacao/DataBase/User.csv");

        RandomAccessFile raf = new RandomAccessFile(file, "rw");

        while (raf.getFilePointer() < raf.length()) {
            linhaUsuario = raf.readLine().split(",");
            nome = linhaUsuario[0];
            senha = linhaUsuario[1];
            flag = linhaUsuario[2];

            Usuario U = new Usuario(nome, senha, flag);
            listaUsuarios.add(U);
        }
        System.out.println(listaUsuarios);

        
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
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
            return false;
        }
        System.out.println("LOGIN ERRADO");
        return false;
    }
}
