import java.util.*;
class Solution {
    
    //[최소 필요도 , 소모 필요도]
    private static boolean[] visited;
    private static int max;
    private static void backTracking(int cnt,int k,int[][] dungeons){
        max=Math.max(cnt,max);
           
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i] && dungeons[i][0]<=k){
                visited[i]=true;
                backTracking(cnt+1,k-dungeons[i][1],dungeons);
                visited[i]=false;
            }
        }
        
    }
    public int solution(int k, int[][] dungeons) {
        visited=new boolean[dungeons.length];
        max=Integer.MIN_VALUE;
        backTracking(0,k,dungeons);
        
        return max;
    }
}