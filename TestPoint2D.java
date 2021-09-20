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
public class TestPoint2D {
    
    public static void main(String args[])
    {
        Random generator = new Random();
        
        Point2D p1 = new Point2D();
        System.out.println("Valeur du point p1 initialisé par \"Point2D p1 = new Point2D()\" :");
        p1.affiche();
        System.out.println("Translation de p1 en (1,1) par \"p1.translate(1,1)\" : ");
        p1.translate(1,1);
        p1.affiche();
        System.out.println("Changement de coordonnée de p1 en (2,2) par \"p1.setPosition(2,2)\" :");
        p1.setPosition(2,2);
        p1.affiche();
        
        System.out.println("Valeur du point p2 après copie de p1 par \"Point2D p2 = new Point2D(p1)\" : ");
        Point2D p2 = new Point2D(p1);
        p2.affiche();
        
        System.out.println("Translation de p1 de (-1,-1).");
        p1.translate(-1, -1);
        System.out.print("p1 vaut alors : "); p1.affiche();
        System.out.print("p2 vaut alors : "); p2.affiche();
        
        Random rand = new Random();
        
        System.out.println("Generation de trois Point2D aléatoire :");
        for(int i=0; i<3; i++)
        {
            int x = rand.nextInt(100);
            int y = rand.nextInt(100);
            System.out.print("Point2D en ("+x+","+y+") : ");
            Point2D p = new Point2D(x, y);
            p.affiche();
        }
    }
}
