
package registrenotesadrianmartinez;
import java.io.*;
import java.util.ArrayList;
import static utilidades.Utils.*;

public class RegistreNotesAdrianMartinez {

    //Mostrar Menu
    static void mostrarMenu(){
        System.out.println("-------------------------");
        System.out.println("Menú");
        System.out.println("-------------------------");
        System.out.println("1- Alta alumne");
        System.out.println("2- Posar nota alumnes");
        System.out.println("3- Buscar alumne");
        System.out.println("0- Finalizar");
        System.out.println("-------------------------");
        System.out.println("Introduce una opción:");
    }
    
// 1 - ALTA ALUMNO
    static void nuevoAlumno(ArrayList<Alumne> estudiante){
        estudiante.add(new Alumne());
    }
    
//2 - POSAR NOTA ALUMNES
    static void ponerNota(ArrayList<Alumne> estudiante){
        System.out.println("¿Qué asignatura quieres?");
            String intr = readString();
            //Comprobará que si la assignatura introducida coincide con la assignatura del vector, y nos devuelve la posicion en la que se encuentra.
            int pos = buscarAssignatura(estudiante,intr); 
            if (pos!=-1){
                System.out.println("De qué evaluacion quieres que ponga nota? (1,2,3)");
                    int evaElegida=readInt();
                for (int i = 0; i < estudiante.size(); i++) {
                    System.out.println("Nota de "+estudiante.get(i).nom+": ");
                    estudiante.get(i).assig[pos].posarNota(evaElegida); //Le enviamos la evaluación que queremos para que nos pida las notas en el metodo "posarNota" de la clase Assignatura.
                }
            }
    }
    
    static int buscarAssignatura(ArrayList<Alumne> estudiante, String asg){
        int resultat=-1;
        
        //Buscamos la asignatura y si la encuentra, guardamos en "resultat" la posicion. 
        for (int i = 0; i < estudiante.size(); i++) {
            for (int j = 0; j < 3; j++) {
                if (estudiante.get(i).assig[j].nom.equals(asg)) {
                    resultat=j;
                } 
            }
        }
        
        if(resultat==-1) {
                    System.out.println("No se ha encontrado la asignatura introducida.");
                }
        return resultat;
    }

//3 - BUSCAR ALUMNE   
    public static void buscarAlumne(ArrayList<Alumne> estudiante){
        int pos=-1;
        System.out.println("Dime el nombre del Alumno que quieres buscar:");
        String nomAlu = readString(); 
        
       for (int i = 0; i < estudiante.size(); i++) {
                if (estudiante.get(i).nom.equals(nomAlu)) {
                    pos=i;
                } 
        }
        if(pos!=-1){
            System.out.println("-------------------------------------");
            System.out.println("Información de "+nomAlu);
            System.out.println("-------------------------------------");
            System.out.print("Nombre: "+estudiante.get(pos).nom);
            System.out.print("\nTeléfono: "+estudiante.get(pos).tel);
            System.out.print("\nDirección: (Calle:) "+estudiante.get(pos).dirCarrer + " (Nº:) "+ estudiante.get(pos).dirNum + " (CP:) " + estudiante.get(pos).dirCP+"\n");
            for (int mouEv = 0, ev = 1; mouEv < 3; mouEv++, ev++) {
                System.out.println("Notas "+ev+"ª Evaluacion:");
                for (int mouAss = 0; mouAss < 3; mouAss++) {
                    System.out.print(estudiante.get(pos).assig[mouAss].nom+": ");
                    System.out.println(estudiante.get(pos).assig[mouAss].eva[mouEv]); 
                }  
            }  
        }
        else{
            System.out.println("¡No se ha encontrado el alumno!");
        }
    }   
    
    public static void main(String[] args) {
        ArrayList <Alumne> llistatAlumnes = new ArrayList<>();
        int opcion;
        
        do{
        mostrarMenu();
        opcion = readInt();
        System.out.println("-------------------------");
            switch(opcion){

                case 0:
                    System.out.println("Bye!");
                break;

                case 1:
                    nuevoAlumno(llistatAlumnes);
                break;

                case 2:
                    ponerNota(llistatAlumnes);
                break;

                case 3:
                    buscarAlumne(llistatAlumnes);
                    
                break;

                default:
                    System.out.println("ERROR! Introduzca de nuevo una de las siguietes opciones: 1 - 2 - 3 - 0");  
            }
        }
        while(opcion!=0);
        
    }

}
