package joc;

public class Alien extends Player {


    //Constructores
    public Alien(String name, int attackPoints, int defensePoints, int life){
        super(name, attackPoints, defensePoints, life);
        
    }
   
    //Métodos
    
    //HIT: Overrideado.
    @Override
    protected void hit(int attackPoints){
        int resta, resultat;
        
        
        if(getLife()>0){ //Si la vida es inferior a 0, está muerto, por supuesto. En ese caso, nos vamos al else.
            
            //Si el jugador tiene objetos, llamaremos a la función que modifica sus características.
            if(!this.getItemsJugador().isEmpty()){ 
                modifyStatusByItem();
            }
            
            if(getLife()>20){
                
                System.out.println("*El Alien, "+ getName()+" está enloquecido. Ataque +3 | Defensa -3*");
               
                //MOFICAMOS EL ATAQUE/DEFENSA
                    this.setAttackPoints(getAttackPoints()+3); //Le aumentamos el Ataque (+ 3)
                    this.setDefensePoints(getDefensePoints()-3); //Le disminuímos la Defensa (- 3)
                
                
                resta=attackPoints-this.getDefensePoints(); //Esta será la resta de puntos que haremos.
                
                
                resultat=getLife()-resta; //En resultado, guardaríamos cómo quedaría la vida.

                //Con la siguiente condición. Si por ejemplo las vidas fueran "6-10=" nos mostraría de resultado 0, en vez de -4. (Para la muestra por pantalla.
                    if(resultat>0){
                        System.out.println(this.getName()+" es golpeado con "+attackPoints+" puntos y se defiende con "+this.getDefensePoints()+". "+ 
                                "Vides: "+this.getLife()+"-"+resta+" = "+ resultat);
                    }
                    else{
                        System.out.println(this.getName()+" es golpeado con "+attackPoints+" puntos y se defiende con "+this.getDefensePoints()+". "+ 
                                "Vides: "+this.getLife()+"-"+resta+" = K.O.");
                    }
                    
                setLife(this.getLife()-resta); //Le voy quitando la vida perdida y almacenandola en el objeto. 
            }
            
            else{
     
                resta=attackPoints-this.getDefensePoints(); //Esta será la resta de puntos que haremos.

                resultat=getLife()-resta; //En resultado, guardaríamos cómo quedaría la vida.

                    //Con la siguiente condición. Si por ejemplo las vidas fueran "6-10=" nos mostraría de resultado 0, en vez de -4. (Para la muestra por pantalla.
                    if(resultat>0){
                        System.out.println(this.getName()+" es golpeado con "+attackPoints+" puntos y se defiende con "+this.getDefensePoints()+". "+ 
                                "Vides: "+this.getLife()+"-"+resta+" = "+ resultat);
                    }
                    else{
                        System.out.println(this.getName()+" es golpeado con "+attackPoints+" puntos y se defiende con "+this.getDefensePoints()+". "+ 
                                "Vides: "+this.getLife()+"-"+resta+" = K.O.");

                    }

                setLife(this.getLife()-resta); //Le voy quitando la vida perdida y almacenandola en el objeto.
            }
        
        }
        
        else{
            System.out.println(this.getName()+" ha muerto entre terribles sufrimientos.");
            setLife(0);
        }
              
    }
      
}
