package tema10_ej1;
import java.io.*;

//1. Crea un projecte de nom Proves i defineix en ell les classes corresponents a les
//següents estructures de dades:

//a. Una data: dia, mes i any
    class Data{
        int dia;
        int mes;
        int any;
    }
//b. Un temps: hores, minuts, segons i centèsimes
    class Temps{
        int hores;
        int minuts;
        int segons;
        int centesimes;
    }
//c. Un rectangle: cantó superior dreta (x1, y1) i cantó inferior esquerra (x2, y2)
    class Rectangle{
        int x1, y1;
        int x2, y2;
    }
//d. Un concursant: nom complet, nom artístic i any de naixement
    class Concursant{
        String nom;
        String nom_artistic;
        int any;
    }
//e. Un CD d’àudio: grup, títol del disc, any publicació, quantitat de cançons
    class CD{
        String grup;
        String titol;
        int any;
        int num_canciones;
    }
//f. Un nom complet de persona: nom, primer cognom i segon cognom   
    class NomCompletPersona{
        String nom;
        String primer_cognom;
        String segon_cognom;
    }
//g. Un número de telèfon fix: prefix i resta del número
    class NumTelf{
        int prefix;
        int num;
    }
//h. Un domicili: carrer, número, pis, porta, codi postal, població i comarca
    class Domicili{
        String carrer;
        int num;
        int pis;
        String porta;
        int c_postal;
        String poblacio;
        String comarca;
    }
//i. Un color RGB: format per 3 enters que signifiquen la quantitat de roig, la de
//verd i la de blau. 
    class Color{
        int roig;
        int verd;
        int blau;
    }

//
//Clases Anidadas
//
    //a.  DadesPersonals: nom complet de persona, domicili i telèfon
    class DadesPersonals{
        NomCompletPersona nomcomplet = new NomCompletPersona();
        Domicili dom = new Domicili();
        NumTelf telf = new NumTelf();
    }

    class CarnetAlumne{
        DadesPersonals dades = new DadesPersonals();
        Data datanaix = new Data();
        Data datasol = new Data();
        Temps horasol = new Temps();
        
    }
    
    /*  8.  Afig la classe Cercle amb els atributs radi, colorVora i colorDins, tenint en compte 
        que els colors han de ser objectes de la classe Color que ja estava definida.*/
        class Cercle{
            float radi;
            Color colorVora;
            Color colorDins;
        }

public class Tema10_ej1 {   
    public static void introduirDades(Data a){
        BufferedReader in; 
        in = new BufferedReader(new InputStreamReader(System.in));
        try{
        System.out.println("Dime un any: ");
            a.any=Integer.parseInt(in.readLine());
        System.out.println("Dime un mes: ");
            a.mes=Integer.parseInt(in.readLine());
        System.out.println("Dime un dia: ");
            a.dia=Integer.parseInt(in.readLine());
        }
        catch(Exception e){
            System.out.println("Error!"); 
        }
        mostrarDades(a);
    }
    
    public static void mostrarDades(Data a){
        System.out.println("Dia: "+a.dia);
        System.out.println("Mes: "+a.mes);
        System.out.println("Any: "+a.any);
    }
    
    public static void main(String[] args) {
    
    //Primer método de declaración
        Data a1;
        a1=new Data();
        
        Temps a2;
        a2=new Temps();
        
        Rectangle a3;
        a3=new Rectangle();
        
        Concursant a4;
        a4=new Concursant();
        
    //Segundo método    
        CD a5 = new CD();
        NomCompletPersona a6 = new NomCompletPersona();
        NumTelf a7 = new NumTelf();
        Domicili a8 = new Domicili();
        Color a9 = new Color();
        
        introduirDades(a1);
        
        
   //6.  Crea l’objecte carnet1 (de la classe Carnet) i ompli’l de dades qualsevol.
        //Crear:
        CarnetAlumne carnet1 = new CarnetAlumne();
        //Rellenar de datos:
        carnet1.dades.nomcomplet.nom="Adrián";
        carnet1.dades.nomcomplet.primer_cognom="Martínez";
        carnet1.dades.nomcomplet.segon_cognom="Marín";
        carnet1.datanaix.any=1994;
        carnet1.datanaix.mes=5;
        carnet1.datanaix.dia=26;
        carnet1.datasol.any=2015;
        carnet1.datasol.mes=2;
        carnet1.datasol.dia=18;
        
    /* 7.  Crea  l’objecte  persona2  (de  la  classe  DadesPersonals)  i  ompli’l  de  dades.  
       Crea l'objecte  carnet2  (de  la  classe  CarnetAlumne)  i  ompli’l  
       amb  l’objecte  persona2  i altres dades qualsevol. */
        
        //Crear:
        DadesPersonals persona2 = new DadesPersonals();
        CarnetAlumne carnet2 = new CarnetAlumne();
        //Rellenar de datos:
        persona2.nomcomplet.nom="Angel";
        persona2.nomcomplet.primer_cognom="Chismol";
        persona2.dom.c_postal=69696;
        persona2.dom.poblacio="Xeraco";
        
        carnet2.dades=persona2;
        carnet2.datasol.any=2015;
        carnet2.datasol.mes=2;
        carnet2.datasol.dia=18;
        
       //Ejercicio 8-9
        //Reservar memoria para cercle1
        Cercle cercle1 = new Cercle();
        //Reservar memoria para colorVora y ColorDins de cercle1
        cercle1.colorVora = new Color();
        cercle1.colorDins = new Color();
        
    /*9.  Crea l’objecte cercle1 (de la classe Cercle) 
    i ompli’l de dades qualsevol. */
       //Omplir
        cercle1.colorDins.blau=22;
        cercle1.colorDins.roig=10;
        cercle1.colorDins.verd=55;
        cercle1.colorVora.blau=74;
        cercle1.colorVora.roig=99;
        cercle1.colorVora.verd=22;
        cercle1.radi=10.4f;
        
        
        
        
    }
}































