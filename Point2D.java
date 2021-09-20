/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 *
 * @author Valentin Molina valentin@molina.pro
 * @author Noé Masson
 */
public class Point2D {
    private int x;
    private int y;
    
    /**
     * @return the x
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * @return the y
     */
    public int getY()
    {
        return y;
    }
    
    /**
     * @param x the x to set
     */
    public void setX(int x)
    {
        this.x = x ;
    }
    
    /**
     * @param y the y to set
     */
    public void setY(int y)
    {
        this.y = y ;
    }
    
    public Point2D()
    {
        this.x = 0;
        this.y = 0;
    }

    public Point2D(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public Point2D(Point2D p)
    {
        this.x = p.getX();
        this.y = p.getY();
    }
            
    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public void translate(int dx, int dy)
    {
        this.x += dx;
        this.y += dy;
    }
    
    public void affiche()
    {
        System.out.println("[" + this.x + ";" + this.y + "]");
    }
}
