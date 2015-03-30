/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tron;

import Engine.Core;
import Engine.IGame;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

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

        Player player1 = new Player(Player.Direction.LEFT, new Point(centrex1, centrey1), Color.BLUE);
        Player player2 = new Player(Player.Direction.RIGHT, new Point(centrex2, centrey2), Color.PINK);
        Player player3 = new Player(Player.Direction.DOWN, new Point(centrex2, centrey2 + 10), Color.lightGray);
        
        player1.setKeyBoard(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
        player2.setKeyBoard(KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D);
        //player3.setKeyBoard(KeyEvent.VK_HOME, KeyEvent.VK_END, KeyEvent.VK_DELETE, KeyEvent.VK_PAGE_DOWN);
        player3.setMouse(MouseEvent.BUTTON1, MouseEvent.BUTTON3);
        

        IGame tron = new Tron();

        tron.addPlayer(player1);
        tron.addPlayer(player2);
        tron.addPlayer(player3);
        
        TronPresentation presentation = new TronPresentation();
        
        Core core = new Core(tron, presentation);
        core.run();
    }
}
