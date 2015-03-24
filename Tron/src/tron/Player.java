/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tron;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Player {
    private Point centre;
    
    private int currentDirection;
    
    private Color color;
    
    public ArrayList<Point> path;

    public Player() {
    }

    public void setColor(Color color) {
        this.color = color;
    }

    
    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }

    public Point getCentre() {
        return centre;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public Color getColor() {
        return color;
    }
           
    
            
}
