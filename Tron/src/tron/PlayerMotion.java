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
    public static void move(Player player, int moveAmount){
        int playerCurrentDirection = player.getCurrentDirection();
        int playerCentrex = player.getCentre().getCentrex();
        int playerCentrey = player.getCentre().getCentrey();
        switch(playerCurrentDirection){
		case 0:
			if (playerCentrey>0){
			playerCentrey-=moveAmount;                        
			} else {
				playerCentrey = yourclass.sm.getHeight();
			}
			break;
		case 1:
			if (playerCentrex < yourclass.sm.getWidth()){
			playerCentrex+=moveAmount;
			} else {
				playerCentrex = 0;
			}
			break;
		case 2:
			if (playerCentrey < yourclass.sm.getHeight()){
			playerCentrey+=moveAmount;
			} else {
				playerCentrey = 0;
			}
			break;
		case 3:
			if (playerCentrex>0){
			playerCentrex-=moveAmount;
			} else {
				playerCentrex = yourclass.sm.getWidth();
			}
			break;
		}
        
        player.getCentre().setCentrex(playerCentrex);
        player.getCentre().setCentrey(playerCentrey);
    }
}
