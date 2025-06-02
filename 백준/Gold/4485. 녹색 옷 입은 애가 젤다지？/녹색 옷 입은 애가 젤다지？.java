import java.util.*;
import java.io.*;
import java.lang.*;
public class Main {
    private static int[][] arr;
    private static StringTokenizer st;
    private static int[] dRow={1,-1,0,0};
    private static int[] dCol={0,0,1,-1};

    private static class Node implements Comparable<Node>{
        int row;
        int col;
        int cost;
        public Node(int row,int col,int cost){
            this.row=row;
            this.col=col;
            this.cost=cost;
        }
        @Override
        public int compareTo(Node o){
            return this.cost-o.cost;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int idx=1;
        while(true){
            int N=Integer.parseInt(br.readLine());
            if(N==0) break;

            arr=new int[N][N];
            for(int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            int cost=bfs(N);
            sb.append("Problem ").append(idx).append(": ").append(cost).append("\n");
            idx++;
        }
        System.out.print(sb);
    }
    private static int bfs(int N){
        Queue<Node> pq=new PriorityQueue<>();
        int[][] move=new int[N][N];
        for(int i=0;i<N;i++){
            Arrays.fill(move[i],Integer.MAX_VALUE);
        }
        pq.add(new Node(0,0,arr[0][0]));
        move[0][0]=arr[0][0];

        while(!pq.isEmpty()){
            Node now=pq.poll();
            int nr=now.row;
            int nc=now.col;
            int cost=now.cost;
            if(nr==N-1 && nc==N-1)return cost;

            for(int i=0;i<4;i++){
                int newRow=now.row+dRow[i];
                int newCol=now.col+dCol[i];

                if(newRow<0 || newRow>=N || newCol<0 || newCol>=N) continue;

                if(cost+arr[newRow][newCol]<move[newRow][newCol]){
                    move[newRow][newCol]=cost+arr[newRow][newCol];
                    pq.add(new Node(newRow,newCol,move[newRow][newCol]));
                }
            }
        }
        return -1;
    }
}
