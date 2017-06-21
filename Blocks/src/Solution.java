/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MyPC
 */
public class Solution {
    int listPosition[][];
    int listBlock[][];
    boolean boardCheck[][];
    int boardHeight;
    int boardWidth;
    int numOfBlock ;
    
    
    Solution (MainBoard mainboard) {
        this.boardHeight =mainboard.height;
        this.boardWidth =mainboard.width;
        this.listPosition = new int[mainboard.numofBlock+1][2];
        this.listBlock = new int[mainboard.numofBlock+1][3];
        this.boardCheck = new boolean [mainboard.width+1][mainboard.height+1];
        numOfBlock = mainboard.numofBlock;
        for (int i =1; i <= numOfBlock;  i++){
            listBlock[i][0] = i;
            listBlock[i][1] = mainboard.listOfBlock[i].width;
            listBlock[i][2] = mainboard.listOfBlock[i].height;
            listPosition[i][0]= -1;
            listPosition[i][1]= -1;
        }
    }
    
    boolean inBound(int w, int h, int x, int y, int M, int N) {
    return (x>0 && y>0 && (x+w)<=M && (y+h) <=N );
    }
    
    boolean isConflict (int w, int h, int x, int y, int M, int N, boolean check[][]){
        
        for (int i =0; i < w; i ++)
            for (int j=0; j < h; j++) 
                if (check [x+i][y+j ]) return true;
            
        return false;
    }
    
    boolean placeBLock  (int w, int h, int x, int y, int M, int N, boolean check[][]){
        if (!inBound(w, h, x, y, M, N)) return false;
        if (isConflict(w, h, x, y, M, N, check)) return false;
        
        for (int i =0; i < w; i ++)
            for (int j=0; j < h; j++) 
             check [x+i][y+j ] = true ;
            
        return true;
    }
    int getSolution(){
        int countBlock = 0;
        for (int i =1; i <= boardWidth; i ++)
            for (int j =1; j <= boardHeight; j ++){
               if (countBlock > numOfBlock) break;
               if (placeBLock(listBlock[countBlock][1], listBlock[countBlock][2], i, j,boardWidth, boardHeight, boardCheck)) {
                   listPosition[listBlock[countBlock][0]][0] = i;
                   listPosition[listBlock[countBlock][0]][1] = j;
                   countBlock++;
               }
            }
              
        return countBlock;
    }
    
}
