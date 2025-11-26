import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int K;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static List<Integer>[] graph;
    private static int[] colors;
    private static int V,E;
    private static StringBuilder sb;
    private static boolean flag;
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        K=Integer.parseInt(br.readLine());
        sb=new StringBuilder();

        for (int i=0;i<K;i++){
            flag=false;
            st=new StringTokenizer(br.readLine());
            V=Integer.parseInt(st.nextToken());
            E=Integer.parseInt(st.nextToken());

            colors=new int[V+1]; //0:미방문 1:Red -1:Blue
            graphInit(V,E);

            flag=false;
            for (int v=1;v<=V;v++){
                if (colors[v]==0){
                    if (!DFS(v,1)) {
                        flag = true;
                        break;
                    }
                }
            }

            sb.append(flag ? "NO" : "YES").append("\n");
        }
    }

    private static void graphInit(int v,int e) throws IOException {
        graph=new List[v+1];
        for (int i=1;i<=v;i++){
            graph[i]=new ArrayList<>();
        }

        for (int i=0;i<e;i++){
            st=new StringTokenizer(br.readLine());

            int node1=Integer.parseInt(st.nextToken());
            int node2=Integer.parseInt(st.nextToken());

            graph[node1].add(node2);
            graph[node2].add(node1);
        }
    }

    private static boolean DFS(int now,int prevColor){
        colors[now]=prevColor;

        for (int next:graph[now]){
            //방문 하지 않은 경우
            if (colors[next]==0){
                if (!DFS(next,-prevColor)) return false;
            }
            //방문 한 경우 => 색깔 비교
            else if (colors[next]==prevColor) return false;
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(sb);
    }
}
