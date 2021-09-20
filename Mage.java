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
public class Mage extends Personnage {
    
    
    /**
     * Mage constructor which specify all the attributes.
     * @param nom Name of the character.
     * @param ptV Number of health point of the character
     * @param ptM Number of mana point of the character.
     * @param pA Percentage corresponding to the success of an attack.
     * @param pP Percentage corresponding to the success of a parade
     * @param pM Percentage corresponding to the success of a magical attack.
     * @param rM Percentage corresponding to the resistance to magical attack.
     * @param dA The amount of damage that inflict the character.
     * @param dM The amount of magical damage that inflict the character.
     * @param distMax The range at which the character can access.
     * @param pos The position of the character on the map.
     * @param nbF The number of arrow of the archer.
     */
    public Mage(String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, 
            int dA, int dM, int distMax, Point2D pos, int nbF)
    {
        super(nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos);
    }
    
    
    /**
     * Mage copy constructor.
     * @param perso : Archer to copy.
     */
    public Mage(Mage perso)
    {
        super(perso);
    }
    
    
    /**
     * Default constructor for Archer. 
     * Each variables is initiated with default values (0 for int, null for 
     * String, (0,0) for Point2D, ...)
     */
    public Mage()
    {
        super();
    }
    
}
