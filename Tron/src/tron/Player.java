/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tron;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Player {

    public Player(Direction currentDirection, Point centre, Color color) {
        this.currentDirection = currentDirection;
        this.centre = centre;
        this.color = color;
        path = new ArrayList();
    }
    
    public enum Direction {
        UP {
            
        }, DOWN {
            
        }, RIGHT {
            
        }, LEFT {
            
        };
    }
    
    //in the final code should be private
    public Direction currentDirection;
    private final Point centre;
    private final Color color;

    public KeyEvent getUP() {
        return UP;
    }

    public void setUP(KeyEvent UP) {
        this.UP = UP;
    }

    public KeyEvent getDOWN() {
        return DOWN;
    }

    public void setDOWN(KeyEvent DOWN) {
        this.DOWN = DOWN;
    }

    public KeyEvent getRIGHT() {
        return RIGHT;
    }

    public void setRIGHT(KeyEvent RIGHT) {
        this.RIGHT = RIGHT;
    }

    public KeyEvent getLEFT() {
        return LEFT;
    }

    public void setLEFT(KeyEvent LEFT) {
        this.LEFT = LEFT;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }
    
    
    private KeyEvent UP;
    
    private KeyEvent DOWN;
    
    private KeyEvent RIGHT;
    
    private KeyEvent LEFT;
    
    public List<Point> path;

   
    public boolean collidesWith(Player other) {
        return path.contains(other.centre);
    }
    
    public void moveInCurrentDirection(int moveAmount, int width, int height) {
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
    }

    public void addCentreToPath() {
        //important to use the new operator
        path.add(new Point(centre));
    }
    
    public Color getColor() {
        return color;
    }   

    public List<Point> getPath() {
        return path;
    }
}
