/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;
import java.util.*;

/**
 *
 * @author Valentin Molina valentin@molina.pro
 * @author Noé Masson
 */
public class World {

    /**
     * @return the largeur
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * @param largeur the largeur to set
     */
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    /**
     * @return the longueur
     */
    public int getLongueur() {
        return longueur;
    }

    /**
     * @param longueur the longueur to set
     */
    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    /**
     * @return the joueur
     */
    public Joueur getJoueur() {
        return joueur;
    }

    /**
     * @param joueur the joueur to set
     */
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    /**
     * @return the nbProtagonistes
     */
    public int getNbProtagonistes() {
        return nbProtagonistes;
    }

    /**
     * @param nbProtagonistes the nbProtagonistes to set
     */
    public void setNbProtagonistes(int nbProtagonistes) {
        this.nbProtagonistes = nbProtagonistes;
    }

    /**
     * @return the nbObjets
     */
    public int getNbObjets() {
        return nbObjets;
    }

    /**
     * @param nbObjets the nbObjets to set
     */
    public void setNbObjets(int nbObjets) {
        this.nbObjets = nbObjets;
    }

    /**
     * @return the protagonistes
     */
    public List<Creature> getProtagonistes() {
        return protagonistes;
    }

    /**
     * @param protagonistes the protagonistes to set
     */
    public void setProtagonistes(List<Creature> protagonistes) {
        this.protagonistes = protagonistes;
    }

    /**
     * @return the objets
     */
    public List<Objet> getObjets() {
        return objets;
    }

    /**
     * @param objets the objets to set
     */
    public void setObjets(List<Objet> objets) {
        this.objets = objets;
    }

    /**
     * @return the nbArchers
     */
    public int getNbArchers() {
        return nbArchers;
    }

    /**
     * @param nbArchers the nbArchers to set
     */
    public void setNbArchers(int nbArchers) {
        this.nbArchers = nbArchers;
    }

    /**
     * @return the nbGuerriers
     */
    public int getNbGuerriers() {
        return nbGuerriers;
    }

    /**
     * @param nbGuerriers the nbGuerriers to set
     */
    public void setNbGuerriers(int nbGuerriers) {
        this.nbGuerriers = nbGuerriers;
    }

    /**
     * @return the nbMages
     */
    public int getNbMages() {
        return nbMages;
    }

    /**
     * @param nbMages the nbMages to set
     */
    public void setNbMages(int nbMages) {
        this.nbMages = nbMages;
    }

    /**
     * @return the nbPaysans
     */
    public int getNbPaysans() {
        return nbPaysans;
    }

    /**
     * @param nbPaysans the nbPaysans to set
     */
    public void setNbPaysans(int nbPaysans) {
        this.nbPaysans = nbPaysans;
    }

    /**
     * @return the nbLoups
     */
    public int getNbLoups() {
        return nbLoups;
    }

    /**
     * @param nbLoups the nbLoups to set
     */
    public void setNbLoups(int nbLoups) {
        this.nbLoups = nbLoups;
    }

    /**
     * @return the nbLapins
     */
    public int getNbLapins() {
        return nbLapins;
    }

    /**
     * @param nbLapins the nbLapins to set
     */
    public void setNbLapins(int nbLapins) {
        this.nbLapins = nbLapins;
    }

    /**
     * @return the nbSoins
     */
    public int getNbSoins() {
        return nbSoins;
    }

    /**
     * @param nbSoins the nbSoins to set
     */
    public void setNbSoins(int nbSoins) {
        this.nbSoins = nbSoins;
    }

    /**
     * @return the nbManas
     */
    public int getNbManas() {
        return nbManas;
    }

    /**
     * @param nbManas the nbManas to set
     */
    public void setNbManas(int nbManas) {
        this.nbManas = nbManas;
    }
    
    private int largeur;
    private int longueur;
    
    private int nbProtagonistes;
    private int nbObjets;
    private List<Creature> protagonistes;
    private List<Objet> objets;
    private int nbArchers;
    private int nbGuerriers;
    private int nbMages;
    private int nbPaysans;
    private int nbLoups;
    private int nbLapins;
    private int nbSoins;
    private int nbManas;
    /**
     * The player of our game.
     */
    private Joueur joueur;
    
    /**
     * Constructor used to create a world while reading a save file.
     * @param longueur The length of the map. 
     * @param largeur The width of the map.
     */
    public World(int longueur, int largeur)
    {
        this.largeur = largeur;
        this.longueur = longueur;
        
        protagonistes = new ArrayList<>();
        objets = new ArrayList<>();
    }
    
