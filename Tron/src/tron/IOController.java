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
 * @author xorsag2
 */
public abstract class IOController {
    protected Map<Integer, Player.Direction> keys;

    public Map<Integer, Direction> getKeys() {
        return keys;
    }

    public IOController(Map<Integer, Direction> keys) {
        this.keys = keys;
    }

    public abstract Direction upTurn(Integer keyCode);
    public abstract Direction downTurn(Integer keyCode);
    public abstract Direction leftTurn(Integer keyCode);
    public abstract Direction rightTurn(Integer keyCode);
    
}
