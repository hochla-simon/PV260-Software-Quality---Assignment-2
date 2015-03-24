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
public class CollisionDetector {
    public static boolean playerPairCollides(Player player1, Player player2){
        
        for (int x = 0; x < player1.path.size(); x++){	    	
                if(isSelfCollision(player1.getCentre(),player1.path.get(x))||
                        isSelfCollision(player2.getCentre(),player2.path.get(x))||
                        isSelfCollision(player1.getCentre(),player2.path.get(x))||
                        isSelfCollision(player2.getCentre(),player1.path.get(x)))
                    {
                        return true;
                    }
	    }
        return false;
    }
    
    private static boolean isSelfCollision(Point centrePoint, Point pathPoint){
        return (((centrePoint.getCentrex() == pathPoint.getCentrex()) && (centrePoint.getCentrey() == pathPoint.getCentrey())));
    }
            
}
