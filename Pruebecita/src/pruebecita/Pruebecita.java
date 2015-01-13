/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebecita;
import java.io.*;
/**
 *
 * @author tokyodownloader
 */
public class Pruebecita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader teclado = 
                new BufferedReader(new InputStreamReader(System.in));
        
      
        try{
        
            System.out.println("Dona'm un número");
            int num1=Integer.parseInt(teclado.readLine());
            
            System.out.println("Dona'm un altre número");
            int num2=Integer.parseInt(teclado.readLine());
            
            int resultado= num1*num2;
            
            System.out.println("El resultado de los 2 números multiplicados nos da:"+resultado);
            
        }
        catch(IOException e){
            System.out.println("Error!");
        }
    }
      
    
}
