import java.util.*;
class Solution {
    /**
    격자의 칸 - 0:비어 있음 / 1:벽
    출발점 (0,0) / 도착점 (N-1,N-1)
    직선 도로 : 100원 / 코너 : 500원
    경주로 건설 최소 비용 구하기
    **/
    private static class Node{
        int x;
        int y;
        int cost;
        int dir;
        
        Node(int x,int y,int cost,int dir){
            this.x=x;
            this.y=y;
            this.cost=cost;
            this.dir=dir;
        }
    }
    private static final int[] dx=new int[]{0,-1,0,1}; //left,up,right,down
    private static final int[] dy=new int[]{-1,0,1,0};
    private static ArrayDeque<Node> dq;
    private static boolean isValid(int row,int col,int R,int C,int[][] map){
        return row>=0 && row<R && col>=0 && col<C && map[row][col]==0;
    }
    
    //방향에 따라 cost추가
    private static int calculateCost(int prevDir,int nowDir,int prevCost){
        //직선
        if(prevDir == -1 || (prevDir-nowDir)%2==0){
            return prevCost+STRAIGHT;
        }
        //곡선
        else return prevCost+CORNER;
    }
    
    //새로운 좌표를 방문하지 않았거나 비용이 더 적을 때
    private static boolean isShouldUpdate(int x,int y,int cost,int dir){
        return visited[x][y][dir]==0 || visited[x][y][dir]>cost;
    }
    //직선 도로
    private static final int STRAIGHT=100;
    //곡선 도로
    private static final int CORNER=600;

    private static int totalCost;

    //방문 여부
    private static int[][][] visited;
  
    public int solution(int[][] board) {
        int size=board.length;
        int endX=size-1;
        int endY=size-1;
        //4방향
        visited=new int[size][size][4];
        totalCost=Integer.MAX_VALUE;
        
        dq=new ArrayDeque<>();
        dq.offer(new Node(0,0,0,-1));
        
        while(!dq.isEmpty()){
            Node now=dq.poll();
            
            for(int i=0;i<4;i++){
                int nx=now.x+dx[i];
                int ny=now.y+dy[i];
                
                if(!isValid(nx,ny,size,size,board)) continue;
                int newCost=calculateCost(now.dir,i,now.cost);
                
                if(isShouldUpdate(nx,ny,newCost,i)){
                    visited[nx][ny][i]=newCost;
                    dq.offer(new Node(nx,ny,newCost,i));
                }
            }
        }
        
        for(int i=0;i<4;i++){
            if(visited[size-1][size-1][i]!=0){
                totalCost=Math.min(totalCost,visited[size-1][size-1][i]);   
            }
        }
        return totalCost;
    }
}