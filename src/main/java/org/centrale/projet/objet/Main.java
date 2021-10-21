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
        String fileName = "Sauvegarde-WoE.txt";
        System.out.println("Opening file " + fileName);
        World world;
        try {
            ChargementPartie loader = new ChargementPartie(fileName);
            world = loader.chargerPartie();
            world.afficheWorld();
            SauvegardePartie save = new SauvegardePartie("testSave.txt");
            save.sauvegarderPartie(world);
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
}
