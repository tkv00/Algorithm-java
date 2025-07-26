import java.io.*;
import java.util.*;

public class Main {
    private static class Point{
        int row;
        int col;
        Point(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    private static boolean isValid(int row,int col){
        return row>=0 && row<R && col>=0 && col<C;
    }
    private static int beaver(){
        while (!beaverQueue.isEmpty()) {
        int waterSize=waterQueue.size();
        //물 퍼뜨림
        for(int i=0;i<waterSize;i++){
            Point water=waterQueue.poll();
            for(int j=0;j<4;j++){
                int nx=water.row+dx[j];
                int ny=water.col+dy[j];
                if(isValid(nx, ny) && map[nx][ny]=='.' && visitMap[nx][ny]==0){
                    map[nx][ny]='*';
                    waterQueue.add(new Point(nx, ny));
                }
            }
        }
        int beaverSize=beaverQueue.size();
        for(int i=0;i<beaverSize;i++){
            Point now=beaverQueue.poll();
            for(int j=0;j<4;j++){
                int nx=now.row+dx[j];
                int ny=now.col+dy[j];
                if(!isValid(nx, ny)) continue;
                if(visitMap[nx][ny]!=0) continue;
                if(map[nx][ny]=='X') continue;
                if(map[nx][ny]=='*') continue;

                visitMap[nx][ny]=visitMap[now.row][now.col]+1;
                if(map[nx][ny]=='D'){
                   return visitMap[nx][ny]-1;
                    
                }
                beaverQueue.offer(new Point(nx, ny));
              }
          } 
        }
        return -1;
    }
    private static int[][] visitMap;
    private static int R,C;
    private static StringTokenizer st;
    private static char[][] map;
    private static Queue<Point> waterQueue=new LinkedList<>();
    private static Queue<Point> beaverQueue=new LinkedList<>();
    //비버 굴 : D
    //고슴도치 : S
    //비어 있는 곳 : .  물이 차있는 곳 : *  돌 : X  
    private static int[] dx=new int[]{0,0,1,-1};
    private static int[] dy=new int[]{1,-1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        map=new char[R][C];
        visitMap=new int[R][C];
        Point end=null;
        for(int i=0;i<R;i++){
            String input=br.readLine();
            for(int j=0;j<C;j++){
                map[i][j]=input.charAt(j);
                if(map[i][j]=='S') {
                    beaverQueue.offer(new Point(i, j));
                    visitMap[i][j]=1;
                }
                if(map[i][j]=='*') waterQueue.offer(new Point(i, j));
                if(map[i][j]=='D') end=new Point(i, j);
            }
        }
        int result=beaver();
        if(result==-1){
            System.out.print("KAKTUS");
            return;
        }
        System.out.print(result);
    }
    
}
