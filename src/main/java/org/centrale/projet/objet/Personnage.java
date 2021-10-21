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
public abstract class Personnage extends Creature {
    
    /**
     * Number of mana point of the character.
     */
    private int ptMana;
    
    /**
     * The percentage corresponding to the success of a magical attack.
     */
    private int pourcentageMag;
    
    /** 
     * The amount of magical damage that inflict the character.
     */
    private int degMag;
    

    /**
     * Personnage constructor which specify all the attributes.
     * @param nom Name of the character.
     * @param ptV Number of health point of the character
     * @param ptM Number of mana point of the character.
     * @param pA Percentage corresponding to the success of an attack.
     * @param pP Percentage corresponding to the success of a parade
     * @param pM Percentage corresponding to the success of a magical attack.
     * @param rM Percentage corresponding to the resistance to magical attack.
     * @param dA The amount of damage that inflict the character.
     * @param dM The amount of magical damage that inflict the character.
     * @param distMax The range at which the character can access.
     * @param pos The position of the character on the map.
     * @param ptPar The amount of damage that the character can counter.
     */
    protected Personnage(String nom, int ptV, int ptM, int pA, int pP, int pM, 
            int rM, int dA, int dM, int distMax, Point2D pos, int ptPar)
    {
        super(nom, ptV, pA, pP, rM, dA, distMax, pos, ptPar);
        this.ptMana = ptM;
        this.pourcentageMag = pM;
        this.degMag = dM;
    }
    
    
    /**
     * Copy constructor for Personnage.
     * @param perso : Personnage to copy.
     */
    protected Personnage(Personnage perso)
    {
        super(perso);
        this.ptMana = perso.getPtMana();
        this.pourcentageMag = perso.getPourcentageMag();
        this.degMag = perso.getDegMag();
    }
    
    
    /**
     * Constructor used to load a Personnage with data from a save file.
     * @param data A line of data coming from a save file.
     */
    protected Personnage(String data) throws WrongSaveFileFormatException
    {
        super(data);
    }
    
    
    /**
     * Default constructor for Personnage. 
     * Each variables is initiated with default values (0 for int, null for 
     * String, (0,0) for Point2D, ...)
     */
    protected Personnage()
    {
        super();
        this.setNom("Perso");
    }

    
    /**
     * Method used to load a Personnage from a line of a save file that 
     * represents a Personnage.
     * @param data A line of data coming from a save file.
     * @throws org.centrale.projet.objet.WrongSaveFileFormatException
     */
    @Override
    public void load(String data) throws WrongSaveFileFormatException
    {
        StringTokenizer tokenizer = new StringTokenizer(data, " ");
        int nbFields = 14;
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
                    case 3 -> this.setPtMana(Integer.parseInt(field));
                    case 4 -> this.setPourcentageAtt(Integer.parseInt(field));
                    case 5 -> this.setPourcentagePar(Integer.parseInt(field));
                    case 6 -> this.setPourcentageMag(Integer.parseInt(field));
                    case 7 -> this.setPourcentageResistMag(Integer.parseInt(field));
                    case 8 -> this.setDegAtt(Integer.parseInt(field));
                    case 9 -> this.setDegMag(Integer.parseInt(field));
                    case 10 -> this.setDistAttMax(Integer.parseInt(field));
                    case 11 -> this.setPtPar(Integer.parseInt(field));
                    case 12 -> x = Integer.parseInt(field);
                    case 13 -> {
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
     * Print the values of each attributes into the terminal.
     */
    public void affiche()
    {
        System.out.print(
            "Ce Personnage s'appelle : "+getNom()+"\n"+
            "- "+getPtVie()+"\tpoints de vie ;\n"+
            "- "+ptMana+"\tpoints de mana ;\n"+        
            "- "+getPourcentageAtt()+"\t% de réussite d'attaque ;\n"+
            "- "+pourcentageMag+"\t% de réussite d'attaque magique;\n"+
            "- "+getPourcentagePar()+"\t% de réussite de parade ;\n"+
            "- "+pourcentageMag+"\t% de réduction des dégâts magiques;\n"+
            "- "+getDegAtt()+" \tde dégâts d'attaque ;\n"+
            "- "+degMag+" \tde dégâts d'attaque magique ;\n"+
            "- "+getDistAttMax()+" \ten distance maximale d'attaque ;\n"+
            "- se situe en :"
            );
        getPos().affiche();
    }
     
    
    public void utilise(Objet obj)
    {
        if(obj instanceof Soin)
        {
            setPtVie(getPtVie() + ((Soin)obj).getQuantiteRestore());
        }
        else if(obj instanceof Mana)
        {
            ptMana += ((Mana)obj).getQuantiteRestore();
        }
    }
}