    public World(int nbProtagonistes, int nbObjets, int mapSize)
    {   
        this.nbProtagonistes = nbProtagonistes;
        this.nbObjets = nbObjets;
        this.largeur = mapSize;
        this.longueur = mapSize;
        this.computeDistribution();
        
        protagonistes = new ArrayList<>();
        objets = new ArrayList<>();
        this.creeMondeAlea();
    }
    
    
    public World()
    {   
        this.nbProtagonistes = 10;
        this.nbObjets = 5;
        this.largeur = 20;
        this.longueur = 20;
        this.computeDistribution();
        
        protagonistes = new ArrayList<>();
        objets = new ArrayList<>();
        this.creeMondeAlea();
    }
    
    
    private void computeDistribution()
    {
        Random rand = new Random();
        
        // Generation of random protagonist distribution.
        int A = rand.nextInt(100);
        int M = rand.nextInt(100);
        int G = rand.nextInt(100);
        int P = rand.nextInt(100);
        int Lo = rand.nextInt(100);
        int La = rand.nextInt(100);
        
        int sum = A + M + G + P + Lo + La ;
        
        setNbArchers(getNbProtagonistes() * A / sum);
        setNbGuerriers(getNbProtagonistes() * G / sum);
        setNbMages(getNbProtagonistes() * M / sum);
        //nbPaysans = nbProtagonistes*P / sum;
        setNbLoups(getNbProtagonistes() * Lo / sum);
        setNbLapins(getNbProtagonistes() * La / sum);
        setNbPaysans(getNbProtagonistes() - getNbArchers() - getNbGuerriers() - getNbMages() - getNbLoups() - getNbLapins());
        
        // Generation of random potion distribtion.
        setNbSoins(rand.nextInt(getNbObjets()));
        setNbManas(getNbObjets() - getNbSoins());
    }
    
    
    /**
     * Generate a map by placing the characters randomly following certain 
     * proximity rules.
     */
    public final void creeMondeAlea()
    {
        // Generate protagonist List.
        for(int i = 0 ; i < getNbArchers(); i++)
        {
            getProtagonistes().add(new Archer());
        }
        for(int i = 0 ; i < getNbGuerriers(); i++)
        {
            getProtagonistes().add(new Guerrier());
        }
        for(int i = 0 ; i < getNbMages(); i++)
        {
            getProtagonistes().add(new Mage());
        }
        for(int i = 0 ; i < getNbPaysans(); i++)
        {
            getProtagonistes().add(new Paysan());
        }
        for(int i = 0 ; i < getNbLoups(); i++)
        {
            getProtagonistes().add(new Loup());
        }
        for(int i = 0 ; i < getNbLapins(); i++)
        {
            getProtagonistes().add(new Lapin());
        }
        
        // Generate object List.
        for(int i = 0 ; i < getNbSoins(); i++)
        {
            getObjets().add(new Soin());
        }
        for(int i = 0 ; i < getNbManas(); i++)
        {
            getObjets().add(new Mana());
        }
        
        Random rand = new Random();
        
        // Position every protagonists.
        int index;
        int x = rand.nextInt(getLargeur());
        int y = rand.nextInt(getLongueur());
        Point2D pos = new Point2D(x, y);
        getProtagonistes().get(0).setPos(pos);
        for(index = 1; index < getProtagonistes().size(); index ++)
        {
            //Positionning the protagonist nb index in function of previous 
            //ones.
            boolean positionOk = false;
            
            while(!positionOk)
            {   
                x = rand.nextInt(getLargeur());
                y = rand.nextInt(getLongueur());
                pos = new Point2D(x,y);
                boolean findOneNear = false;
                boolean collision = false ;
                for(int itr = 0 ; itr < index ; itr++)
                {
                    Creature current = protagonistes.get(itr);
                    
                    // Tcheck for collision.
                    if(x == current.getPos().getX() &&
                            y == current.getPos().getY())
                    {
                        collision = true;
                        break;
                    }
                    
                    // Search for a protagonist near the position.
                    if((!findOneNear) && (pos.distance(current.getPos()) <= 3))
                    {
                        findOneNear = true;
                    }
                }
                positionOk = findOneNear && (!collision);
            }
            protagonistes.get(index).setPos(pos);
        }
    }
    
    
    /**
     * Testing method for a game turn.
     */
    public void tourDeJeu()
    {
        this.afficheWorld();
        this.playJoueur();
    }
    
    
    /**
     * Display the information about all the characters into the terminal.
     */
    public void afficheWorld()
    {
        System.out.print("This is a World of " + getLargeur()+"x"+getLongueur());/* + ". It contains :\n"+
           " - "+getNbProtagonistes()+" protagonistes distributed as :\n"+
           " \t- "+getNbGuerriers()+" Guerriers;\n"+
           " \t- "+getNbArchers()+" Archers;\n"+
           " \t- "+getNbMages()+" Mages;\n"+
           " \t- "+getNbPaysans()+" Paysans;\n"+
           " \t- "+getNbLoups()+" Loups;\n"+
           " \t- "+getNbLapins()+" Lapins.\n\n"+
           " - "+getNbObjets()+" objets distributes as :\n"+
           " \t- "+getNbSoins()+" Potions de soin;\n"+       
           " \t- "+getNbManas()+" Potions de mana.\n\n"  
           );*/
        System.out.println("");
        
        char[][] positions = new char[getLargeur()][getLongueur()];
        for(int i = 0; i < getLargeur() ; i ++){
            for(int j = 0; j < getLongueur(); j++){
                positions[i][j] = ' ';
            }
        }
        
        for(Objet o : objets){
            
            Point2D pos = o.getPos();
            int x = pos.getX();
            int y = pos.getY();
            
            if(o instanceof Soin){
                positions[x][y] = 's';
            }
            if(o instanceof Mana){
                positions[x][y] = 'm';
            }
            
        }
        
        for(Creature c : protagonistes)
        {
            Point2D pos = c.getPos();
            int x = pos.getX();
            int y = pos.getY();
            
            //System.out.println(c.getClass());
            
            if(c instanceof Guerrier){
                positions[x][y] = 'G';
            }
            else if(c instanceof Mage){
                positions[x][y] = 'M';
            }
            else if(c instanceof Archer){
                positions[x][y] = 'A';
            }
            else if(c instanceof Paysan){
                positions[x][y] = 'P';
            }
            else if(c instanceof Loup){
                positions[x][y] = 'L';
            }
            else if(c instanceof Lapin){
                positions[x][y] = 'l';
            }
            
        }
        
        positions[joueur.getPerso().getPos().getX()]
                [joueur.getPerso().getPos().getY()] = 'J';
        
        for(int i = 0; i < getLargeur()+2; i ++){
            System.out.print("# ");
        }
        System.out.print('\n');
        
        for(int i = 0; i < getLargeur(); i ++){
            System.out.print("# ");
            for(int j = 0; j < getLongueur(); j ++){
                System.out.print(positions[i][j]);
                System.out.print(' ');
            }
            System.out.print("#\n");
        }
        
        for(int i = 0; i < getLargeur()+2; i ++){
            System.out.print("# ");
        }
        System.out.print('\n');
        
        System.out.println("Où :");
        System.out.println("\t- J est la position du joueur ;");
        System.out.println("\t- G est un Guerrier ;");
        System.out.println("\t- M est un Mage ;");
        System.out.println("\t- A est un Archer ;");
        System.out.println("\t- L est un Loup ;");
        System.out.println("\t- l est un lapin ;");
        System.out.println("\t- P est un Paysan.");
        System.out.println("\t- s est une Potion de soin.");
        System.out.println("\t- m est une Potion de mana.");
        System.out.println("");
        System.out.println("Le joueu possède le status suivant :");
        System.out.println("\t Points de vie : " + joueur.getPerso().getPtVie());
        System.out.println("\t Points de mana : " + joueur.getPerso().getPtMana());
        System.out.println("");
    }
    
    
    public void creationJoueur() throws PlayerCreationException
    {
        java.util.Scanner in = new java.util.Scanner(System.in);
        
        System.out.print(
                "Quelle classe choisissez vous ?\n" +
                "1 -\tArcher ;\n" + 
                "2 -\tGuerrier ;\n" +
                "3 -\tMage.\n");
        int choice=0;
        String classe = new String("Mage");
        while(choice != 1 && choice != 2 && choice != 3)
        {
            System.out.println("Entrez 1, 2 ou 3.");
            try{
                choice = Integer.parseInt(in.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print("Vous devez entrer un entier ! ");
            }
        }
        
        switch(choice){
            case 1 :
                classe = new String("Archer");
                break;
            case 2 :
                classe = new String("Guerrier");
                break;
            case 3:
            default :
                //Allready a Mage.
                break;
             
        }
        System.out.println("Vous avez choisi d'être un " + classe);
        System.out.println("");
        System.out.println("Quel nom voulez-vous donner à votre personnage ?");
        String name = in.nextLine();
        
        joueur = new Joueur("org.centrale.projet.objet."+classe, name); 
        
    }
    
    
    public void playJoueur(){
        
        java.util.Scanner in = new java.util.Scanner(System.in);
        
        System.out.println("Souhaitez-vous combattre ou vous déplacer ?");
        System.out.println("1 - Déplacement.");
        System.out.println("2 - Combattre.");
        System.out.println("");
        int choice = 0;
        while(choice != 1 && choice != 2){
            try{
                System.out.println("Entrez 1 ou 2 en fonction de votre choix.");
                System.out.println("");
                choice = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Vous devez entrer un entier ! ");
            }
        }
        switch(choice){
            case 1 -> {
                Objet toDelete = this.getJoueur().move(
                    this.surroundingObj(getJoueur().getPerso().getPos()),
                    this.surroundingOpponents(getJoueur().getPerso().getPos()));
                if(toDelete != null){
                    objets.remove(toDelete);
                }
                System.out.println("");
                this.afficheWorld();
            }
            case 2 -> {
                this.getJoueur().fight(
                    this.canAttack(this.getJoueur().getPerso()));
            }
        }
        
    }
    
    
    /**
     * This method is used to compute the opponent which surround a specific 
     * position.
     * It returns a Creature[] of size 8 which encode the 8 positions around pos.
     * It used the following convention :
     *   -> x
     * y |1|2|3| delta(-1,-1) = 1
     * | |8|O|4| O = position pos.
     * ' |7|6|5|
     * @param pos The position O.
     * @return The list of opponent which surround the position pos.
     */
    private Creature[] surroundingOpponents(Point2D pos){
        Creature[] opponents = new Creature[8];
        
        for(Creature c : this.getProtagonistes()){
            if(c.getPos().distance(pos) < 2){
                int deltaX, deltaY;
                deltaX = pos.getX() - c.getPos().getX();
                deltaY = pos.getY() - c.getPos().getY();
                switch(deltaX){
                    case -1 :
                        switch(deltaY){
                            case -1 -> opponents[0] = c;
                            case  0 -> opponents[1] = c;
                            case  1 -> opponents[2] = c;
                        }
                        break;
                    case 0 :
                        switch(deltaY){
                            case -1 -> opponents[7] = c;
                            case  1 -> opponents[3] = c;
                        }
                        break;
                    case 1 :
                        switch(deltaY){
                            case -1 -> opponents[6] = c;
                            case  0 -> opponents[5] = c;
                            case  1 -> opponents[4] = c;
                        }
                        break;
                }
                    
            }
        }
        return opponents;
    }
    
    
    /**
     * This method is used to compute the opponent which surround a specific 
     * position.
     * It returns a Creature[] of size 8 which encode the 8 positions around pos.
     * It used the following convention :
     *   -> x
     * y |1|2|3| delta(-1,-1) = 1
     * | |8|O|4| O = position pos.
     * ' |7|6|5|
     * @param pos The position O.
     * @return The list of opponent which surround the position pos.
     */
    private Objet[] surroundingObj(Point2D pos){
        Objet[] surroundingObjets = new Objet[8];
        
        for(Objet o : this.getObjets()){
            if(o.getPos().distance(pos) < 2){
                int deltaX, deltaY;
                deltaX = pos.getX() - o.getPos().getX();
                deltaY = pos.getY() - o.getPos().getY();
                switch(deltaX){
                    case -1 :
                        switch(deltaY){
                            case -1 -> surroundingObjets[0] = o;
                            case  0 -> surroundingObjets[1] = o;
                            case  1 -> surroundingObjets[2] = o;
                        }
                        break;
                    case 0 :
                        switch(deltaY){
                            case -1 -> surroundingObjets[7] = o;
                            case  1 -> surroundingObjets[3] = o;
                        }
                        break;
                    case 1 :
                        switch(deltaY){
                            case -1 -> surroundingObjets[6] = o;
                            case  0 -> surroundingObjets[5] = o;
                            case  1 -> surroundingObjets[4] = o;
                        }
                        break;
                }
                    
            }
        }
        return surroundingObjets;
    }
    
    
    /**
     * Select the Creature in World which can be hit by perso.
     * @param perso The Creature which try to hit.
     * @return The Creature that can be hit by perso.
     */
    private ArrayList<Creature> canAttack(Creature perso){
        ArrayList<Creature> atRange = new ArrayList<Creature>();
        for(Creature c : this.getProtagonistes()){
            if(c.getPos().distance(perso.getPos()) <= perso.getDistAttMax())
            {
                atRange.add(c);
            }
        }
        return atRange;
    }
    
}
