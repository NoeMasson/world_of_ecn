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
public class Monstre {

    private int ptVie ;
    private int pourcentageAtt;
    private int pourcentagePar;
    private int degAtt;
    private Point2D pos;
    
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

    public Monstre(int ptV, int pA, int pP, int dA, Point2D pos)
    {
        this.ptVie = ptV;
        this.pourcentageAtt = pA;
        this.pourcentagePar = pP;
        this.degAtt = dA;
        this.pos = new Point2D(pos);
    }
    
    public Monstre(Monstre m)
    {
        this.ptVie = m.getPtVie();
        this.pourcentageAtt = m.getPourcentageAtt();
        this.pourcentagePar = m.getPourcentagePar();
        this.degAtt = m.getDegAtt();
        this.pos = new Point2D(m.getPos());
    }
    
    public Monstre()
    {
        this.pos = new Point2D();
    }
    
    
    void deplace()
    {
        //Work in progress.
    }
    
    void affiche()
    {
        System.out.print(
            "Ce Monstre possède : \n"+
            "- "+ptVie+"\tpoints de vie ;\n"+
            "- "+pourcentageAtt+"\t% de réussite d'attaque ;\n"+
            "- "+pourcentagePar+"\t% de réussite de parade ;\n"+
            "- "+degAtt+" \tde dégâts d'attaque ;\n"+
            "- se situe en :"
            );
        pos.affiche();
    }
}
