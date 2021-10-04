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
public class Joueur {

    /**
     * @return the perso
     */
    public Personnage getPerso() {
        return perso;
    }

    /**
     * @param perso the perso to set
     */
    public void setPerso(Personnage perso) {
        this.perso = perso;
    }
    
    /**
     * The Personnage player by the player.
     */
    private Personnage perso ;
    
    /**
     * Only Player constructor. Used by World.
     * @param classeName The Class selected by the player.
     * @param name The name of the player.
     * @throws PlayerCreationException Raise this expression if the class can't 
     * be created.
     */
    public Joueur(String classeName, String name) throws PlayerCreationException
    {
        try{
            Class classType = Class.forName(classeName);
            perso = (Personnage) classType.newInstance();
            perso.setNom(name);
        } catch (ClassNotFoundException e) {
            System.out.println("A ClassNotFoundException occurs.");
            // Does not seem to be an issue with this exception... exception should be hidden by the finally.
            System.out.print(e.getCause());
            PlayerCreationException ex = new PlayerCreationException("Can't create object of class "+classeName);
            throw ex;
        }
        finally {
            PlayerCreationException e = new PlayerCreationException("Can't create object of class "+classeName);
            throw e;
        } 
    }
    
}
