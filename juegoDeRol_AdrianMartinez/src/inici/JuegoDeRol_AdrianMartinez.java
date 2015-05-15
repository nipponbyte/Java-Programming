 
package inici;
import java.io.*;
import java.util.ArrayList;
import joc.*;
import static io.Utils.*;

public class JuegoDeRol_AdrianMartinez {
    //Atributos
    static ArrayList<Player> jugadores = new ArrayList<>();
    static ArrayList<Team> equipos = new ArrayList<>();
    static ArrayList<Item> armas = new ArrayList<>();
    
    public static void mostrarMenuPrincipal(){
        System.out.println("----------------");
        System.out.println("Menu principal");
        System.out.println("----------------");
        System.out.println("1- Configuración");
        System.out.println("2- Jugar");
        System.out.println("3- Salir");
        System.out.println("----------------");
    }
    
    public static void mostrarMenuConfiguracion(){
        System.out.println("----------------");
        System.out.println("1- Configuración");
        System.out.println("----------------");
        System.out.println("1- Gestión de jugadores");
        System.out.println("2- Gestión de equipos");
        System.out.println("3- Gestión de objetos");
        System.out.println("4- Salir");
        System.out.println("----------------");
    }
    
    public static void mostrarMenuJugadores(){
        System.out.println("----------------");
        System.out.println("1.1- Jugadores");
        System.out.println("----------------");
        System.out.println("1- Crear un jugador");
        System.out.println("2- Mostrar jugadores");
        System.out.println("3- Eliminar un jugador");
        System.out.println("4- Asignar un equipo al jugador");
        System.out.println("5- Asignar un objeto al jugador"); 
        System.out.println("6- Salir");
        System.out.println("----------------");
    }
    
    public static void mostrarMenuEquipos(){
        System.out.println("----------------");
        System.out.println("1.2- Equipos");
        System.out.println("----------------");
        System.out.println("1- Crear un equipo");
        System.out.println("2- Mostrar equipos");
        System.out.println("3- Borrar un equipo");
        System.out.println("4- Asignar un jugador al equipo");
        System.out.println("5- Salir"); 
        System.out.println("----------------");
    }
    
    public static void mostrarMenuObjetos(){
        System.out.println("----------------");
        System.out.println("1.3- Objetos");
        System.out.println("----------------");
        System.out.println("1- Crear un objeto");
        System.out.println("2- Mostrar objetos");
        System.out.println("3- Borrar un objeto");
        System.out.println("4- Asignar un objeto al jugador");
        System.out.println("5- Salir");
        System.out.println("----------------");
    }
    //JUGADORES: ACCIONES.
        //1.1- CREAR JUGADOR
        public static void crearJugador(ArrayList<Player> players){

            boolean exist=false;
            final int hPoints=100;
            int aPoints=0;
            char tipoJug = ' ';

            System.out.println("----------------");
            System.out.println("Opción escogida: Crear un jugador.");
            System.out.println("----------------");

            System.out.print("¿Que nombre le ponemos? -> ");
            String nombre = readString();
            System.out.println("");

            for (int i = 0; i < players.size(); i++) {
                if(players.get(i).getName().equals(nombre)){
                    exist=true;
                }    
            }

            if(exist==false){

                System.out.println("¿Qué tipo de jugador quieres crear?");
                System.out.print("(A) para Alien, (H) para Human, (W) para Warrior -> ");
                tipoJug = readChar();


                System.out.println("");

                    do{
                    System.out.print("¿Cuántos puntos de ataque tendrá "+nombre+"? -> ");
                        aPoints = readInt();

                        if(aPoints<0||aPoints>100){ System.out.println("Error! Introduzca una cantidad comprendida entre 0 y 100");}

                        System.out.println("");

                    } while(aPoints<0||aPoints>100);

                int dPoints = 100 - aPoints; //Calcular los puntos de defensa automáticamente.

                //Creamos los jugadores según el tipo que sean, y así incluiremos en la creación sus características específicas.
                if(tipoJug=='A'||tipoJug=='a'){ //Alien
                    Alien al1 = new Alien(nombre, aPoints, dPoints, hPoints);
                    System.out.println("La creación del Alien "+nombre+", se ha completado de forma satisfactoria.");
                    players.add(al1);
                }

                if(tipoJug=='H'||tipoJug=='h'){ //Human
                    Human h1=new Human(nombre, aPoints, dPoints, hPoints);
                    System.out.println("La creación del Human "+nombre+", se ha completado de forma satisfactoria.");
                    players.add(h1);
                }

                if(tipoJug=='W'||tipoJug=='w'){ //Warrior
                    Warrior w1=new Warrior(nombre, aPoints, dPoints, hPoints);
                    System.out.println("La creación del Warrior "+nombre+", se ha completado de forma satisfactoria.");
                    players.add(w1);
                }      
            }
            else{
                System.out.println("El jugador ya ha sido creado anteriormente.");

            }
        } //Fin crearJugador

