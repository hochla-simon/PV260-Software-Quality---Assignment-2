/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Simon
 */
public interface IGame extends KeyListener, MouseListener, MouseMotionListener {
    public void move(int screenWidth, int screenHeight);
}