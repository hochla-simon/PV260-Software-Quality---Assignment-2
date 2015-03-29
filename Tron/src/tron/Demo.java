/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tron;

import Engine.Core;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

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

        Tron tron = new Tron();

        tron.addPlayer(player1);
        tron.addPlayer(player2);
        
        TronPresentation presentation = new TronPresentation(tron);
        
        Core core = new Core(tron, presentation);
        core.run();
    }
}