        //1.2- MOSTRAR JUGADORES
        public static void mostrarJugador(ArrayList<Player> players){
            String muestra;
            System.out.println("----------------");
            System.out.println("Opción escogida: Mostrar jugadores.");
            System.out.println("----------------");

            if(players.isEmpty()){ //Si está vacío.
                System.out.println("No se ha añadido ningún jugador.");
            }
            else{
                for (int i = 0; i < players.size(); i++) {
                    muestra = players.get(i).toString();

                    System.out.println(muestra);
                }
            }
        }

        //1.3- ELIMINAR JUGADOR
        public static void eliminarJugador(ArrayList<Player> players){
            String nom;
            int pos=0;
            boolean result = false;

            System.out.println("----------------");
            System.out.println("Opción escogida: Eliminar un jugador.");
            System.out.println("----------------");

            if(players.isEmpty()){
                System.out.println("No existen jugadores. No se podrían buscar.");

            }
            else{
                System.out.print("Introduce el nombre del jugador que quieres eliminar -> ");
                nom = readString();
                System.out.println("");

                for (int i = 0; i < players.size(); i++) {
                    if(players.get(i).getName().equals(nom)){ //Si el nombre corresponde con alguno de la lista, que lo elimine.
                        result = true;
                        pos=i;
                    } 
                }
                if(result){
                    players.remove(pos);
                    System.out.println(nom+" se eliminó de forma satisfactoria.");
                }
                else{
                    System.out.println("No existe ningún jugador con el nombre indicado.");
                }

            }   
        }//Fin Eliminar jugador

        //1.4- Asignar un equipo al jugador
        public static void asignarEquipoAJugador(ArrayList<Player> players, ArrayList<Team> teams){
            String nomJug, nomEq;
            int posJug=0, posEq=0;
            boolean resultJug=false, resultEq=false;

            System.out.println("----------------");
            System.out.println("Opción escogida: Asignar un equipo al jugador.");
            System.out.println("----------------");


            if(players.isEmpty()){
                System.out.println("No existen jugadores. No se podría añadir nadie.");

            }

            else if(teams.isEmpty()){
                System.out.println("No existen equipos. No se podría asignar ninguno.");
            }
            else{
                System.out.print("Introduce el nombre del JUGADOR que quieres añadir a un equipo. -> ");
                nomJug = readString();
                System.out.println("");

                System.out.print("Introduce el nombre del EQUIPO al que quieres que añada al jugador  -> ");
                nomEq = readString();
                System.out.println("");

                for (int i = 0; i < players.size(); i++) {
                    if(players.get(i).getName().equals(nomJug)){ 
                        resultJug = true;
                        posJug=i;
                    } 
                }
                for (int i = 0; i < teams.size(); i++) {
                    if(teams.get(i).getName().equals(nomEq)){
                        resultEq = true;
                        posEq = i;
                    }
                }
                //Finalmente añadimos el jugador al equipo si las comprobaciones han sido las correctas.
                if(resultEq&&resultJug){
                    players.get(posJug).addTeamIntoPlayer(teams.get(posEq));
                    System.out.println("Se añadio "+nomJug+" al equipo "+nomEq+" de forma satisfactoria.");
                }
                else{
                    System.out.println("Error. No se ha podido añadir.");
                }   
            }  
        }

