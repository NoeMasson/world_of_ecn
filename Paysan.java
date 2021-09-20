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
public class Paysan extends Personnage {
    
    public Paysan(String nom, int ptV, int ptM, int pA, 
            int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos)
    {
        super(nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos);
    }
    
    public Paysan(Paysan perso)
    {
        super(perso);
    }
    
    public Paysan()
    {
        super();
    }
}
