public class Disparos {
    public static boolean yaDisparados(char[][] tableroDisparos, int fila, int columna){
        return tableroDisparos[fila][columna]!='~';
    }
    public static boolean procesarDisparo(
            int fila,
            int columna,
            int [][] tableroBarcos,
            char[][] tableroDisparos,
            int[] impactosBarcos,
            int[] tamanoBarcos
    ){
        int idBarco= tableroBarcos[fila][columna];
        if(idBarco==-1){
            tableroDisparos[fila][columna]='A';
            return false;
        }
    }
}
