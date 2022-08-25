import java.util.*;
public class teste {
    
    public static void main(String[] args){
        Usuario[] usuarios = new Usuario[2];
        Usuario U1 = new Usuario("nome124","senha",true);
        Usuario U2  = new Usuario("nome124","senha",true);
        usuarios[0] = U1;
        usuarios[1] = U2;

    System.out.println(usuarios[0].nomeUsuario);
    }
}