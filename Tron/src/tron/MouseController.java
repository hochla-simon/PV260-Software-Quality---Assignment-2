/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tron;

import java.util.Map;
import tron.Player.Direction;
/**
 *
 * @author Simon
 */
public class MouseController extends IOController{

    public MouseController(Map<Integer, Player.Direction> keys) {
        super(keys);
    }    
    
    public Player.Direction turn(Player.Direction currentDirection, Integer keyCode) {
        Player.Direction keyDirection = keys.get(keyCode);
        Direction direction = null;
        switch (currentDirection) {
            case UP: {
                direction = keyDirection;
                break;
            }
            case DOWN: {
                direction = keyDirection.opposite();
                break;
            }
            case RIGHT: {
                direction = keyDirection.getRight();
                break;
            }
            case LEFT: {
                direction = keyDirection.getLeft();
                break;
            }
        }
        Direction newDirection = Direction.tryChangeDirectionTo(currentDirection, direction);
        return newDirection;
    }
}
