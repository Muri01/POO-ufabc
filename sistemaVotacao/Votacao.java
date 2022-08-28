import java.util.Date;

public class Votacao {
    public String nomeVotacao;
    public String infoAdicionalVotacao;
    public Date dataCriacaoVotacao;
    public Date dataInicial;
    public Date dataFinal;
    public String[] candidatos;
    public int[] votos;

    //metodo construtor, que é chamado automaticamente sempre que um objeto é instanciado (não sei se precisa fazer)
    public Votacao(String nome, String candidato1, String candidato2, int numVotos1, int numVotos2) {
        nomeVotacao = nome;
        candidatos[0] = candidato1;
        votos[0] = numVotos1;
        candidatos[1] = candidato2;
        votos[1] = numVotos2;
        Date data = new Date(); // Gera uma data
        this.dataCriacaoVotacao = data;
    }

    public void detalhes(){
        
    }
    public void resultado(){
        if(votos[0]>votos[1]){
            System.out.println("O candidato vencedor é: " + candidatos[0]);
        }
        else if(votos[1]>votos[0]){
            System.out.println("O candidato vencedor é: " + candidatos[1]);
        }
        else{
            System.out.println("Houve EMPATE");
        }
    }




    //metodos dessa classe, não sei se vão ficar aqui mesmo
    // void criarVotacao(Votacao p){}
    // void deletarVotacao(Votacao p){}
    // void resultado(Votacao p){}
    // void inserirCandidato(Candidato c){}
    // void excluirCandidato(Candidato c){}
    // void votarCandidato(Candidato c){}
}
