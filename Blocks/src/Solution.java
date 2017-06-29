
import static java.lang.Math.abs;

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
    int numOfUseBlock  =0;
    int listPosition[][];
    int listBlock[][];
    boolean boardCheck[][];
    int boardHeight;
    int boardWidth;
    int numOfBlock ;
    int usedBlock;
    int usedUnit;
    
    
    Solution (MainBoard mainboard) {
        this.boardHeight =mainboard.height;
        this.boardWidth =mainboard.width;
        this.listPosition = new int[mainboard.numofBlock+1][2];
        this.listBlock = new int[mainboard.numofBlock+1][3];
        this.boardCheck = new boolean [mainboard.width+2][mainboard.height+2];
        numOfBlock = mainboard.numofBlock;
        for (int i =1; i <= numOfBlock;  i++){
            listBlock[i][0] = i;
            listBlock[i][1] = mainboard.listOfBlock[i].width;
            listBlock[i][2] = mainboard.listOfBlock[i].height;
            listPosition[i][0]= -1;
            listPosition[i][1]= -1;
        }  
            
            for (int i =1; i <= boardWidth; i++)
                for (int j =1; j <= boardHeight; j++)
                boardCheck[i][j] = false;
           
            for (int i =1; i <=boardHeight ; i++){
                boardCheck[0][i] = true;
                boardCheck[0][boardHeight+1] = true;
            }
            
            for (int i =1; i <= boardWidth; i++){
                boardCheck[i][0] = true;
                boardCheck[mainboard.width+1][0] = true;
            }
    }
    
    boolean inBound(int w, int h, int x, int y, int M, int N) {
    return (x>0 && y>0 && (x+w-1)<=M && (y+h-1) <=N );
    }
    
    boolean isConflict (int w, int h, int x, int y, int M, int N, boolean check[][]){
        
        for (int i =0; i < w; i ++)
            for (int j=0; j < h; j++) 
                if (check [x+i][y+j ]) return true;
            
        return false;
    }
    
    boolean placeBLock  (int w, int h, int x, int y, int M, int N, boolean check[][]){
        if (!inBound(w, h, x, y, M, N)) { return false;}
        if (isConflict(w, h, x, y, M, N, check)) return false;
        
        for (int i =0; i < w; i ++)
            for (int j=0; j < h; j++) 
             check [x+i][y+j ] = true ;
            
        return true;
    }
    int getSolution(){
        sortBlock();
        boolean isPlaced = false;
        int countBlock = 1;
        System.out.println(numOfBlock);
        for (int b =1; b <=numOfBlock; b++){
            isPlaced = false;
            for (int j =1; j <= boardHeight && !isPlaced; j ++)
             for (int i =1; i <= boardWidth && !isPlaced; i ++)
                if (placeBLock(listBlock[b][1], listBlock[b][2], i, j,boardWidth, boardHeight, boardCheck)) {
                   listPosition[listBlock[b][0]][0] = i;
                   listPosition[listBlock[b][0]][1] = j;
                   countBlock++;
                   isPlaced = true;
                 }
        }
              
        return countBlock-1;
    }
    
    int countTouch  (int w, int h, int x, int y, int M, int N, boolean check[][]){
        if (!inBound(w, h, x, y, M, N)) { return -1;}
        if (isConflict(w, h, x, y, M, N, check)) return -1;
        int count =0 ;
        for (int i =-1; i <= w; i ++)
            for (int j=-1; j <= h; j++) 
                if (check[x+i][y+j]) count++;
            
        return count;
    }
    
     int getSolution2(){
        sortBlock();
        boolean isPlaced = false;
        int countBlock = 1;
        System.out.println(numOfBlock);
        for (int b =1; b <=numOfBlock; b++){
            isPlaced = false;
            int maxPoint = 0;
            for (int j =1; j <= boardHeight ; j ++)
             for (int i =1; i <= boardWidth ; i ++)
                 {
                    int t =  countTouch(listBlock[b][1], listBlock[b][2], i, j,boardWidth, boardHeight, boardCheck); 
                    if (t==-1) continue;
                    if( t >maxPoint){
                        listPosition[listBlock[b][0]][0] = i;
                        listPosition[listBlock[b][0]][1] = j;
                        maxPoint = t;
                        }
                   
                 }
           if(placeBLock(listBlock[b][1], listBlock[b][2], listPosition[listBlock[b][0]][0], listPosition[listBlock[b][0]][1],boardWidth, boardHeight, boardCheck))
               countBlock++;
            }
              
        return countBlock-1;
    }
    
    void sortBlock ( ) {
        
        for (int i =1; i<=numOfBlock; i++)
            for (int j =i+1; j<=numOfBlock; j++) {
                
                if (listBlock[i][1]*listBlock[i][2] > listBlock[j][1]*listBlock[j][2]
                    ||
                    (listBlock[i][1]*listBlock[i][2] ==  listBlock[j][1]*listBlock[j][2] && (abs(listBlock[i][1]-listBlock[i][2]) >  abs(listBlock[j][1]-listBlock[j][2]))  )  )    
                {
                    
                    int c = listBlock[i][0];
                    listBlock[i][0] = listBlock[j][0];
                    listBlock[j][0] = c;
                    
                     c = listBlock[i][1];
                    listBlock[i][1] = listBlock[j][1];
                    listBlock[j][1] = c;
                    
                    c = listBlock[i][2];
                    listBlock[i][2] = listBlock[j][2];
                    listBlock[j][2] = c;
                }
                
            }
        
    }
    
    boolean checkCorrectness (){
       
    int checkNum = 0;
        usedUnit =0 ;
        
        for (int i =1; i < this.numOfBlock; i++) {
            if ( listPosition[listBlock[i][0]][0]==-1 &&  listPosition[listBlock[i][0]][1]==-1) continue;
            if (!(placeBLock(listBlock[i][1], listBlock[i][2], listPosition[listBlock[i][0]][0], listPosition[listBlock[i][0]][1],boardWidth, boardHeight, boardCheck))){
                    System.out.println("CONFLICT" + listBlock[i][0] +" " + i);
                    return false;
            }
            checkNum++;
            usedUnit+= listBlock[i][1]* listBlock[i][2];
        }
        System.out.println(checkNum +" "+ this.numOfUseBlock);
    if (checkNum != this.numOfUseBlock) return false;
    usedBlock = checkNum;
    return true;
    }
    
}
