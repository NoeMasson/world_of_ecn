/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Noé Masson
 * @author Valentin Molina valentin@molina.pro
 */
public class Main {
    
    public static void main(String[] argv){
        World world = null;
        java.util.Scanner in = new java.util.Scanner(System.in);
        while(world == null)
        {
            System.out.println("Voulez-vous charger une partie ou en commencer une nouvelle ?");
            System.out.println("1 - Charger une partie.");
            System.out.println("2 - Nouvelle partie.");
            System.out.println("");
            System.out.print("Entrez le numéro correspond à votre choix : ");
            
            int choice = 0;
            while(choice != 1 && choice != 2){
                try{
                    choice = Integer.parseInt(in.nextLine());
                } catch(NumberFormatException ex) {
                    System.out.println("Vous devez entrer un entier ! Recommencez :");
                }    
            }
            
            switch(choice){
                case 1 -> 
                {
                    //To finish
                    try {
                    ChargementPartie loader = new ChargementPartie(fileName);
                    world = loader.chargerPartie();

                    } catch(FileNotFoundException e){
                        System.out.println("File not found.");
                    } catch(IOException ex) {
                        ex.printStackTrace();
                    } catch(WrongSaveFileFormatException e){
                        System.out.println(e.getMessage());
                    } catch (InstantiationException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvocationTargetException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                case 2 -> {
                    //To finish
                }
            }
            
            
        }
        
        int choice = 0;
        while(choice != 4)
        {
            System.out.println("Que voulez-vous faire ?");
            System.out.println("1 - Jouer un tour de jeu");
            System.out.println("2 - Sauvegarder");
            System.out.println("3 - Sauvegarder et quitter");
            System.out.println("4 - Quitter");
            System.out.println("");
            System.out.print("Entrez le numéro correspond à votre choix : ");

            while(choice != 1 && choice != 2 && choice != 3){
                try{
                    choice = Integer.parseInt(in.nextLine());
                } catch(NumberFormatException ex) {
                    System.out.println("Vous devez entrer un entier ! Recommencez :");
                }    
            }

            switch(choice){
                case 1 -> {
                    world.tourDeJeu();
                }
                case 2 -> {
                    // to finish
                }
                case 3 -> {
                    //to finish
                    choice = 4;
                }
            }
        }
        
        System.out.println("");
        System.out.println("Aurevoir.");
        
    }
}
