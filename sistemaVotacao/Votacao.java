import java.util.Date;

public class Votacao {
    public String nomeVotacao;
    public String infoAdicionalVotacao;
    public Date dataCriacaoVotacao;
    public Date dataInicial;
    public Date dataFinal;
    public String[] candidatos;
    public String[] votos;
    public String[] resultadoFinal;

    //metodo construtor, que é chamado automaticamente sempre que um objeto é instanciado (não sei se precisa fazer)
    public Votacao(String nome, String candidato1, String candidato2, int numVotos1, int numVotos2) {
        nomeVotacao = nome;
        candidatos[1] = candidato1;
        candidatos[3] = candidato2;
        Date data = new Date(); // Gera uma data
        this.dataCriacaoVotacao = data;
    }

    public void detalhes(){
        
    }
    public void resultado(){

    }




    //metodos dessa classe, não sei se vão ficar aqui mesmo
    // void criarVotacao(Votacao p){}
    // void deletarVotacao(Votacao p){}
    // void resultado(Votacao p){}
    // void inserirCandidato(Candidato c){}
    // void excluirCandidato(Candidato c){}
    // void votarCandidato(Candidato c){}
}
