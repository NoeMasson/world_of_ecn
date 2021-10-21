/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 *
 * @author Noe Masson
 * @author Valentin Molina
 */
abstract class Objet implements IO{
    
    
    private String nom;
    
    private Point2D pos;
    
    private int nbUtilisation;
    
    
    public Objet(String name, Point2D p, int n){
        nom = name;
        pos = new Point2D(p);
        nbUtilisation = n;
    }   
    
    
    public Objet(Objet o){
        this.nom = o.nom;
        this.pos = o.pos;
        this.nbUtilisation = o.nbUtilisation;
    }
    
    
    public Objet(){
        nom = "objet";
        pos = new Point2D();
        nbUtilisation = 1;
    }
    
    
    /**
     * Constructor used to load an Objet with data from a save file.
     * @param data A line of data coming from a save file.
     * @throws WrongSaveFileFormatException 
     */
    public Objet(String data) throws WrongSaveFileFormatException{
        this.load(data);
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
     * @return the nbUtilisation
     */
    public int getNbUtilisation() {
        return nbUtilisation;
    }

    /**
     * @param nbUtilisation the nbUtilisation to set
     */
    public void setNbUtilisation(int nbUtilisation) {
        this.nbUtilisation = nbUtilisation;
    }
    

    public String getTexteSauvegarde(){
        return(nom+" "+pos.getX()+" "+pos.getY());
        
    }
    
}
