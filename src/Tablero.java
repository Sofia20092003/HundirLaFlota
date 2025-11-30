public class Tablero {

    public static int[][] crearTableroBarcos(int filas, int columnas){
        int[][] tablero= new int[filas][columnas];
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                tablero[i][j]=-1;
            }
        }
        return tablero;
    }
    public static char[][] crearTableroDisparos(int filas, int columnas){
        char[][] tablero= new char[filas][columnas];
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                tablero[i][j]='~';
            }
        }
        return tablero;
    }
    public static void mostrarTableroDisparos(char[][] t){
        System.out.println("   ");
        for (int c=0;c<t[0].length;c++){
            System.out.println(c+" ");
        }
        System.out.println();
        for(int f=0;f<t.length;f++){
            System.out.println((char) ('A' +f) +" ");
            for(int c=0;c<t[0].length;c++){
                System.out.println(t[f][c]+" ");
            }
            System.out.println();
        }
    }
    public static void mostarTableroconBarcos(int[][] barcos, char[][] disparos){
        System.out.println("  ");
        for (int c=0;c<barcos[0].length;c++){
            System.out.println(c+"  ");
        }
        System.out.println();

        for(int f=0;f<barcos.length;f++){
            System.out.println((char) ('A' +f) +" ");
            for(int c=0;c<barcos[0].length;c++){
                if(disparos[f][c]=='~'){
                    if(barcos[f][c]==-1){
                        System.out.println(".  ");
                    }else {
                        System.out.println(barcos[f][c]+" ");
                    }
                }else {
                    System.out.println(disparos[f][c]+" ");
                }
            }
            System.out.println();
        }
    }
    public static boolean esCoordenadaValida(int fila, int columna, int filas, int columnas){
        return fila>=0 && fila<filas && columna>=0 && columna<columnas;
    }
}
