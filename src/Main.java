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

                System.out.println("\nIntroduce Coordenadas (A0, B5....): ");
                String coord=sc.nextLine().trim().toUpperCase();

                int fila=Utilidades.convertirFila(coord);
                int columna=Utilidades.convertirColumna(coord);

                if(!Tablero.esCoordenadaValida(fila,columna, FILAS, COLUMNAS)){
                    System.out.println("Coordenadas no validas. Pierdes el turno.");
                } else if (Disparos.yaDisparados(tableroDisparosJugador, fila, columna)) {
                    System.out.println("Ya habías disparado ahí. Pierdes turno.");
                }else {
                    boolean hundido=Disparos.procesarDisparo(
                            fila,columna,tableroBarcosCPU,tableroDisparosJugador,
                            impactosCPU,tamanosBarcos
                    );
                    if(hundido){
                        System.out.println("Has Hundido un barco de la CPU!!!");
                    }
                }

                if (Barcos.todosHundidos(impactosCPU,tamanosBarcos)){
                    System.out.println("\n¡Has Ganado!");
                    end=true;
                }
            }else {
                System.out.println("Es turno del CPU...");
                int fila, col;
                do {
                    fila=Utilidades.numeroAleatorio(0,FILAS-1);
                    col=Utilidades.numeroAleatorio(0,COLUMNAS-1);
                }while (Disparos.yaDisparados(tableroDisparosCPU, fila, col));

                System.out.println("La CPU ha disparado en "+(char)('A'+fila)+col);

                boolean hundido=Disparos.procesarDisparo(
                        fila,col, tableroBarcosJugador,tableroDisparosCPU,
                        impactosJugador,tamanosBarcos
                );
                if(hundido){
                    System.out.println("¡La CPU le ha dado ha uno de tus barcos!");
                }

                if (Barcos.todosHundidos(impactosJugador,tamanosBarcos)){
                    System.out.println("\n¡Has Perdido!");
                    end=true;
                }
            }
            turnoJugador=!turnoJugador;
        }
        System.out.println("Fin de la Partida.");
    }
}
