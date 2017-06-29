
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
    static final int MAX_BLOCK = 1000;
    
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
    this.numofBlock = 1;
    
    generateListBlock();
    
    }
    
    void generateListBlock() {
        int quota = this.height * this.width*2;
        listOfBlock = new Blocks[MAX_BLOCK+1];
        while (quota>0 ) {
            listOfBlock[this.numofBlock] = Blocks.generateNewBlock();
            quota-= ( listOfBlock[this.numofBlock].width * listOfBlock[this.numofBlock].height );
            this.numofBlock++;
        }
        this.numofBlock--;
    }
    
}
