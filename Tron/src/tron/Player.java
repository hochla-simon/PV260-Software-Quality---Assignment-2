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
public class Player{

    public Player(Direction currentDirection, Point centre, Color color) {
        this.currentDirection = currentDirection;
        this.centre = centre;
        this.color = color;
        path = new ArrayList();
    }
    
    public enum Direction {
        UP {
            
        }, RIGHT {
            
        }, DOWN {
            
        }, LEFT {
            
        };
    }
    
    //in the final code should be private
    public Direction currentDirection;
    private final Point centre;
    private final Color color;

    
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
    
    
    private int UP;
    
    private int DOWN;
    
    private int RIGHT;
    
    private int LEFT;
    
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
