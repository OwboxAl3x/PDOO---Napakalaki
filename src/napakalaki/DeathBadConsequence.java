/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import static napakalaki.BadConsequence.MAXTREASURES;


public class DeathBadConsequence extends NumericBadConsequence{
    
    private boolean death;
    
    public DeathBadConsequence(String text, boolean death){
        
        super(text, Player.MAXLEVEL, MAXTREASURES, MAXTREASURES);
        this.death = death;
        
    }
    
    @Override
    public boolean isEmpty(){
        
        return false;
        
    }
    
    @Override
    public String toString(){
        
        String bc = super.toString() + "\nMueres.";
        
        return bc;
        
    }
    
}
