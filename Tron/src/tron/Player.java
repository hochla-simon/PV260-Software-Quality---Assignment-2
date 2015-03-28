/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tron;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Player {

    public Player(Direction currentDirection, Point centre, Color color, ArrayList<Point> path) {
        this.currentDirection = currentDirection;
        this.centre = centre;
        this.color = color;
        this.path = path;
    }
    
    public enum Direction {
        UP {
            
        }, DOWN {
            
        }, RIGHT {
            
        }, LEFT {
            
        };
    }
    
    private Direction currentDirection;
    
    private Point centre;
    
    private Color color;
    
    public ArrayList<Point> path;

   
    public boolean collidesWith(Player other) {
        return this.path.contains(other.centre);
    }
    
    public Point moveInCurrentDirection(int moveAmount, int width, int height) {
        switch (currentDirection) {
            case UP:
                if (centre.y > 0) {
                    centre.y -= moveAmount;
                } else {
                    centre.y = height;
                }
                break;
            case RIGHT:
                if (centre.x < width) {
                    centre.x += moveAmount;
                } else {
                    centre.x = 0;
                }
                break;
            case DOWN:
                if (centre.y < height) {
                    centre.y += moveAmount;
                } else {
                    centre.y = 0;
                }
                break;
            case LEFT:
                if (centre.x > 0) {
                    centre.x -= moveAmount;
                } else {
                    centre.x = width;
                }
                break;
        }

        return new Point(centre.x, centre.y);
    }
    
    public void addCentreToPath() {
        path.add(centre);
    }
    
    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }      
}
