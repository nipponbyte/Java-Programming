package buscaminas_adrian_martinez_1dam;
import java.io.*;
import static utilidades.Utils.*;
import java.util.Random;

public class Buscaminas_Adrian_Martinez_1DAM {
 
//DECLARAMOS VARIABLES GLOBALES
final static int TAB_SIZE = 10;
static char[][] tableroGrafico = new char[TAB_SIZE][TAB_SIZE];
static char[][] tableroBomb = minar();

//MINAR: Le introducimos cuantas minas querremos en el tablero, y nos las distribuirá de forma aleatoria por el teclado.
    public static char[][] minar(){
        int qMinas,f,c;
        char m[][]= new char[TAB_SIZE][TAB_SIZE];
        
        for(int i=0;i<TAB_SIZE;i++){
            for(int j=0;j<TAB_SIZE;j++){
                m[i][j]='_';
            } 
        }
        
        Random objetoRandom = new Random();   
        System.out.println("Bienvenido al buscaminas.");
              
        System.out.println("¿Con cuántas minas quieres jugar? (Máx 20)");
        
        do{
            qMinas=readInt();
            
            if(qMinas>20 || qMinas<=0){
                System.out.println("Introduce entre 1 o 20 minas");
            }
            
        }while(qMinas>20 || qMinas<=0);
        
        
        
        for(int i=0;i<qMinas;i++){
                do{
                    f=objetoRandom.nextInt(9);
                    c=objetoRandom.nextInt(9);
                    
                    if(m[f][c] == '*'){
                        i--;
                    }
                    
                    m[f][c]='*'; 
                }
                while(m[f][c] != '*');
            }
            
        return m;
    }

//PICAR
    static void picar(){
        int f=0,c=0,op;
        do{
            
            mostra(tableroGrafico);
            
            mostrarMenu();
            
            op = readInt();
        
        
            switch(op){
                //1- PICAR EN UNA POSICION
                case 1:

                   //Introducir una fila
                    do{
                        System.out.println("Introduzca la fila: ");
                             f=readInt();

                        if(f<0){
                            System.out.println("Introduzca un número positivo.");
                        }

                        if(f>=TAB_SIZE){
                            System.out.println("Introduzca un número menor o igual a "+(TAB_SIZE-1));
                        }

                    }
                    while(f<0 || f>=TAB_SIZE);

                   //Introducir una columna
                    do{
                        System.out.println("Introduzca la columna: ");
                            c=readInt();

                        if(c<0){
                            System.out.println("Introduzca un número positivo.");
                        }

                        if(c>=TAB_SIZE){
                            System.out.println("Introduzca un número menor o igual a "+(TAB_SIZE-1));
                        }
                    }
                    while(c<0 || c>=TAB_SIZE);
                    //Si en esa celda no encuentra una bomba, le enviamos la fila y la columna a la función recursiva "destapar".
                    if(tableroBomb[f][c]!='*'){
                        destapar(f,c);
                    }
                    //Si la encuentra, fin de la partida.
                    else{
                        System.out.println("------------------------------------------");
                        System.out.println("Has tocado una bomba. \nFin de la partida.");
                        System.out.println("------------------------------------------");
                    }

                break;

                //2 - PONER UNA BANDERITA EN UNA POSICION
                case 2:
                    colocarBandera();
                break;

                //DEFAULT - En caso de que no se introduzca 1 o 2.    
                default:
                    System.out.println("La opción introducida no está en el menú, introduzca 1 o 2.");
                break;
            }
        }
        while( qTapados()!= qBombas()  && tableroBomb[f][c]!='*');
    }
    
//MOSTRAR MENU    
    public static void mostrarMenu(){
        System.out.println("--------------------------------------");
        System.out.println("Seleccione una opción del menú (1-2)");
        System.out.println("--------------------------------------");
        System.out.println("1- Picar en una posición");
        System.out.println("2- Poner una banderita en una posición");
        System.out.println("--------------------------------------");
        System.out.print("Introduzca: ");   
    }
       
//DESTAPAR
    static void destapar(int f, int c){
        if ( (correcto(f,c)==true) && (tableroGrafico[f][c]=='X') && (minat(f,c)==false) ){
            
            if(qma(f,c)=='0'){ //Llamamos a qma para que nos devuelva la cantidad de minas adyacentes.

            tableroGrafico[f][c]='_'; //Vaciaremos la casilla.
            
            //Vamos destapando cifras de forma recursiva.
            destapar(f,c+1);
            destapar(f,c-1);
            destapar(f+1,c);
            destapar(f-1,c);
            destapar(f+1,c+1);
            destapar(f-1,c+1);
            destapar(f-1,c-1);
            destapar(f+1,c-1);
            
            }
            //Si hay minas alrrededor, qma nos devolverá un numero, y lo escribimos en el tablero gráfico.
            else{
                tableroGrafico[f][c]=qma(f,c);
            }           
        }
        
    }

//QMA: Cantidad de minas adyacentes.
    static char qma(int f, int c){
         int x=0;
         char y='0';  
         
        if(minat(f,c+1)==true){

            x=x+1;

        }

        if(minat(f,c-1)==true){

            x=x+1;
        }

        if(minat(f+1,c)==true){

            x=x+1;
        }

        if(minat(f-1,c)==true){

            x=x+1;

        }

        if(minat(f+1,c+1)==true){

            x=x+1;

        }
            
        if(minat(f+1,c-1)==true){

            x=x+1;

        }

        if(minat(f-1,c+1)==true){

            x=x+1;

        }

       if(minat(f-1,c-1)==true){

            x=x+1;
            
        }
       
        //Convertimos el resultado de x en caracter para poder devolverlo.
        switch(x){
            case 1: 
                y='1';
            break;
                
            case 2: 
                y='2';
            break;
                
            case 3: 
                y='3';
            break;
                
            case 4: 
                y='4';
            break;
                
            case 5: 
                y='5';
            break;
                
            case 6: 
                y='6';
            break;
                
            case 7: 
                y='7';
            break;
                
            case 8: 
                y='8';
            break;    
        }    

         return y;   
        }
    
//MINAT   
    static boolean minat(int f, int c){
        if(correcto(f,c)==true){
            return tableroBomb[f][c]=='*';
        }
        
        else{
            return false;
        }
    }

//CORRECTO
    static boolean correcto(int f, int c){
        return (f>=0) && (f<TAB_SIZE) && (c>=0) && (c<TAB_SIZE);
    }
       
//CANTIDAD DE TAPADOS
    static int qTapados(){
       int q=0; //contador
       for(int i=0 ; i<TAB_SIZE ; i++){
           for (int j = 0; j < TAB_SIZE; j++) {
               if(tableroGrafico[i][j]=='X'){
                   q++;
               }
           }
       }
       return q;
   }
    
//CANTIDAD DE BOMBAS
    static int qBombas(){
       int q=0;
       for(int i=0;i<TAB_SIZE;i++){
           for (int j = 0; j < TAB_SIZE; j++) {
               if(tableroBomb[i][j]=='*'){
                   q++;
               }
           }
       }
       return q;
   }
   
//COLOCAR BANDERA    
    static void colocarBandera(){
            int f,c;

            do{
                System.out.println("Introduce una fila: ");
                    f=readInt();
                    
                if(f<0){
                    System.out.println("La fila tiene que ser positiva.");
                }
                
                if(f>=TAB_SIZE){
                    System.out.println("La fila tiene que ser menor o igual a "+(TAB_SIZE-1));
                }

            }
            while(f<0 || f>=TAB_SIZE);

            do{
                System.out.println("Introduce una columna: ");
                c=readInt();

                if(c<0){
                    System.out.println("La columna tiene que ser positiva");
                }

                if(c>=TAB_SIZE){
                    System.out.println("La columna tiene que ser menor o igual a "+(TAB_SIZE-1));
                }

            }
            while(c<0 || c>=TAB_SIZE);

            if(tableroGrafico[f][c]=='X'){
                tableroGrafico[f][c]='P';
            }
            
            else{
                System.out.println("Aquí no se puede poner una bandera.");
            }
        }
    
//CONTADOR DE BANDERAS
    static int qBanderas(){
       int q=0;
       for(int i=0;i<TAB_SIZE;i++){
           for (int j = 0; j < TAB_SIZE; j++) {
               if(tableroGrafico[i][j]=='P'){
                   q++;
               }
           }
       }
       
       return q;
   }
    
//MOSTRAR EL TABLERO
    static void mostra(char m[][]){
        System.out.print("  ");   
        for (int i = 0; i < TAB_SIZE; i++) {
             
            System.out.print(" " + i + "");
        }
        System.out.println();
            for(int i=0;i<TAB_SIZE;i++){
                System.out.print(i+" |");
                for(int j=0;j<TAB_SIZE;j++){
                    
                    System.out.print(m[i][j]+"|");
                
                }
                System.out.print(" " + i);
                System.out.println("");    
            }
        
        System.out.print("  ");   
        for (int i = 0; i < TAB_SIZE; i++) {
             
            System.out.print(" " + i + "");
        }
        System.out.println("");
    }
    
//MAIN  
    public static void main(String[] args) {
        
        //Llenamos el tablero gráfico de 'X'.
        for(int i=0;i<TAB_SIZE;i++){
            for(int j=0;j<TAB_SIZE;j++){
                tableroGrafico[i][j]='X';
            }            
        }      
        
        picar();
        mostra(tableroGrafico);
        mostra(tableroBomb);  
          
    }

}
