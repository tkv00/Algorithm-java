import java.util.*;

class Solution {
    private static char[][] map;
    private static int[][] dist;
    private static int[] dx=new int[]{0,0,1,-1};
    private static int[] dy=new int[]{1,-1,0,0};
    private static int endRow;
    private static int endCol;
    private static int leverRow;
    private static int leverCol;
    private static int startRow;
    private static int startCol;
    private static Queue<int[]> q;
    private static boolean[][] visited;
    private static boolean isValid(int nx,int ny,int rowSize,int colSize){
        return nx>=0 && nx<rowSize && ny>=0 && ny<colSize && !visited[nx][ny];
    }

    public int solution(String[] maps) {
        int rowSize=maps.length;
        int colSize=maps[0].length();
        map=new char[rowSize][colSize];
        
        
        for(int i=0;i<rowSize;i++){
            char[] chArr=maps[i].toCharArray();
            for(int j=0;j<colSize;j++){
                map[i][j]=chArr[j];
                if(map[i][j]=='S'){
                    startRow=i;
                    startCol=j;
                }
                else if(map[i][j]=='L'){
                    leverRow=i;
                    leverCol=j;
                }else if(map[i][j]=='E'){
                    endRow=i;
                    endCol=j;
                }
            }
        }
        
        //시작점-레버 최소거리 측정.
        q=new LinkedList<>();
        dist=new int[rowSize][colSize];
        visited=new boolean[rowSize][colSize];
        q.offer(new int[]{startRow,startCol});
        visited[startRow][startCol]=true;
        
        while(!q.isEmpty()){
            int[] now=q.poll();
            for(int i=0;i<4;i++){
                int nx=now[0]+dx[i];
                int ny=now[1]+dy[i];
                if(!isValid(nx,ny,rowSize,colSize) || map[nx][ny]=='X') continue;
                
                dist[nx][ny]=dist[now[0]][now[1]]+1;
                visited[nx][ny]=true;
                q.offer(new int[]{nx,ny});
            }
        }
        int startToLever=dist[leverRow][leverCol];
        
        //레버-도착점 거리 측정.
        q.clear();
        dist=new int[rowSize][colSize];
        q.offer(new int[]{leverRow,leverCol});
        visited=new boolean[rowSize][colSize];
        visited[leverRow][leverCol]=true;
        
        while(!q.isEmpty()){
            int[] now=q.poll();
            for(int i=0;i<4;i++){
                int nx=now[0]+dx[i];
                int ny=now[1]+dy[i];
                if(!isValid(nx,ny,rowSize,colSize) || map[nx][ny]=='X') continue;
                
                dist[nx][ny]=dist[now[0]][now[1]]+1;
                q.offer(new int[]{nx,ny});
                visited[nx][ny]=true;
            }
        }
        
        int leverToEnd=dist[endRow][endCol];
        
        
        return (startToLever == 0 || leverToEnd == 0) ? -1 : startToLever+leverToEnd;
    }
}