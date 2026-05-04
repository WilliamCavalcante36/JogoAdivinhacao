package jogoadivinhicao;

public class LogicaJogo {
    private int numeroAleatorio;
    private int tentativas; 

    public LogicaJogo() {
        gerarNumero();
        tentativas = 0;
    }
    
    public void gerarNumero(){
        numeroAleatorio = (int)(Math.random() * 100) +1;
    }
    
    public String verificarTentativas(int numero){
        tentativas++;
        
         if(numero == numeroAleatorio){
            String msg = "Você acertou na " + tentativas + "° tentativa, parabéns!";
            tentativas = 0;
            return msg;
         }else if(numero < numeroAleatorio){
            return ("Tente um número maior");
         }else{
            return ("Tente um número menor");
         }
    }
}
