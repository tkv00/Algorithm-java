import java.util.*;

class Solution {
    class Point{
        int row;
        int col;
        int cost;
        Point(int row,int col,int cost){
            this.row=row;
            this.col=col;
            this.cost=cost;
        }
    }
    
    private static int cnt=0;
    private static int size;
    private static int[] dx={1,0,-1,0};
    private static int[] dy={0,1,0,-1};
    private static boolean[][] visit;
    
    //경계값 체크
    private static boolean boundary(int row,int col){
        if(row <0 || row >= size || col < 0 || col >= size || visit[row][col])
            return false;
        return true;
    }
    
    private static int sub(int nextR,int nextC,int nowR,int nowC,int[][]map){
        return Math.abs(map[nextR][nextC]-map[nowR][nowC]);
    }
    
    
    public int solution(int[][] land, int height) {
        //사다리 개수 = 집합 갯수 - 1
        //경계지점 파악
        size=land.length;
        visit=new boolean[size][size];
        
        Queue<Point> pq=new PriorityQueue<>((p1,p2)->Integer.compare(p1.cost,p2.cost));
        pq.add(new Point(0,0,0));
        
        int answer=0;
        
        while(!pq.isEmpty()){
            Point now=pq.poll();
            if(visit[now.row][now.col])continue;
            answer+=now.cost;
            //방문 표시
            visit[now.row][now.col]=true;
            
            for(int i=0;i<4;i++){
                int next_row=now.row+dx[i];
                int next_col=now.col+dy[i];
                
                //경계체크
                if(!boundary(next_row,next_col)) continue;
                
                int subNum=sub(next_row,next_col,now.row,now.col,land);
                
                
                //다른 영역
                if(subNum>height){
                    pq.add(new Point(next_row,next_col,subNum));
                    continue;
                }
                //같은 영역
                pq.add(new Point(next_row,next_col,0));
            }
        }
        return answer;
    }
}