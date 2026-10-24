import java.util.*;
import java.io.*;

class Solution {
    static int[][] dist;
    static final int INF = 2_000_000_000;
    static void init(int n,int[][] fares){
        dist = new int[n+1][n+1];
        
        for(int i=1;i<=n;i++){
            Arrays.fill(dist[i],INF);
            dist[i][i]=0;
        }
        
        for(int[] fare:fares){
            dist[fare[0]][fare[1]]=fare[2];
            dist[fare[1]][fare[0]]=fare[2];
        }
    }
    
    static void floydWarshall(int n){
        for(int mid=1;mid<=n;mid++){
            for(int start=1;start<=n;start++){
                for(int end=1;end<=n;end++){
                    if(dist[start][mid]==INF || dist[mid][end]==INF) 
                        continue;
                    
                    if(dist[start][end] > dist[start][mid]+dist[mid][end]){
                        dist[start][end] = dist[start][mid]+dist[mid][end];
                    }
                }
            }
        }
        
        
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=n;j++){
        //         System.out.print(dist[i][j]+" ");
        //     }
        //     System.out.println();
        // }
    }
    
    static int operation(int n,int s,int a,int b){
        int min =  INF;
        
    
        for(int mid=1;mid<=n;mid++){
            
            if(dist[s][mid]==INF || dist[mid][a]==INF || dist[mid][b]==INF) continue;
            min = Math.min(
                dist[s][mid] + dist[mid][a] + dist[mid][b],min
            );
        }
        
      
        
        return min;
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        //s ->mid -> A
        //        -> B
        
        //s -> A
        //s -> B
        
        init(n,fares);
        floydWarshall(n);
        return operation(n,s,a,b);
    }
}