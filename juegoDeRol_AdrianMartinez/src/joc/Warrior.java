package joc;

public class Warrior extends Human {
    

    @Override
    public void hit(int attackPoints){
           
        int herida, resultat;
        
        herida=attackPoints-this.getDefensePoints();
        
            if (herida<=5){
                System.out.println("*Debido a la agilidad del Warrior,  "+this.getName()+ " evade el ataque.*");
                herida=0;
            }
        
        
        if(getLife()>0){
            
        //Si el jugador tiene objetos, llamaremos a la función que modifica sus características.
        if(!this.getItemsJugador().isEmpty()){ 
            modifyStatusByItem();
        }
             
        resultat=getLife()-herida;
            //Con la siguiente condición. Si por ejemplo las vidas fueran "6-10=" nos mostraría de resultado 0, en vez de -4. (Para la muestra por pantalla.
            if(resultat>0){
                System.out.println(this.getName()+" es golpeado con "+attackPoints+" puntos y se defiende con "+this.getDefensePoints()+". "+ 
                        "Vides: "+this.getLife()+"-"+herida+" = "+ resultat);
            }
            else{
                System.out.println(this.getName()+" es golpeado con "+attackPoints+" puntos y se defiende con "+this.getDefensePoints()+". "+ 
                        "Vides: "+this.getLife()+"-"+herida+" = K.O.");
            
            }
            
            setLife(this.getLife()-herida); //Le voy quitando la vida perdida y almacenandola en el objeto.
        }
        
        else{
            System.out.println(this.getName()+" ha muerto entre terribles sufrimientos.");
            setLife(0);
        }  
    }
    
    //Constructores
    public Warrior(String name, int attackPoints, int defensePoints, int life){
        super(name, attackPoints, defensePoints, life);
        
    }
    
}
