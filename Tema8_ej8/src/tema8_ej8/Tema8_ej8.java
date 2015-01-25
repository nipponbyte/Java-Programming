/*
8.  Funció booleana esBixest que, a partir d’un any, retorne si és bixest o no. Un any 
és bixest només si complix alguna d’estes 2 condicions: 
    a)  és múltiple de 4 i no de 100 (per exemple, el 2008)
    b)  és múltiple de 400 (per exemple, el 2000)
 */

/*Introducir datos por teclado:
--------------------------------
BufferedReader in; 
in = new BufferedReader(new InputStreamReader(System.in));*/
package tema8_ej8;
import java.io.*;

public class Tema8_ej8 {

    public static void esBixest(int any){
        if(any>0&&any<=9999){
            if (any%4==0&&any%100!=0){
                System.out.println("El número "+any+" es bisiesto.");
            }
            else if(any%400==0){
                System.out.println("El número "+any+" es bisiesto.");
            }

            else{
                System.out.println("El número "+any+" no es bisiesto.");
            }
        }
        else{
            System.out.println("Introduceme un numero desde el 1 al 9999 ");
        }
    }
    
    public static void main(String[] args) {
    BufferedReader in; 
    in = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Introduceme un año -> ");
            try {
                int num=Integer.parseInt(in.readLine());
                esBixest(num);
            } 
            catch (IOException | NumberFormatException e) {
                System.out.println("Error");
            }
        
    }

}
