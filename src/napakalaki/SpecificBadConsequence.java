/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;


public class SpecificBadConsequence extends BadConsequence{
    
    private ArrayList<TreasureKind> specificHiddenTreasures;
    private ArrayList<TreasureKind> specificVisibleTreasures;
    
    public SpecificBadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        
        super(text, levels);
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
        
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        
        return this.specificVisibleTreasures;
        
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        
        return this.specificHiddenTreasures;
        
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        
        if(!this.specificVisibleTreasures.isEmpty()){
                    
            this.specificVisibleTreasures.remove(t.getType());
        
        }
    
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        
        if(!this.specificHiddenTreasures.isEmpty()){
                    
            this.specificHiddenTreasures.remove(t.getType());
        
        }
        
    }
    
    
    @Override
    public boolean isEmpty(){
        
        boolean empty = false;

        if (this.specificHiddenTreasures.isEmpty() 
                && this.specificVisibleTreasures.isEmpty()) {

            empty = true;
            
        }

        return empty;
        
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        
        BadConsequence bc;
        
        ArrayList<Treasure> VisibleT = new ArrayList(v);
        ArrayList<TreasureKind> sVisibleTreasures = new ArrayList();
        
        for(TreasureKind tKind : this.specificVisibleTreasures){
            
            int i = 0;
            boolean encontrado = false;
            
            while((i < VisibleT.size()) && !encontrado){
                
                if(VisibleT.get(i).getType() == tKind){
                    
                    encontrado = true;
                    sVisibleTreasures.add(tKind);
                    VisibleT.remove(i);
                    
                }
                
                i++;
                
            }
            
        }
        
        ArrayList<Treasure> HiddenT = new ArrayList(h);
        ArrayList<TreasureKind> sHiddenTreasures = new ArrayList();
        
        for(TreasureKind tKind : this.specificHiddenTreasures){
            
            int i = 0;
            boolean encontrado = false;
            
            while((i < HiddenT.size()) && !encontrado){
                
                if(HiddenT.get(i).getType() == tKind){
                    
                    encontrado = true;
                    sHiddenTreasures.add(tKind);
                    HiddenT.remove(i);
                    
                }
                
                i++;
                
            }
            
        }
        
        bc = new SpecificBadConsequence(this.text, this.levels, sVisibleTreasures, sHiddenTreasures);
        
        return bc;
    
    }
    
    @Override
    public String toString(){
        
        String bc = super.toString();
        
        if(!specificVisibleTreasures.isEmpty()){
            
            bc += "\nTesoros visibles que pierdes: ";
            
            for(int i=0; i<this.specificVisibleTreasures.size(); i++){
                
                bc += this.specificVisibleTreasures.get(i) + " ";
                
            }
            
        }
        
        if(!specificHiddenTreasures.isEmpty()){
            
            bc += "\nTesoros ocultos que pierdes: ";
            
            for(int i=0; i<this.specificHiddenTreasures.size(); i++){
                
                bc += this.specificHiddenTreasures.get(i) + " ";
                
            }
            
        }
        
        return bc;
        
    }
    
}
