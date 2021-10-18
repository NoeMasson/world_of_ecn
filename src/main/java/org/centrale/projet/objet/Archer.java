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
public class Archer extends Personnage implements Combattant{

    /**
     * The number of arrows that remain to the archer.
     */
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
    
    
    /**
     * Archer constructor which specify all the attributes.
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
     * @param ptPar The amount of damage that the character can counter.
     * @param nbF The number of arrow of the archer.
     */
    public Archer(String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, 
            int dA, int dM, int distMax, Point2D pos, int ptPar, int nbF)
    {
        super(nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
        nbFleches = nbF;
    }
    
    
    /**
     * Archer copy constructor.
     * @param perso : Archer to copy.
     */
    public Archer(Archer perso)
    {
        super(perso);
        nbFleches = perso.getNbFleches();
    }
    
    
    /**
     * Default constructor for Archer. 
     * Each variables is initiated with default values (0 for int, null for 
     * String, (0,0) for Point2D, ...)
     */
    public Archer()
    {
        super();
        this.setNom("Archer");
    }
    
    
    /**
     * Print the values of each attributes into the terminal.
     */
    public void affiche()
    {
        super.affiche();
        System.out.println("Ce personnage est un archer qui possède " + 
                nbFleches+ " flèches.");
    }
    
    /**
     * If the attack is successful the Archer hit the opponent with an arrow.
     * In both cases, the Archer loses an arrow.
     * @param opponent The Creature on which the Archer is shooting.
     */
    @Override
    public void combattre(Creature opponent)
    {
        // Tchecking if the opponent is in the range.
        if((opponent.getPos().distance(this.getPos()) > this.getDistAttMax())
                || (opponent.getPos().distance(this.getPos()) <= 1))
        {
            System.out.println("The opponent " + opponent.getNom() + 
                    " is to far from the Archer " + this.getNom());
            return;
        }
        
        // Tchecking the number of arrow.
        if(nbFleches <= 0)
        {
            System.out.println("The Archer " + this.getNom() + 
                    " has not enough arrow.");
            return;
        }
        nbFleches--;
        
        Random rand = new Random();
        
        // random value between 1 (inclusive) and 100 (inclusive).
        int rollTheDice = 1 + rand.nextInt(100); 
        
        if(rollTheDice < this.getPourcentageAtt())
        {
            System.out.println("The Archer " + this.getNom() + 
                    " miss his attack.");
            return;
        }
        System.out.println("The Archer " + this.getNom() + 
                " succeeds in this attack and hit " + opponent.getNom() +
                " with an arrow.");
        opponent.setPtVie(Math.max(0, opponent.getPtVie() - this.getDegAtt()));
    }
    
    /**
     * 
     * @return string corresponding to the caracteristics of the Archer
     * @Override overides the Creature methode
     * 
     */
    public String getTexteSauvegarde(){
        return("Archer "+getNom()+" "+getPtVie()+" "+getPtMana()+" "+getPourcentageAtt()+" "
                +getPourcentageMag()+" "+getPourcentagePar()+" "
                +getPourcentageResistMag()+" "+getDegAtt()+" "+getDegMag()+" "+getDistAttMax()
                +" "+getPtPar()+" "+nbFleches+" "+getPos().getX()+" "+getPos().getY());
        
        
   
    }
}
