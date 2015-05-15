package joc;

public class Human extends Player {
        
    //Constructores
    public Human(String name, int attackPoints, int defensePoints, int life){
        super(name, attackPoints, defensePoints, life);
        if(life>100){
            super.setLife(100);
        }
           
    }
  
}
