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
public class Point {
    private int centrex;
    private int centrey;

    public Point(int centrex1, int centrey1) {
        this.centrex = centrex1;
        this.centrey = centrey1;
    }
   

    public void setCentrex(int centrex) {
        this.centrex = centrex;
    }

    public void setCentrey(int centrey) {
        this.centrey = centrey;
    }

    public int getCentrex() {
        return centrex;
    }

    public int getCentrey() {
        return centrey;
    }
    
    
    
}
