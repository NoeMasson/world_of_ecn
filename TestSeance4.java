package org.centrale.projet.objet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Valentin Molina
 * @author Noe Masson
 */
public class TestSeance4 {
    
    public static void main(String args[])
    {
        /** 
         * Variables pour la définition du monde
         * 
         * */
        int nbProta;
        int nbObj;
        int sizeMap;
        
        nbProta = 10;
        nbObj = 5; 
        sizeMap = 20;
        
        /**
         * Variables temporelles
         * */
        float debut;
        float fin;
        
        
        
        World testingWorld = new World(nbProta, nbObj, sizeMap);
        
        testingWorld.afficheWorld();
               
        
        
        
        /**
         * Tests de durée des différentes Collections
         */
        debut = System.nanoTime();
        
        // insérer test de durée ici
                        
        fin = System.nanoTime();                   
        System.out.println("Cette opération a duré "+(fin-debut));
        
          
              
    }
    
}
