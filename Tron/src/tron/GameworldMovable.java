/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tron;

import java.awt.Point;

/**
 *
 * @author xorsag2
 */
public abstract class GameworldMovable {
    protected Direction currentDirection;
    protected Point centre;

    public GameworldMovable(Direction initialDirection, Point centre) {
        this.currentDirection = initialDirection;
        this.centre = centre;
    }
    
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

    public Direction getCurrentDirection() {
        return currentDirection;
    }
    
    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }
}