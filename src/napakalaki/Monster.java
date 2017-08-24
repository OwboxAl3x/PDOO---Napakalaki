/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;


public class Monster {
    
    private String name;
    private int combatLevel;
    private Prize price;
    private BadConsequence bc;
    private int levelChangedAgainstCultistPlayer;
    
    private String icon;
    
    public String getName(){
        
        return name;
        
    }
    
    public int getCombatLevel(){
        
        return combatLevel;
        
    }
    
    public int getCombatLevelAgainstCultistPlayer(){
        
        return this.getCombatLevel() + this.levelChangedAgainstCultistPlayer;
        
    }
    
    public BadConsequence getBC(){
        
        return bc;
        
    }
    
    public Prize getPrice(){
        
        return price;
        
    }
    
    public int getLevelsGained(){
        
        return price.getLevel();
        
    }
    
    public int getTreasuresGained(){
        
        return price.getTreasures();
        
    }
    
    public Monster(String name, int level, BadConsequence bc, Prize price, String icon){
        
        this.name = name;
        this.combatLevel = level;
        this.bc = bc;
        this.price = price;
        this.levelChangedAgainstCultistPlayer = 0;
        this.icon = icon;
        
    }
    
    public Monster(String name, int level, BadConsequence bc, Prize price, int lc, String icon){
        
        this.name = name;
        this.combatLevel = level;
        this.bc = bc;
        this.price = price;
        this.levelChangedAgainstCultistPlayer = lc;
        this.icon = icon;
        
    }
    
    public String getIcon(){
        
        return "/monsters/" + this.icon + ".jpg";
        
    }
    
    @Override
    public String toString(){
        
    return this.name + ", Nivel: " + Integer.toString(this.combatLevel) + price.toString() + bc.toString();
    
    }
    
}
