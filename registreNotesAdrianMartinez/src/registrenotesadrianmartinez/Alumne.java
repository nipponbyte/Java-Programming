package registrenotesadrianmartinez;
import static utilidades.Utils.*;


public class Alumne {
    String nom;
    int tel;
    String dirCarrer;
    int dirNum;
    int dirCP;
    Assignatura assig[]=new Assignatura[3];

   //Constructor
    Alumne(){
        System.out.println("Dime el nombre:");
            String nom=readString();
        this.nom=nom;
        
        System.out.println("Dime el telefono:");
            int tel = readInt();
        this.tel=tel;
        
        System.out.println("Dime el nombre de la calle:");
            String dirCarrer=readString();
        this.dirCarrer=dirCarrer;
        
        System.out.println("Dime el numero de la calle:");
            int dirNum=readInt();
        this.dirNum=dirNum;
        
        System.out.println("Dime el Código postal:");
            int dirCP=readInt();
        this.dirCP=dirCP;
        
        for (int i = 0; i < this.assig.length; i++) {
            this.assig[i] = new Assignatura();
        }
        
        this.assig[0].nom="PRG";
        this.assig[1].nom="BDA";
        this.assig[2].nom="EDD";
        
    }
    
}

