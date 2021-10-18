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
public class Guerrier extends Personnage implements Combattant{
    
    /**
     * Guerrier constructor which specify all the attributes.
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
    public Guerrier(String nom, int ptV, int ptM, int pA, int pP, int pM, 
            int rM, int dA, int dM, int distMax, Point2D pos, int ptPar)
    {
        super(nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
    }
    
    
    /**
     * Copy constructor for Guerrier.
     * @param guerrier : Guerrier to copy.
     */
    public Guerrier(Guerrier guerrier)
    {
        super(guerrier);
    }
    
    
    /**
     * Default constructor for Guerrier. 
     * Each variables is initiated with default values (0 for int, null for 
     * String, (0,0) for Point2D, ...)
     */
    public Guerrier()
    {
        super();
        this.setNom("Guerrier");
    }
    
    
    /**
     * Fighting method for the Warrior. 
     * The Warrior can hit a Creature adjacent.
     * If the Warrior succeed his attack the opponent can try to counter.
     * @param opponent The opponent that the Warrior try to hit.
     */
    @Override
    public void combattre(Creature opponent)
    {
        // Tchecking if the opponent is in the range.
        // Adjacent cases are a distance of 1 or sqrt(2).
        if(opponent.getPos().distance(this.getPos()) >= 2)
        {
            System.out.println("The opponent " + opponent.getNom() + 
                    " is to far from the Warrior " + this.getNom());
            return;
        } 
        
        Random rand = new Random();
        
        // random value between 1 (inclusive) and 100 (inclusive).
        int rollTheDiceAttack = 1 + rand.nextInt(100); 
        
        // Tchecking the success of the attack.
        if(rollTheDiceAttack < this.getPourcentageAtt())
        {
            System.out.println("The Warrior " + this.getNom() + " miss his attack.");
            return;
        }
        System.out.println("The Warrior " + this.getNom() + 
                " succeeds in this attack and hit " + opponent.getNom() );
        
        // Tchecking the success of the counter.
        int rollTheDiceDefence = 1 + rand.nextInt(100); 
        if(rollTheDiceDefence < opponent.getPourcentagePar())
        {
            System.out.println("The opponent " + opponent.getNom() + 
                    " fails to counter the attack.");
            opponent.setPtVie(Math.max(0, 
                    opponent.getPtVie() - this.getDegAtt()));
        }
        System.out.println("The opponent " + opponent.getNom() + 
                    " counters the attack.");
        opponent.setPtVie(Math.max(0, 
                opponent.getPtVie() - Math.max(0, 
                        this.getDegAtt() - opponent.getPtPar())));
        
    }
    
    /**
     * 
     * @return string corresponding to the caracteristics of the Guerrier
     * @Override overides the Creature methode
     * 
     */
    public String getTexteSauvegarde(){
        return("Guerrier "+getNom()+" "+getPtVie()+" "+" "+getPtMana()+" "+getPourcentageAtt()+" "
                +getPourcentageMag()+" "+getPourcentagePar()+" "
                +getPourcentageResistMag()+" "+getDegAtt()+" "+getDegMag()+" "+getDistAttMax()
                +" "+getPtPar()+" "+getPos().getX()+" "+getPos().getY());
        
        
   
    }
    
}
