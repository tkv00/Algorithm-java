import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N,M;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static List<int[]>[] graph;
    private static boolean[] visited;
    private static StringBuilder sb;
    private static List<int[]> query;
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        graph=new List[N+1];
        query=new ArrayList<>();
        sb=new StringBuilder();

        for (int i=1;i<=N;i++){
            graph[i]=new ArrayList<>();
        }

        for (int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

            graph[start].add(new int[]{end,cost});
            graph[end].add(new int[]{start,cost});
        }

        for (int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int node1=Integer.parseInt(st.nextToken());
            int node2=Integer.parseInt(st.nextToken());

            query.add(new int[]{node1,node2});
        }
    }

    private static void operation(int now,int cost,int find){
        if (now==find){
            sb.append(cost).append("\n");
            return;
        }

        visited[now]=true;

        for (int[] next:graph[now]){
            if(visited[next[0]]) continue;

            operation(next[0],cost+next[1],find);
        }
    }
    public static void main(String[] args) throws IOException {
        init();
        for (int[] nodes:query){
            visited=new boolean[N+1];
            operation(nodes[0],0,nodes[1]);
        }

        System.out.println(sb);
    }
}
