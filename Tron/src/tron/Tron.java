/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tron;

import java.awt.Color;
import java.awt.Point;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Simon
 */
public class Tron implements Game {
    
    int MOVE_AMOUNT = 5;
    List<Player> players;
    Core core;
    
    public Tron(Core core) {
        this.core = core;
        players = new ArrayList();
    }
    public static void main(String[] args) {
        tronTest();
    }
    
    public void move() {
        for (Player player: players) {
            player.moveInCurrentDirection(MOVE_AMOUNT, core.getWidht(), core.getHeight());
        }
        for (Player player1: players) {
            for (Player player2: players) {
                if (player1.collidesWith(player2)) {
                    System.exit(0);
                }
            }
        }
        for (Player player: players) {
            player.addCentreToPath();
        }
        
        //draw
    }
            
    public static void tronTest() {
        int centrex1 = 40;
	int centrey1 = 40;
	int centrex2 = 600;
	int centrey2 = 440;
        
        Player player1 = new Player(Player.Direction.LEFT, new Point(centrex1, centrey1), Color.BLUE, new ArrayList<Point>());
        Player player2 = new Player(Player.Direction.RIGHT, new Point(centrex2, centrey2), Color.PINK, new ArrayList<Point>());
        
        Tron tron = new Tron(new Core());
        
        tron.players.add(player1);
        tron.players.add(player2);
    }
}
