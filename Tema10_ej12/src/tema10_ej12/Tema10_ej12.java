/*
 12.  Estructura per a guardar la informació de 200 empleats: número, nom, adreça, 
edat, estat civil, telèfon fix i mòbil. 
 */
/*Introducir datos por teclado:
--------------------------------
BufferedReader in; 
in = new BufferedReader(new InputStreamReader(System.in));*/
package tema10_ej12;
import java.io.*;


class Empleat{
    int num;
    String nom;
    String direccion;
    int edat;
    String estCivil;
    Telefon tel = new Telefon(); //Clase anidada.
}

class Telefon{
    int fijo;
    int movil;
}
public class Tema10_ej12 {

    
    public static void main(String[] args) {
        
        final int Q=200;
        
        //Declaramos el vector
            Empleat emp[]=new Empleat[Q];
            
        //Reservamos espacio
            for (int i = 0; i < emp.length; i++) {
            emp[i]=new Empleat();
            emp[i].tel=new Telefon(); //Clase anidada.
            
        }
        
    }

}
