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
public class Mage extends Personnage implements Combattant{
    
    
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
     * @param ptPar The amount of damage that the character can counter.
     */
    public Mage(String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, 
            int dA, int dM, int distMax, Point2D pos, int ptPar)
    {
        super(nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
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
        this.setNom("Mage");
    }
    
    
    /**
     * The Mage try to cast a spell on his opponent.
     * It the Mage succeed the cast of this spell the opponent can try to 
     * counter it.
     * @param opponent 
     */
    @Override
    public void combattre(Creature opponent)
    {
        // Tchecking if the opponent is in the range.
        if((opponent.getPos().distance(this.getPos()) > this.getDistAttMax()) 
                || (opponent.getPos().distance(this.getPos()) < 1))
        {
            System.out.println("The opponent " + opponent.getNom() + 
                    " is to far from the Mage " + this.getNom());
            return;
        }
        
        // Tchecking the amount of mana.
        if(this.getPtMana() <= 0)
        {
            System.out.println("The Mage " + this.getNom() + 
                    " has not enough mana.");
            return;
        }
        this.setPtMana(this.getPtMana() - 1);
        
        Random rand = new Random();
        
        // random value between 1 (inclusive) and 100 (inclusive).
        int rollTheDice = 1 + rand.nextInt(100); 
        
        // Tchecking the success of the magical attack.
        if(rollTheDice < this.getPourcentageMag())
        {
            System.out.println("The Mage " + this.getNom() + 
                    " miss his attack.");
            return;
        }
        System.out.println("The Mage " + this.getNom() + 
                " succeeds in this attack and hit " + opponent.getNom() +
                " with a spell.");
        
        // Tchecking the success of the counter.
        int rollTheDiceDefence = 1 + rand.nextInt(100); 
        if(rollTheDiceDefence < opponent.getPourcentageResistMag())
        {
            System.out.println("The opponent " + opponent.getNom() + 
                    " fails to counter the attack.");
            opponent.setPtVie(Math.max(0, 
                    opponent.getPtVie() - this.getDegMag()));
        }
        System.out.println("The opponent " + opponent.getNom() + 
                    " counters the attack.");
        opponent.setPtVie(Math.max(0, 
                opponent.getPtVie() - Math.max(0, 
                        this.getDegMag() - opponent.getPtPar())));
    }
}
