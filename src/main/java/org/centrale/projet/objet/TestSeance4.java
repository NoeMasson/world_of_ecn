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
public class TestSeance4 {
    
    public static void main(String args[])
    {
        /** 
         * Variables pour la définition du monde de test.
         * 
         * */
        int nbProta = 10;
        int nbObj = 5;
        int sizeMap = 20;
        
        
        /**
         * Affichage du monde.
         */
        World testingWorld = new World(nbProta, nbObj, sizeMap);
        
        testingWorld.afficheWorld();
               
        
        /**
         * Boucle de parcours des protagonistes.
         */
        /* Iterator<Creature> listIt = testingWorld.protagonistes.iterator();
        while(listIt.hasNext()){
            Creature p = listIt.next();
            p.affiche();
        } */ 
        
        /**
         * Tests de performance différentes Collections
         */
        System.out.println("\n------------------------------------------------------------------------------------------\n");
        System.out.println("Test de performances avec une collections de 100 Creatures.");
        timeTest(100);
        System.out.println("\n------------------------------------------------------------------------------------------\n");
        System.out.println("Test de performances avec une collections de 1000 Creatures.");
        timeTest(1000);
        System.out.println("\n------------------------------------------------------------------------------------------\n");
        System.out.println("Test de performances avec une collections de 10000 Creatures.");
        timeTest(10000);
        System.out.println("\n------------------------------------------------------------------------------------------\n");
        System.out.println("Test de performances avec une collections de 100000 Creatures.");
        timeTest(100000);
        System.out.println("\n------------------------------------------------------------------------------------------\n");
        System.out.println("Test de performances avec une collections de 1000000 Creatures.");
        timeTest(1000000);
        System.out.println("\n------------------------------------------------------------------------------------------\n");
       
              
    }
    
    
    public static void timeTest(int nbProta2)
    {
        int nbObj, sizeMap;
        nbObj = 5; 
        
        long debut, fin;
        
        sizeMap = 2 * (int) Math.ceil(Math.sqrt(nbProta2));

        World tempsWorld = new World(nbProta2, nbObj, sizeMap);
        Iterator<Creature> listIt = tempsWorld.getProtagonistes().iterator();
        //tempsWorld.afficheWorld();

        // Parcours avec iterator :
        
        debut = System.nanoTime();
        while(listIt.hasNext()){
            Creature p = listIt.next();
        }
        fin = System.nanoTime();                   
        System.out.println("Le parcours avec iterator a duré "+(fin-debut)+"ns");
        
        // Parcours avec indice :
        
        debut = System.nanoTime();
        for(int i=0; i<nbProta2; i++){
            Creature p = tempsWorld.getProtagonistes().get(i);
        }
        fin = System.nanoTime();
        System.out.println("Le parcours avec indice a duré "+(fin-debut)+"ns");
    }
    
}
