import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Main {
     public static int findParent(int v,int[]arr){
        if(v==arr[v]) return v;
        return arr[v]=findParent(arr[v],arr);
    }
   public static void Union(int[]arr,int a,int b){
        a=findParent(a,arr);
        b=findParent(b,arr);

        if(b<a) arr[a]=b;
        else arr[b]=a;
    }


    public static int N;
    public static int M;
    public static StringTokenizer st;
    public static int[] plan;
    public static int [][]graph;
    public static int[]dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        M=Integer.parseInt(br.readLine());
        plan=new int[M+1];
        dp=new int[N+1];
        graph=new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            dp[i]=i;
        }
        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=M;i++){
            plan[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(graph[i][j]==1){
                    Union(dp,i,j);
                }
            }
        }
        int index=findParent(plan[1],dp);
        for(int i=2;i<=M;i++){
            if(index!=findParent(plan[i],dp)){
                System.out.println("NO");
                exit(0);
            }

        }
        System.out.println("YES");


    }
}
