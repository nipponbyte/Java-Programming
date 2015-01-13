package pruebavectores;
import java.io.*;
/**
 *
 * @author tokyodownloader
 */
public class PruebaVectores {
    
    public static void main(String[] args) {
        BufferedReader in;
        in= new BufferedReader (new InputStreamReader(System.in));
     
       int notas[];
       
       notas=new int[3];
       
        for (int i = 1; i < notas.length; i++) {
            System.out.println("Dime una nota y la guardaré en "+i+": ");
            try {
                notas[i]=Integer.parseInt(in.readLine());
            } 
            catch (Exception e) {
                System.out.println("Error");
            } 
        }
        
        for (int i = 1; i < notas.length; i++) {
            System.out.println("La nota del alumno "+i+" es de "+notas[i]);
            
        }
        
        
        
    }
    
}
