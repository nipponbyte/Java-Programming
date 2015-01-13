/** 
 * 
 * 1. Fes la funció mostrarVectorInt , que imprimisca un vector d’enters passat com a
        paràmetre. Cal mostrar els elements separats per comes i amb salt de línia final.
*
**/


package tema8_ej1;
import java.io.*;


public class Tema8_ej1 {

    
     static void mostrarVectorInt(int enters[]){
         for (int i = 0; i < enters.length; i++) {
            System.out.print(enters[i]+", ");
        }
    }

    public static void main(String[] args) {
       int enters[]={9,8,7,6,5,4,3,2,1};
       
        
            mostrarVectorInt(enters); 
        
       System.out.println("");
       

        
        
    }
    
}
