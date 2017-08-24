/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Random;
import GUI.Dice;


public class Player {
    
    final static int MAXLEVEL = 10;
    
    private String name;
    private int level;
    private boolean dead = false;
    private boolean canISteal = true;
    
    protected Player enemy;
    private BadConsequence pendingBadConsequence;
    
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
    
    public Player(String name){
    
        this.name = name;
        this.level = 1;
        this.dead = true;
    
    }
    
    public Player(Player p){
        
        this.name = p.name;
        this.level = p.level;
        this.pendingBadConsequence = p.pendingBadConsequence;
        this.dead = p.dead;
        this.visibleTreasures = p.visibleTreasures;
        this.hiddenTreasures = p.hiddenTreasures;
        
    }
    
    public Player getEnemy(){
        
        return this.enemy;
        
    }
    
    @Override
    public String toString(){
        
        return this.name+" Nivel: "+this.level;
        
    }
    
    public String getName(){
        
        return this.name;
        
    }
    
    private void bringToLife(){
    
        this.dead=false;
    
    }
    
    protected int getOponentLevel(Monster m){
        
        return m.getCombatLevel();
        
    }
    
    protected boolean shouldConvert(){
        
        Dice d = Dice.getInstance();
        
        int num = d.nextNumber();
        
        boolean puede = false;
        
        if(num == 1){
            
            puede = true;
            
        }
        
        return puede;
        
    }
    
    public int getCombatLevel(){
        
        int cl=1;
        
        for(Treasure t:visibleTreasures){
            
            cl += t.getBonus();
            
        }
        
        if(cl > MAXLEVEL)
            cl=MAXLEVEL;
        
        return cl;
        
    }
    
    private void incrementLevels(int l){
    
        if(this.level<MAXLEVEL){
            
            this.level += l;
            
        }
    
    }
    
    private void decrementLevels(int l){
    
        this.level -= l;
        
        if(this.level < 1){
            
            this.level = 1;
            
        }
    
    }
    
    private void setPendingBadConsequence(BadConsequence bc){
    
        this.pendingBadConsequence = bc;
    
    }
    
    public BadConsequence getPendingBadConsequence(){
        
        return this.pendingBadConsequence;
        
    }
    
    private void applyPrize(Monster m){
    
        int nLevels = m.getLevelsGained();
        
        this.incrementLevels(nLevels);
        
        int nTreasures = m.getTreasuresGained();
        
        if(nTreasures>0){
            
            CardDealer CD;
            CD = CardDealer.getInstance();
            
            for(int i=1;i<=nTreasures;i++){
                
                Treasure t = CD.nextTreasure();
                this.hiddenTreasures.add(t);
                
            }
            
        }
    
    }
    
    private void applyBadConsecuence(Monster m){
    
        BadConsequence BC = m.getBC();
        
        int nLevels = BC.getLevels();
        this.decrementLevels(nLevels);
        this.pendingBadConsequence = BC.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        
        this.setPendingBadConsequence(this.pendingBadConsequence);
    
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        
        if (t.getType().equals(TreasureKind.BOTHHANDS)
                && this.howManyVisibleTreasures(TreasureKind.ONEHAND) > 0){
            
            return false;
            
        }
        else if (t.getType().equals(TreasureKind.ONEHAND)
                && this.howManyVisibleTreasures(TreasureKind.BOTHHANDS) < 1
                && this.howManyVisibleTreasures(TreasureKind.ONEHAND) < 2) {
            
            return true;
            
        }
        else if(t.getType().equals(TreasureKind.ONEHAND)
                && this.howManyVisibleTreasures(TreasureKind.BOTHHANDS)>0){
            
            return false;
            
        }
        else if (this.howManyVisibleTreasures(t.getType()) < 1) {
            
            return true;
            
        }
        else {
            
            return false;
            
        }
        
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
    
        int ntesoros=0;
        
        for(Treasure t:visibleTreasures){
            
            if(t.getType() == tKind){
                
                ntesoros++;
                
            }
            
        }
        
        return ntesoros;
    
    }
    
    private void dieIfNoTreasures(){
        
        if(visibleTreasures.isEmpty() && hiddenTreasures.isEmpty()){
    
            this.dead = true;
            
        }
    
    }
    
