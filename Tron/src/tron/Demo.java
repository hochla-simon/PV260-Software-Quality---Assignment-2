/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tron;

import Engine.Core;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import tron.Player.Direction;

/**
 *
 * @author Simon
 */
public class Demo {
    
    public static void main(String[] args) {
        tronTest();
    }
    
    public static void tronTest() {
        int centrex1 = 40;
        int centrey1 = 40;
        int centrex2 = 600;
        int centrey2 = 440;

        Map<Integer, Direction> keys = new HashMap<>();
        keys.put(MouseEvent.BUTTON1, Direction.LEFT);
        keys.put(MouseEvent.BUTTON3, Direction.RIGHT);
        IOController ioController = new MouseController(keys);
        
        Player player1 = new Player(Player.Direction.LEFT, new Point(centrex1, centrey1), Color.BLUE, ioController);
        
        keys = new HashMap<>();
        keys.put(KeyEvent.VK_UP, Direction.UP);
        keys.put(KeyEvent.VK_DOWN, Direction.DOWN);
        keys.put(KeyEvent.VK_LEFT, Direction.LEFT);
        keys.put(KeyEvent.VK_RIGHT, Direction.RIGHT);
        ioController = new KeyboardController(keys);
        
        Player player2 = new Player(Player.Direction.RIGHT, new Point(centrex2, centrey2), Color.PINK, ioController);
        
        keys = new HashMap<>();
        keys.put(KeyEvent.VK_W, Direction.UP);
        keys.put(KeyEvent.VK_S, Direction.DOWN);
        keys.put(KeyEvent.VK_A, Direction.LEFT);
        keys.put(KeyEvent.VK_D, Direction.RIGHT);
        ioController = new KeyboardController(keys);
        
        Player player3 = new Player(Player.Direction.DOWN, new Point(centrex2, centrey2 + 10), Color.lightGray, ioController);
        
        Tron tron = new Tron();

        tron.addPlayer(player1);
        tron.addPlayer(player2);
        tron.addPlayer(player3);
        
        TronPresentation presentation = new TronPresentation(tron);
        
        Core core = new Core(presentation);
        core.run();
    }
}
