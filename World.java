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
     * A Lapin
     */
    public Lapin bugs;
    
    /**
     * Constructor for a new world
     */
    public World()
    {
        robin = new Archer("robin", 100, 100, 15, 2, 1, 1, 10, 1, 5, 
                new Point2D(0,0), 10);
        peon = new Paysan("peon", 100, 0, 0, 0, 0, 0, 0, 0, 0, 
                new Point2D(0,0));
        bugs = new Lapin(500, 90, 90, 50, new Point2D(0,0));
        this.creeMondeAlea();
    }
    
    /**
     * For a created map, place the characters randomly following certain proximity rules
     */
    public final void creeMondeAlea()
    {
        Random rand = new Random();
        
        int size = 20;
        
        // Positionning the first character : robin.
        int xR = rand.nextInt(size);
        int yR = rand.nextInt(size);
        robin.setPos(new Point2D(xR,yR));
        
        // Positionning the second character : peon.
        int xP = rand.nextInt(size);
        int yP = rand.nextInt(size);
        while((xP == xR && yP == yR) ||
               Math.sqrt((xR - xP)*(xR - xP) + (yR - yP)*(yR - yP)) > 5)
        {
            xP = rand.nextInt(size);
            yP = rand.nextInt(size);
        }
        peon.setPos(new Point2D(xP, yP));
        
        // Positionning the third character : bugs.
        int xB = rand.nextInt(size);
        int yB = rand.nextInt(size);
        while((xP == xB && yP == yB) || (xR == xB && yR == yB) ||
               Math.sqrt((xR - xB)*(xR - xB) + (yR - yB)*(yR - yB)) > 5 ||
               Math.sqrt((xB - xP)*(xB - xP) + (yB - yP)*(yB - yP)) > 5)
        {
            xB = rand.nextInt(size);
            yB = rand.nextInt(size);
        }
        bugs.setPos(new Point2D(xB, yB));
        
    }
    
    
}
