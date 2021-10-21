/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 * 
 * @author Valentin Molina
 * @author Noe Masson
 */
public class Loup extends Monstre implements Combattant{
    
    
    /**
     * Constructor of Loup which specifies all attributes.
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
    public Loup(String nom, int ptV, int pA, int pP, int rM, int dA, 
            int distMax, Point2D pos, int ptPar)
    {
        super(nom, ptV, pA, pP, rM, dA, distMax, pos, ptPar);
    }
    
    /**
     * Copy constructor for Loup.
     * @param l Lapin to copy.
     */
    public Loup(Loup l)
    {
        super(l);
    }
    
    /**
     * Constructor without specifying anything.
     */
    public Loup()
    {
        super();
        this.setNom("Loup");
    }
    
    
    /**
     * Constructor used to load a Mage with data from a save file.
     * @param data A line of data coming from a save file.
     * @throws org.centrale.projet.objet.WrongSaveFileFormatException
     */
    public Loup(String data) throws WrongSaveFileFormatException
    {
        super(data);
    }
    
    
    /**
     * Fighting method for the Loup. 
     * The Loup can hit a Creature adjacent.
     * If the Loup succeed his attack the opponent can try to counter.
     * @param opponent The opponent that the Loup try to hit.
     */
    @Override
    public void combattre(Creature opponent)
    {
        // Tchecking if the opponent is in the range.
        // Adjacent cases are a distance of 1 or sqrt(2).
        if(opponent.getPos().distance(this.getPos()) >= 2)
        {
            System.out.println("The opponent " + opponent.getNom() + 
                    " is to far from the Loup " + this.getNom());
            return;
        } 
        
        Random rand = new Random();
        
        // random value between 1 (inclusive) and 100 (inclusive).
        int rollTheDiceAttack = 1 + rand.nextInt(100); 
        
        // Tchecking the success of the attack.
        if(rollTheDiceAttack < this.getPourcentageAtt())
        {
            System.out.println("The Loup " + this.getNom() + " miss his attack.");
            return;
        }
        System.out.println("The Loup " + this.getNom() + 
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
     * @return string corresponding to the caracteristics of the Loup
     * @Override overides the Creature methode
     * 
     */
    public String getTexteSauvegarde(){
        return("Loup "+getNom()+" "+getPtVie()+" "+getPourcentageAtt()+" "
                +getPourcentagePar()+" "+
                +getPourcentageResistMag()+" "+getDegAtt()+" "+getDistAttMax()
                +" "+getPtPar()+" "+getPos().getX()+" "+getPos().getY());
        
        
   
    }
}
