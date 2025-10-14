import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N,K;
    private static int[][] timeMap;
    private static int [][] map;
    private static BufferedReader br;
    private static StringTokenizer st;
    private static final int INF=1_000_000_000;
    private static boolean[] visited;
    private static int result=Integer.MAX_VALUE;

    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        timeMap=new int[N][N];
        map=new int[N][N];
        visited=new boolean[N];

        for (int i=0;i<N;i++){
            Arrays.fill(timeMap[i],INF);
        }

        for (int i=0;i<N;i++){
            timeMap[i][i]=0;
        }

        for (int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                timeMap[i][j]=Math.min(timeMap[i][j],Integer.parseInt(st.nextToken()));
            }
        }
    }

    private static void floyd_warshall(){
        for (int k=0;k<N;k++){
            for (int row=0;row<N;row++){
                for (int col=0;col<N;col++){
                    timeMap[row][col]=Math.min(timeMap[row][col],timeMap[row][k]+timeMap[k][col]);
                }
            }
        }
    }

    private static void DFS(int start,int sum){
        boolean flag=true;
        for (int end=0;end<N;end++){
            //if (start==end)continue;

            if (!visited[end]){
                flag=false;
                visited[end]=true;
                DFS(end,sum+timeMap[start][end]);
                visited[end]=false;
            }
        }
        if (flag){
            result=Math.min(result,sum);
            return;
        }

    }
    private static void printMap(){
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                System.out.print(timeMap[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException {
        init();
        floyd_warshall();
        //printMap();


        DFS(K,0);
        System.out.println(result);
    }
}
