package sistemaVotacao;
import java.util.Date;

public class Votacao {
    String idVotacao;
    String nomeVotacao;
    String infoAdicionalVotacao;
    String criadoPor;
    Date dataCriacaoVotacao;
    Date dataInicial;
    Date dataFinal;
    String[] canditos;
    String[] votos;
    String[] resultadoFinal;

     public static void main(String[] args){
        Usuario u1 = new Usuario("test1", "test1@gmail.com", "senha1");
        u1.status();
    }

    //metodos dessa classe, não sei se vão ficar aqui mesmo
    // void criarVotacao(Votacao p){}
    // void deletarVotacao(Votacao p){}
    // void resultado(Votacao p){}
    // void inserirCandidato(Candidato c){}
    // void excluirCandidato(Candidato c){}
    // void votarCandidato(Candidato c){}
}
