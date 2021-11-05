/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valentin Molina valentin@molina.pro
 * @author Noé Masson
 */
public class Joueur implements IO {

    /**
     * @return the perso
     */
    public Personnage getPerso() {
        return perso;
    }

    /**
     * @param perso the perso to set
     */
    public void setPerso(Personnage perso) {
        this.perso = perso;
    }
    
    /**
     * The Personnage player by the player.
     */
    private Personnage perso ;
    
    
    /**
     * Only Player constructor. Used by World.
     * @param classeName The Class selected by the player.
     * @param name The name of the player.
     * @throws PlayerCreationException Raise this expression if the class can't 
     * be created.
     */
    public Joueur(String classeName, String name) throws PlayerCreationException
    {
        try{
            Class classType = Class.forName(classeName);
            perso = (Personnage) classType.newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("A ClassNotFoundException occurs.");
            PlayerCreationException ex = new PlayerCreationException("Can't create object of class "+classeName);
            throw ex;
        } catch (InstantiationException e) {
            System.out.println("A InstantiationException occurs.");
            PlayerCreationException ex = new PlayerCreationException("Can't create object of class "+classeName);
            throw ex;
        } catch (IllegalAccessException e) {
            System.out.println("A IllegalAccessException occurs.");
            PlayerCreationException ex = new PlayerCreationException("Can't create object of class "+classeName);
            throw ex;
        }
        perso.setNom(name);
        
        Random rand = new Random();
        
        perso.setPtVie(80 + rand.nextInt(20));
        perso.setDegAtt(10+rand.nextInt(10));
        perso.setDegMag(5+rand.nextInt(10));
        perso.setDistAttMax(1);
        perso.setPos(new Point2D(0,0));
        perso.setPourcentageAtt(20+rand.nextInt(80));
        perso.setPourcentageMag(20+rand.nextInt(80));
        perso.setPourcentagePar(10+rand.nextInt(90));
        perso.setPourcentageResistMag(10+rand.nextInt(90));
        perso.setPtMana(10+rand.nextInt(10));
        perso.setPtPar(5+rand.nextInt(5));
        if(classeName.contains("Guerrier"))
        {
            perso.setDegMag(15+rand.nextInt(10));
            perso.setPourcentageAtt(50+rand.nextInt(50));
            perso.setPourcentagePar(40+rand.nextInt(60));
            perso.setPtPar(10+rand.nextInt(5));
        }
        else if(classeName.contains("Archer"))
        {
            perso.setDistAttMax(rand.nextInt(8));
            ((Archer)perso).setNbFleches(rand.nextInt(30));
        }
        else if(classeName.contains("Mage"))
        {
            perso.setDegMag(10+rand.nextInt(15));
            perso.setDistAttMax(rand.nextInt(5));
            perso.setPourcentageMag(70+rand.nextInt(30));
            perso.setPourcentageResistMag(40+rand.nextInt(60));
            perso.setPtMana(30+rand.nextInt(10));
        }
        
    }
    
    
    /**
     * Constructor used to load a Joueur with data from a save file.
     * @param data A line of data coming from a save file.
     * @throws org.centrale.projet.objet.WrongSaveFileFormatException
     */
    public Joueur(String data) throws WrongSaveFileFormatException
    {
        this.load(data);
    }
    
    
    /**
     * Method used to load a Joueur from a line of a save file that 
     * represents a Joueur.
     * @param data A line of data coming from a save file.
     * @throws org.centrale.projet.objet.WrongSaveFileFormatException
     */
    @Override
    public void load(String data) throws WrongSaveFileFormatException
    {
        StringTokenizer tokenizer = new StringTokenizer(data, " ");
        if(!tokenizer.hasMoreTokens())
        {
            WrongSaveFileFormatException ex = 
                new WrongSaveFileFormatException("The line : "+data+
                            " doesn't follow the right format. At least a "
                                    + "field is missing.");
            throw ex;  
        }
        tokenizer.nextToken();
        if(!tokenizer.hasMoreTokens())
        {
            WrongSaveFileFormatException ex = 
                new WrongSaveFileFormatException("The line : "+data+
                            " doesn't follow the right format. At least a "
                                    + "field is missing.");
            throw ex;
        }
        String className = tokenizer.nextToken();
        try{
            Class classType = Class.forName("org.centrale.projet.objet."
                    +className);
            Class[] types = new Class[] {String.class};
            Constructor construct = classType.getConstructor(types);
            this.setPerso((Personnage) construct.newInstance(
                    (Object[])new String[]{data.substring(7, data.length())}));
        } catch(ClassNotFoundException e) {
            WrongSaveFileFormatException ex = 
                new WrongSaveFileFormatException("The line : "+data+
                                " doesn't follow the right format.");
            throw ex;
        } catch(NoSuchMethodException ex) {
            System.out.println("NoSuchMethodException occurs...");
            Logger.getLogger(Joueur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            System.out.println("InstantiationException occurs...");
            Logger.getLogger(Joueur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            System.out.println("IllegalAccessException occurs...");
            Logger.getLogger(Joueur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            System.out.println("IllegalArgumentException occurs...");
            Logger.getLogger(Joueur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            System.out.println("InvocationTargetException occurs...");
            Logger.getLogger(Joueur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    /**
     * @return string corresponding to the characteristics of the Joueur
     */
    @Override
    public String getTexteSauvegarde(){
        return("Joueur "+perso.getTexteSauvegarde());
    }
    
    
    /**
     * This method implements the move mechanics for the player.
     * @param surroundingObj The objects that surround the player according to 
     * World.surroundingObj().
     * @param surroundingOpponents The opponents that surround the player according to 
     * World.opponent().
     */
    public Objet move(Objet[] surroundingObj, Creature[] surroundingOpponents){
        
        Objet toDelete = null;
        System.out.println("Vous avez choisi de vous déplacer.");
        int[] posOk = new int[]{1, 1, 1,
                                1,    1, 
                                1, 1, 1};
        for(int i = 0; i < 8; i++){
            if(surroundingOpponents[i] != null){
                int posOpp = i+1;
                System.out.println("La case "+posOpp+" est occupée par :");
                surroundingOpponents[i].affiche();
                System.out.println("Vous ne pouvez pas vous y déplacer.");
            }
            if(surroundingObj[i] != null){
                int posObj = i+1;
                System.out.println("Sur la case "+posObj+" se trouve l'objet suivant :");
                //surroundingObj[i].affiche();
                System.out.println("Vous pouvez vous y déplacer pour rammasser et utiliser l'objet (effet immédiat).");
                System.out.println("WARNING : l'utilisation des objets n'est pas encore prises en compte.");
            }
        }
        
        int choice = 0;
        java.util.Scanner in = new java.util.Scanner(System.in);
        
        System.out.println("Entrez la case sur laquelle vous souhaitez vous déplacer.");
        System.out.println("Il s'agit d'un nombre entre 1 et 8 suivant la convention suivante :");
        System.out.println("|1|8|7|\n"
                         + "|2|J|6|\n"
                         + "|3|4|5| où J correspond à votre position.");
        
        while(choice == 0){
            try{
                choice = Integer.parseInt(in.nextLine());
                if(choice < 1 || choice > 8){
                    choice = 0;
                    System.out.println("Vous devez entrer un nombre entre 1 et 8.");
                } else if(posOk[choice-1] == 0){
                    choice = 0;
                    System.out.println("Cette position est occupée. Vous devez choisir une autre position.");
                }
            } catch(NumberFormatException e) {
                System.out.println("Vous devez entrer un nombre entre 1 et 8.");
            }
        }
        
        this.getPerso().deplace(choice);
        
        for(Objet o : surroundingObj){
            if(o != null && this.perso.getPos().getX() == o.getPos().getX() && this.perso.getPos().getY() == o.getPos().getX() ){
                if(o instanceof Soin){
                    this.perso.setPtVie(this.perso.getPtVie()+((Soin) o).getQuantiteRestore());
                }
                if(o instanceof Mana){
                    this.perso.setPtMana(this.perso.getPtMana()+((Mana) o).getQuantiteRestore());
                }
                toDelete = o;
            }
        }
        
        return(toDelete);
        
    }
    
    
    /**
     * This method implements the fight mechanics for the player.
     * @param opponents The opponents that surround the player according to 
     * World.opponent().
     */
    public void fight(ArrayList<Creature> opponents){
        int n = opponents.size();
        System.out.println("Vous pouvez attaquer "+n+" ennemies.");
        System.out.println("");
        for(int i = 0 ; i < n ; i++){
            System.out.println("* Entrez "+i+" pour attaquer ce personnage :");
            opponents.get(i).affiche();
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Quel personnage souhaitez vous attaquer ?");
        
        java.util.Scanner in = new java.util.Scanner(System.in);
        int choice = -1;
        while(choice < 0 || choice >= n){
            try{
                choice = Integer.parseInt(in.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Vous devez entrer un nombre entre 0 et "+n+".");
            }
        }
        
        this.getPerso().combattre(opponents.get(choice));
    }
    
}
