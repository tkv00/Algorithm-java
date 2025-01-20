import java.util.*;
class Solution {
    private static final int RIGHT=0;
    private static final int DOWN=1;
    private static final int LEFT=2;
    private static final int UP=3;
    
    static class Point{
        int x;
        int y;
        int direction;
        Point(int x,int y,int direction){
            this.x=x;
            this.y=y;
            this.direction=direction;
        }
    }
    
    private int findDirection(int x1,int y1,int x2,int y2){
        int dx=x2-x1;
        int dy=y2-y1;
        //오른쪽
        if(dx>0 && dy==0){
            return RIGHT;
        }
        //왼쪽
        if(dx<0 && dy==0){
            return LEFT;
        }
        //위쪽
        if(dx==0 && dy<0){
            return UP;
        }
        //아래쪽
        if(dx==0 && dy>0){
            return DOWN;
        }
        return -1;
    }
    
    //영역 체크
    private boolean boundary(int x,int y,int[][]board){
        int N=board.length;
        if(x<0 || x>=N || y<0 || y>=N || board[y][x]==1)
            return false;
        
        return true;
    }
    
    //코너 체크
    private boolean isCorner(int prev_direction,int now_direction){
        if(prev_direction!=-1 && prev_direction!=now_direction)return true;
        return false;
    }
    
    private static final int[] dx={1,0,-1,0};
    private static final int[] dy={0,1,0,-1};
    
    
    public int solution(int[][] board) {
        int N=board.length;
        int[][][]visit=new int[N][N][4];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                Arrays.fill(visit[i][j],Integer.MAX_VALUE);
            }
        }
        
        for(int i=0;i<4;i++){
            visit[0][0][i]=0;
        }
        ArrayDeque<Point> map=new ArrayDeque<>();
        map.addLast(new Point(0,0,-1));
        
        while(!map.isEmpty()){
            Point now=map.pollFirst();
            
            for(int i=0;i<4;i++){
                int next_x=now.x+dx[i];
                int next_y=now.y+dy[i];
                
                if(boundary(next_x,next_y,board)){
                    int next_cost=(now.direction==-1 ? 100 :(visit[now.y][now.x][now.direction]+(isCorner(now.direction,i) ? 600 : 100)));

                    //기존 비용보다 작은 경우에만 업데이트
                    if(next_cost < visit[next_y][next_x][i]){
                        visit[next_y][next_x][i]=next_cost;
                        map.addLast(new Point(next_x,next_y,i));
                    }
                }
            }
        }
        int minCost=Integer.MAX_VALUE;
        for(int i=0;i<4;i++){
            if(visit[N-1][N-1][i]!=0){
                minCost=Math.min(minCost,visit[N-1][N-1][i]);
            }
        }
        return minCost;
    }
}