import java.util.Scanner;

public class Main {
    public static final int FILAS=10;
    public static final int COLUMNAS=10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] tamanosBarcos={5, 4, 3, 3, 2};
        int numBarcos= tamanosBarcos.length;

        int[][] tableroBarcosJugador=Tablero.crearTableroBarcos(FILAS, COLUMNAS);
        int[][] tableroBarcosCPU=Tablero.crearTableroBarcos(FILAS,COLUMNAS);

        char[][] tableroDisparosJugador= Tablero.crearTableroDisparos(FILAS,COLUMNAS);
        char[][] tableroDisparosCPU=Tablero.crearTableroDisparos(FILAS,COLUMNAS);

        int[] impactosJugador= new int[numBarcos];
        int[] impactosCPU= new int[numBarcos];

        for (int i = 0; i < numBarcos; i++) {
            impactosJugador[i]=0;
            impactosCPU[i]=0;
        }

        System.out.println("Alistando los barcos del jugador......");
        Barcos.colocarBarcosAleatorios(tableroBarcosJugador,tamanosBarcos);

        System.out.println("Alistando los barcos del CPU......");
        Barcos.colocarBarcosAleatorios(tableroBarcosCPU,tamanosBarcos);

        boolean end=false;
        boolean turnoJugador=true;

        while(!end){
            System.out.println("---------NUEVO TURNO----------");
            if (turnoJugador){
                System.out.println("Turno del jugador....");
                System.out.println("\nTus Barcos: ");
                Tablero.mostarTableroconBarcos(tableroBarcosJugador, tableroDisparosCPU);

                System.out.println("\nTus disparos contra la CPU: ");
                Tablero.mostrarTableroDisparos(tableroDisparosJugador);
            }
        }
    }
}
