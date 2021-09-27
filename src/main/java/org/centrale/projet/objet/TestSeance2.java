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
public class TestSeance2 {
    
    public static void main(String args[])
    {
        System.out.print("Creation of a testing world... ");
        World testingWorld = new World();
        System.out.print("Done.\n");
        
        System.out.println("Here are the information about the testing world :");
        testingWorld.afficheWorld();
        System.out.println("");
        
        System.out.println("--------------------- Playing 4 game turns : -------------------------");
        System.out.println("");
        for(int i = 0 ; i < 4 ; i ++)
        {
            testingWorld.tourDeJeu();
            System.out.println("--------------------- Result of the turn " + i + " : ---------------------");
            System.out.println("");
            testingWorld.afficheWorld();
            System.out.println("");
            
        }
        
    }
    
}
