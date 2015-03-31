/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.Set;
import tron.Player;

/**
 *
 * @author Simon
 */
public interface IGame extends KeyListener, MouseListener, MouseMotionListener {
    public void move(int screenWidth, int screenHeight);
    
    public Set<Player> getPlayers();
    public void addPlayer(Player player);
    /**
    * ma byt toto sucatou rozhrania, ako zadeklarovat abstrakneho hraca
    **/ 
}