import java.util.*;

class Solution {
    private static int[][] map;
    private static final int INF=Integer.MAX_VALUE;
    public int solution(int N, int[][] road, int K) {
        map=new int[N+1][N+1];
        int cnt=0;
        for(int i=1;i<=N;i++){
            Arrays.fill(map[i],INF);
        }
        
        for(int i=1;i<=N;i++){
            map[i][i]=0;
        }
        for(int[] info:road){
            int row=info[0];
            int col=info[1];
            map[row][col]=Math.min(map[row][col],info[2]);
            map[col][row]=Math.min(map[col][row],info[2]);
        }
        
        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(i==j || i==k || j==k) continue;
                    if(map[i][k]!=INF && map[k][j]!=INF){
                        map[i][j]=Math.min(map[i][j],map[i][k]+map[k][j]);        
                    }
                
                }
            }
        }
        for(int i=1;i<=N;i++){
            if(map[1][i]<=K)cnt++;
        }
        return cnt;
    }
}