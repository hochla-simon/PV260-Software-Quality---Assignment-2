/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

/**
 *
 * @author Simon
 */
public interface IPresentation {
    public void draw(ScreenManager sm);
    public IGame getGame();
}
