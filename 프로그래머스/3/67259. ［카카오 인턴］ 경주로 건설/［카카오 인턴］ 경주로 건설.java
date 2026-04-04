import java.util.*;
class Solution {
    private static final int EMPTY=0;
    private static final int WALL=1;
    //직선 도로 -> 100원
    private static final int STR=100;
    //코너 -> 500원
    private static final int CORNER=500;
    
    private static int[] dx=new int[]{0,1,0,-1};//오른쪽, 아래, 왼쪽, 위
    private static int[] dy=new int[]{1,0,-1,0};
    
    private static int rowSize;
    private static int colSize;
    private static int[][][] costMap;
    private static final int INF=987654321;
    private static PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[3]-b[3]); 
    
    private static boolean isValid(int row,int col,int d){
        return row>=0 && row<rowSize && col>=0 && col<colSize ;
    }
    
    private static void setUpMaxValue(){
        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                if(i==0 && j==0) continue;
                
                for(int k=0;k<4;k++){
                    costMap[i][j][k]=INF;
                }
            }
        }
    }

    public int solution(int[][] board) {
        rowSize=board.length;
        colSize=board[0].length;
        
        costMap=new int[rowSize][colSize][4];
        setUpMaxValue();
        
        q.offer(new int[]{0,0,0,0});
        q.offer(new int[]{0,0,1,0});
        
        while(!q.isEmpty()){
            int[] now=q.poll();
            
            for(int d=0;d<4;d++){
                int nx=now[0]+dx[d];
                int ny=now[1]+dy[d];
                int prevDir=now[2];
                int preCost=now[3];
                
                if(isValid(nx,ny,d) && board[nx][ny]==EMPTY){        
                    int nextCost=0;
                    
                    if(prevDir==d){
                        nextCost=preCost+100;
                    }else{
                        nextCost=preCost+600;
                    }
                    
                    if(nextCost > costMap[nx][ny][d]) continue;
                    
                    costMap[nx][ny][d]=nextCost;
                    q.offer(new int[]{nx,ny,d,nextCost});
                }
            }
        }
        
        int min=INF;
        
        for(int i=0;i<4;i++){
            min=Math.min(min,costMap[rowSize-1][colSize-1][i]);
        }
        
        return min;
        
    }
}