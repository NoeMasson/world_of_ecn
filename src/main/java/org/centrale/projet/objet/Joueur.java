/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;
import java.util.Random;

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
        } catch (ClassNotFoundException e) {
            System.out.println("A ClassNotFoundException occurs.");
            PlayerCreationException ex = new PlayerCreationException("Can't create object of class "+classeName);
            throw ex;
        } catch (InstantiationException e) {
            System.out.println("A InstantiationException occurs.");
            PlayerCreationException ex = new PlayerCreationException("Can't create object of class "+classeName);
            throw ex;
        } catch (IllegalAccessException e) {
            System.out.println("A IllegalAccessException occurs.");
            PlayerCreationException ex = new PlayerCreationException("Can't create object of class "+classeName);
            throw ex;
        }
        perso.setNom(name);
        
        Random rand = new Random();
        
        perso.setPtVie(80 + rand.nextInt(20));
        perso.setDegAtt(10+rand.nextInt(10));
        perso.setDegMag(5+rand.nextInt(10));
        perso.setDistAttMax(1);
        perso.setPos(new Point2D(0,0));
        perso.setPourcentageAtt(20+rand.nextInt(80));
        perso.setPourcentageMag(20+rand.nextInt(80));
        perso.setPourcentagePar(10+rand.nextInt(90));
        perso.setPourcentageResistMag(10+rand.nextInt(90));
        perso.setPtMana(10+rand.nextInt(10));
        perso.setPtPar(5+rand.nextInt(5));
        if(classeName.contains("Guerrier"))
        {
            perso.setDegMag(15+rand.nextInt(10));
            perso.setPourcentageAtt(50+rand.nextInt(50));
            perso.setPourcentagePar(40+rand.nextInt(60));
            perso.setPtPar(10+rand.nextInt(5));
        }
        else if(classeName.contains("Archer"))
        {
            perso.setDistAttMax(rand.nextInt(8));
            ((Archer)perso).setNbFleches(rand.nextInt(30));
        }
        else if(classeName.contains("Mage"))
        {
            perso.setDegMag(10+rand.nextInt(15));
            perso.setDistAttMax(rand.nextInt(5));
            perso.setPourcentageMag(70+rand.nextInt(30));
            perso.setPourcentageResistMag(40+rand.nextInt(60));
            perso.setPtMana(30+rand.nextInt(10));
        }
        
    }
    
}
