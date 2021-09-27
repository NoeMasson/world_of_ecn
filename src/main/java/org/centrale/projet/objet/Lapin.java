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
public class Lapin extends Monstre {
    
    /**
     * Constructor of Lapin which specifies all attributes.
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
    public Lapin(String nom, int ptV, int pA, int pP, int rM, int dA, 
            int distMax, Point2D pos, int ptPar)
    {
        super(nom, ptV, pA, pP, rM, dA, distMax, pos, ptPar);
    }
    
    /**
     * Copy constructor for Lapin.
     * @param l Lapin to copy.
     */
    public Lapin(Lapin l)
    {
        super(l);
    }
    
    /**
     * Constructor without specifying anything.
     */
    public Lapin()
    {
        super();
        this.setNom("Lapin");
    }
}
