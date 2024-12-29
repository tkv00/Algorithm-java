import java.util.Queue;
import java.util.LinkedList;
class Solution {
    static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    
    static final int[] dx={1,0,-1,0};
    static final int[] dy={0,1,0,-1};
    static int row_size;
    static int col_size;
   
    public int solution(String[] maps) {
        int result=-1;
        row_size=maps.length;
        col_size=maps[0].length();
        
        
        //Exit 좌표 기록
        int exit_x=-1;
        int exit_y=-1;
        int start_x=-1;
        int start_y=-1;
        int lever_x=-1;
        int lever_y=-1;
        
        
        for(int i=0;i<row_size;i++){
            for(int j=0;j<col_size;j++){
                char c=maps[i].charAt(j);
                if(c=='S'){
                    start_x=j;
                    start_y=i;
                }
                if(c=='E'){
                    exit_x=j;
                    exit_y=i;
                }if(c=='L'){
                    lever_x=j;
                    lever_y=i;
                }
            }
        }
        
        
        //시작점 없는 경우
        if (start_x == -1 || start_y == -1 || lever_x == -1 || lever_y == -1 || exit_x == -1 || exit_y == -1)           {
            return -1;
        }
        
         int toLever = bfs(new Node(start_x, start_y), new Node(lever_x, lever_y), maps);
        int toExit = bfs(new Node(lever_x, lever_y), new Node(exit_x, exit_y), maps);

        if (toLever == -1 || toExit == -1) return -1;
        return toLever + toExit;
        
        
    }
    
     public int bfs(Node start,Node end,String[] maps){
        Queue<Node> q=new LinkedList<>();
        int[][] visited=new int[row_size][col_size];
         visited[start.y][start.x]=1;
        q.add(new Node(start.x,start.y));
        
        while(!q.isEmpty()){
            //현재 노드
            Node nowNode=q.poll();
            
            if(nowNode.x==end.x && nowNode.y==end.y){
                return visited[nowNode.y][nowNode.x]-1;
            }
            
            for(int i=0;i<4;i++){
                int new_x=nowNode.x+dx[i];
                int new_y=nowNode.y+dy[i];
               
                if((new_x>=0 && new_x<col_size)&&(new_y>=0 && new_y<row_size)&&
                    visited[new_y][new_x]==0 && maps[new_y].charAt(new_x)!='X'){
                    q.add(new Node(new_x,new_y));
                    visited[new_y][new_x]=visited[nowNode.y][nowNode.x]+1;    
                }
            }
        }
        
        return -1;
        
    }
}