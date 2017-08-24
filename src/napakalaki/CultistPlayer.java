/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.Random;


public class CultistPlayer extends Player{
    
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p,Cultist c){
        
        super(p);

        this.myCultistCard = c;
        totalCultistPlayers++;
        
    }
    
    @Override
    public int getCombatLevel(){
        
        int casilevel = super.getCombatLevel() + ((super.getCombatLevel()*20)/100) + this.myCultistCard.getGainedLevel();
        
        int level = casilevel*this.getTotalCultistPlayer();
        
        return level;
        
    }
    
    @Override
    protected int getOponentLevel(Monster m){
        
        return m.getCombatLevelAgainstCultistPlayer();
        
    }
    
    @Override
    protected boolean shouldConvert(){
        
        return false;
        
    }
    
    @Override
    protected Treasure giveMeATreasure(){
        
        Random r = new Random();
        
        int pos = r.nextInt(super.getVisibleTreasures().size() - 1);
        
        Treasure t = super.getVisibleTreasures().get(pos);
        
        return t;
        
    }
    
    @Override
    protected boolean canYouGiveMeATreasure(){
        
        boolean tiene = true;
        
        if(super.getVisibleTreasures().isEmpty() && super.getHiddenTreasures().isEmpty()){
            
            tiene = false;
            
        }
        
        return tiene;
        
    }
    
    public int getTotalCultistPlayer(){
        
        return this.totalCultistPlayers;
        
    }
    
    @Override
    public String toString(){
        
        String p = super.toString() + "\n Es un Cultist Player\n";
        
        return p;
        
    }
    
}
