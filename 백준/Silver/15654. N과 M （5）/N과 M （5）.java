import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static StringTokenizer st;
    private static boolean[] visited;
    private static int[] arr;
    private static int[] record;
    private static StringBuilder sb;
    private static void dfs(int depth){
        if( depth==M ){
            for (int i=0;i<M;i++){
                sb.append(record[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=0;i<N;i++){
            if(!visited[i]){
                visited[i]=true;
                record[depth]=arr[i];
                dfs(depth+1);
                visited[i]=false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new int[N];
        record=new int[M];
        visited=new boolean[N];
        st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();

        for (int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);

        System.out.println(sb.toString());
    }

}
