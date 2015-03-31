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
    public Direction upTurn(Integer keyCode){
        Direction keyDirection = keys.get(keyCode);
        if (keyDirection == Direction.LEFT || keyDirection == Direction.RIGHT) {
            return keyDirection;
        }
        return Player.Direction.UP;             
    }
    
    @Override
    public Direction downTurn(Integer keyCode){
        Direction keyDirection = keys.get(keyCode);
        if (keyDirection == Direction.LEFT || keyDirection == Direction.RIGHT) {
            return keyDirection;
        }
        return Player.Direction.DOWN;             
    }
    
    @Override
    public Direction leftTurn(Integer keyCode){
        Direction keyDirection = keys.get(keyCode);
        if (keyDirection == Direction.UP || keyDirection == Direction.DOWN) {
            return keyDirection;
        }
        return Player.Direction.LEFT;             
    }
    
    @Override
    public Direction rightTurn(Integer keyCode){
        Direction keyDirection = keys.get(keyCode);
        if (keyDirection == Direction.UP || keyDirection == Direction.DOWN) {
            return keyDirection;
        }
        return Player.Direction.RIGHT;             
    }
    
    
    
    
}

   