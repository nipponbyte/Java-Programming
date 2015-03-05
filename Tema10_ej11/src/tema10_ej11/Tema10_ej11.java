/*
11.  Un  empresa  de  lloguer  de  cotxes  vol  tindre  guardada la  informació  de  cadascun 
dels cotxes: matrícula (lletres i número), marca, model, data de compra i kms. 
 */



/*Introducir datos por teclado:
--------------------------------
BufferedReader in; 
in = new BufferedReader(new InputStreamReader(System.in));*/


package tema10_ej11;
import java.io.*;


class Cotxe{
int numMatr;
String nomMatr;
String marca;
String modelo;
DataCompra dataCompra = new DataCompra(); //Clase anidada
int kms;
}

class DataCompra{
int dia;
int mes;
int any;
}


public class Tema10_ej11 {

    
    public static void main(String[] args) {
       
        final int Q=2; //Cantidad total de coches que tenemos.
        
        //Definir vector de Q coches.  
        Cotxe cot[]=new Cotxe[Q];
        
        //Reservar espacio en memoria.
        
        for (int i = 0; i < cot.length; i++) {
            cot[i]=new Cotxe();
            cot[i].dataCompra=new DataCompra(); //Clase anidada.
        }
        
        
        
        
    }

}
