/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;
import java.io.*;
import java.util.*;
/**
 *
 * @author Noé Masson
 * @author Valentin Molina
 * 
 * Class allowing to save a game in the World Of ECN project
 */
public class SauvegardePartie {

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the writer
     */
    public BufferedWriter getWriter() {
        return writer;
    }

    /**
     * @param writer the writer to set
     */
    public void setWriter(BufferedWriter writer) {
        this.writer = writer;
    }
    
    private String fileName;
    private BufferedWriter writer;
    
    protected SauvegardePartie(){
        fileName = "testSave.txt";
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    protected SauvegardePartie(String name){
        fileName = name;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
        }
        // on attrape l'exception si on a pas pu creer le fichier
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void sauvegarderPartie(World world){
        try{
            //Saving Size of the world
            writer.write("Largeur "+world.getLargeur());
            writer.newLine();
            writer.write("Longueur "+world.getLongueur());
            writer.newLine();
            //Saving informations about the creatures
            Iterator<Creature> listIt = world.getProtagonistes().iterator();
            while(listIt.hasNext()){
                writer.write(listIt.next().getTexteSauvegarde());
                writer.newLine();
            }
            // Saving objects
            Iterator<Objet> listObjets = world.getObjets().iterator();
            while(listObjets.hasNext()){
                writer.write(listObjets.next().getTexteSauvegarde());
                writer.newLine();
            }
            
            writer.write(world.getJoueur().getTexteSauvegarde());
            writer.newLine();
        }
        
        
        
        // on attrape l'exception si on a pas pu creer le fichier
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } 
        // on attrape l'exception si il y a un probleme lors de l'ecriture dans le fichier
        catch (IOException ex) {
            ex.printStackTrace();
        }
        // on ferme le fichier
        finally {
            try {
                if (writer != null) {
                // je force l'Ã©criture dans le fichier
                    writer.flush();
                // puis je le ferme
                    writer.close();
                }
            }
            // on attrape l'exception potentielle 
            catch (IOException ex) {
                ex.printStackTrace();
                }
            }
    }
}
        
    