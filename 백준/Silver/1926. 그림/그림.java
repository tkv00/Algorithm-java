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
    private static int N,M;
    private static StringTokenizer st;
    private static int[][] map;
    private static boolean[][] visited;
    private static int cnt=0;
    private static int max=Integer.MIN_VALUE;
    private static int size=0;
    private static Queue<Node> q;
    private static int[] dx=new int[]{0,0,1,-1};
    private static int[] dy=new int[]{1,-1,0,0};
    private static boolean isValid(int row,int col){
        return row >= 0 && row < N && col >= 0 && col < M && !visited[row][col] && map[row][col]==1;
    }
    public static void main(String[]args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        visited=new boolean[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==1 && !visited[i][j]){
                    size=1;
                    q=new LinkedList<>();
                    q.offer(new Node(i,j));
                    visited[i][j]=true;

                    while(!q.isEmpty()){
                        Node now=q.poll();
                        for(int k=0;k<4;k++){
                            int newRow=now.row+dx[k];
                            int newCol=now.col+dy[k];
                            if(isValid(newRow,newCol)){
                                visited[newRow][newCol]=true;
                                q.offer(new Node(newRow,newCol));
                                size++;
                            }
                        }
                    }
                    cnt++;
                    max=Math.max(max,size);
                }
            }
        }
        if(cnt==0){
            System.out.print("0"+"\n"+"0");
            return;
        }
        System.out.print(cnt+"\n"+max);
    }

}
