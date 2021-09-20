/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * 
 * @author Valentin Molina
 * @author Noe Masson
 */
public class Loup extends Monstre{
    
    
    public Loup(int ptV, int pA, int pP, int dA, Point2D pos)
    {
        super(ptV,pA,pP,dA,pos);
    }
    
    public Loup(Loup l){
        super(l);
    }
    
    public Loup(){
        super();
    }
    
}
