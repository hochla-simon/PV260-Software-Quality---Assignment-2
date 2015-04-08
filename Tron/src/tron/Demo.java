/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tron;

import engine.Core;
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

        Map<Integer, Direction> keys1 = new HashMap<>();
        keys1.put(MouseEvent.BUTTON1, Direction.LEFT);
        keys1.put(MouseEvent.BUTTON3, Direction.RIGHT);
        IOController ioController1 = new MouseController(keys1);
        
        Player player1 = new Player(Player.Direction.LEFT, new Point(centrex1, centrey1), Color.BLUE, ioController1);
        
        Map<Integer, Direction> keys2 = new HashMap<>();
        keys2.put(KeyEvent.VK_UP, Direction.UP);
        keys2.put(KeyEvent.VK_DOWN, Direction.DOWN);
        keys2.put(KeyEvent.VK_LEFT, Direction.LEFT);
        keys2.put(KeyEvent.VK_RIGHT, Direction.RIGHT);
        IOController ioController2 = new MouseController(keys2);
        
        Player player2 = new Player(Player.Direction.RIGHT, new Point(centrex2, centrey2), Color.PINK, ioController2);
        
        Map<Integer, Direction> keys3 = new HashMap<>();
        keys3.put(KeyEvent.VK_W, Direction.UP);
        keys3.put(KeyEvent.VK_S, Direction.DOWN);
        keys3.put(KeyEvent.VK_A, Direction.LEFT);
        keys3.put(KeyEvent.VK_D, Direction.RIGHT);
        IOController ioController3 = new MouseController(keys3);
        
        Player player3 = new Player(Player.Direction.DOWN, new Point(centrex2, centrey2 + 10), Color.lightGray, ioController3);
        
        Tron tron = new Tron();

        tron.addPlayer(player1);
        tron.addPlayer(player2);
        tron.addPlayer(player3);
        
        TronPresentation presentation = new TronPresentation(tron);
        
        Core core = new Core(presentation);
        core.run();
    }
}
