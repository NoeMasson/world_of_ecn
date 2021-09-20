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
    
    public Lapin(int ptV, int pA, int pP, int dA, Point2D pos)
    {
        super(ptV, pA, pP, dA, pos);
    }
    
    public Lapin(Lapin l)
    {
        super(l);
    }
    
    public Lapin()
    {
        super();
    }
}
