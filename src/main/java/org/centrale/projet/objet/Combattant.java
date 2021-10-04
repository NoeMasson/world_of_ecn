/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * This interface specify the implementation of a method used to make a 
 * character fight with another one.
 * @author Valentin Molina valentin@molina.pro
 * @author Noé Masson
 */
public interface Combattant {
    
    public void combattre(Creature opponent);
}
