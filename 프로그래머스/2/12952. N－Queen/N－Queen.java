import java.util.*;
class Solution {
    private static boolean[][] map;
    private static int max;
    //같은 행에 퀸 존재하는지
    private static boolean existSameRow(int row,int n){
        for(int i=0;i<n;i++){
            if(map[row][i]) return true;
        }
        return false;
    }
    
    //같은 열에 퀸이 존재하는지
    private static boolean existSameCol(int col,int n){
        for(int i=0;i<n;i++){
            if(map[i][col]) return true;
        }
        return false;
    }
    
    //대각선에 퀸이 존재하는지
    private static boolean existSameCross(int row,int col,int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==row && j==col) continue;
                if(Math.abs(row-i)==Math.abs(col-j)){
                    if(map[i][j]) return true;
                }
            }
        }
        return false;
    }
    private static void BackTracking(int row,int n){
        if(row==n){
            max++;
            return;
        }
        
        

        for(int col=0;col<n;col++){
            if(!existSameRow(row,n) && !existSameCol(col,n) && !existSameCross(row,col,n)){
            map[row][col]=true;
            BackTracking(row+1,n);
            map[row][col]=false;
            }
        }
        
    }
    public int solution(int n) {
        map=new boolean[n][n];
        max=0;
        BackTracking(0,n);
        return max;
    }
}