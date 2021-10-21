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
public class Mana extends Potion{
    
        public Mana(String name, Point2D p,int n, int q){
        super(name,p,n,q);
        
        
    }
    
    public Mana(Mana m){
        super(m);
    }
    
    public Mana(){
        super();       
    }
    
    
    /**
     * Constructor used to load a Mana with data from a save file.
     * @param data A line of data coming from a save file.
     * @throws WrongSaveFileFormatException 
     */
    public Mana(String data) throws WrongSaveFileFormatException{
        super(data);
    }
    
    
    public String getTexteSauvegarde(){
        return("Mana "+getQuantiteRestore()+" "+getPos().getX()+" "+getPos().getY());
        
    }
    
}
