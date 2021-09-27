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
        this.creeMondeAlea();
    }
    
    
    public World()
    {   
        this.nbProtagonistes = 10;
        this.nbObjets = 5;
        this.mapSize = 20;
        this.computeDistribution();
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
        
        nbArchers = nbProtagonistes*A / sum;
        nbGuerriers = nbProtagonistes*G / sum;
        nbMages = nbProtagonistes*M / sum;
        nbPaysans = nbProtagonistes*P / sum;
        nbLoups = nbProtagonistes*Lo / sum;
        nbLapins = nbProtagonistes*La / sum;
        
        // Generation of random potion distribtion.
        nbSoins = rand.nextInt(nbObjets);
        nbManas = nbObjets - nbSoins;
    }
    
    
    /**
     * Generate a map by placing the characters randomly following certain 
     * proximity rules.
     */
    public final void creeMondeAlea()
    {
        /*for(int i = 0 ; i < nbArchers; i++)
        {
            protagonistes.add(new Archer());
        }*/
        
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
        
    }
    
    
}
