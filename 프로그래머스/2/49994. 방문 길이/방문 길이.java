import java.util.*;
class Point{
    int x;
    int y;
    
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    private static int[] dx={0,-1,0,1};
    private static int[] dy={-1,0,1,0};
    private static boolean[][]visited;
    
    //적합성 판단
    private static boolean isValid(int x,int y){
        if(x<1 || x>=12 || y<1 || y>=12)return false;
        return true;
    }
    public int solution(String dirs) {
        int size=dirs.length();
        char[] array=dirs.toCharArray();
        int result=0;
        //11*11
        visited=new boolean[12][12];
        //(0,0) 방문처리
        visited[5][5]=true;
        
        Deque<Point> dq=new ArrayDeque<>();
        dq.addFirst(new Point(5,5));
        
        for(int i=0;i<size;i++){
            Point now=dq.pollLast();
            int now_x=now.x;
            int now_y=now.y;
            
            switch(array[i]){
                case 'L':
                    int new_x=now_x+dx[0];
                    int new_y=now_y+dy[0];
                    if(!isValid(new_x,new_y)) continue;
                    
                    //방문 안 한 경우
                    if(!visited[new_x][new_y]){
                        visited[new_x][new_y]=true;
                        result++;
                    }
                    dq.addFirst(new Point(new_x,new_y));
                    break;
                    
                case 'U':
                    int new_x=now_x+dx[1];
                    int new_y=now_y+dy[1];
                    if(!isValid(new_x,new_y)) continue;
                    
                    //방문 안 한 경우
                    if(!visited[new_x][new_y]){
                        visited[new_x][new_y]=true;
                        result++;
                    }
                    dq.addFirst(new Point(new_x,new_y));
                    break;
                    
                 case 'R':
                    int new_x=now_x+dx[2];
                    int new_y=now_y+dy[2];
                    if(!isValid(new_x,new_y)) continue;
                    
                    //방문 안 한 경우
                    if(!visited[new_x][new_y]){
                        visited[new_x][new_y]=true;
                        result++;
                    }
                    dq.addFirst(new Point(new_x,new_y));
                    break;
                
                 case 'D':
                    int new_x=now_x+dx[3];
                    int new_y=now_y+dy[3];
                    if(!isValid(new_x,new_y)) continue;
                    
                    //방문 안 한 경우
                    if(!visited[new_x][new_y]){
                        visited[new_x][new_y]=true;
                        result++;
                    }
                    dq.addFirst(new Point(new_x,new_y));
                    break;
                    
            }
        }
        return result;
        
    }
}