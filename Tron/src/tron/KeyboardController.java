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
public class KeyboardController extends IOController{
    
    public KeyboardController(Map<Integer, Direction> keys) {
        super(keys);
    }
     
    @Override
    public Direction turn(Direction currentDirection, Integer keyCode) {
        Direction keyDirection = keys.get(keyCode);               
        Direction newDirection = Direction.tryChangeDirectionTo(currentDirection, keyDirection);        
        return newDirection;
    }
}