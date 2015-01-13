package pruebaentrada;
import java.io.*;

public class PruebaEntrada {

    
    public static void main(String[] args) {
        BufferedReader in;
        in = new BufferedReader (new InputStreamReader(System.in));
        
        System.out.println("Dime algo:");
        
        try {
            String dato=in.readLine();
            System.out.println("Eres un/a "+dato);
            System.out.println("Cuantos años tienes?");
            int num=Integer.parseInt(in.readLine());
            System.out.println("Tienes "+num+" años.");
        } 
        
        catch (Exception e) {
            System.out.println("Error!");
        }
        
    }

  
    
}
