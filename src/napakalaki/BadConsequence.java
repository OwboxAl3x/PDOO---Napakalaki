/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
//import static java.lang.Math.min;


public abstract class BadConsequence {
    
    static final int MAXTREASURES = 10;
    
    protected String text;
    protected int levels;
    
    
    public BadConsequence(String text, int levels){
        
        this.text = text;
        this.levels = levels;
        
    }
    
    public abstract boolean isEmpty();
    
    public String getText(){
        
        return this.text;
        
    }
    
    public int getLevels(){
        
        return this.levels;
        
    }
    
    public abstract void substractVisibleTreasure(Treasure t);
    
    
    public abstract void substractHiddenTreasure(Treasure t);
    
    
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h);
    
    @Override
    public String toString(){

        return ", Mal rollo: " + text 
                + "\nNiveles que pierdes: " + Integer.toString(levels);

    }
    
}
