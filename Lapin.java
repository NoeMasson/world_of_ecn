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
     * Constructor which specify all attributes.
     * @param ptV Number of health point of the character
     * @param pA Percentage corresponding to the success of an attack.
     * @param pP Percentage corresponding to the success of a parade.
     * @param dA The amount of damage that inflict the character.
     * @param pos The position of the character on the map.
     */
    public Lapin(int ptV, int pA, int pP, int dA, Point2D pos)
    {
        super(ptV, pA, pP, dA, pos);
    }
    
    /**
     * Constructor using another Lapin
     * @param l 
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
    }
}
