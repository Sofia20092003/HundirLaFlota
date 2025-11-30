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
}
