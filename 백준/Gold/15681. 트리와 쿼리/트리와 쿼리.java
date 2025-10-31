import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N,R,Q;
    private static BufferedReader br;
    private static StringTokenizer st;
    private static List<Integer>[] graph;
    private static int[] query;
    private static boolean[] visited;
    private static int[] subTreeCount;
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        Q=Integer.parseInt(st.nextToken());
        graph=new List[N+1];
        query=new int[Q];
        visited=new boolean[N+1];
        subTreeCount=new int[N+1];//서브 트리 개수

        for (int i=1;i<=N;i++){
            graph[i]=new ArrayList<>();
        }

        for (int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        for (int i=0;i<Q;i++){
            int num=Integer.parseInt(br.readLine());
            query[i]=num;
        }

    }

    private static int DFS(int root){
        visited[root]=true;
        int cnt=1;

        for (int next:graph[root]){
            if (subTreeCount[next]>0) continue;
            if (visited[next]) continue;
            cnt+=DFS(next);
        }

        return subTreeCount[root]=cnt;
    }

    public static void main(String[] args) throws IOException {
        init();
        DFS(R);
        //System.out.println(Arrays.toString(subTreeCount));

        for (int q:query){
            System.out.println(subTreeCount[q]);
        }
    }
}
