import java.util.*;

class Solution {
    private static class Node{
    int idx;
    int cost;
    Node(int idx,int cost){
        this.idx=idx;
        this.cost=cost;
        }
    }
    private static int answer=0;
    public int solution(int N, int[][] road, int K) {
        ArrayList<Node>[] map=new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            map[i]=new ArrayList<>();
        }
        for(int[] r:road){
            int start=r[0];
            int end=r[1];
            int cost=r[2];
            
            //양방향 설정
            map[start].add(new Node(end,cost));
            map[end].add(new Node(start,cost));
        }
        
        int[] dist=new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
            
        PriorityQueue<Node> pq=new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost,o2.cost));
        pq.add(new Node(1,0));
        dist[1]=0;
            
        while(!pq.isEmpty()){
            Node now=pq.poll();
                
            if(now.cost>dist[now.idx]) continue;
                
            for(Node next:map[now.idx]){
                if(now.cost+next.cost<dist[next.idx]){
                    dist[next.idx]=now.cost+next.cost;
                    pq.add(new Node(next.idx,dist[next.idx]));
                }
            }
        }
        
         for(int i=1;i<=N;i++){
                if(dist[i]<=K){
                    answer++;
                }
            }
        return answer;             
    }
}