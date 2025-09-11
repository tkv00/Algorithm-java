import java.util.*;
import java.io.*;
class Solution {
    private static boolean isValid(int nowRow,int nowCol,int row,int col){
        return nowRow>=0 && nowRow < row && nowCol >= 0 && nowCol<col;
    }
    
    private static final int[] dx=new int[]{1,0,0,-1};
    private static final int[] dy=new int[]{0,-1,1,0};
    private static final char[] move=new char[]{'d','l','r','u'};
    private static int[][] map;
    private static boolean flag;
    private static String answer;
    private static void DFS(int row,int col,int endRow,int endCol,String order,int k,int r,int c){
        //k값 벗어나는 경우
        if(flag) return;
        if(order.length()>k) return;
        
        //도달 못하는 경우
        int dist=Math.abs(row-endRow)+Math.abs(col-endCol);
        if(dist>k-order.length()) return;
        if((k-order.length()-dist)%2!=0) return;
        //도착한 경우
        if(row==endRow && col==endCol && order.length()==k){
            flag=true;
            answer=order;
            return;
        }
        
        for(int i=0;i<4;i++){
            int nextRow=row+dx[i];
            int nextCol=col+dy[i];
            String newOrder=order+move[i];
            
            if(!isValid(nextRow,nextCol,r,c)) continue;
            DFS(nextRow,nextCol,endRow,endCol,newOrder,k,r,c);
        }
    }
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        answer="impossible";
        map=new int[n][m];
        flag=false;
     
        DFS(x-1,y-1,r-1,c-1,"",k,n,m);
        
        return answer;
    }
}