        //1.5- Asignar un objeto al jugador
        public static void asignarObjetoAJugador(ArrayList<Player> players, ArrayList<Item> items){
            String nomJug, nomObj;
            int posJug=0, posObj=0;
            boolean resultJug=false, resultObj=false;

            System.out.println("----------------");
            System.out.println("Opción escogida: Asignar un objeto al jugador.");
            System.out.println("----------------");


            if(players.isEmpty()){
                System.out.println("No existen jugadores. No se podría añadir un objeto.");

            }

            else if(items.isEmpty()){
                System.out.println("No existen objetos. No se podría asignar ninguno.");
            }
            else{
                System.out.print("Introduce el nombre del JUGADOR al que quieres añadir un objeto -> ");
                nomJug = readString();
                System.out.println("");

                System.out.print("Introduce el nombre del OBJETO que quieres asignar al jugador -> ");
                nomObj = readString();
                System.out.println("");

                for (int i = 0; i < players.size(); i++) {
                    if(players.get(i).getName().equals(nomJug)){ 
                        resultJug = true;
                        posJug=i;
                    } 
                }
                for (int i = 0; i < items.size(); i++) {
                    if(items.get(i).getName().equals(nomObj)){
                        resultObj = true;
                        posObj = i;
                    }
                }
                //Finalmente añadimos el jugador al equipo si las comprobaciones han sido las correctas.
                if(resultObj&&resultJug){
                    players.get(posJug).addItem(items.get(posObj));
                    System.out.println("Se asignó el objeto "+nomObj+" al jugador "+nomJug+" de forma satisfactoria.");
                }
                else{
                    System.out.println("Error. No se ha podido asignar.");
                }   
            }

        }
    
    //EQUIPOS: ACCIONES
        //2.1- Crear un equipo
        public static void crearEquipo(ArrayList<Team> teams){

            boolean exist=false;


            System.out.println("----------------");
            System.out.println("Opción escogida: Crear un equipo.");
            System.out.println("----------------");

            System.out.print("¿Que nombre le ponemos? -> ");
            String nombre = readString();
            System.out.println("");

            for (int i = 0; i < teams.size(); i++) {
                if(teams.get(i).getName().equals(nombre)){
                    exist=true;
                }    
            }

            if(exist==false){
                Team t1 = new Team(nombre);
                teams.add(t1);
                System.out.println("Se ha creado el equipo "+nombre+" de forma satisfactoria.");
            }    
            else{
                System.out.println("El equipo ya ha sido creado anteriormente.");

            }
        } //Fin crearEquipo

        //2.2- Mostrar equipos
        public static void mostrarEquipos(ArrayList<Team> teams){
            String muestra;
            System.out.println("----------------");
            System.out.println("Opción escogida: Mostrar equipos.");
            System.out.println("----------------");

            if(teams.isEmpty()){ //Si está vacío.
                System.out.println("No se ha añadido ningún jugador.");
            }
            else{
                for (int i = 0; i < teams.size(); i++) {
                    muestra = teams.get(i).toString();

                    System.out.println(muestra);
                }
            }
        }

        //2.3- Eliminar un equipo   
        public static void eliminarEquipo(ArrayList<Team> teams){
            String nom;
            int pos=0;
            boolean result = false;

            System.out.println("----------------");
            System.out.println("Opción escogida: Borrar un equipo.");
            System.out.println("----------------");

            if(teams.isEmpty()){
                System.out.println("No existen equipos. No se podrían eliminar ya que no existen");

            }
            else{
                System.out.print("Introduce el nombre del equipo que quieres eliminar -> ");
                nom = readString();
                System.out.println("");

                for (int i = 0; i < teams.size(); i++) {
                    if(teams.get(i).getName().equals(nom)){ //Si el nombre corresponde con alguno de la lista, que lo elimine.
                        result = true;
                        pos=i;
                    } 
                }
                if(result){
                    teams.remove(pos);
                    System.out.println(nom+" se eliminó de forma satisfactoria.");
                }
                else{
                    System.out.println("No existe ningún equipo con el nombre indicado.");
                }

            }   
        }//Fin Eliminar equipo
        
