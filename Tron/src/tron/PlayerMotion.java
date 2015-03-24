/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tron;

/**
 *
 * @author admin
 */
public class PlayerMotion {
    
    int width;
    int height;

    public PlayerMotion(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    
    
    public Point move(Player player, int moveAmount){
        int playerCurrentDirection = player.getCurrentDirection();
        int playerCentrex = player.getCentre().getCentrex();
        int playerCentrey = player.getCentre().getCentrey();
        switch(playerCurrentDirection){
		case 0:
			if (playerCentrey>0){
			playerCentrey-=moveAmount;                        
			} else {
				playerCentrey = height;
			}
			break;
		case 1:
			if (playerCentrex < width){
			playerCentrex+=moveAmount;
			} else {
				playerCentrex = 0;
			}
			break;
		case 2:
			if (playerCentrey < height){
			playerCentrey+=moveAmount;
			} else {
				playerCentrey = 0;
			}
			break;
		case 3:
			if (playerCentrex>0){
			playerCentrex-=moveAmount;
			} else {
				playerCentrex = width;
			}
			break;
		}
        
        return new Point(playerCentrex, playerCentrey);
    }
}
