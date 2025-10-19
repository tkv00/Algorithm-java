import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int T,N;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[][]arr;
    private static int[][] dp;
    private static StringBuilder sb=new StringBuilder();

    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));

        T=Integer.parseInt(br.readLine());

        for (int i=0;i<T;i++){
            N=Integer.parseInt(br.readLine());
            arr=new int[2][N];
            dp=new int[2][N+1];

            for (int row=0;row<2;row++){
                st=new StringTokenizer(br.readLine());
                for (int col=0;col<N;col++){
                    arr[row][col]=Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1]=arr[0][0];
            dp[1][1]=arr[1][0];

            operation();
            sb.append(Math.max(dp[0][N],dp[1][N])).append("\n");
        }
    }
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(sb);
    }

    private static void operation() {
        for (int i=2;i<=N;i++){
            dp[0][i]=Math.max(dp[1][i-1],dp[1][i-2])+arr[0][i-1];
            dp[1][i]=Math.max(dp[0][i-1],dp[0][i-2])+arr[1][i-1];
        }
    }
}
