import java.util.*;
public class main {
    
    public static void main(String[] args){
        List lista = new ArrayList();
        Usuario U1 = new Usuario("nome124","senha",true);
        Usuario U2  = new Usuario("nome124","senha",true);
        lista.add(U1.nomeUsuario);
        lista.add(U2);

        System.out.println(lista.get(0));
        System.out.println(U1.flagAdmin);
    }
}




