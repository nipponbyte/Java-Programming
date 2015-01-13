/**
2. Funció mostrarMatriuInt , que imprimisca una matriu d’enters. Cal mostrar-la en
forma de matriu on, en cada fila els elements han d’estar separats per comes.
Ajuda’t de la funció mostrarVectorInt3.
 
 
 **/


package tema8_ej2;
import java.io.*;

public class Tema8_ej2 {

    static void omplirVector(int m[][], int num){
        for (int f = 0; f < m.length; f++) {
            for (int c = 0; c < m.length; c++) {
                m[f][c] = num;
            }   
        }
    }
  
    static void mostrarMatriu(int matriu[][] ){
        for (int i = 0; i < matriu.length; i++) {
            mostrarVector(matriu[i]);
            
        }
    }
    
    static void mostrarVector(int vector []){
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i]+ "-");       
        }
        System.out.println(" ");
    }
    
    
    
    public static void main(String[] args) {
        int matriu[][]= new int [5][5]; //5 "filas" y 5 "columnas
        omplirVector(matriu, 3);
        mostrarMatriu(matriu);
        
    }
    
}
