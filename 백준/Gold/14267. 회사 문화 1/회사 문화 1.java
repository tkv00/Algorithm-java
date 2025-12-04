
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[]weights;
    private static Map<Integer, List<Integer>>graph;
    private static int n,m;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static StringBuilder sb;
    private static int[] result;
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        weights=new int[n+1];
        result=new int[n+1];
        graph=new HashMap<>();

        st=new StringTokenizer(br.readLine());

        for (int i=1;i<=n;i++){
            int num=Integer.parseInt(st.nextToken());

            //사장인 경우
            if (num==-1) continue;

            graph.putIfAbsent(num,new ArrayList<>());
            graph.get(num).add(i);
        }

        for (int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int employee=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());

            weights[employee]+=w;
        }
    }

    private static void dfs(int node,int weight){
        if (!graph.containsKey(node)) {
            result[node]=weight;
            return;
        };

        result[node]+=weight;

        for (int next:graph.get(node)){
            dfs(next,weight+weights[next]);
        }
    }
    private static void print(){
        for (int i=1;i<=n;i++){
            sb.append(result[i]).append(" ");
        }
    }
    public static void main(String[] args) throws IOException {
        init();
        dfs(1,0);
        print();
        System.out.println(sb);
    }
}
