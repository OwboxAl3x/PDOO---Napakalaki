/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;


public class Treasure {
    
    private String name;
    private int bonus;
    private TreasureKind type;
    private String icon;
    
    public Treasure(String n, int bonus, TreasureKind t, String icon){
        
        this.name = n;
        this.bonus = bonus;
        this.type = t;
        this.icon = icon;
        
    }
    
    public String toString(){
        
        return name+" Tipo: "+type+" Bonus: "+bonus;
        
    }
    
    public String getName(){
        
        return this.name;
        
    }
    
    public int getBonus(){
        
        return this.bonus;
        
    }
    
    public TreasureKind getType(){
        
        return this.type;
        
    }
    
    public String getIcon(){
        
        return "/treasures/" + this.icon + ".jpg";
        
    }
    
}
