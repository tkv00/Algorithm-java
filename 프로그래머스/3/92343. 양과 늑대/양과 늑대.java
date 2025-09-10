import java.util.*;
class Solution {
    private static class Info{
        //현재 노드
        int node;
        //양 개수
        int sheep;
        //늑대 개수
        int wolf;
        //방문 
        HashSet<Integer> visited;
        
        Info(int node,int sheep,int wolf,HashSet<Integer> visited){
            this.node=node;
            this.sheep=sheep;
            this.wolf=wolf;
            this.visited=visited;
        }
    }
    
    private static void buildTree(int[][] edges,int[] info){
        map=new ArrayList[info.length];
        for(int i=0;i<info.length;i++){
            map[i]=new ArrayList<>();
        }
        
        for(int[] edge : edges){
            map[edge[0]].add(edge[1]);
        }
    }
    
    private static ArrayList<Integer>[] map;
    private static ArrayDeque<Info> q;
    
    public int solution(int[] info, int[][] edges) {
        buildTree(edges,info);
        q=new ArrayDeque<>();
        
        q.offer(new Info(0,1,0,new HashSet<>()));
        int answer=0; 
        
        while(!q.isEmpty()){
            Info now=q.poll();
            
            answer = answer < now.sheep ? now.sheep : answer;
            now.visited.addAll(map[now.node]);
            
            for(int next:now.visited){
                HashSet<Integer> set=new HashSet<>(now.visited);
                set.remove(next);
                
                //늑대인 경우
                if(info[next]==1){
                    if(now.sheep!=now.wolf+1){
                        q.offer(new Info(next,now.sheep,now.wolf+1,set));
                    }
                }
                else{
                    q.offer(new Info(next,now.sheep+1,now.wolf,set));
                }
            }
        }
        
        return answer;
        
    }
}