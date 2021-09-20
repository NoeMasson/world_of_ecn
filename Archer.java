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
public class Archer extends Personnage {

    private int nbFleches;
    
    /**
     * @return the nbFleches
     */
    public int getNbFleches() {
        return nbFleches;
    }

    /**
     * @param nbFleches the nbFleches to set
     */
    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }
    
    public Archer(String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, 
            int dA, int dM, int distMax, Point2D pos, int nbF)
    {
        super(nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos);
        nbFleches = nbF;
    }
    
    public Archer(Archer perso)
    {
        super(perso);
        nbFleches = perso.getNbFleches();
    }
    
    public Archer()
    {
        super();
    }
    
    public void affiche()
    {
        super.affiche();
        System.out.println("Ce personnage est un archer qui possède " + 
                nbFleches+ " flèches.");
    }
}
