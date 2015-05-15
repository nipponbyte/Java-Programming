package joc;

import java.util.ArrayList;
import java.util.Objects;

public class Team {
    //Atributos
    private String name;
    private ArrayList<Player> players = new ArrayList<>(); 
    
    //Constructores
    public Team (String name){
        this.name=name;
    }
    
    //
    //Métodos
    //

    //ADD: AÑADIR JUGADOR EN UN EQUIPO
    public void addPlayerIntoTeam(Player p){
        
        if(players.indexOf(p)==-1){ //Comprobamos si Team ya tiene asignado "p" como jugador de este equipo.
            
            players.add(p); //Añadimos a el Player "p" en el la lista de jugadores llamada "players".
            p.addTeamIntoPlayer(this); //Añadimos a este equipo dentro de Players llamando al método de "p" llamado "addTeamIntoPlayer"
            p.incrementarqEquips(); //Incrementamos la cantidad de equipos de este jugador en 1 (qEquips++)
        } 
    }
    
    //REMOVE: ELIMINAR JUGADOR DE UN EQUIPO
    public void removePlayerIntoTeam(Player p){
        int pos = players.indexOf(p);
        
        if(pos!=-1){ //Comprobamos si existe.
            players.remove(p);
            p.removeTeamIntoPlayer(this);
            p.decrementarqEquips();   
        }  
    }
    
    public ArrayList<Player> getMembers(){
        return this.players;
    }

    //EQUALS
    @Override 
    //Sobreescribimos el método equals el cual está por defecto en Java
    public boolean equals(Object obj){
        if(obj instanceof Team){ //Comprobamos si es un objeto de la clase player. 
            
            Team t = ((Team)obj); //Convertimos el objeto a la clase Player
            
            if(this.name==t.getName()){ //Comparamos si tienen el nombre igual
                return true;
            }
            
            else{
                return false;
            } 
        }
        
        else{
            System.out.println("No pertenece a la clase Team");
            
            return false;
        } 
    }
    
    //TO STRING
    @Override
    public String toString() {
        String mensaje="", jugadores="";
        
       
        
        if(this.players.isEmpty()){ //Si está vacio, no muestra PLAYERS.
            mensaje = this.name;
        }
        
        else{
            for(Player player : this.players){
                 jugadores+= "\n\t "+player.getName();
            }
        
            mensaje = this.name  + "\n\t Miembros: " +jugadores;
        }
        
        return mensaje; 
    }

    //GETTERS
    public String getName() {
        return name;
    }

}
