
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
    
    static final int MAX_HEIGHT = 30;
    static final int MAX_WIDTH = 50;
    static final int MAX_BLOCK = 100;
    
    int height;
    int width;
    int numofBlock;
    Blocks listOfBlock [] ;
    
    public MainBoard (){
    
    }
    
    public void generateMainBoard(){
    Random R = new Random();
    
    this.height =30;
    this.width =50;
    this.numofBlock = 100;
    
    generateListBlock();
    
    }
    
    void generateListBlock() {
        
        listOfBlock = new Blocks[this.numofBlock];
        for (int i =0; i < this.numofBlock; i++)
            listOfBlock[i] = Blocks.generateNewBlock();
        
    }
    
}
