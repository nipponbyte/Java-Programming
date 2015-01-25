/*
5. Fes la funció llegirString que llija una cadena de teclat i la retorne. 
*/



package tema8_ej5;
import java.io.*;



public class Tema8_ej5 {


    static String llegirString(){
        String cadena="";
        BufferedReader in; 
        in = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            System.out.println("Introduce un string: ");
            cadena=in.readLine();
            
        } 
        catch (Exception e) {
            System.out.println("Error.");
        }
        return cadena;
        
    }
    
    public static void main(String[] args) {
        
        System.out.println(llegirString());
    }

}
