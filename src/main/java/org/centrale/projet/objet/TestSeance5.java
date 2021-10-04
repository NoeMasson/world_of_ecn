package org.centrale.projet.objet;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Valentin Molina
 * @author Noe Masson
 */
public class TestSeance5 {
    
    public static void main(String args[])
    {
        /** 
         * Variables used to create a testing word.
         * */
        int nbProta = 10;
        int nbObj = 5;
        int sizeMap = 20;
        World testingWorld = new World(nbProta, nbObj, sizeMap);
        
        
        /**
         * Print data about the world and a simple map.
         */
        testingWorld.afficheWorld();
        
        /**
         * Test the player creation.
         */
        try {
            testingWorld.creationJoueur();
            testingWorld.getJoueur().getPerso().affiche();
        } catch(PlayerCreationException e){
            System.out.println("Un problème est survenu lors de la création du joueur. Voici l'erreur :");
            System.out.print(e.getMessage());
        }
    }
    
}
