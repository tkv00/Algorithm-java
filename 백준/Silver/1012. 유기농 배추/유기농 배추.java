import java.util.*;
import java.io.*;
public class Main {
    private static int T;
    private static StringTokenizer st;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx=new int[]{0,0,1,-1};
    private static int[] dy=new int[]{1,-1,0,0};
    private static Queue<Node> q;
    private static int M;
    private static int N;
    private static int K;
    private static int cnt;
    private static class Node{
        int row;
        int col;
        Node(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    private static boolean isValid(int row,int col){
        return row>=0 && row<M && col>=0 && col<N && !visited[row][col] && map[row][col]==1;
    }

    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<T;i++){
            st=new StringTokenizer(br.readLine());
            M=Integer.parseInt(st.nextToken());
            N=Integer.parseInt(st.nextToken());
            K=Integer.parseInt(st.nextToken());

            visited=new boolean[M][N];
            map=new int[M][N];

            for(int j=0;j<K;j++){
                st=new StringTokenizer(br.readLine());
                int row=Integer.parseInt(st.nextToken());
                int col=Integer.parseInt(st.nextToken());
                map[row][col]=1;
            }
            q=new LinkedList<>();
            cnt=0;
            for(int j=0;j<M;j++){
                for(int k=0;k<N;k++){
                    if(map[j][k]==1 && !visited[j][k]){
                        q.offer(new Node(j,k));
                        visited[j][k]=true;
                        while(!q.isEmpty()){
                            Node now=q.poll();
                            for(int x=0;x<4;x++){
                                int newRow=now.row+dx[x];
                                int newCol=now.col+dy[x];
                                if(isValid(newRow,newCol)){
                                    q.offer(new Node(newRow,newCol));
                                    visited[newRow][newCol]=true;
                                }
                            }
                        }
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}
