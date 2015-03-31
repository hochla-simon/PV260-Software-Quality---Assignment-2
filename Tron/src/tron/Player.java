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

    //in the final code should be private
    private Direction currentDirection;
    private Point centre;
    private final Color color;
    private IOController ioController;
    private int UP;

    private int DOWN;

    private int RIGHT;

    private int LEFT;

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
    
    public Player(Direction currentDirection, Point centre, Color color, IOController ioController) {
        this.currentDirection = currentDirection;
        this.centre = centre;
        this.color = color;
        this.ioController = ioController;
        path = new HashSet();
    }
    
    public void setKeyBoard(int up, int down, int left, int right){
        this.UP = up;
        this.DOWN = down;
        this.LEFT = left;
        this.RIGHT = right;
    }
    
    public void setMouse(int left, int right){        
        this.LEFT = left;
        this.RIGHT = right;
    }
    
    public int getUP() {
        return UP;
    }

    public int getDOWN() {
        return DOWN;
    }

    public int getRIGHT() {
        return RIGHT;
    }

    public int getLEFT() {
        return LEFT;
    }  

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }
    
    public void turnDown(){
        if (this.currentDirection != Direction.DOWN && this.currentDirection != Direction.UP){
                    this.currentDirection = Direction.DOWN;
                }
    }
    public void turnUp(){
        if (this.currentDirection != Direction.DOWN && this.currentDirection != Direction.UP){
                    this.currentDirection = Direction.UP;
                }
    }
    public void turnLeft(){
        if (this.currentDirection != Direction.LEFT && this.currentDirection != Direction.RIGHT){
                    this.currentDirection = Direction.LEFT;
                }
    }
    public void turnRight(){
        if (this.currentDirection != Direction.LEFT && this.currentDirection != Direction.RIGHT){
                    this.currentDirection = Direction.RIGHT;
                }
    }
    
    public void turnLeftByMouse(){
        switch(this.currentDirection){
            case UP:
                this.currentDirection = Direction.LEFT;
                break;
            case LEFT:
                this.currentDirection = Direction.DOWN;
                break;
            case DOWN:
                this.currentDirection = Direction.RIGHT;
                break;
            case RIGHT:
                this.currentDirection = Direction.UP;
                break;
        }        
    }
    
    public void turnRightByMouse(){
        switch(this.currentDirection){
            case UP:
                this.currentDirection = Direction.RIGHT;
                break;
            case LEFT:
                this.currentDirection = Direction.UP;
                break;
            case DOWN:
                this.currentDirection = Direction.LEFT;
                break;
            case RIGHT:
                this.currentDirection = Direction.DOWN;
                break;
        }        
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
    
}
