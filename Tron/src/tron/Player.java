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
public class Player{

    private Direction currentDirection;
    private Point centre;
    private final Color color;
    private IOController ioController;
    private final Set<Point> path;
    
    public enum Direction {
        UP {
            @Override
            public Point move(int moveAmount, int width, int height, Point centre) {
                if (centre.y > 0) {
                    centre.y -= moveAmount;
                } else {
                    centre.y = height;
                }
                return centre;
            }
        }, RIGHT {
            @Override
            public Point move(int moveAmount, int width, int height, Point centre) {
                if (centre.x < width) {
                    centre.x += moveAmount;
                } else {
                    centre.x = 0;
                }
                return centre;
            }
        }, DOWN {
            @Override
            public Point move(int moveAmount, int width, int height, Point centre) {
                if (centre.y < height) {
                    centre.y += moveAmount;
                } else {
                    centre.y = 0;
                }
                return centre;
            }
        }, LEFT {
            @Override
            public Point move(int moveAmount, int width, int height, Point centre) {
                if (centre.x > 0) {
                    centre.x -= moveAmount;
                } else {
                    centre.x = width;
                }
                return centre;
            }
        };

        public abstract Point move(int moveAmount, int width, int height, Point centre);
    }
    
    public Player(Direction initialDirection, Point centre, Color color, IOController ioController) {
        this.currentDirection = initialDirection;
        this.centre = centre;
        this.color = color;
        this.ioController = ioController;
        path = new HashSet();
    }
    
    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }
    
    public boolean collidesWith(Player other) {
        return path.contains(other.centre);
    }
    
    public void moveInCurrentDirection(int moveAmount, int width, int height) {
       centre = currentDirection.move(moveAmount, width, height, centre);
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

    public void setIoController(IOController ioController) {
        this.ioController = ioController;
    }
}
