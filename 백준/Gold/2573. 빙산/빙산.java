import java.io.*;
import java.util.*;

public class Main {
    private static class Node{
        int row;
        int col;
        Node(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    private static boolean isValid(int row,int col){
        return row>=0 && row<N && col>=0 && col<M;
    }
    private static int N;
    private static int M;
    private static int[][] map;
    private static StringTokenizer st;
    private static int[] dx=new int[]{0,0,1,-1};
    private static int[] dy=new int[]{1,-1,0,0};
    private static boolean[][]visited;
    private static Queue<Node> q;
    private static int year=0;
    //개수 세기
    private static int count(){
        int cnt=0;
        visited=new boolean[N][M];
        q=new LinkedList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(isValid(i,j) && !visited[i][j] && map[i][j]!=0){
                    q.offer(new Node(i,j));
                    visited[i][j]=true;
                    while(!q.isEmpty()){
                        Node now=q.poll();
                        for(int k=0;k<4;k++){
                            int newRow=now.row+dx[k];
                            int newCol=now.col+dy[k];
                            if(isValid(newRow,newCol) && !visited[newRow][newCol] && map[newRow][newCol]!=0){
                                visited[newRow][newCol]=true;
                                q.offer(new Node(newRow,newCol));
                            }
                        }
                    }
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            int cnt=count();
            if(cnt>=2 ) break;
            if(cnt==0) {
                year=0;
                break;
            }

            visited=new boolean[N][M];
            q=new LinkedList<>();
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]!=0){
                        q.offer(new Node(i,j));
                    }
                }
            }
            int[][]meltMap=new int[N][M];

            while(!q.isEmpty()){
                Node now=q.poll();
                int zero=0;
                for(int i=0;i<4;i++){
                    int newRow=now.row+dx[i];
                    int newCol=now.col+dy[i];
                    if(isValid(newRow,newCol) && map[newRow][newCol]==0){
                        zero++;
                    }
                }
                meltMap[now.row][now.col]=zero;
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]>0){
                        map[i][j]=Math.max(0,map[i][j]-meltMap[i][j]);
                    }
                }
            }
            year++;
        }
        System.out.print(year);
    }
}
