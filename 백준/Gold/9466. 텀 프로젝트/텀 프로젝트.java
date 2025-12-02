import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int T;
    private static int n;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[] input;
    private static int cnt;
    private static boolean[] visited;
    private static boolean[] done;
    private static StringBuilder sb;
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(br.readLine());
        sb=new StringBuilder();

        for (int t=0;t<T;t++){
            int N=Integer.parseInt(br.readLine());
            input=new int[N+1];
            cnt=0;
            st=new StringTokenizer(br.readLine());

            done=new boolean[N+1];
            visited=new boolean[N+1];

            for (int j=1;j<=N;j++){
                input[j]=Integer.parseInt(st.nextToken());
            }

            for (int j=1;j<=N;j++){
                operation(j);
            }

            sb.append(N-cnt).append("\n");
        }
    }

    private static void operation(int node){
        visited[node]=true;
        int next=input[node];

        if (!visited[next]){
            operation(next);
        }

        else if (!done[next]){
            for (int i=next;i!=node;i=input[i]){
                cnt++;
            }
            cnt++;
        }

        done[node]=true;
    }
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(sb);
    }
}
