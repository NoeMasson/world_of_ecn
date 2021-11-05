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
        SauvegardePartie save = new SauvegardePartie(); 
        
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("                            Bienvenue dans World Of ECN                         ");
        System.out.println("");
        System.out.println("                       Un jeu de Noé Masson et Valentin Molina                  ");
        System.out.println("");
        System.out.println("                                      2021-2022                                 ");
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("Voulez-vous charger une partie ou en commencer une nouvelle ?");
        System.out.println("1 - Charger une partie.");
        System.out.println("2 - Nouvelle partie.");
        System.out.println("");
        System.out.println("Entrez le numéro correspond à votre choix : ");

        int choice = 0;
        while(choice != 1 && choice != 2){
            try{
                choice = Integer.parseInt(in.nextLine());
            } catch(NumberFormatException ex) {
                System.out.println("Vous devez entrer un entier ! Recommencez :");
            }    
        }
        
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("");
        
        switch(choice){
            case 1 -> 
            {
                //To test
                boolean loaded = false;

                while(!loaded){

                System.out.println("Rentrez le nom du fichier que vous souhaitez charger (sans le .txt de fin)");
                String file;
                file = in.nextLine();
                String fileName = file + ".txt";

                save.setFileName(file);

                try {
                ChargementPartie loader = new ChargementPartie(fileName);
                world = loader.chargerPartie();
                loaded = true;

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
                
                System.out.println("");
                System.out.println("Chargement réussi !");
            }
            case 2 -> {
                //To test
                System.out.println("Voulez-vous donner un nom à votre partie ?");
                System.out.println("1 - Oui.");
                System.out.println("2 - Non.");
                System.out.println("");
                System.out.println("Entrez le numéro correspond à votre choix : ");
                int choice2 = 0;
                while(choice2 != 1 && choice2 != 2){
                    try{
                        choice2 = Integer.parseInt(in.nextLine());
                    } catch(NumberFormatException ex) {
                    System.out.println("Vous devez entrer un entier ! Recommencez :");
                    }    
                }
                switch(choice2){

                    case 1 ->{

                        System.out.println("Entrez le nom du fichier (sans le .txt de fin):");
                        String file = in.nextLine() + ".txt";
                        save.setFileName(file);
                        }

                    case 2 ->{
                        System.out.println("Le nom de la sauvegarde est : "+ save.getFileName());
                    }
                }
                world = new World();
                try{
                    world.creationJoueur();
                } catch(PlayerCreationException e) {
                    System.err.println("[ERROR]"+e);
                    System.err.println("[ERROR] Abort...");
                    return;
                }
                
            }
        }
            
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("");
        
        choice = 0;
        while(choice != 4)
        {
            System.out.println("Que voulez-vous faire ?");
            System.out.println("1 - Jouer un tour de jeu");
            System.out.println("2 - Sauvegarder");
            System.out.println("3 - Sauvegarder et quitter");
            System.out.println("4 - Quitter");
            System.out.println("");
            System.out.println("Entrez le numéro correspond à votre choix : ");

            while(choice != 1 && choice != 2 && choice != 3 && choice != 4){
                try{
                    choice = Integer.parseInt(in.nextLine());
                } catch(NumberFormatException ex) {
                    System.out.println("Vous devez entrer un entier ! Recommencez :");
                }    
            }

            switch(choice){
                case 1 -> {
                    world.tourDeJeu();
                    choice = 0;
                }
                case 2 -> {
                    save.sauvegarderPartie(world);
                    choice = 0;
                }
                case 3 -> {
                    save.sauvegarderPartie(world);
                    choice = 4;
                }
                case 4 -> {
                    break;
                }
            }
            
            System.out.println("");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("");
            
        }
        
        System.out.println("Aurevoir.");
        
    }
}
