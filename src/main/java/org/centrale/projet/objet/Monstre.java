/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.StringTokenizer;

/**
 *
 * @author Valentin Molina valentin@molina.pro
 * @author Noé Masson
 */
public abstract class Monstre extends Creature {
    
    
    /**
     * Constructor of Monstre which specifies all attributes.
     * @param nom Name of the character.
     * @param ptV Number of health point of the character
     * @param pA Percentage corresponding to the success of an attack.
     * @param pP Percentage corresponding to the success of a parade
     * @param rM Percentage corresponding to the resistance to magical attack.
     * @param dA The amount of damage that inflict the character.
     * @param distMax The range at which the character can access.
     * @param pos The position of the character on the map.
     * @param ptPar The amount of damage that the character can counter.
     */
    protected Monstre(String nom, int ptV, int pA, int pP, int rM, int dA, 
            int distMax, Point2D pos, int ptPar)
    {
        super(nom, ptV, pA, pP, rM, dA, distMax, pos, ptPar);
    }
    
    /**
     * Copy constructor from another Monster.
     * @param m Monstre to copy.
     */
    protected Monstre(Monstre m)
    {
        super(m);
    }
    
    /**
     * Constructor without specifying anything. Use default values.
     */
    protected Monstre()
    {
        super();
        this.setNom("Monstre");
    }
    
    /**
     * Constructor used to load a Monstre with data from a save file.
     * @param data A line of a save file representing a Monstre.
     * @throws WrongSaveFileFormatException 
     */
    protected Monstre(String data) throws WrongSaveFileFormatException
    {
        this.load(data);
    }
    
    
    /**
     * Method used to load a Monstre from a line of a save file that 
     * represents a Monstre.
     * @param data A line of data coming from a save file.
     * @throws WrongSaveFileFormatException 
     */
    @Override
    public void load(String data) throws WrongSaveFileFormatException
    {
        StringTokenizer tokenizer = new StringTokenizer(data, " ");
        int nbFields = 11;
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
                    case 1 -> this.setNom(field);
                    case 2 -> this.setPtVie(Integer.parseInt(field));
                    case 3 -> this.setPourcentageAtt(Integer.parseInt(field));
                    case 4 -> this.setPourcentagePar(Integer.parseInt(field));
                    case 5 -> this.setPourcentageResistMag(Integer.parseInt(field));
                    case 6 -> this.setDegAtt(Integer.parseInt(field));
                    case 7 -> this.setDistAttMax(Integer.parseInt(field));
                    case 8 -> this.setPtPar(Integer.parseInt(field));
                    case 9 -> x = Integer.parseInt(field);
                    case 10 -> {
                        y = Integer.parseInt(field);
                        this.setPos(new Point2D(x,y));
                    } 
                } 
                    
            }
        } catch(NumberFormatException e) {
            WrongSaveFileFormatException ex = 
                new WrongSaveFileFormatException("The line : "+data+
                        " doesn't follow the right format. A number is incorrect.");
            throw ex;
        }
    }
    
}
