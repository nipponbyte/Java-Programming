/*6- Fes les funcions llegirInt i llegirFloat que lligen un int i un float respectivament i el
retornen. */

/*Introducir datos por teclado:
--------------------------------
BufferedReader in; 
in = new BufferedReader(new InputStreamReader(System.in));*/
package tema8_ej6;
import java.io.*;


public class Tema8_ej6 {
            
    
    public static int llegirInt(){
        BufferedReader in; 
        in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introdúceme un entero");
        /*int entero;*/
        try {
            int entero=Integer.parseInt(in.readLine());
            return entero;
        } 
        catch (IOException | NumberFormatException e) {
            System.out.println("Error!");
        } 
        return 0;
        
    }
    
    public static float llegirFloat(){
        BufferedReader in; 
        in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introdúceme un float");
        
        try {
            float fl=Float.parseFloat(in.readLine());
            return fl;
        } 
        catch (IOException | NumberFormatException e) {
            System.out.println("Error!");
        } 
        return 0;
    }
    
    public static void main(String[] args) {
        
        int enter=llegirInt();
        float flotante=llegirFloat();
        System.out.println("El entero es "+enter);
        System.out.println("El float es "+flotante);
    }

}
