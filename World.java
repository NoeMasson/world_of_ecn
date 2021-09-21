/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 *
 * @author Valentin Molina valentin@molina.pro
 * @author Noé Masson
 */
public class World {
    
    /**
     * An Archer character
     */
    public Archer robin;
    
    /**
     * A Paysan character
     */
    public Paysan peon;
    
    /**
     * Twos rabbits
     */
    public Lapin bugs, bunny;
    
    /**
     * Guillaume Tell, a famous archer
     */
    public Archer guillaumeT;
    
    /**
     * A warrior
     */
    public Guerrier grosBill;
    
    /**
     * A Mage
     */
    public Mage merlin;
    
    /**
     * A wolf
     */
    public Loup wolfie;
    
    /**
     * Constructor for a new world
     */
    public World()
    {
        robin = new Archer("Robin", 100, 100, 15, 2, 1, 1, 10, 1, 5, 
                new Point2D(0,0), 2, 10);
        peon = new Paysan("Peon", 100, 0, 0, 0, 0, 0, 0, 0, 1, 
                new Point2D(0,0), 0);
        bugs = new Lapin("Bugs", 500, 90, 90, 50, 50, 1, new Point2D(0,0), 40);
        bunny = new Lapin("Bunny", 5, 0, 0, 0, 0, 1, new Point2D(0,0), 0);
        grosBill = new Guerrier("Gros Bill", 100, 10, 70, 60, 10, 10, 10, 2, 1,
                new Point2D(0,0), 7);
        merlin = new Mage("Merlin", 100, 100, 20, 20, 80, 60, 2, 10, 5,
                new Point2D(0,0), 2);
        wolfie = new Loup("Wolfie", 50, 90, 50, 20, 7, 1, new Point2D(0,0), 2);
        
        this.creeMondeAlea();
        guillaumeT = new Archer(robin);
    }
    
    /**
     * Generate a map by placing the characters randomly following certain 
     * proximity rules.
     */
    public final void creeMondeAlea()
    {
        Random rand = new Random();
        
        int size = 20;
        
        // Positionning the first character : robin.
        int x1 = rand.nextInt(size);
        int y1 = rand.nextInt(size);
        Point2D p1 = new Point2D(x1, y1);
        robin.setPos(p1);
        
        // Positionning the second character : peon.
        int x2 = rand.nextInt(size);
        int y2 = rand.nextInt(size);
        Point2D p2 = new Point2D(x2, y2);
        while(p1.distance(p2) > 5)
        {
            x2 = rand.nextInt(size);
            y2 = rand.nextInt(size);
            p2 = new Point2D(x2, y2);
        }
        peon.setPos(p2);
        p1 = p2;
        
        // Positionning the third character : bugs.
        x2 = rand.nextInt(size);
        y2 = rand.nextInt(size);
        p2 = new Point2D(x2, y2);
        while(p1.distance(p2) > 5)
        {
            x2 = rand.nextInt(size);
            y2 = rand.nextInt(size);
            p2 = new Point2D(x2, y2);
        }
        bugs.setPos(p2);
        p1 = p2;
        
        // Positionning the fourth character : bunny.
        x2 = rand.nextInt(size);
        y2 = rand.nextInt(size);
        p2 = new Point2D(x2, y2);
        while(p1.distance(p2) > 5)
        {
            x2 = rand.nextInt(size);
            y2 = rand.nextInt(size);
            p2 = new Point2D(x2, y2);
        }
        bunny.setPos(p2);
        p1 = p2;
        
        // Positionning the fifth character : grosBill.
        x2 = rand.nextInt(size);
        y2 = rand.nextInt(size);
        p2 = new Point2D(x2, y2);
        while(p1.distance(p2) > 5)
        {
            x2 = rand.nextInt(size);
            y2 = rand.nextInt(size);
            p2 = new Point2D(x2, y2);
        }
        grosBill.setPos(p2);
        p1 = p2;
        
        // Positionning the sixth character : merlin.
        x2 = rand.nextInt(size);
        y2 = rand.nextInt(size);
        p2 = new Point2D(x2, y2);
        while(p1.distance(p2) > 5)
        {
            x2 = rand.nextInt(size);
            y2 = rand.nextInt(size);
            p2 = new Point2D(x2, y2);
        }
        merlin.setPos(p2);
        p1 = p2;
        
        // Positionning the seventh character : wolfie.
        x2 = rand.nextInt(size);
        y2 = rand.nextInt(size);
        p2 = new Point2D(x2, y2);
        while(p1.distance(p2) > 5)
        {
            x2 = rand.nextInt(size);
            y2 = rand.nextInt(size);
            p2 = new Point2D(x2, y2);
        }
        wolfie.setPos(p2);
        p1 = p2;   
    }
    
    
    /**
     * Testing method for a game turn.
     */
    public void tourDeJeu()
    {
        System.out.println("Moving Bugs, Wolfie and Gros Bill.");
        bugs.deplace();
        wolfie.deplace();
        grosBill.deplace();
        System.out.println("Merlin try to cast a spell on bugs.");
        merlin.combattre(bugs);
        System.out.println("Gros Bill try to hit the peon.");
        grosBill.combattre(peon);
        System.out.println("Robin try to hit Wolfie");
        robin.combattre(wolfie);
        System.out.println("Wolfie try to bite Gros Bill");
        wolfie.combattre(grosBill);
    }
    
    
    /**
     * Display the information about all the characters into the terminal.
     */
    public void afficheWorld()
    {
        robin.affiche();
        System.out.println("----------------------------------------------------------------------");
        peon.affiche();
        System.out.println("----------------------------------------------------------------------");
        bugs.affiche();
        System.out.println("----------------------------------------------------------------------");
        bunny.affiche();
        System.out.println("----------------------------------------------------------------------");
        guillaumeT.affiche();
        System.out.println("----------------------------------------------------------------------");
        grosBill.affiche();
        System.out.println("----------------------------------------------------------------------");
        merlin.affiche();
        System.out.println("----------------------------------------------------------------------");
        wolfie.affiche();
    }
    
    
}
