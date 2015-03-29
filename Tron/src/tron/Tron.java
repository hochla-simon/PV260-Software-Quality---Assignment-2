/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tron;

import Engine.Game;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Simon
 */
public class Tron implements Game {
    
    int MOVE_AMOUNT = 5;
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
            if (players.get(0).getCurrentDirection() != Player.Direction.DOWN) {
                players.get(0).setCurrentDirection(Player.Direction.DOWN);
            }
       
//            if (e.getKeyCode() == KeyEvent.VK_UP) {
//            if (currentDirection1 != 2) {
//                currentDirection1 = 0;
//            }
//        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//            if (currentDirection1 != 0) {
//                currentDirection1 = 2;
//            }
//        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//            if (currentDirection1 != 3) {
//                currentDirection1 = 1;
//            }
//        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//            if (currentDirection1 != 1) {
//                currentDirection1 = 3;
//            }
//        }
//        if (e.getKeyCode() == KeyEvent.VK_W) {
//            if (currentDirection2 != 2) {
//                currentDirection2 = 0;
//            }
//        } else if (e.getKeyCode() == KeyEvent.VK_S) {
//            if (currentDirection2 != 0) {
//                currentDirection2 = 2;
//            }
//        } else if (e.getKeyCode() == KeyEvent.VK_D) {
//            if (currentDirection2 != 3) {
//                currentDirection2 = 1;
//            }
//        } else if (e.getKeyCode() == KeyEvent.VK_A) {
//            if (currentDirection2 != 1) {
//                currentDirection2 = 3;
//            }
//        }
    }
    
    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent arg0) {

    }

    public void mouseClicked(MouseEvent e) {

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
