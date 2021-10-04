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
public abstract class Monstre extends Creature {
    
    
    /**
     * Constructor of Monstre which specifies all attributes.
     * @param nom Name of the character.
     * @param ptV Number of health point of the character
     * @param pA Percentage corresponding to the success of an attack.
     * @param pP Percentage corresponding to the success of a parade
     * @param rM Percentage corresponding to the resistance to magical attack.
     * @param dA The amount of damage that inflict the character.
     * @param distMax The range at which the character can access.
     * @param pos The position of the character on the map.
     * @param ptPar The amount of damage that the character can counter.
     */
    protected Monstre(String nom, int ptV, int pA, int pP, int rM, int dA, 
            int distMax, Point2D pos, int ptPar)
    {
        super(nom, ptV, pA, pP, rM, dA, distMax, pos, ptPar);
    }
    
    /**
     * Copy constructor from another Monster.
     * @param m Monstre to copy.
     */
    protected Monstre(Monstre m)
    {
        super(m);
    }
    
    /**
     * Constructor without specifying anything. Use default values.
     */
    protected Monstre()
    {
        super();
        this.setNom("Monstre");
    }
    
}
