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
    public List<Creature> protagonistes;
    public List<Objet> objets;
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
        // Generate protagonist List.
        for(int i = 0 ; i < nbArchers; i++)
        {
            protagonistes.add(new Archer());
        }
        for(int i = 0 ; i < nbGuerriers; i++)
        {
            protagonistes.add(new Guerrier());
        }
        for(int i = 0 ; i < nbMages; i++)
        {
            protagonistes.add(new Mage());
        }
        for(int i = 0 ; i < nbPaysans; i++)
        {
            protagonistes.add(new Paysan());
        }
        for(int i = 0 ; i < nbLoups; i++)
        {
            protagonistes.add(new Loup());
        }
        for(int i = 0 ; i < nbLapins; i++)
        {
            protagonistes.add(new Lapin());
        }
        
        // Generate object List.
        for(int i = 0 ; i < nbSoins; i++)
        {
            objets.add(new Soin());
        }
        for(int i = 0 ; i < nbManas; i++)
        {
            objets.add(new Mana());
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
        System.out.print(
           "This is a World of " + mapSize+"x"+mapSize + ". It contains :\n"+
           " - "+nbProtagonistes+" protagonistes distributed as :\n"+
           " \t- "+nbGuerriers+" Guerriers;\n"+
           " \t- "+nbArchers+" Archers;\n"+
           " \t- "+nbMages+" Mages;\n"+
           " \t- "+nbPaysans+" Paysans;\n"+
           " \t- "+nbLoups+" Loups;\n"+
           " \t- "+nbLapins+" Lapins.\n\n"+
           " - "+nbObjets+" objets distributes as :\n"+
           " \t- "+nbSoins+" Potions de soin;\n"+       
           " \t- "+nbManas+" Potions de mana.\n"  
           );
    }
    
    
}