        //2.4- Asignar un jugador al equipo
        public static void asignarJugadorAEquipo(ArrayList<Player> players, ArrayList<Team> teams){
            String nomJug, nomEq;
            int posJug=0, posEq=0;
            boolean resultJug=false, resultEq=false;

            System.out.println("----------------");
            System.out.println("Opción escogida: Asignar un jugador al equipo.");
            System.out.println("----------------");


            if(teams.isEmpty()){
                System.out.println("No existen equipos. No se podría asignar ninguno.");
            }

            else if(players.isEmpty()){
                System.out.println("No existen jugadores. No se podría añadir nadie.");
            }
            
            else{
                System.out.print("Introduce el nombre del EQUIPO al que quieres que añada a un jugador  -> ");
                nomEq = readString();
                System.out.println("");
                
                System.out.print("Introduce el nombre del JUGADOR que quieres añadir al equipo. -> ");
                nomJug = readString();
                System.out.println("");

                for (int i = 0; i < teams.size(); i++) {
                    if(teams.get(i).getName().equals(nomEq)){
                        resultEq = true;
                        posEq = i;
                    }
                }

                for (int i = 0; i < players.size(); i++) {
                    if(players.get(i).getName().equals(nomJug)){ 
                        resultJug = true;
                        posJug=i;
                    } 
                }
                
                //Finalmente añadimos el jugador al equipo si las comprobaciones han sido las correctas.
                if(resultEq&&resultJug){
                    teams.get(posEq).addPlayerIntoTeam(players.get(posJug));
                    System.out.println("Se añadio al equipo "+nomEq+" el jugador "+nomJug+" de forma satisfactoria.");
                }
                else{
                    System.out.println("Error. No se ha podido añadir.");
                }   
            }  
        }
        
    //ITEMS: ACCIONES
        //3.1 - Crear un item
        public static void crearItem(ArrayList<Item> items){
            boolean exist=false;
            int aPoints=0, dPoints=0;

            System.out.println("----------------");
            System.out.println("Opción escogida: Crear un item.");
            System.out.println("----------------");

            System.out.print("¿Que nombre le ponemos? -> ");
            String nombre = readString();
            System.out.println("");

            for (int i = 0; i < items.size(); i++) {
                if(items.get(i).getName().equals(nombre)){
                    exist=true;
                }    
            }

            if(exist==false){

                    System.out.print("¿Cuántos puntos de ataque tendrá "+nombre+"? -> ");
                    aPoints = readInt();
                    System.out.println("");
                    
                    System.out.print("¿Cuántos puntos de defensa tendrá "+nombre+"? -> ");
                    dPoints = readInt();
                    System.out.println("");
                    
                    Item it1 = new Item(nombre, aPoints, dPoints);
                    items.add(it1);
                    System.out.println("Se ha creado un/a "+nombre+" de forma satisfactoria.");
            }
            else{
                System.out.println("La arma ya ha sido creada anteriormente.");

            }
        }
        
        //3.2 - Mostrar Items
        public static void mostrarItems(ArrayList<Item> items){
            String muestra;
            System.out.println("----------------");
            System.out.println("Opción escogida: Mostrar items.");
            System.out.println("----------------");

            if(items.isEmpty()){ //Si está vacío.
                System.out.println("No se ha añadido ningún jugador.");
            }
            else{
                for (int i = 0; i < items.size(); i++) {
                    System.out.println(items.get(i).getName()+" | Bonus de Ataque: "+items.get(i).getAttackBonus()+" | Bonus de Defensa: "+items.get(i).getDefenseBonus());   
                }
            }
        }
     
