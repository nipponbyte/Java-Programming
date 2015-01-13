/*4. Funció igualsVectors. Rebrà 2 vectors. La funció ha de retornar un booleà dient si
els 2 vectors són iguals (igual grandària i mateixos elements). Feu-ho sense
utilitzar Arrays.equals. */

package tema8_ej4;
import java.io.*;

public class Tema8_ej4 {
    
    
static boolean igualVectors(int v1[], int v2[]) {
    int contador=0;
        for (int i = 0; i < v1.length; i++) {
            if(v1[i]==v2[i]){
                contador++;
            }
            
           
        }
        if (contador==4){
            return true;
        }
        else{
            return false;
        }
    }
 
    public static void main(String[] args) {
     BufferedReader in; 
     in = new BufferedReader(new InputStreamReader(System.in));
     
     int vector1[] = new int[4];
     int vector2[] = new int[4];
     
     
     //Relleno los vectores de datos. 
        for (int i = 0; i < vector2.length; i++) {
            
            try {
                System.out.println("Dime un numero y lo guardaré en la posición "+i+" del vector1:");
                    vector1[i] = Integer.parseInt(in.readLine());
                System.out.println("Dime un numero y lo guardaré en la posición "+i+" del vector2:");
                 vector1[i] = Integer.parseInt(in.readLine());
            } 
            catch (IOException | NumberFormatException e) {
                System.out.println("Error!");
            }
            
        }
     boolean resultado;
        resultado = igualVectors(vector1, vector2);
        if(resultado==true){
            System.out.println("Los vectores contienen lo mismo.");
        }
        else {
            System.out.println("Los vectores tienen contenidos distintos.");
        }
    }
    
}
