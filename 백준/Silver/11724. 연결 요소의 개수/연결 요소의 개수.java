import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;
    public static int[][] arr;
    public static boolean [] visit;;
    public  static StringTokenizer st;
    public static int res=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        visit=new boolean[N+1];
        arr=new int[N+1][N+1];
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

           arr[start][end]=arr[end][start]=1;

        }
        for(int i=1;i<=N;i++){
            if(!visit[i]){
                res++;
                dfs(i);
                
            }
        }
        System.out.println(res+N-arr.length+1);


    }
    public static void dfs(int x){
        visit[x]=true;
        for(int i=1;i<=N;i++){
            if(!visit[i] && arr[x][i]==1){
                dfs(i);
            }
        }

    }
}
