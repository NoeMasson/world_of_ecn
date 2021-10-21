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
    
    
    /**
     * Constructor used to load a Soin with data from a save file.
     * @param data A line of data coming from a save file.
     * @throws WrongSaveFileFormatException 
     */
    public Soin(String data) throws WrongSaveFileFormatException{
        super(data);
    }
    
    
    public String getTexteSauvegarde(){
        return("Soin "+getQuantiteRestore()+" "+getPos().getX()+" "+getPos().getY());
        
    }
}
