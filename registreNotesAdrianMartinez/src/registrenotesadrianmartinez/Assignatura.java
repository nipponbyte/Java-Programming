package registrenotesadrianmartinez;
import static utilidades.Utils.*;

public class Assignatura {
    String nom;
    float eva[] = new float[3];
    
    //Métodos
    void posarNota(int evaElegida){
        
        switch(evaElegida){
           //Primera evaluacion
            case 1:
                System.out.println("Dime la nota de la primera evaluacion: ");
                    eva[0] = readFloat();
            break;
           //Segunda evaluacion    
            case 2:
                System.out.println("Dime la nota de la segunda evaluacion: ");
                    eva[1]=readFloat();
            break;
           //Tercera evaluación
            case 3:
                System.out.println("Dime la nota de la tercera evaluacion: ");
                    eva[2]=readFloat();
            break;
        }
        
    }
}

