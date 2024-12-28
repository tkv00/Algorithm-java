import java.util.Queue;
import java.util.LinkedList;
class Solution {
    private static int[] dx={1,0,-1,0};
    private static int[] dy={0,1,0,-1};
    
    private static class Node{
        int x,y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    
    public int solution(int[][] maps) {
        int N=maps.length;
        int M=maps[0].length;
        
        //방문배열
        int [][] visited=new int[N][M];
        Queue<Node> q=new LinkedList<>();
        //첫 번쨰 노드 넣기
        q.add(new Node(0,0));
        visited[0][0]=1;
        
        while(!q.isEmpty()){
            //현재 노드
            Node nowNode=q.poll();
            for(int i=0;i<4;i++){
                int now_x=nowNode.x;
                int now_y=nowNode.y;
                if((now_x+dx[i] >= 0 && now_x+dx[i]<N)&&(now_y+dy[i]>=0 && now_y+dy[i]<M)
                   &&maps[now_x+dx[i]][now_y+dy[i]]==1&&visited[now_x+dx[i]][now_y+dy[i]]==0){
                    visited[now_x+dx[i]][now_y+dy[i]]=visited[now_x][now_y]+1;
                    q.add(new Node(now_x+dx[i],now_y+dy[i]));
                }
            }
        }
        if(visited[N-1][M-1]==0){
            return -1;
        }else{
            return visited[N-1][M-1];
        }
        
    }
    
}