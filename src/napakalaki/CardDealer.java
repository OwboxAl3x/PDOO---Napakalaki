/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class CardDealer {
    
    private static CardDealer instance = null;
    
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Cultist> unusedCultist;
    
    private CardDealer(){
        
        
    }
    
    public static CardDealer getInstance(){
        
        if(instance==null){
            
            instance = new CardDealer();
            
        }
        
        return instance;
        
    }
    
    private void initTreasureCardDeck(){
        
        unusedTreasures = new ArrayList();
        usedTreasures = new ArrayList();
        
        Treasure t;

        t = new Treasure("¡Sí mi amo!", 4, TreasureKind.HELMET, "¡Si mi amo!");
        unusedTreasures.add(t);
        
        t = new Treasure("Botas de investigación", 3, TreasureKind.SHOES, "Botas de investigacion");
        unusedTreasures.add(t);
        
        t = new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET, "Capucha de Cthulhu");
        unusedTreasures.add(t);
        
        t = new Treasure("A prueba de babas", 2, TreasureKind.ARMOR, "A prueba de babas");
        unusedTreasures.add(t);
        
        t = new Treasure("Botas de lluvia ácida", 1, TreasureKind.BOTHHANDS, "Botas de lluvia acida");
        unusedTreasures.add(t);
        
        t = new Treasure("Casco minero", 2, TreasureKind.HELMET, "Casco minero");
        unusedTreasures.add(t);
        
        t = new Treasure("Ametralladora Thompson", 4, TreasureKind.BOTHHANDS, "Ametralladora Thompson");
        unusedTreasures.add(t);
        
        t = new Treasure("Camiseta de la UGR", 1, TreasureKind.ARMOR, "Camiseta de la UGR");
        unusedTreasures.add(t);
        
        t = new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND, "Clavo de rail ferroviario");
        unusedTreasures.add(t);
        
        t = new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND, "Cuchillo de sushi arcano");
        unusedTreasures.add(t);
        
        t = new Treasure("Fez alópodo", 3, TreasureKind.HELMET, "Fez alopodo");
        unusedTreasures.add(t);
        
        t = new Treasure("Hacha prehistórica", 2, TreasureKind.ONEHAND, "Hacha prehistorica");
        unusedTreasures.add(t);
        
        t = new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR, "El aparato del Pr. Tesla");
        unusedTreasures.add(t);
        
        t = new Treasure("Gaita", 4, TreasureKind.BOTHHANDS, "Gaita");
        unusedTreasures.add(t);
        
        t = new Treasure("Insecticida", 2, TreasureKind.ONEHAND, "Insecticida");
        unusedTreasures.add(t);
        
        t = new Treasure("La rebeca metálica", 2, TreasureKind.ARMOR, "La rebeca metalica");
        unusedTreasures.add(t);
        
        t = new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS, "Lanzallamas");
        unusedTreasures.add(t);
        
        t = new Treasure("Necrocomicón", 1, TreasureKind.ONEHAND, "Necro comicon");
        unusedTreasures.add(t);
        
        t = new Treasure("Necronomicón", 5, TreasureKind.BOTHHANDS, "Necronomicon");
        unusedTreasures.add(t);
        
        t = new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS, "Linterna a 2 manos");
        unusedTreasures.add(t);
        
        t = new Treasure("Necrognomicón", 2, TreasureKind.ONEHAND, "Necro-gnomicon");
        unusedTreasures.add(t);
        
        t = new Treasure("Necrotelecom", 2, TreasureKind.HELMET, "Necrotelecom");
        unusedTreasures.add(t);
        
        t = new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND, "Mazo de los antiguos");
        unusedTreasures.add(t);
        
        t = new Treasure("Necroplayboycón", 3, TreasureKind.ONEHAND, "Necro playboycon");
        unusedTreasures.add(t);
        
        t = new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND, "Porra preternatural");
        unusedTreasures.add(t);
        
        t = new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS, "Shogulador");
        unusedTreasures.add(t);
        
        t = new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND, "Varita de atizamiento");
        unusedTreasures.add(t);
        
        t = new Treasure("Tentáculo de pega", 2, TreasureKind.HELMET, "Tentaculo de pega");
        unusedTreasures.add(t);
        
        t = new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES, "Zapato deja-amigos");
        unusedTreasures.add(t);
        
    }
    
    private void initMonsterCardDeck(){
        
        unusedMonsters = new ArrayList();
        usedMonsters = new ArrayList();
        
        BadConsequence bc;
        Prize price;
        
        bc = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        price = new Prize(2, 1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, bc, price, "3 Byakhees de bonanza"));
        
        bc = new SpecificBadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        price = new Prize(1,1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, bc, price, "Chibithulhu"));
        
        bc = new SpecificBadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList(Arrays.asList()));
        price = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, bc, price, "El sopor de Dunwich"));
    
        bc = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitas del vuelo. Descarta 1 mano visible y 1 mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        price = new Prize(4,1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, bc, price, "Angeles de la noche ibicenca"));
        
        bc = new NumericBadConsequence("Pierdes todos tus tesoros visibles", 0, bc.MAXTREASURES, 0);
        price = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorrón del umbral", 10, bc, price, "El gorron en el umbral"));
        
        bc = new SpecificBadConsequence("Pierdes la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        price = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, bc, price, "H.P. Munchcraft"));
        
        bc = new SpecificBadConsequence("Sientes bichos bajo la ropa", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        price = new Prize(1,1);
        unusedMonsters.add(new Monster("Bichgooth", 2, bc, price, "Bichgooth"));
        
        bc = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        price = new Prize(4,2);
        unusedMonsters.add(new Monster("El rey de rosa", 13, bc, price, "El rey de rosa"));
        
        bc = new NumericBadConsequence("Toses los pulmones y pierdes dos niveles", 2, 0, 0);
        price = new Prize(1,1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, bc, price, "La que redacta en las tinieblas"));
        
        bc = new DeathBadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto", true);
        price = new Prize(2,1);
        unusedMonsters.add(new Monster("Los hondos", 8, bc, price, "Los hondos"));
        
        bc = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
        price = new Prize(12,1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, bc, price, "Semillas Cthulhu"));
        
        bc = new SpecificBadConsequence("Te intentas escaquear. Pierdes una mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList()));
        price = new Prize(2,1);
        unusedMonsters.add(new Monster("Dameargo", 1, bc, price, "Dameargo"));
        
        bc = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
        price = new Prize(1,1);
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, bc, price, "Pollipolipo volante"));
        
        bc = new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto", true);
        price = new Prize(3,1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, bc, price, "YskhtihyssgGoth"));
        
