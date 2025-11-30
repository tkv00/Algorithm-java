import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] map;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static final int MAX_VALUE = 1_000_001;
    private static int[][] dp;
    private static int result;
    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][3];
        dp = new int[N][3];
        result=MAX_VALUE;

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], MAX_VALUE);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void dp() {
        for (int color = 0; color < 3; color++) {
            for (int k=0;k<3;k++){
                if (color==k) dp[0][k]=map[0][k];
                else dp[0][k]=MAX_VALUE;
            }

            for (int k=1;k<N;k++){
                dp[k][0]=Math.min(dp[k-1][1],dp[k-1][2])+map[k][0];
                dp[k][1]=Math.min(dp[k-1][0],dp[k-1][2])+map[k][1];
                dp[k][2]=Math.min(dp[k-1][0],dp[k-1][1])+map[k][2];
            }

            for (int k=0;k<3;k++){
                if (k==color) continue;
                result=Math.min(result,dp[N-1][k]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        dp();

        System.out.println(result);
    }
}
