import java.util.*;

class Solution {
    private static int[][] dp;
    private static int MAX=Integer.MIN_VALUE;
    
    public int solution(int[][] triangle) {
        int size=triangle.length;
        dp=new int[size][size];
        dp[0][0]=triangle[0][0];
        
        for(int row=1;row<size;row++){
            for(int col=0;col<=row;col++){
                dp[row][col]=Math.max(dp[row-1][col],dp[row-1][col > 0 ? col-1 : 0 ])+triangle[row][col];
            }
        }
        
        for(int i=0;i<size;i++){
            MAX=Math.max(MAX,dp[size-1][i]);
        }
        
        return MAX;
        
    }
}