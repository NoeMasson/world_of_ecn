/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Noé Masson
 * @author Valentin Molina valentin@molina.pro
 */
public class Main {
    
    public static void main(String[] argv){
        String fileName = "Sauvegarde-WoE.txt";
        try {
            ChargementPartie loader = new ChargementPartie(fileName);
            World world = loader.chargerPartie();
        } catch(FileNotFoundException e){
            System.out.println("File not found.");
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch(WrongSaveFileFormatException e){
            System.out.println(e.getMessage());
        }
    }
    
}
