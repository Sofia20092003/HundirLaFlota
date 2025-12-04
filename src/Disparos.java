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
        impactosBarcos[idBarco]++;

        if (impactosBarcos[idBarco]<tamanoBarcos[idBarco]){
            tableroDisparos[fila][columna]='T';
            return false;
        }
        tableroDisparos[fila][columna]='H';

        for(int f=0; f<tableroBarcos.length; f++){
            for(int c=0; c<tableroBarcos[f].length; c++){
                if(tableroBarcos[f][c]==idBarco){
                    tableroDisparos[f][c]='H';
                }
            }
        }
        return true;
    }
}
