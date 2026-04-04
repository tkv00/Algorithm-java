import java.util.*;
import java.util.*;
class Solution {
    private static int[] dx=new int[]{0,0,1,-1};
    private static int[] dy=new int[]{1,-1,0,0};
    private static final int DONT=-1;
    private static int result=0;
    private static Queue<int[]> q = new LinkedList<>();
    private static boolean[][] visited;
    private static int[][] dist;
    
    private static boolean isValid(int x,int y,int rowSize,int colSize){
        return x>=0 && x<rowSize && y>=0 && y<colSize && !visited[x][y];
    }
    
    private static final int INF=987654321;
    
    public int solution(int[][] maps) {
        int rowSize=maps.length;
        int colSize=maps[0].length;
        
        visited=new boolean[rowSize][colSize];
        dist=new int[rowSize][colSize];
        
        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                dist[i][j]=INF;
            }
        }
        visited[0][0]=true;
        dist[0][0]=1;
        
        
        q.offer(new int[]{0,0});
        boolean flag=false;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int d=0;d<4;d++){
                int nx=now[0]+dx[d];
                int ny=now[1]+dy[d];
                
                if(isValid(nx,ny,rowSize,colSize) && maps[nx][ny]==1){
                    dist[nx][ny]=Math.min(dist[now[0]][now[1]]+1,dist[nx][ny]);
                    
                    if(nx==rowSize-1 && ny==colSize-1){
                        flag=true;
                        break;
                    }
                    visited[nx][ny]=true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        
        
        return flag ? dist[rowSize-1][colSize-1]: DONT;
    }
    
}