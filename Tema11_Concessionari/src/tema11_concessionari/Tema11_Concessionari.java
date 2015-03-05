/*Introducir datos por teclado:
--------------------------------
BufferedReader in; 
in = new BufferedReader(new InputStreamReader(System.in));*/
package tema11_concessionari;
import java.io.*;
import java.util.Arrays;
import utilidades.Utils.*;
import static utilidades.Utils.*;

/*Posa els següents atributs a la classe Cotxe: 
numBastidor, matricula, marca, model, color, preu. 
També l’atribut privat revisions (vector de 5 booleans).*/

class Cotxe{
    int numBastidor;
    float preu;
    String matricula;
    String marca;
    String model;
    String color;
    private final boolean revisions[]=new boolean[5];

   //Metodos
    void matricular(String matr){
        this.matricula=matr;
    
    }
    
    void mostrarRevisions(){
        for (int i = 0; i < revisions.length; i++) {
            System.out.print(revisions[i]);
            System.out.print(" - ");
            
        }       
    }
    
    void mostrarDades(){
        System.out.println("Bastidor: "+this.numBastidor);
        System.out.println("Preu: "+ this.preu);
        System.out.println("Matrícula: "+ this.matricula);
        System.out.println("Marca: "+ this.marca);
        System.out.println("Model: "+this.model);
        System.out.println("Color: "+this.color);
        System.out.print("Revisions: ");
        mostrarRevisions();
    }
    void pintar(String colour){
        this.color=colour;
    }
    void augmentarPercentatgePreu(int porcentaje){
        this.preu=(this.preu/100)*porcentaje+this.preu;
    }
    void revisar(int nRev){
        nRev--;
        this.revisions[nRev]=true;
    }
    int quantitatRevisions(){
        int qRev=0;
        for (int i = 0; i < revisions.length; i++) {
            if(revisions[i]==true){
            
                qRev++;
            } 
        }
        return qRev; 
    }
    
   //Constructores
    Cotxe(int numBastidor, String matricula, String marca, String model, String color, float preu){
        this.numBastidor=numBastidor;
        this.matricula=matricula;
        this.marca=marca;
        this.model=model;
        this.color=color;
        this.preu=preu;
        
        for (int i = 0; i < revisions.length; i++) {
            this.revisions[i]=false;  
        }
    }
    
    Cotxe(int numBastidor, String marca, String model){
       
        this(numBastidor,null,marca,model,null,0.0f);
        
    }
    
    Cotxe(){
    this.numBastidor=0;
        this.matricula=;
        this.marca=null;
        this.model=null;
        this.color=null;
        this.preu=0.0f;
        
        for (int i = 0; i < revisions.length; i++) {
            this.revisions[i]=false;  
        }
    }
    
  
   //Getters y Setters
    public boolean[] getRevisions() {
        return revisions;
    }
    
    
   
  
}

public class Tema11_Concessionari {

    
    public static void main(String[] args) {
        
        Cotxe ct1 =new Cotxe(001,"Opel","Astra");

        Cotxe cotxeMeu = new Cotxe();
        
        
        ct1.mostrarDades();
        
        System.out.println("\nRevisions fetes: "+ct1.quantitatRevisions());
        
    }

}
