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
    public Player.Direction upTurn(Integer keyCode){
        Player.Direction keyDirection = keys.get(keyCode);
        if (keyDirection == Player.Direction.LEFT || keyDirection == Player.Direction.RIGHT) {
           return keyDirection;
        }        
        return Player.Direction.UP;           
    }
    
    @Override
    public Player.Direction downTurn(Integer keyCode){
        
        Player.Direction keyDirection = keys.get(keyCode);
        if (keyDirection == Player.Direction.LEFT) {
            return Player.Direction.RIGHT;
        }
        if (keyDirection == Player.Direction.RIGHT) {
            return Player.Direction.LEFT;
        }        
        return Player.Direction.DOWN;                       
    }
    
    @Override
    public Player.Direction leftTurn(Integer keyCode){
        
        Player.Direction keyDirection = keys.get(keyCode);
        if (keyDirection == Player.Direction.LEFT) {
            return Player.Direction.DOWN;
        }
        if (keyDirection == Player.Direction.RIGHT) {
            return Player.Direction.UP;
        }        
        return Player.Direction.LEFT;                       
    }
    
    @Override
    public Player.Direction rightTurn(Integer keyCode){
        
        Player.Direction keyDirection = keys.get(keyCode);
        if (keyDirection == Player.Direction.LEFT) {
            return Player.Direction.UP;
        }
        if (keyDirection == Player.Direction.RIGHT) {
            return Player.Direction.DOWN;
        }        
        return Player.Direction.RIGHT;                       
    }
 
}
