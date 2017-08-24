/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Random;


public class Napakalaki {
    
    private static Napakalaki instance = null;
    
    private Player currentPlayer;
    private Monster currentMonster;
    private CardDealer dealer;
    private ArrayList<Treasure> treasures = new ArrayList();
    private ArrayList<Player> players;
    private ArrayList<String> names = new ArrayList();
    
    private Napakalaki(){
        
        dealer = CardDealer.getInstance();
        
    }
    
    public static Napakalaki getInstance(){
        
        if(instance==null){
            
            instance = new Napakalaki();
            
        }
        
        return instance;
        
    }
    
    private void initPlayers(ArrayList<String> names){
    
        players = new ArrayList();
        
        for (String n : names){
            
            players.add(new Player(n));
            
        }
    
    }
    
    private Player nextPlayer(){
        
        int indice;
        int nPlayers = players.size();
        
        if (currentPlayer == null) {
            
            Random r = new Random();
            
            indice = r.nextInt(nPlayers);
            
        } else {
            
            int indicePA = this.players.indexOf(this.currentPlayer);
            
            if(indicePA==nPlayers-1){
                
                indice = 0;
                
            }else{
                
                indice = indicePA+1;
                
            }
            
        }
        
        Player p = this.players.get(indice);
        
        this.currentPlayer = p;
        
        return this.currentPlayer;
    
    }
    
    private boolean nextTurnAllowed(){
        
        boolean puede;
        if(currentPlayer!=null){
            
            puede=currentPlayer.validState();
            
        }else puede=true;
        
        return puede;
        
    }
    
    private void setEnemies(){
        
        Random r = new Random();
        
        int indice;
        
        for(int i=0; i<players.size();){
            
            indice = r.nextInt(players.size());
            
            if(i != indice){
                
                players.get(i).setEnemy(players.get(indice));
                i++;
                
            }
             
        }
        
    }
    
    public CombatResult developCombat(){
        
        CombatResult CR;
        
        CR = this.currentPlayer.combat(this.currentMonster);
        
        if(CR == CombatResult.LOSEANDCONVERT){
            
            Cultist cl = this.dealer.nextCultist();
            
            CultistPlayer CP = new CultistPlayer(this.currentPlayer, cl);
            
            for(Player p:players){
                
                if(p.getEnemy()==this.currentPlayer)
                    p.setEnemy(CP);
                
            }
            
            int pos = this.players.indexOf(this.currentPlayer);
            
            this.players.set(pos, CP);
            
            this.currentPlayer = CP;
            
        }
        
        this.dealer.giveMonsterBack(this.currentMonster);
        
        return CR;
        
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
    
        for(Treasure t : treasures){
            
            currentPlayer.discardVisibleTreasure(t);
            dealer.giveTreasureBack(t);
            
        }
    
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
    
        for(Treasure t : treasures){
            
            currentPlayer.discardHiddenTreasure(t);
            dealer.giveTreasureBack(t);
            
        }
    
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
    
        for(Treasure t:treasures){
            
            this.currentPlayer.makeTreasureVisible(t);
            
        }
    
    }
    
    public void initGame(ArrayList<String> names){
    
        this.initPlayers(names);
        this.setEnemies();
        this.dealer.initCards();
        this.nextTurn();
    
    }
    
    public Player getCurrentPlayer(){
        
        return currentPlayer;
        
    }
    
    public Monster getCurrentMonster(){
        
        return currentMonster;
        
    }
    
    public boolean nextTurn(){
        
        boolean stateOK=this.nextTurnAllowed();
        
        if(stateOK){
            
            this.currentMonster = this.dealer.nextMonster();
            this.currentPlayer = this.nextPlayer();
            boolean dead = this.currentPlayer.isDead();
            if(dead){
                
                this.currentPlayer.initTreasures();
                
            }
            
        }
        
        return stateOK;
        
    }
    
    public boolean endOfGame(CombatResult CR){
        
        return CR == CombatResult.WINGAME;
        
    }
    
}
