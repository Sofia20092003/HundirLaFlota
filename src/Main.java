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

    }
}
