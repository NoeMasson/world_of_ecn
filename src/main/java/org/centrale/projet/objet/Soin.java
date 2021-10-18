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
public class Soin extends Potion{
    
    public Soin(String name, Point2D p,int n, int q){
        super(name,p,n,q);
        
        
    }
    
    public Soin(Soin s){
        super(s);
    }
    
    public Soin(){
        super();       
    }
    
    
    public String getTexteSauvegarde(){
        return("Soin "+getQuantiteRestore()+" "+getPos().getX()+" "+getPos().getY());
        
    }
}
