
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MyPC
 */
public class Blocks {
    
    static final int MAX_HEIGHT_BLOCK = 5;
    static final int MAX_WIDTH_BLOCK = 10;
    
    int width;
    int height;
    Position position;
    
    public Blocks(){
        this.height = -1;
        this.width = -1;
        this.position = new Position(-1, -1);
    }
    
    public Blocks(int w, int h, int x, int y){
        this.width = w;
        this.height = h;
        this.position = new Position(x,y);
    }
    
    static public Blocks generateNewBlock(){
        Blocks X = new Blocks();
        Random R = new Random();
        X.height = 1+ R.nextInt( MAX_HEIGHT_BLOCK);
        X.width = 1+ R.nextInt(MAX_WIDTH_BLOCK);
        
        X.position = new Position(-1, -1);
        
        return X;
    }
}
