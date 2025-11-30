public class Barcos {
    public static void colocarBarcosAleatorios(int[][] tableroBarcos, int [] tamanoBarcos){
        for (int id=0; id<tamanoBarcos.length; id++){
            int tam=tamanoBarcos[id];
            boolean colocado=false;

            while (!colocado){
                int fila= Utilidades.numeroAleatorio(0, tableroBarcos.length-1);
                int col= Utilidades.numeroAleatorio(0, tableroBarcos[0].length-1);
                boolean horizontal= Utilidades.numeroAleatorio(0,1)==0;

                if(sePuedecolocarBarco(tableroBarcos, fila, col, tam, horizontal)){
                    colocarBarco(tableroBarcos, fila, col, tam, horizontal, id);
                    colocado=true;
                }
            }
        }
    }
    public static boolean sePuedecolocarBarco(int[][] tablero, int fila, int columna, int tamano, boolean horizontal){
        int filas=tablero.length;
        int columnas=tablero[0].length;

        if(horizontal){
            if(columna+tamano>columnas){
                return false;
            }
        }
    }
}
