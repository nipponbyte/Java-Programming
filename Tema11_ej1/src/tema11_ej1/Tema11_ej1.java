/*
 1.  Mira  al  teu  voltant.  Escriu  una  llista  d’alguns  objectes  i  posal’s un  nom  a 
cadascun. Classifica’ls. Finalment, escriu una sèrie de característiques de la classe i 
d’operacions. Posa també valors a les característiques de cada objecte. Exemple:
    Classe:   taula    
    Característiques: color, estat_de_conservació, coixaSN
    Operacions: arreglar-la, pintar-la, crear-la, destruir-la
    Objectes: taula1(verd,bo,N), taula2(verd,bo,N), taula3(verd,mal,S)
*/


/*Introducir datos por teclado:
--------------------------------
BufferedReader in; 
in = new BufferedReader(new InputStreamReader(System.in));*/


package tema11_ej1;
import java.io.*;
import utilidades.Utils.*;
import static utilidades.Utils.*;


class Silla{
    //Atributos
    String color;
    String estadoConservacion;
    String acolchadaSN;
    
    //Métodos
    void pintarDeBlanco(){
        this.color="Blanco";
    }
    
    
}

class Ordinador {
    String marca;
    String modelo;
    String tipoPantalla;
    String portatilSN;
    int anyFabricacion;
    
}



public class Tema11_ej1 {

    
    public static void main(String[] args) {
           Silla sill1=new Silla();
           sill1.pintarDeBlanco();
           System.out.println(sill1.color);
           
    }

}
