/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MyPC
 */
public class Position {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position P) {
        this.x = P.getX();
        this.y = P.getY();
    }

    public void setPosition(Position P) {
        this.setX(P.getX());
        this.setY(P.getY());
    }

    public void setPosition(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public boolean compare (Position X) {
    
        return ( this.getX() == X.getX() && this.getY() == X.getY() );
    }
    
  
}
