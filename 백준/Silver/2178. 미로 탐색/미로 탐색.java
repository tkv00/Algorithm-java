import java.util.*;
import java.io.*;
public class Main {
    private static int N,M;
    private static int[] dx=new int[]{0,0,1,-1};
    private static int[] dy=new int[] {1,-1,0,0};
    private static boolean[][] visited;
    private static int[][] map;
    private static StringTokenizer st;
    private static Queue<Node> q=new LinkedList<>();
    private static class Node{
        int row;
        int col;
        Node(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    private static boolean isValid(int row,int col){
        return row>=0 && row<N && col>=0 && col<M && !visited[row][col] && map[row][col]==1;
    }
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        visited=new boolean[N][M];
        for(int i=0;i<N;i++){
            char[] input=br.readLine().toCharArray();
            for(int j=0;j<M;j++){
                map[i][j]=input[j]-'0';
            }
        }

        q.offer(new Node(0,0));
        visited[0][0]=true;

        while(!q.isEmpty()){
            Node now=q.poll();

            for(int i=0;i<4;i++){
                int newRow=now.row+dx[i];
                int newCol=now.col+dy[i];
                if(isValid(newRow,newCol)){
                    map[newRow][newCol]=map[now.row][now.col]+1;
                    visited[newRow][newCol]=true;
                    q.offer(new Node(newRow,newCol));
                }
            }
        }
        System.out.print(map[N-1][M-1]);
    }
}
