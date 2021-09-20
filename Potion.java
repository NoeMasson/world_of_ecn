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
public class Potion extends Objet{

    /**
     * @return the quantiteRestore
     */
    public int getQuantiteRestore() {
        return quantiteRestore;
    }

    /**
     * @param quantiteRestore the quantiteRestore to set
     */
    public void setQuantiteRestore(int quantiteRestore) {
        this.quantiteRestore = quantiteRestore;
    }
    
    private int quantiteRestore;
    
    public Potion(String name, Point2D p,int n, int q){
        super(name,p,n);
        quantiteRestore = q;
        
    }
    
    public Potion(Potion p){
        super(p);
        quantiteRestore = 5;
    }
    
    public Potion(){
        super();
        quantiteRestore = 5;
        
    }
    
}