    public boolean isDead(){
        
        return this.dead; 
        
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        
        return hiddenTreasures;
        
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        
        return visibleTreasures;
        
    }
    
    public CombatResult combat(Monster m){
        int myLevel = this.getCombatLevel();
        int monsterLevel = this.getOponentLevel(m);
        
         CombatResult result;
        
        if(myLevel>monsterLevel){
            applyPrize(m);
            if(this.level>=MAXLEVEL){
                result = CombatResult.WINGAME;
            }
            else{
                result = CombatResult.WIN;
            }
        }
        else{
            applyBadConsecuence(m);
            if(shouldConvert()){
                result = CombatResult.LOSEANDCONVERT;
            }
            else{
                result = CombatResult.LOSE;
            }
        }
        
        //System.out.println(this.getOponentLevel(m) + " " + this.getCombatLevel() );
        
        return result;
    }

    public void makeTreasureVisible(Treasure t){
    
        boolean canI = this.canMakeTreasureVisible(t);
        
        if(canI){
            
            this.visibleTreasures.add(t);
            
            this.hiddenTreasures.remove(t);
            
            this.level = this.getCombatLevel();
         
        }
    
    }
    
    public void discardVisibleTreasure(Treasure t){
    
        this.visibleTreasures.remove(t);
        if((this.pendingBadConsequence != null) && (!this.pendingBadConsequence.isEmpty())){
            
            this.pendingBadConsequence.substractVisibleTreasure(t);
            
        }
        
        this.level = this.getCombatLevel();
        
        this.dieIfNoTreasures();
    
    }
    
    public void discardHiddenTreasure(Treasure t){
    
        this.hiddenTreasures.remove(t);
        if((this.pendingBadConsequence != null) && (!this.pendingBadConsequence.isEmpty())){
            
            this.pendingBadConsequence.substractHiddenTreasure(t);
            
        }
        
        this.dieIfNoTreasures();
    
    }
    
    public boolean validState(){
        
        
        return (this.hiddenTreasures.size()<5 && (this.pendingBadConsequence==null || this.pendingBadConsequence.isEmpty()));
        
    }
    
    public void initTreasures(){
        
        CardDealer CD = CardDealer.getInstance();
        
        Dice dice = Dice.getInstance();
        
        this.bringToLife();
        
        Treasure t = CD.nextTreasure();
        this.hiddenTreasures.add(t);
        
        int num = dice.nextNumber();
        
        if(num>1){
            
            t = CD.nextTreasure();
            this.hiddenTreasures.add(t);
            
        }
        
        if(num==6){
            
            t = CD.nextTreasure();
            this.hiddenTreasures.add(t);
            
        }
        
    }
    
    public int getLevels(){
        
        return this.level;
        
    }
    
    public Treasure stealTreasure(){
        
        boolean canI = this.canISteal();
        Treasure t=null;
        
        if(canI){
            
            boolean canYou = this.enemy.canYouGiveMeATreasure();
            
            if(canYou){
                
                t = this.enemy.giveMeATreasure();
                this.hiddenTreasures.add(t);
                
                this.haveStolen();
                
            }
            
        }
        
        return t;
        
    }
    
    public void setEnemy(Player ene){
        
        this.enemy = new Player(ene);
    
    }
    
    protected Treasure giveMeATreasure(){
        
        Random r = new Random();
        
        int indice = r.nextInt(this.hiddenTreasures.size());
        
        Treasure t = this.hiddenTreasures.get(indice);
        this.hiddenTreasures.remove(indice);
        
        return t;
        
    }
    
    public boolean canISteal(){
        
        return this.canISteal;
        
    }
    
    protected boolean canYouGiveMeATreasure(){
        
        return !(this.hiddenTreasures.isEmpty());
        
    }
    
    private void haveStolen(){
    
        this.canISteal = false;
    
    }
    
    public void discardAllTreasures(){
        
        ArrayList<Treasure> vt = new ArrayList(this.visibleTreasures);
        ArrayList<Treasure> ht = new ArrayList(this.hiddenTreasures);
        
        for(Treasure t : vt){
            
            this.discardVisibleTreasure(t);
            
        }
        
        for(Treasure t : ht){
            
            this.discardHiddenTreasure(t);
            
        }
    
    }
    
}
