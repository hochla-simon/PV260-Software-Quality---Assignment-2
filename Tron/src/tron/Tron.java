/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tron;

import Engine.IGame;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Simon
 */
public class Tron implements IGame {
    
    private final int MOVE_AMOUNT = 1;
    private final List<Player> players;
    
    public Tron() {
        players = new ArrayList();
    }
    
    @Override
    public void move(int screenWidth, int screenHeight) {
        for (Player player: players) {
            player.moveInCurrentDirection(MOVE_AMOUNT, screenWidth, screenHeight);
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
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        for (Player player: players) {
            if (player.getIoController().getKeys().containsKey(keyCode)) {
                player.turn(keyCode);
            }
        }
    }
    
    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent arg0) {

    }

    public void mouseClicked(MouseEvent e) {
        int keyCode = e.getButton();
        for (Player player: players) {
            if (player.getIoController().getKeys().containsKey(keyCode)) {
                player.turn(keyCode);
            }
        }
    }

    public void mouseEntered(MouseEvent arg0) {
    }

    public void mouseExited(MouseEvent arg0) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }

    public List<Player> getPlayers() {
        return players;
    }
    
    public void addPlayer(Player player) {
        players.add(player);
    }
}
