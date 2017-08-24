/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;


public class NumericBadConsequence extends BadConsequence{
    
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    
    public NumericBadConsequence(String text, int levels, int nVisible, int nHidden){
        
        super(text, levels);
        
        this.nVisibleTreasures = (nVisible > MAXTREASURES ? MAXTREASURES : nVisible);
        this.nHiddenTreasures = (nHidden > MAXTREASURES ? MAXTREASURES : nHidden);
        
    }
    
    public int getNVisible(){
        
        return this.nVisibleTreasures;
        
    }
    
    public int getNHidden(){
        
        return this.nHiddenTreasures;
        
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        
        if(this.nVisibleTreasures>0){
                    
            this.nVisibleTreasures--;
        
        }
    
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        
        if(this.nHiddenTreasures>0){
                    
            this.nHiddenTreasures--;
        
        }
        
    }
    
    @Override
    public boolean isEmpty(){
        
        boolean empty = false;

        if (this.nVisibleTreasures == 0 
                && this.nHiddenTreasures == 0) {

            empty = true;
            
        }

        return empty;
        
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        
        BadConsequence bc;
        
        if(this.nVisibleTreasures > v.size())
            this.nVisibleTreasures = v.size();
        
        if(this.nHiddenTreasures > h.size())
            this.nHiddenTreasures = h.size();
        
        bc = new NumericBadConsequence(this.text, this.levels, this.nVisibleTreasures, this.nHiddenTreasures);
        
        return bc;
    
    }
    
    @Override
    public String toString(){
        
        String bc = super.toString() + "\nNumero de tesoros visibles que pierdes: " + this.nVisibleTreasures
                + "\nNumero de tesoros ocultos que pierdes: " + this.nHiddenTreasures;
        
        return bc;
        
    }
    
}
