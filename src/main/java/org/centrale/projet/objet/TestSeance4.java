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
        Point2D bary1 = new Point2D();
        Point2D bary2 = new Point2D();
        
        sizeMap = 2 * (int) Math.ceil(Math.sqrt(nbProta2));

        System.out.print("Generating testing world of "+sizeMap+"x"+sizeMap+" ... ");
        World tempsWorld = new World(nbProta2, nbObj, sizeMap);
        System.out.print("Done.\n ");
        //tempsWorld.afficheWorld();

        // Parcours avec iterator :
        
        debut = System.nanoTime();
        Iterator<Creature> listIt = tempsWorld.getProtagonistes().iterator();
        bary1 = listIt.next().getPos();
        while(listIt.hasNext()){
            bary1 = bary1.barycentre(listIt.next().getPos());
        }
        fin = System.nanoTime();                   
        System.out.println("Le parcours avec iterator a duré "+(fin-debut)+"ns");
        System.out.println("Le barycentre se situe en : ("+bary1.getX()+","+bary1.getY()+")");
        
        // Parcours avec indice :
        
        debut = System.nanoTime();
        bary2 = tempsWorld.getProtagonistes().get(0).getPos();
        for(int i=1; i<nbProta2; i++){
            bary2 = bary2.barycentre(tempsWorld.getProtagonistes().get(i).getPos());
        }
        fin = System.nanoTime();
        System.out.println("Le parcours avec indice a duré "+(fin-debut)+"ns");
        System.out.println("Le barycentre se situe en : ("+bary2.getX()+","+bary2.getY()+")");
    }
}
