
/*Introducir datos por teclado:
--------------------------------
BufferedReader in; 
in = new BufferedReader(new InputStreamReader(System.in));*/
package tema10_ej10;
import java.io.*;

/*
10.  Una  biblioteca  vol  emmagatzemar  informació  de  cada  llibre  que  té:  codi  de 
referència  (alfanumèric),  autors  (màxim,  3),  títol, editorial  i  any.  Implementa 
l’estructura necessària.


*/
class Llibre{
    String codi;
    String autor[]=new String[2];
    String titol;
    String editorial;
    int any;
}


public class Tema10_ej10 {
    
    
    
    public static void ioLlibre(Llibre llib){
        
        try {
            BufferedReader in; 
            in = new BufferedReader(new InputStreamReader(System.in));
            
            //Pedir código
                System.out.println("Disme el codi del llibre: ");
                    llib.codi=in.readLine();
            //Pedir autores. Primero cuantos son, y luego recorro el for con los autores que son. 
                    for (int i = 0, n = 1; i <llib.autor.length; i++,n++) {
                        System.out.println("Dime el nombre del autor nº"+n+": ");
                        llib.autor[i]=in.readLine();
                    }
            //Pedir título
                System.out.println("Dime el título del libro: ");
                    llib.titol=in.readLine();
            //Pedir editorial
                System.out.println("Dime el nombre de la editorial: ");
                    llib.editorial=in.readLine();
            //Pedir año
                System.out.println("Dime el año de publicación del libro: ");
                    llib.any=Integer.parseInt(in.readLine());        
        } 
        
        catch (Exception e) {
        }
        System.out.println("--------------------------------");
        //Mostrar código
                    System.out.println("Código: "+llib.codi);
            //Mostrar autores
                    for (int i = 0, n = 1; i < llib.autor.length; i++,n++) {
                        System.out.println("Autor nº"+n+": "+llib.autor[i]);     
                    }
            //Mostrar título
                    System.out.println("Título: "+llib.titol);
            //Mostrar editorial
                    System.out.println("Editorial: "+llib.editorial);
            //Mostrar any
                    System.out.println("Any de Publicació: "+llib.any);
        System.out.println("--------------------------------");
    }
    

    public static void main(String[] args) {
       
        final int Q=4; //Cantidad total de libros que tenemos.
        
        //Defino un vector de Q libros de la clase Llibre.
        Llibre llib[] = new Llibre[Q];
        
        //Reservo memoria para cada uno de los Q.
        for (int i = 0; i < llib.length; i++) {
            llib[i] = new Llibre();
            ioLlibre(llib[i]);
            
        }
        
        
        
        
        
  
    }

}
