/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * @author Valentin Molina valentin@molina.pro
 * @author Noé Masson
 */
public class PlayerCreationException extends Exception {
    
    /**
     * Construction which add log data about the crash.
     * @param log The log data.
     */
    public PlayerCreationException(String log){
        super(log);
    }
    
    /**
     * Default constructor. Only gives more semantics.
     */
    public PlayerCreationException(){
        super();
    }
    
}
