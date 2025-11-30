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
            for (int c=columna; c<columnas; c++){
                if(tablero[fila][c] !=-1){
                    return false;
                }
            }
        }else {
            if(fila+tamano>filas){
                return false;
            }
            for (int f=fila; f<fila + tamano; f++) {
                if(tablero[f][columna]!=-1){
                    return false;
                }
            }
        }
        return true;
    }
    public static void colocarBarco(int[][] tablero, int fila, int columna, int tamano, boolean horizontal, int idBarco){
        if (horizontal){
            for (int c=columna;c< columna+tamano; c++){
                tablero[fila][c]=idBarco;
            }
        }else {
            for (int f=fila; f<fila + tamano; f++) {
                tablero[f][columna]=idBarco;
            }
        }
    }
    public static boolean todosHundidos(int[] impactos, int[] tamanosBarcos){
        for (int i=0; i<impactos.length; i++){
            if (impactos[i]<tamanosBarcos[i]){
                return false;
            }
        }
        return true;
    }
}
