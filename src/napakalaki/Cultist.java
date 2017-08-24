/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;


public class Cultist {
    
    private String name;
    private int gainedLevels;
    
    public Cultist(String n, int gl){
        
        this.name = n;
        this.gainedLevels = gl;
        
    }
    
    public int getGainedLevel(){
        
        return this.gainedLevels;
        
    }
    
}
