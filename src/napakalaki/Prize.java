/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;


public class Prize {
    
    private int treasures;
    private int level;
    
    public Prize(int treasures, int level){
        
        this.treasures = treasures;
        this.level = level;
        
    }
    
    public int getTreasures(){
        
        return treasures;
        
    }
    
    public int getLevel(){
        
        return level;
        
    }
    
    public String toString(){

        return ", Tesoros que ganas: " + Integer.toString(treasures) + ", Niveles que ganas: " + Integer.toString(level);

    }
    
}
