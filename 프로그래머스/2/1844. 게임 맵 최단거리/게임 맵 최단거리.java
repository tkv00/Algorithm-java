import java.util.Queue;
import java.util.LinkedList;
class Solution {
    /**
    흰 색 : O 검은 색 : X
    
    **/
    private static int[][] dist;
    private static Queue<int[]> q;
    private static int endRow=0,endCol=0;
    private static int[] dx=new int[]{0,0,1,-1};
    private static int[] dy=new int[]{1,-1,0,0};
    
    private static boolean isValid(int row,int col,int R,int C,int[][] map){
        return row>=0 && row<R && col>=0 && col<C && map[row][col]!=0;
    }
    
    public int solution(int[][] maps) {
        int rowSize=maps.length;
        int colSize=maps[0].length;
        
        endRow=rowSize-1;
        endCol=colSize-1;
        
        dist=new int[rowSize][colSize];
        q=new LinkedList<>();
        dist[0][0]=1;
        q.offer(new int[]{0,0});
        
        while(!q.isEmpty()){
            int[] now=q.poll();
            for(int i=0;i<4;i++){
                int newRow=now[0]+dx[i];
                int newCol=now[1]+dy[i];
                
                if(!isValid(newRow,newCol,rowSize,colSize,maps) || dist[newRow][newCol]!=0) continue;
                
                dist[newRow][newCol]=dist[now[0]][now[1]]+1;
                q.offer(new int[]{newRow,newCol});
            }
            
        }
        
        return dist[endRow][endCol] == 0 ? -1 : dist[endRow][endCol];
        
    }
    
}