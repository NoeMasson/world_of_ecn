/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 *
 * @author Valentin Molina valentin@molina.pro
 * @author Noé Masson
 */
public class TestSeance1 {
 
    public static void main(String args[])
    {
        System.out.print("Creation of a testing world... ");
        World testingWorld = new World();
        System.out.print("Done.\n");
        
        System.out.println("Here are the information about testing character robin :");
        testingWorld.robin.affiche();
        
        System.out.println("Here are the information about testing character peon :");
        testingWorld.peon.affiche();
        
        System.out.println("Here are the information about testing character bugs :");
        testingWorld.bugs.affiche();
    }
}
