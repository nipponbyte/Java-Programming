/*3. Funció copiarVector. 
Rebrà 2 vectors com a paràmetres i ha de copiar el primer vector al segon. 
Feu-ho sense utilitzar System.arraycopy.*/ 

package tema8ej3;
import  java.io.*;

public class Tema8_ej3 {
    
    static void copiarVector(int v[], int vcopia[]) {
        for (int i = 0; i < v.length; i++) {
            vcopia[i]=v[i];
        }
    }
    
    public static void main(String[] args) {
     BufferedReader in; 
     in = new BufferedReader(new InputStreamReader(System.in));
     
     int vector[] = {6,1,4,5};
     int vectorcopia[] = new int[4];
     copiarVector(vector, vectorcopia);
     for (int i = 0; i < vectorcopia.length; i++) {
            System.out.print(vectorcopia[i]+", ");   
        }
    }
    
}
