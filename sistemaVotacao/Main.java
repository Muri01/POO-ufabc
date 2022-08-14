
import sistemaVotacao.*;
public class Main {
    
    public static void main(String[] args){
        Usuario u1 = new Usuario();
        u1.status();

        FileWrite fw = new FileWriter("usuarios.txt"); 
        PrintWriter pw = new PrintWriter(fw); 
        for (Usuario u: usuarios){ 
            String linha= String.format("%s;%s;%s",u.getNome(), u.getEmail(), u.getSenha()); 
            pw.println(linha);
        } 
        pw.close(); 
    }
}
