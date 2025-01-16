import java.util.*;
class Solution {
    private static int answer=0;
    private static int MAX_VALUE=Integer.MIN_VALUE;
        
    public int solution(int n, int[][] edge) {
        Deque<Integer> q=new ArrayDeque<>();
        ArrayList<Integer>[] array=new ArrayList[n+1];
        boolean[]visit=new boolean[n+1];
        int[] dist=new int[n+1];
        
        for(int i=0;i<=n;i++){
            array[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<edge.length;i++){
            int first=edge[i][0];
            int second=edge[i][1];
            array[first].add(second);
            array[second].add(first);
        }
        
        q.addLast(1);
        visit[1]=true;
        int dep=0;
        
        while(!q.isEmpty()){
            int now=q.pollFirst();
            dep=dist[now]+1;
            for(int next:array[now]){
               if(!visit[next]){
                    //방문처리
                   visit[next]=true;
                   dist[next]=dep;
                   q.addLast(next);
                   MAX_VALUE=Math.max(MAX_VALUE,dist[next]);
               }
            }
        }
        
        for(int k:dist){
            if(k==MAX_VALUE){
                answer++;
            }
        }
        return answer;
    }
}