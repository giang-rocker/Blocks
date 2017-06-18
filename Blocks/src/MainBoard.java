
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
public class MainBoard {
    
    static final int MAX_HEIGHT = 15;
    static final int MAX_WIDTH = 20;
    static final int MAX_BLOCK = 30;
    
    int height;
    int width;
    int numofBlock;
    Blocks listOfBlock [] ;
    
    public MainBoard (){
    
    }
    
    public void generateMainBoard(){
    Random R = new Random();
    
    this.height =MAX_HEIGHT;
    this.width =MAX_WIDTH;
    this.numofBlock = MAX_BLOCK;
    
    generateListBlock();
    
    }
    
    void generateListBlock() {
        
        listOfBlock = new Blocks[this.numofBlock];
        for (int i =0; i < this.numofBlock; i++)
            listOfBlock[i] = Blocks.generateNewBlock();
        
    }
    
}
