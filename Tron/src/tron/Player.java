/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tron;

import java.awt.Color;
import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author admin
 */
public class Player extends GameworldMovable{
    
    private final Color color;
    private final IOController ioController;
    private final Set<Point> path;
    
    
    public Player(Direction initialDirection, Point centre, Color color, IOController ioController) {
        super(initialDirection, centre);
        this.color = color;
        this.ioController = ioController;
        path = new HashSet();
    }
    
    public boolean collidesWith(Player other) {
        return path.contains(other.centre);
    }
    
    @Override
    public void moveInCurrentDirection(int moveAmount, int width, int height) {
       switch (currentDirection) {
            case UP: {
                if (centre.y > 0) {
                    centre.y -= moveAmount;
                } else {
                    centre.y = height;
                }                
                break;
            }
            case RIGHT: {
                if (centre.x < width) {
                    centre.x += moveAmount;
                } else {
                    centre.x = 0;
                }                
                break;
            }
            case DOWN: {
                if (centre.y < height) {
                    centre.y += moveAmount;
                } else {
                    centre.y = 0;
                }
                break;
            }
            case LEFT: {
                if (centre.x > 0) {
                    centre.x -= moveAmount;
                } else {
                    centre.x = width;
                }
                break;
            }
        }
    }

    public void addCentreToPath() {
        //important to use the new operator
        path.add(new Point(centre));
    }
    
    public Color getColor() {
        return color;
    }   

    public Set<Point> getPath() {
        return path;
    }
    
    public void turn(Integer keyCode) {        
        currentDirection = ioController.turn(currentDirection, keyCode);
    }

    public IOController getIoController() {
        return ioController;
    }
}
