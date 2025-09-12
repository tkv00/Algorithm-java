import java.util.*;
class Solution {
    private static int cnt;
    private static boolean[] visited;
    private static ArrayDeque<Node> dq;
    private static ArrayList<Integer>[] map;
    private static int[] distance;
    private static class Node{
        int index;
        int cnt;
        
        Node(int index,int cnt){
            this.index=index;
            this.cnt=cnt;
        }
    }
        
    public int solution(int n, int[][] edge) {
        map=new ArrayList[n+1];
        distance=new int[n+1];
        dq=new ArrayDeque<>();
        visited=new boolean[n+1];
        
        for(int i=1;i<=n;i++){
            map[i]=new ArrayList<>();
        }
        
        for(int[] info:edge){
            map[info[0]].add(info[1]);
            map[info[1]].add(info[0]);
        }
        
        dq.offer(new Node(1,1));
        visited[1]=true;
        distance[1]=1;
        
        while(!dq.isEmpty()){
            Node now=dq.poll();
            
            for(int x:map[now.index]){
                if(!visited[x]){
                    distance[x]=now.cnt+1;
                    visited[x]=true;
                    dq.offer(new Node(x,now.cnt+1));
                }
            }
        }
        
        int max=Integer.MIN_VALUE;
        for(int x:distance){
            max=Math.max(x,max);
        }
        
        int result=0;
        for(int x:distance){
            if(x==max) result++;
        }
        return result;
    }
}