import java.util.*;

class Solution {
    private static int[][]map;
    private static final int INF=20_000_001;
    public int solution(int N, int[][] road, int K) {
        map=new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j) continue;
                map[i][j]=INF;
            }
        }
    
        for(int[] arr:road){
            map[arr[0]][arr[1]]=
                    Math.min(arr[2],map[arr[0]][arr[1]]);
            map[arr[1]][arr[0]]= 
                    Math.min(arr[2],map[arr[1]][arr[0]]);
        }
        
        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(i==j) continue;
                    map[i][j]=Math.min(map[i][j],map[i][k]+map[k][j]);
                }
            }
        }
        
        int answer=0;
        for(int i=1;i<=N;i++){
            if(map[1][i]<=K) answer++;
        }
        return answer;
        
    }
}