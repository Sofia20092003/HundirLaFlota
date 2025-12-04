import java.util.Scanner;

public class Utilidades {
    private static final Scanner SC = new Scanner(System.in);

    public static int numeroAleatorio(int min, int max){
        return (int)(Math.random()*(max-min+1))+min;
    }

    public static int convertirFila(String coord){
        if(coord.length()<2){
            return -1;
        }
        String numero=coord.substring(1);
        try{
            return Integer.parseInt(numero);
        }catch (Exception e){
            return -1;
        }
    }
}