        //3.3 - Eliminar un item
        public static void eliminarItem(ArrayList<Item> items){
            String nom;
            int pos=0;
            boolean result = false;

            System.out.println("----------------");
            System.out.println("Opción escogida: Eliminar un item.");
            System.out.println("----------------");

            if(items.isEmpty()){
                System.out.println("No existen armas. No se podrían eliminar.");
            }
            else{
                System.out.print("Introduce el nombre del arma que quieres eliminar -> ");
                nom = readString();
                System.out.println("");

                for (int i = 0; i < items.size(); i++) {
                    if(items.get(i).getName().equals(nom)){ //Si el nombre corresponde con alguno de la lista, que lo elimine.
                        result = true;
                        pos=i;
                    } 
                }
                if(result){
                    items.remove(pos);
                    System.out.println(nom+" se eliminó de forma satisfactoria.");
                }
                else{
                    System.out.println("No existe ningún item con el nombre indicado.");
                }

            }   
        }//Fin Eliminar item
        
       
    
    public static void menuPrincipal(ArrayList<Player> jugadores, ArrayList<Team> equipos, ArrayList<Item> armas){
        int opPrin=0, opConf=0, opJug=0, opEq=0, opObj=0; //Aquí guardaremos la opción escogida. 
        
        System.out.println("Bienvenido a -Rock and ROL-. ");
        System.out.println("Autor: Adrián Martínez");
        
            
            do{
                mostrarMenuPrincipal();
                System.out.print("Selecciona una opción ->  ");
                opPrin = readInt();

                switch(opPrin){
                
                //CONFIGURACIÓN
                    case 1:
                        do{
                            mostrarMenuConfiguracion();
                            System.out.print("Selecciona una opción ->  "); 
                            opConf = readInt();
                                switch(opConf){
                                    
                                   //Gestión de Jugadores
                                    case 1:
                                        do{
                                            mostrarMenuJugadores();
                                            System.out.print("Selecciona una opción ->  "); 
                                            opJug = readInt();
                                            
                                            switch(opJug){
                                                //Crear un jugador
                                                case 1:
                                                    crearJugador(jugadores);
                                                break;   
                                                    
                                                //Mostrar jugadores
                                                case 2:
                                                    mostrarJugador(jugadores);
                                                break;
                                                    
                                                //Eliminar jugador
                                                case 3:
                                                    eliminarJugador(jugadores);
                                                break;
                                                    
                                                //Asignar un equipo al jugador    
                                                case 4:
                                                    asignarEquipoAJugador(jugadores, equipos);
                                                break;
                                                    
                                                //Asignar un objeto al jugador    
                                                case 5:
                                                    asignarObjetoAJugador(jugadores, armas);
                                                break;
                                                //Salir
                                                case 6:
                                                break;
                                                    
                                                //Opción error    
                                                default:
                                                    System.out.println("La opción introducida no es la correcta, introduzca de nuevo.");
                                                break;
                                            }
                                        }while(opJug!=6); 
                                    break;
                                    
                                   //Gestión de Equipos    
                                    case 2:
                                        do{
                                            mostrarMenuEquipos();
                                            System.out.print("Selecciona una opción ->  "); 
                                            opEq = readInt();
                                            
                                            switch(opEq){
                                                //Crear un equipo
                                                case 1:
                                                    crearEquipo(equipos);
                                                break;
                                                    
                                                //Mostrar equipos    
                                                case 2:
                                                    mostrarEquipos(equipos);
                                                break;
                                                    
                                                //Eliminar Equipos
                                                case 3:
                                                    eliminarEquipo(equipos);
                                                break;
                                                    
                                                //Asignar un jugador dentro del equipo    
                                                case 4:
                                                    asignarJugadorAEquipo(jugadores, equipos);
                                                break;
                                                //Salir
                                                case 5:
                                                break; 
                                                default:
                                                    System.out.println("La opción introducida no es la correcta, introduzca de nuevo.");
                                                break;
                                            } 
                                        }while(opEq!=5); 
                                    break;
                                    
                                   //Gestión de objetos
                                    case 3:
                                        do{
                                            mostrarMenuObjetos();
                                            System.out.print("Selecciona una opción ->  "); 
                                            opObj = readInt();
                                            
                                            switch(opObj){
                                                //Crear un arma
                                                case 1:
                                                    crearItem(armas);
                                                break;
                                                
                                                //Mostrar items
                                                case 2:
                                                    mostrarItems(armas);
                                                break;
                                                //Eliminar un item    
                                                case 3:
                                                    eliminarItem(armas);
                                                break;
                                                //Asignar un objeto al jugador
                                                case 4:
                                                    asignarObjetoAJugador(jugadores, armas);
                                                break;
                                                //Salir
                                                case 5:
                                                break;
                                                default:
                                                    System.out.println("La opción introducida no es la correcta, introduzca de nuevo.");
                                                break;
                                            }
                                        }while(opObj!=5); 
                                        
                                    break;
                                        
                                    //Salir
                                    case 4:
                                    break;
                                        
                                    //Opción default    
                                    default:
                                        System.out.println("La opción introducida no es la correcta, introduzca de nuevo.");
                                    break;
                                }

                        }while(opConf!=4);                        
                          
                    break;
                //JUGAR       
                    case 2:
                        String nom1="",nom2="";
                        boolean exist1=false, exist2=false;
                        int pos1=0, pos2=0;
                   
                        System.out.println("----------------");
                        System.out.println("¡Vamos a jugar!");
                        System.out.println("----------------");
                        
                        if(jugadores.size()<2){ //No se puede jugar si no hay 2 jugadores.
                            System.out.println("Se requieren un mínimo de 2 jugadores para jugar, créalos antes. (Configuración -> Jugadores -> Crear jugador");
                        }
                        
                        else{
                            
                            //Pedimos el jugador 1
                            do{
                                System.out.print("Dime el nombre del 1er jugador con el que quieras jugar ->  ");
                                nom1 = readString();
                                System.out.println("");

                                for (int i = 0; i < jugadores.size(); i++) {
                                    if(jugadores.get(i).getName().equals(nom1)){
                                        exist1=true;
                                        pos1=i;
                                    }    
                                }
                                
                                if(!exist1){ System.out.println("El jugador introducido no existe, vuélvalo a introducir.");}  
                            }while(!exist1);
                            
                            
                            //Pedimos el jugador 2
                            do{
                                System.out.print("Dime el nombre del 2º jugador con el que quieras jugar ->  ");
                                nom2 = readString();
                                System.out.println("");

                                for (int i = 0; i < jugadores.size(); i++) {
                                    if(jugadores.get(i).getName().equals(nom2)){
                                        exist2=true;
                                        pos2=i;
                                    }    
                                }
                                
                                if(!exist2){ System.out.println("El jugador introducido no existe, vuélvalo a introducir.");}
                            }while(!exist2);
                            
                            //Ataque. 
                            int turno=1;
                            
                            do{
                                if(turno==1){
                                    jugadores.get(pos1).attack(jugadores.get(pos2));
                                    turno=2;
                                }
                                else{
                                     jugadores.get(pos2).attack(jugadores.get(pos1));
                                     turno=1;
                                }
                            }while(jugadores.get(pos1).getLife()>0 && jugadores.get(pos2).getLife()>0);
                            
                        }
                        
                        
                    break;
                
                //SALIR
                    case 3:
                        System.out.println("Gracias por jugar. Espero verte pronto.");
                    break;
                    default:
                        System.out.println("La opción introducida no es la correcta, introduzca de nuevo.");
                    break;
                }
            }while(opPrin!=3);
     
    }
    
 
    public static void main(String[] args) {
        menuPrincipal(jugadores, equipos, armas);
       
    }

}
