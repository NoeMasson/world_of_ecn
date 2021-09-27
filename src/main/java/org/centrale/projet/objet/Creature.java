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
public class Creature {

    /**
     * @return the ptPar
     */
    public int getPtPar() {
        return ptPar;
    }

    /**
     * @param ptPar the ptPar to set
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the ptVie
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     * @param ptVie the ptVie to set
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    /**
     * @return the pourcentageAtt
     */
    public int getPourcentageAtt() {
        return pourcentageAtt;
    }

    /**
     * @param pourcentageAtt the pourcentageAtt to set
     */
    public void setPourcentageAtt(int pourcentageAtt) {
        this.pourcentageAtt = pourcentageAtt;
    }

    /**
     * @return the pourcentagePar
     */
    public int getPourcentagePar() {
        return pourcentagePar;
    }

    /**
     * @param pourcentagePar the pourcentagePar to set
     */
    public void setPourcentagePar(int pourcentagePar) {
        this.pourcentagePar = pourcentagePar;
    }

    /**
     * @return the pourcentageResistMag
     */
    public int getPourcentageResistMag() {
        return pourcentageResistMag;
    }

    /**
     * @param pourcentageResistMag the pourcentageResistMag to set
     */
    public void setPourcentageResistMag(int pourcentageResistMag) {
        this.pourcentageResistMag = pourcentageResistMag;
    }

    /**
     * @return the degAtt
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     * @param degAtt the degAtt to set
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     * @return the distAttMax
     */
    public int getDistAttMax() {
        return distAttMax;
    }

    /**
     * @param distAttMax the distAttMax to set
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    /**
     * @return the pos
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    
    /**
     * Name of the character.
     */
    private String nom;
    
    /**
     * Number of health point of the character.
     */
    private int ptVie;
    
    /**
     * The percentage corresponding to the success of an attack of the 
     * character.
     */
    private int pourcentageAtt;
    
    /**
     * The percentage corresponding to the success of a parade. 
     */
    private int pourcentagePar;
    
    /**
     * The percentage corresponding to the resistance to magical attack of the 
     * character.
     */
    private int pourcentageResistMag;
    
    /**
     * The amount of damage that inflict the character.
     */
    private int degAtt;
    
    /**
     * The range at which the character can access.
     */
    private int distAttMax;
    
    /**
     * The position of the character on the map.
     */
    private Point2D pos;
    
    /**
     * The amount of damage that the character can counter.
     */
    private int ptPar;
    
    
    /**
     * Creature constructor which specify all the attributes.
     * @param nom Name of the character.
     * @param pV Number of health point of the character
     * @param pA Percentage corresponding to the success of an attack.
     * @param pP Percentage corresponding to the success of a parade
     * @param rM Percentage corresponding to the resistance to magical attack.
     * @param dA The amount of damage that inflict the character.
     * @param distMax The range at which the character can access.
     * @param pos The position of the character on the map.
     * @param ptPar The amount of damage that the character can counter.
     */
    public Creature(String nom, int pV, int pA, int pP, int rM, int dA, 
            int distMax, Point2D pos, int ptPar)
    {
        this.nom = nom;
        this.ptVie = pV;
        this.pourcentageAtt = pA;
        this.pourcentagePar = pP;
        this.pourcentageResistMag = rM;
        this.degAtt = dA;
        this.distAttMax = distMax;
        this.pos = new Point2D(pos);
        this.ptPar = ptPar;
    }
    
    
    /**
     * Copy constructor for Creature.
     * @param crea : Creature to copy.
     */
    public Creature(Creature crea)
    {
        this.nom = crea.getNom();
        this.ptVie = crea.getPtVie();
        this.pourcentageAtt = crea.getPourcentageAtt();
        this.pourcentagePar = crea.getPourcentagePar();
        this.pourcentageResistMag = crea.getPourcentageResistMag();
        this.degAtt = crea.getDegAtt();
        this.distAttMax = crea.getDistAttMax();
        this.pos = new Point2D(crea.getPos());
    }
    
    
    /**
     * Default constructor for Creature. 
     * Each variables is initiated with default values :
     * - 100 health points ;
     * - 50% of attack, counter and magical resistance ;
     * - 2 points of damage and 2 points of counter ;
     * - a range of attack of 1.
     */
    public Creature()
    {
        this.ptVie = 100;
        this.pourcentageAtt = 50;
        this.pourcentagePar = 50;
        this.pourcentageResistMag = 50;
        this.degAtt = 2;
        this.distAttMax = 1;
        this.ptPar = 2;
        this.nom = "Crea";
        this.pos = new Point2D();
    }
    
    
    /**
     * This function moves the creature randomly around it's initial position.
     * The creature can move in 8-adjacent and can also stay in the same 
     * position. Each position as 1 chance out of 9 to be pick. 
     */
    public void deplace()
    {
        Random rand = new Random();
        
        int dx = rand.nextInt(2) - 1;
        int dy = rand.nextInt(2) - 1;
        
        this.pos.translate(dx, dy);
    }
    
    
    /**
     * Print the values of each attributes into the terminal.
     */
    public void affiche()
    {
        System.out.print(
            "Ce Personnage s'appelle : "+nom+"\n"+
            "- "+ptVie+"\tpoints de vie ;\n"+        
            "- "+pourcentageAtt+"\t% de réussite d'attaque ;\n"+
            "- "+pourcentagePar+"\t% de réussite de parade ;\n"+
            "- "+pourcentageResistMag+"\t% de résistance aux dégâts magiques ;\n"+
            "- "+degAtt+" \tde dégâts d'attaque ;\n"+
            "- "+distAttMax+" \ten distance maximale d'attaque ;\n"+
            "- se situe en :"
            );
        pos.affiche();
    }    
}
