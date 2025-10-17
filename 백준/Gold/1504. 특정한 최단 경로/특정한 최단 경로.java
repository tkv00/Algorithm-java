import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N,E;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static long[][] graph;
    private static long INF = 1_000_000_000L;
    private static int node_1,node_2;
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());


        N=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());

        graph=new long[N+1][N+1];
        for (int i=0;i<=N;i++){
            Arrays.fill(graph[i],INF);
            graph[i][i]=0;
        }


        for (int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int node1=Integer.parseInt(st.nextToken());
            int node2=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

            graph[node1][node2]=Math.min(cost,graph[node1][node2]);
            graph[node2][node1]=Math.min(cost,graph[node2][node1]);
        }
        st=new StringTokenizer(br.readLine());

        //반드시 들려야 하는 노드
        node_1=Integer.parseInt(st.nextToken());
        node_2=Integer.parseInt(st.nextToken());
    }
    private static void operation(){
        for (int k=1;k<=N;k++){
            for (int i=1;i<=N;i++){
                for (int j=1;j<=N;j++){
                    if (graph[i][k]==INF || graph[k][j]==INF) continue;
                    graph[i][j]=Math.min(graph[i][j],graph[i][k]+graph[k][j]);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        init();
        operation();
        long path_1=graph[1][node_1]+graph[node_1][node_2]+graph[node_2][N];
        long path_2=graph[1][node_2]+graph[node_2][node_1]+graph[node_1][N];
        long result=Math.min(path_1,path_2);
        System.out.println(result >=INF ? -1 : result);
    }
}
