/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tron;

import java.util.Map;

/**
 *
 * @author Simon
 */
public class MouseController extends IOController{

    public MouseController(Map<Integer, Player.Direction> keys) {
        super(keys);
    }
    
    @Override
    public Player.Direction turn(Player.Direction direction, Integer keyCode) {
        switch(direction) {
            case UP: {
                Player.Direction keyDirection = keys.get(keyCode);
                if (keyDirection == Player.Direction.LEFT || keyDirection == Player.Direction.RIGHT) {
                    return keyDirection;
                }
                else {
                    return direction;
                }
            }
            case DOWN: {
                Player.Direction keyDirection = keys.get(keyCode);
                if (keyDirection == Player.Direction.LEFT) {
                    return Player.Direction.RIGHT;
                }
                if (keyDirection == Player.Direction.RIGHT) {
                    return Player.Direction.LEFT;
                }
                else {
                    return direction;
                }
            }
            case RIGHT: {
                Player.Direction keyDirection = keys.get(keyCode);
                if (keyDirection == Player.Direction.LEFT) {
                    return Player.Direction.UP;
                }
                if (keyDirection == Player.Direction.RIGHT) {
                    return Player.Direction.DOWN;
                }
                else {
                    return direction;
                }
            }
            case LEFT: {
                Player.Direction keyDirection = keys.get(keyCode);
                if (keyDirection == Player.Direction.LEFT) {
                    return Player.Direction.DOWN;
                }
                if (keyDirection == Player.Direction.RIGHT) {
                    return Player.Direction.UP;
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
