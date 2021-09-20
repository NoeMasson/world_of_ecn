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
public class Personnage {

    /**
     * Name of the character.
     */
    private String nom;
    
    /**
     * Number of health point of the character.
     */
    private int ptVie;
    
    /**
     * Number of mana point of the character.
     */
    private int ptMana;
    
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
     * The percentage corresponding to the success of a magical attack.
     */
    private int pourcentageMag;
    
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
     * The amount of magical damage that inflict the character.
     */
    private int degMag;
    
    /**
     * The range at which the character can access.
     */
    private int distAttMax;
    
    /**
     * The position of the character on the map.
     */
    private Point2D pos;
    

    /**
     * Personnage constructor which specify all the attributes.
     * @param nom
     * @param ptV
     * @param ptM
     * @param pA
     * @param pP
     * @param pM
     * @param rM
     * @param dA
     * @param dM
     * @param distMax
     * @param pos 
     */
    public Personnage(String nom, int ptV, int ptM, int pA, 
            int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos)
    {
        this.nom = nom;
        this.ptVie = ptV;
        this.ptMana = ptM;
        this.pourcentageAtt = pA;
        this.pourcentageMag = pM;
        this.pourcentagePar = pP;
        this.pourcentageResistMag = rM;
        this.degAtt = dA;
        this.degMag = dM;
        this.distAttMax = distMax;
        this.pos = new Point2D(pos);
    }
    
    
    /**
     * Copy constructor for Personnage.
     * @param perso : Personnage to copy.
     */
    public Personnage(Personnage perso)
    {
        this.nom = perso.getNom();
        this.ptVie = perso.getPtVie();
        this.ptMana = perso.getPtMana();
        this.pourcentageAtt = perso.getPourcentageAtt();
        this.pourcentageMag = perso.getPourcentageMag();
        this.pourcentagePar = perso.getPourcentagePar();
        this.pourcentageResistMag = perso.getPourcentageResistMag();
        this.degAtt = perso.getDegAtt();
        this.degMag = perso.getDegMag();
        this.distAttMax = perso.getDistAttMax();
        this.pos = new Point2D(perso.getPos());
    }
    
    
    /**
     * Default constructor for Personnage. 
     * Each variables is initiated with default values (0 for int, null for 
     * String, (0,0) for Point2D, ...)
     */
    public Personnage()
    {
        this.pos = new Point2D();
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
     * @return the ptMana
     */
    public int getPtMana() {
        return ptMana;
    }

    /**
     * @param ptMana the ptMana to set
     */
    public void setPtMana(int ptMana) {
        this.ptMana = ptMana;
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
     * @return the pourcentageMag
     */
    public int getPourcentageMag() {
        return pourcentageMag;
    }

    /**
     * @param pourcentageMag the pourcentageMag to set
     */
    public void setPourcentageMag(int pourcentageMag) {
        this.pourcentageMag = pourcentageMag;
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
     * @return the degMag
     */
    public int getDegMag() {
        return degMag;
    }

    /**
     * @param degMag the degMag to set
     */
    public void setDegMag(int degMag) {
        this.degMag = degMag;
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
     * This function moves the character randomly around it's initial position.
     * The character can move in 8-adjacent and can also stay in the same 
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
            "- "+ptMana+"\tpoints de mana ;\n"+        
            "- "+pourcentageAtt+"\t% de réussite d'attaque ;\n"+
            "- "+pourcentageMag+"\t% de réussite d'attaque magique;\n"+
            "- "+pourcentagePar+"\t% de réussite de parade ;\n"+
            "- "+pourcentageMag+"\t% de réduction des dégâts magiques;\n"+
            "- "+degAtt+" \tde dégâts d'attaque ;\n"+
            "- "+degMag+" \tde dégâts d'attaque magique ;\n"+
            "- "+distAttMax+" \ten distance maximale d'attaque ;\n"+
            "- se situe en :"
            );
        pos.affiche();
    }
}
