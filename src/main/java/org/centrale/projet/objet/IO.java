/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 *
 * @author Noe Masson
 * @author Valentin Molina valentin@molina.pro
 */
public interface IO {
    
    public String getTexteSauvegarde();
    
    public void load(String data) throws WrongSaveFileFormatException;
    
}