//        bc = new DeathBadConsequence("La familia te atrapa. Estas muerto", true);
//        price = new Prize(4,1);
//        unusedMonsters.add(new Monster("Familia Feliz", 1, bc, price, "Familia feliz"));
        
        bc = new SpecificBadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y en tesoro 2 manos visibles", 2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList()));
        price = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth", 8, bc, price, "Roboggoth"));
        
        bc = new SpecificBadConsequence("Te asusta en la noche. Pierdes un casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        price = new Prize(1,1);
        unusedMonsters.add(new Monster("El espia", 5, bc, price, "El espia"));
        
        bc = new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        price = new Prize(1,1);
        unusedMonsters.add(new Monster("Bichgooth", 20, bc, price, "Bichgooth"));
        
        bc = new NumericBadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, bc.MAXTREASURES, 0);
        price = new Prize(1,1);
        unusedMonsters.add(new Monster("Bicéfalo", 20, bc, price, "Bicefalo"));
        
        //Monstruos contra sectarios
        
        bc = new SpecificBadConsequence("Pierdes una mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList()));
        price = new Prize(3, 1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, bc, price, -2, "El mal indecible impronunciable"));
        
        bc = new NumericBadConsequence("Pierdes tus tesoros visibles. Jajaja", 0, bc.MAXTREASURES, 0);
        price = new Prize(2, 1);
        unusedMonsters.add(new Monster("Testigos oculares", 6, bc, price, +2, "Testigos Oculares"));
        
        bc = new DeathBadConsequence("Hoy no es tu dia de suerte. Mueres", true);
        price = new Prize(2, 5);
        unusedMonsters.add(new Monster("El gran cthulhu", 20, bc, price, +4, "El gran cthulhu"));
        
        bc = new NumericBadConsequence("Tu gobierno te recorta 2 niveles", 2, 0, 0);
        price = new Prize(2, 1);
        unusedMonsters.add(new Monster("Serpiente político", 8, bc, price, -2, "Serpiente politico"));
        
        bc = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS, TreasureKind.ONEHAND)));
        price = new Prize(1, 1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, bc, price, +5, "Felpuggoth"));
        
        bc = new NumericBadConsequence("Pierdes dos niveles", 2, 0, 0);
        price = new Prize(4, 2);
        unusedMonsters.add(new Monster("Shoggoth", 16, bc, price, -4, "Shoggoth"));
        
        bc = new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles", 2, 0, 0);
        price = new Prize(1, 1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, bc, price, +3, "Lolitagooth"));
        
    }
    
    private void initCultistCardDesk(){
        
        unusedCultist = new ArrayList();
        
        unusedCultist.add(new Cultist("Sectario", 1));
        unusedCultist.add(new Cultist("Sectario", 2));
        unusedCultist.add(new Cultist("Sectario", 1));
        unusedCultist.add(new Cultist("Sectario", 2));
        unusedCultist.add(new Cultist("Sectario", 1));
        unusedCultist.add(new Cultist("Sectario", 1));
        
    }
    
    private void shuffleCultist(){
        
        Collections.shuffle(this.unusedCultist);
        
    }
    
    private void shuffleTreasures(){
        
        Collections.shuffle(this.unusedTreasures);
        
    }
    
    private void shuffleMonsters(){
        
        Collections.shuffle(this.unusedMonsters);
        
    }
    
    public Treasure nextTreasure(){
        
        if(this.unusedTreasures.isEmpty()){
            
           for(Treasure t:usedTreasures){
               
               unusedTreasures.add(t);
               
           }
           
           this.shuffleTreasures();
           
        }
        
        Treasure t = this.unusedTreasures.remove(0);
        this.usedTreasures.add(t);
        
        return t;
        
    }
    
    public Monster nextMonster(){
        
        if(unusedMonsters.isEmpty()){
            
           for(Monster m:usedMonsters){
               
               this.unusedMonsters.add(m);
               
           }
           
           this.shuffleMonsters();
           
        }
        
        Monster m = this.unusedMonsters.remove(0);
        this.usedMonsters.add(m);
        
        return m;
        
    }
    
    public Cultist nextCultist(){
        
        Cultist c = this.unusedCultist.get(0);
        
        this.unusedCultist.remove(0);
        
        return c;
        
    }
    
    public void giveTreasureBack(Treasure t){
        
        usedTreasures.add(t);
        
    }
    
    public void giveMonsterBack(Monster m){
        
        usedMonsters.add(m);
        
    }
    
    public void initCards(){
    
        this.initTreasureCardDeck();
        this.initMonsterCardDeck();
        this.initCultistCardDesk();
        this.shuffleTreasures();
        this.shuffleMonsters();
        this.shuffleCultist();
    
    }
    
}
