import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[][]map;
    private static int[][] dp;

    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];

        for (int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<i;j++){
                map[i-1][j]=Integer.parseInt(st.nextToken());
            }
        }
    }
    private static void DP(){
        dp=new int[N][N];
        dp[0][0]=map[0][0];

        for (int i=1;i<N;i++){
            for (int j=0;j<=i;j++){
                if (j==0){
                    dp[i][j]=dp[i-1][j]+map[i][j];
                    continue;
                }
                if (j==i){
                    dp[i][j]=dp[i-1][j-1]+map[i][j];
                    continue;
                }

                dp[i][j]=Math.max(dp[i-1][j-1],dp[i-1][j])+map[i][j];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        init();
        DP();

        int max=0;
        for (int i=0;i<N;i++){
            max=Math.max(max,dp[N-1][i]);
        }

        System.out.println(max);
    }
}
