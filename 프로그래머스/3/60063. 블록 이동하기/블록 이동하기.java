import java.util.*;
import java.io.*;

class Solution {
    
    static int[][] map;
    static int[][][] dist;
    static final int[] dx = new int[]{-1,0,1,0};
    static final int[] dy = new int[]{0,1,0,-1};
    static int size;
    static ArrayDeque<int[]> dq;
    static final int HOR = 0; //가로
    static final int VER = 1; //세로
    static int answer;

    static boolean isValid(int row,int col){
        return row>=0 && row<size && col>=0 && col<size && map[row][col]!=1;
    }
    
    static void operation(){
        dq = new ArrayDeque<>();
        dq.offer(new int[]{0,0,HOR});
        
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                dist[i][j][0]=-1;
                dist[i][j][1]=-1;
            }    
        }
        
        dist[0][0][HOR]=0;
        
        while(!dq.isEmpty()){
            int[] now = dq.poll();
            int r1 = now[0];
            int c1 = now[1];
            int state = now[2];
            
            //1. move
            int r2 = r1 + (state==VER ? 1 : 0);
            int c2 = c1 + (state==HOR ? 1 : 0);
            
            if((r1==size-1 && c1==size-1) || (r2==size-1 && c2==size-1)){
                answer = dist[r1][c1][state];
                
                return;
            }
            
            for(int d=0;d<4;d++){
                int nr= r1+dx[d];
                int nc = c1+dy[d];
                
                int nr2=r2+dx[d];
                int nc2=c2+dy[d];
                
                if(!isValid(nr,nc) || !isValid(nr2,nc2)) continue;
                if(dist[nr][nc][state]!=-1) continue;
                
                dist[nr][nc][state] = dist[r1][c1][state] + 1;
                dq.offer(new int[]{nr,nc,state});
            }
            
            
            //2. rotate
            if(state==HOR){
                //이거는 위로 회전 가능
                if(isValid(r1-1,c1) && isValid(r2-1,c2)){
                    //r1,c1 기준축
                    if(dist[r1-1][c1][VER]==-1){
                        dist[r1-1][c1][VER]=dist[r1][c1][HOR]+1;
                        dq.offer(new int[]{r1-1,c1,VER});
                    }
                    
                    //r2,c2 기준축
                    if(dist[r2-1][c2][VER]==-1){
                        dist[r2-1][c2][VER] = dist[r1][c1][HOR]+1;
                        dq.offer(new int[]{r2-1,c2,VER});
                    }
                }
                
                //이거는 아래로 회전 가능
                if(isValid(r1+1,c1) && isValid(r2+1,c2)){
                    //r1,c1 기준축
                    if(dist[r1][c1][VER]==-1){
                        dist[r1][c1][VER] = dist[r1][c1][HOR]+1;
                        dq.offer(new int[]{r1,c1,VER});
                    }
                    
                    //r2,c2 기준축
                    if(dist[r2][c2][VER]==-1){
                        dist[r2][c2][VER]=dist[r1][c1][HOR]+1;
                        dq.offer(new int[]{r2,c2,VER});
                    }
                }
            }else if(state==VER){
                //1. 왼쪽면으로 회전
                if(isValid(r1,c1-1) && isValid(r2,c2-1)){
                    //1) r1,c1 기준축
                    if(dist[r1][c1-1][HOR]==-1){
                        dist[r1][c1-1][HOR] = dist[r1][c1][VER]+1;
                        dq.offer(new int[]{r1,c1-1,HOR});
                    }
                    //2) r2,c2 기준축
                    if(dist[r2][c2-1][HOR]==-1){
                        dist[r2][c2-1][HOR] = dist[r1][c1][VER]+1;
                        dq.offer(new int[]{r2,c2-1,HOR});
                    }
                }
                
                //2. 오른쪽면으로 회전
                if(isValid(r1,c1+1) && isValid(r2,c2+1)){
                    //1) r1, c1 기준축
                    if(dist[r1][c1][HOR]==-1){
                        dist[r1][c1][HOR] = dist[r1][c1][VER]+1;
                        dq.offer(new int[]{r1,c1,HOR});
                    }
                    
                    //2) r2, c2 기준축
                    if(dist[r2][c2][HOR]==-1){
                        dist[r2][c2][HOR] = dist[r1][c1][VER]+1;
                        dq.offer(new int[]{r2,c2,HOR});
                    }
                }
            }
        }
    }
    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        size = board.length;
        dist = new int[size][size][2];
        map = new int[size][size];
        for(int i=0;i<size;i++){
            map[i]=board[i].clone();
        }
        
        operation();
        
    
        return answer;
    }
}