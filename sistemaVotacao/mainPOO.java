package sistemaVotacao.*;
import javax.lang.model.util.ElementScanner14;
import java.util.Scanner;


public class mainPOO {
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String Usuario, Senha, Controle1="0",Controle2="0";


        // autenticação
        System.out.println("Insira o seu nome de Usuário: ");
        Usuario = scan.nextLine();
        System.out.println("Insira sua Senha: ");
        Senha = scan.nextLine();

        while(!Autenticao(Usuario,Senha))
        {
            System.out.println("Credenciais incorretas, insira novamente seu usuario e senha: ");
            System.out.println("Insira o seu nome de Usuário: ");
            Usuario = scan.nextLine();
            System.out.println("Insira sua Senha: ");
            Senha = scan.nextLine();
        }
        
        if(VerificaADM(Usuario, Senha)){
            while(!Controle1.equals("4")){
                Controle2 = "0";
                System.out.println("Gerenciar Candidatos: 1");
                System.out.println("Gerenciar Votações: 2");
                System.out.println("Gerenciar Usuários: 3");
                System.out.println("Sair: 4");
                System.out.println("");

                Controle1 = scan.nextLine();
                
                if(Controle1.equals("1")){

                    while(!Controle2.equals("4")){
                        System.out.println("Adicionar Candidado: 1");
                        System.out.println("Excluir Candidato: 2");
                        System.out.println("Sair: 4");
                        System.out.println("");

                        Controle2 = scan.nextLine();
                        
                        if(Controle2.equals("1")){
                            System.out.println("Executou função adicionar  candidato");
                            //função adicionar  candidato
                        }
                        else if( Controle2.equals("2")){
                            System.out.println("Executou função excluir candidato");
                            //função excluir  candidato
                        }
                    }

                }
                
                else if( Controle1.equals("2")){
                    while(!Controle2.equals("4")){ 
                        System.out.println("Adicionar Votação: 1");
                        System.out.println("Excluir Votação: 2");
                        System.out.println("Sair: 4");
                        System.out.println("");
                        Controle2 = scan.nextLine();
                        if(Controle2.equals("1")){
                            System.out.println("Executou função adicionar  Votação");
                            //função adicionar  Votação
                        }
                        else if( Controle2.equals("2")){
                            System.out.println("Executou função excluir  Votação");
                            //função excluir  Votação
                        }
                    }

                }
                else if( Controle1.equals("3")){ 
                    while(!Controle2.equals("4")){
                        System.out.println("Adicionar Usuário: 1");
                        System.out.println("Excluir Usuário: 2");
                        System.out.println("Sair: 4");
                        System.out.println("");
                        Controle2 = scan.nextLine();
                        if(Controle2.equals("1")){ 
                            System.out.println("Executou adição de usuario");
                            //adiciona usuario
                        }
                        else if(Controle2.equals("2")){ 
                            System.out.println("Executou exclusão");
                            //função excluir usuário

                        }
                    }

                }

                else if( Controle1.equals("3")){ 
                    while(!Controle2.equals("4")){ 
                        System.out.println("Votar: 1 ");
                        System.out.println("Sair: 4");
                        System.out.println("");
                        Controle2 = scan.nextLine();
                            if(Controle2.equals("1")){ 
                                System.out.println("Executou função votar");
                                //chama função votar
                            }
                    }

                }
            }
        }
        else{ 
            while(!Controle2.equals("4")){
                System.out.println("Votar: 1 ");
                System.out.println("Cosultar resultados: 2");
                System.out.println("Sair da aplicacao: 4");
                System.out.println("");
                Controle2 = scan.nextLine();

                    if(Controle2.equals("1")){ 
                        System.out.println("Executou função voltar");
                        //chama função votar

                    }
                    else if(Controle2.equals("2")){ 
                        System.out.println("Executou função consultar resultados");
                        //chama função votar
                    }
            }

        }
    }


    public static Boolean Autenticao( String U, String S) {
        if( U.equals("user") && S.equals("senha")){
            return true;
        }
        else
        {
            return false;
        }
    }

    public static Boolean VerificaADM( String U, String S) {
        if(U.equals("user") && S.equals("senha")){
            return true;
        }
        else
        {
            return false;
        }
    }
}




