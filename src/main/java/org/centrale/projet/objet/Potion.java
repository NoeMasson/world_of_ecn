/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.StringTokenizer;

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
    
    
    /**
     * Constructor used to load an Objet with data from a save file.
     * @param data A line of data coming from a save file.
     * @throws WrongSaveFileFormatException 
     */
    public Potion(String data) throws WrongSaveFileFormatException{
        super(data);
    }
    
    
    
    /**
     * Method used to load a Potion from a line of a save file that 
     * represents a Potion.
     * @param data A line of data coming from a save file.
     * @throws org.centrale.projet.objet.WrongSaveFileFormatException
     */
    @Override
    public void load(String data) throws WrongSaveFileFormatException
    {
        StringTokenizer tokenizer = new StringTokenizer(data, " ");
        int nbFields = 4;
        try{
            int x=0,y=0;
            for(int i = 0; i < nbFields ;i++){
                if(!tokenizer.hasMoreTokens()){
                    WrongSaveFileFormatException ex = 
                        new WrongSaveFileFormatException("The line : "+data+
                                " doesn't follow the right format. At least a "
                                        + "field is missing.");
                    throw ex;
                }
                String field = tokenizer.nextToken();
                switch(i){
                    case 1 -> this.setQuantiteRestore(Integer.parseInt(field));
                    case 2 -> x = Integer.parseInt(field);
                    case 3 -> {
                        y = Integer.parseInt(field);
                        this.setPos(new Point2D(x,y));
                    } 
                } 
                    
            }
            this.setNbUtilisation(0);
        } catch(NumberFormatException e) {
            WrongSaveFileFormatException ex = 
                new WrongSaveFileFormatException("The line : "+data+
                        " doesn't follow the right format. A number is incorrect.");
            throw ex;
        }
    }
}
