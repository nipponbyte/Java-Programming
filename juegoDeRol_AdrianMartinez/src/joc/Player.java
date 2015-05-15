package joc;

import java.util.ArrayList;

abstract public class Player {
    private String name;
    private int attackPoints;
    private int defensePoints;
    private int life;
    private int qEquips;
    private ArrayList<Team> equipsJugador = new ArrayList<>();
    private ArrayList<Item> itemsJugador = new ArrayList<>();
    
    //Constructor
    Player(String name, int attackPoints, int defensePoints, int life){
        this.name=name;
        this.attackPoints=attackPoints;
        this.defensePoints=defensePoints;
        this.life=life;
    }
    
    //
    //Métodos
    //
    
    //ATTACK: ATACAR 
    public void attack(Player p){
        System.out.println("****************");
        System.out.println("");
        System.out.println("ANTES DEL ATAQUE:");
        System.out.println("Atacante:"+ this.toString());
        System.out.println("Atacado: "+p.toString());
        System.out.println("----------------");
        //-----
        
        System.out.println("ATAQUE:");
        System.out.println("");
       
            //Desde aquí iremos llamando al método hit. 
            //En el hit es dónde se harán las modificaciones de los estados de los personajes.
            p.hit(this.attackPoints);
                System.out.println("");
            this.hit(p.attackPoints);
            System.out.println("");
        
        
        System.out.println("----------------");
        //-----
        System.out.println("DESPUÉS DEL ATAQUE:");
        System.out.println("Atacante:"+ this.toString());
        System.out.println("Atacado: "+p.toString());
        System.out.println("");
        System.out.println("****************");
        
    }
    
    //HIT: GOLPEAR
    protected void hit(int attackPoints){
        int resta, resultat;
        
        resta=attackPoints-this.defensePoints;
        
        if(getLife()>0){
        
        //Si el jugador tiene objetos, llamaremos a la función que modifica sus características.
        if(!this.itemsJugador.isEmpty()){ 
            modifyStatusByItem();
        }
            
        
        resultat=life-resta;
            //Con la siguiente condición. Si por ejemplo las vidas fueran "6-10=" nos mostraría de resultado 0, en vez de -4. (Para la muestra por pantalla.
            if(resultat>0){
                System.out.println(this.name+" es golpeado con "+attackPoints+" puntos y se defiende con "+this.defensePoints+". "+ 
                        "Vides: "+this.life+"-"+resta+" = "+ resultat);
            }
            else{
                System.out.println(this.name+" es golpeado con "+attackPoints+" puntos y se defiende con "+this.defensePoints+". "+ 
                        "Vides: "+this.life+"-"+resta+" = K.O.");
            
            }
            
            setLife(this.life-resta); //Le voy quitando la vida perdida y almacenandola en el objeto.
        }
        
        else{
            System.out.println(this.name+" ha muerto entre terribles sufrimientos.");
            setLife(0);
        }  
    }
    
    //ADD TEAM: Asignar un equipo a un jugador.
    public void addTeamIntoPlayer(Team t){
        
        if(equipsJugador.indexOf(t)==-1){ //Comprobamos si el Player ya tiene asignado como a equipo a "t".
           
            this.equipsJugador.add(t); //Añadiremos a "t" como un equipo de este jugador, dentro del ArrayList "equipsJugador".
            t.addPlayerIntoTeam(this); //Llamamos al método "addPlayerIntoTeam" para añadir a este Player en Teams. 
        }
        
    }
    
    //REMOVE TEAM: Desvincular un equipo a un jugador.
    public void removeTeamIntoPlayer(Team t){
         
         int pos = equipsJugador.indexOf(t);
         
         if(pos!=-1){
             this.equipsJugador.remove(t);
             t.removePlayerIntoTeam(this);
             
         }
         
    }
    
    //ADD ITEM
    public void addItem(Item i){
        if(itemsJugador.indexOf(i)==-1){
            this.itemsJugador.add(i);
        }
    }
    
    //REMOVE ITEM
    public void removeItem(Item i){
        if(itemsJugador.indexOf(i)!=-1){
            this.itemsJugador.remove(i);
        }
    }
    
    //MODIFY STATUS BY ITEM: Modifica las caracteristicas del jugador basándose en los Items que lleve.
    public void modifyStatusByItem(){
        
        //Recorremos todo el array de objetos en busca de los nuestros y les aplicamos los bonus. 
        for (Item item:itemsJugador) {
                System.out.println("Objeto Encontrado! --> Nombre: "+item.getName()+" | Ataque: +"+item.getAttackBonus()+
                " | Defensa: +"+item.getDefenseBonus());
                this.attackPoints+=item.getAttackBonus();
                this.defensePoints+=item.getDefenseBonus();
            }
            
    }
    
    //
    //Getters y Setters
    //
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public int getLife() {
        return life;
    }

    public ArrayList<Item> getItemsJugador() {
        return itemsJugador;
    }
    
    

    public void setLife(int life) {
        this.life = life;
    }
    
    public void incrementarqEquips(){ //incrementa en 1 la cantidad de equipos al que pertenece el objeto.
        this.qEquips++;
    }
    
    public void decrementarqEquips(){ //decrementa en 1 la cantidad de equipos al que pertenece el objeto.
        this.qEquips--;
    }
    
    
    //EQUALS
    
    @Override 
    //Sobreescribimos el método equals el cual está por defecto en Java
    public boolean equals(Object obj){
        if(obj instanceof Player){ //Comprobamos si es un objeto de la clase player. 
            
            Player p = (Player)obj; //Convertimos el objeto a la clase Player
            
            if(this.name==p.getName()){ //Comparamos si tienen el nombre igual
                return true;
            }
            
            else{
                return false;
            } 
        }
        
        else{
            System.out.println("No pertenece a la clase Player");
            
            return false;
        } 
    }

    

    //TO STRING
    @Override
    public String toString() {
        String mensaje="", items="";
        
       
        
        if(this.itemsJugador.isEmpty()){ //Si está vacio, no muestra ITEMS.
            mensaje = this.name + " PA:"+this.attackPoints+ " / PD:"+this.defensePoints+" / PV:"+this.life + " (Pertenece a "+this.qEquips+" equipos)." ;
        }
        
        else{
            for(Item item : this.itemsJugador){
                 items+= "\n\t -"+item.getName()+ " -> Bonus de Ataque: "+item.getAttackBonus()+" | Bonus de Defensa: "+item.getDefenseBonus();
            }
        
            mensaje = this.name + " PA:"+this.attackPoints+ " / PD:"+this.defensePoints+" / PV:"+this.life + " (Pertenece a "+this.qEquips+" equipos)." + items;
        }
        
        return mensaje; 
    }
    
    
    
    
    
}
