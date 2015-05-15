
package joc;

public class Item {
    //Atributos
    private String name;
    private int attackBonus;
    private int defenseBonus;
    
    //Constructor
    public Item (String name, int attack, int defense){
        this.name=name;
        this.attackBonus=attack;
        this.defenseBonus=defense;
    }

    //GETTERS Y SETTERS
    public String getName() {
        return name;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public int getDefenseBonus() {
        return defenseBonus;
    }
    

    
    
}
