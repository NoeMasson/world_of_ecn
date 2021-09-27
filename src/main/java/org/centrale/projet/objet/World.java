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
     * @return the mapSize
     */
    public int getMapSize() {
        return mapSize;
    }

    /**
     * @param mapSize the mapSize to set
     */
    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
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
    
    private int nbProtagonistes;
    private int nbObjets;
    private int mapSize;
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
    
    
    public World(int nbProtagonistes, int nbObjets, int mapSize)
    {   
        this.nbProtagonistes = nbProtagonistes;
        this.nbObjets = nbObjets;
        this.mapSize = mapSize;
        this.computeDistribution();
        
        protagonistes = new LinkedList<>();
        objets = new LinkedList<>();
        this.creeMondeAlea();
    }
    
    
    public World()
    {   
        this.nbProtagonistes = 10;
        this.nbObjets = 5;
        this.mapSize = 20;
        this.computeDistribution();
        
        protagonistes = new LinkedList<>();
        objets = new LinkedList<>();
        this.creeMondeAlea();
    }
    
    
    private final void computeDistribution()
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
        int x = rand.nextInt(getMapSize());
        int y = rand.nextInt(getMapSize());
        Point2D pos = new Point2D(x, y);
        getProtagonistes().get(0).setPos(pos);
        for(index = 1; index < getProtagonistes().size(); index ++)
        {
            //Positionning the protagonist nb index in function of previous 
            //ones.
            boolean positionOk = false;
            
            while(!positionOk)
            {   
                x = rand.nextInt(getMapSize());
                y = rand.nextInt(getMapSize());
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
        }
    }
    
    
    /**
     * Testing method for a game turn.
     */
    public void tourDeJeu()
    {
        
    }
    
    
    /**
     * Display the information about all the characters into the terminal.
     */
    public void afficheWorld()
    {
        System.out.print("This is a World of " + getMapSize()+"x"+getMapSize() + ". It contains :\n"+
           " - "+getNbProtagonistes()+" protagonistes distributed as :\n"+
           " \t- "+getNbGuerriers()+" Guerriers;\n"+
           " \t- "+getNbArchers()+" Archers;\n"+
           " \t- "+getNbMages()+" Mages;\n"+
           " \t- "+getNbPaysans()+" Paysans;\n"+
           " \t- "+getNbLoups()+" Loups;\n"+
           " \t- "+getNbLapins()+" Lapins.\n\n"+
           " - "+getNbObjets()+" objets distributes as :\n"+
           " \t- "+getNbSoins()+" Potions de soin;\n"+       
           " \t- "+getNbManas()+" Potions de mana.\n"  
           );
    }
    
    
}
