/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tron;

import Engine.IGame;
import Engine.IPresentation;
import Engine.ScreenManager;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author Simon
 */
public class TronPresentation implements IPresentation{

    private Tron tron;
    
    public TronPresentation(Tron tron) {
        this.tron = tron;
    }

    @Override
    public void draw( ScreenManager sm) {
        Graphics2D g = sm.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, sm.getWidth(), sm.getHeight());
        for (Player player : tron.getPlayers()) {
            g.setColor(player.getColor());
            for (Point point : player.getPath()) {
                g.fillRect(point.x, point.y, 1, 1);
            }
        }
        g.dispose();
    }
    
    @Override
    public IGame getGame() {
        return tron;
    }
}
