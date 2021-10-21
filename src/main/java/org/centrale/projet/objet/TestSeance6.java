/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 *
 * @author Noe
 */
public class TestSeance6 {
    public static void main(String args[])
    {
         
        // Testing save methods
        SauvegardePartie save = new SauvegardePartie("testSave");
        World world = new World();
        save.sauvegarderPartie(world);
        save.sauvegarderPartie(world);
        
        SauvegardePartie save2 = new SauvegardePartie();
        save2.sauvegarderPartie(world);
        save2.sauvegarderPartie(world);
    }
}
