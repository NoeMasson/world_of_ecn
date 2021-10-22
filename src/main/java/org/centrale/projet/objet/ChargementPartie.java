/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/**
 * @author Noé Masson
 * @author Valentin Molina valentin@molina.pro
 */
public class ChargementPartie {
    
    private String file;
    private BufferedReader reader;
    
    public ChargementPartie(String file) throws FileNotFoundException {
        this.file = file;
        this.reader = new BufferedReader(new FileReader(this.file));
    }
    
    
    public World chargerPartie() throws IOException, 
            WrongSaveFileFormatException,
            InstantiationException,
            IllegalAccessException,
            IllegalArgumentException,
            InvocationTargetException {
        World world;
        StringTokenizer tokenizer;
        
        int width, length;
        
        String line;
        
        // First line is the map width
        line = reader.readLine();
        if(line == null){
            WrongSaveFileFormatException ex = 
                    new WrongSaveFileFormatException("File " + this.file + 
                            " does not follow the right format : " +
                            "File is empty.");
            throw ex;
        }
        tokenizer = new StringTokenizer(line, " ");
        if(!tokenizer.hasMoreTokens())
        {
            WrongSaveFileFormatException ex = 
                    new WrongSaveFileFormatException("File " + this.file + 
                            " does not follow the right format : " +
                            "First line is empty. It should be the width.");
            throw ex;
        }
        String Largeur = tokenizer.nextToken();
        if(!Largeur.equals("Largeur")){
            WrongSaveFileFormatException ex = 
                    new WrongSaveFileFormatException("File " + this.file + 
                            " does not follow the right format : " +
                            "First line should be the width.");
        }
        if(!tokenizer.hasMoreTokens())
        {
            WrongSaveFileFormatException ex = 
                    new WrongSaveFileFormatException("File " + this.file + 
                            " does not follow the right format : " +
                            "Width is not set.");
            throw ex;
        }
        try {
            width = Integer.parseInt(tokenizer.nextToken());
        } catch(NumberFormatException e) {
            WrongSaveFileFormatException ex = 
                    new WrongSaveFileFormatException("File " + this.file + 
                            " does not follow the right format : " +
                            "Width should be an integer.");;
            throw ex;
        }
        
        // Second line is the map length
        line = reader.readLine();
        if(line == null){
            WrongSaveFileFormatException ex = 
                    new WrongSaveFileFormatException("File " + this.file + 
                            " does not follow the right format : " +
                            "Second line is empty. It should be the length.");
            throw ex;
        }
        tokenizer = new StringTokenizer(line, " ");
        if(!tokenizer.hasMoreTokens())
        {
            WrongSaveFileFormatException ex = 
                    new WrongSaveFileFormatException("File " + this.file + 
                            " does not follow the right format : " +
                            "Second line is empty. It should be the length.");
            throw ex;
        }
        String Longueur = tokenizer.nextToken();
        if(!Longueur.equals("Longueur")){
            WrongSaveFileFormatException ex = 
                    new WrongSaveFileFormatException("File " + this.file + 
                            " does not follow the right format : " +
                            "Second line should be the length.");
            throw ex;
        }
        if(!tokenizer.hasMoreTokens())
        {
            WrongSaveFileFormatException ex = 
                    new WrongSaveFileFormatException("File " + this.file + 
                            " does not follow the right format : " +
                            "Length is not set.");
            throw ex;
        }
        try {
            length = Integer.parseInt(tokenizer.nextToken());
        } catch(NumberFormatException e) {
            WrongSaveFileFormatException ex = 
                    new WrongSaveFileFormatException("File " + this.file + 
                            " does not follow the right format : " +
                            "Length should be an integer.");;
            throw ex;
        }
        
        world = new World(width, length);
        
        // Following lines are the characters.
        line = reader.readLine();
        while(line != null){
            tokenizer = new StringTokenizer(line, " ");
            if(!tokenizer.hasMoreTokens())
            {
                WrongSaveFileFormatException ex = 
                        new WrongSaveFileFormatException("File " + this.file + 
                                " does not follow the right format : " +
                                "A line is empty.");
                throw ex;
            }
            String className = tokenizer.nextToken();
            try{
                Class classType = Class.forName("org.centrale.projet.objet."+className);
                Class[] types = new Class[] {String.class};
                Constructor construct = classType.getConstructor(types);
                Object obj = construct.newInstance((Object[])new String[]{line});
                if(obj instanceof Creature){
                    world.getProtagonistes().add((Creature) obj);
                }
                else if(obj instanceof Objet){
                    world.getObjets().add((Objet) obj);
                }
                else if(obj instanceof Joueur){
                    world.setJoueur((Joueur) obj);
                }
            } catch(ClassNotFoundException e) {
                WrongSaveFileFormatException ex = 
                        new WrongSaveFileFormatException("File " + this.file + 
                                " does not follow the right format : " +
                                "The class "+className+" doesn't exist.");
                throw ex;
            } catch(NoSuchMethodException e) {
                WrongSaveFileFormatException ex = 
                        new WrongSaveFileFormatException(
                                "A issue was encounter while reading the file : " + 
                                this.file + "\n" +
                                "The class "+className+" doesn't have the right constructor.");
                throw ex;
            }
            line = reader.readLine();
        }
        
        return world;
    }
    
}
