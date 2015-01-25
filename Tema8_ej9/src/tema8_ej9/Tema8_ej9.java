/*
9. Funció  dataLLetra que  li  passes  una  data  amb  3  enters  (19,  2,  2009)  i  que 
retorne la data amb el format “19 de febrer de 2009”. Utilitza un switch. 
 */
/*Introducir datos por teclado:
--------------------------------
BufferedReader in; 
in = new BufferedReader(new InputStreamReader(System.in));*/
package tema8_ej9;
import java.io.*;

public class Tema8_ej9 {

    
    public static String dataLletra(int dia,int mes, int any){
        String monthString;
        switch(mes){
            case 1:  monthString = "Enero";
                     break;
            case 2:  monthString = "Febrero";
                     break;
            case 3:  monthString = "Marzo";
                     break;
            case 4:  monthString = "Abril";
                     break;
            case 5:  monthString = "Mayo";
                     break;
            case 6:  monthString = "Junio";
                     break;
            case 7:  monthString = "Julio";
                     break;
            case 8:  monthString = "Agosto";
                     break;
            case 9:  monthString = "Septiembre";
                     break;
            case 10: monthString = "Octubre";
                     break;
            case 11: monthString = "Noviembre";
                     break;
            case 12: monthString = "Diciembre";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
        
        return monthString;
    }
    
    
    public static void main(String[] args) {
        System.out.println("26 de "+ dataLletra(26,5,1994) + " de 1994.");
        
        
    }

}
