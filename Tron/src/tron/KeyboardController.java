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
public class KeyboardController extends IOController{
    

    public KeyboardController(Map<Integer, Direction> keys) {
        super(keys);
    }
    
    @Override
    public Player.Direction turn(Player.Direction direction, Integer keyCode) {
        switch(direction) {
            case UP: {
                Direction keyDirection = keys.get(keyCode);
                if (keyDirection == Direction.LEFT || keyDirection == Direction.RIGHT) {
                    return keyDirection;
                }
                else {
                    return direction;
                }
            }
            case DOWN: {
                Direction keyDirection = keys.get(keyCode);
                if (keyDirection == Direction.LEFT || keyDirection == Direction.RIGHT) {
                    return keyDirection;
                }
                else {
                    return direction;
                }
            }
            case RIGHT: {
                Direction keyDirection = keys.get(keyCode);
                if (keyDirection == Direction.UP || keyDirection == Direction.DOWN) {
                    return keyDirection;
                }
                else {
                    return direction;
                }
            }
            case LEFT: {
                Direction keyDirection = keys.get(keyCode);
                if (keyDirection == Direction.UP || keyDirection == Direction.DOWN) {
                    return keyDirection;
                }
                else {
                    return direction;
                }
            }
            default: {
                return null;
            }
        }
    }
}

   