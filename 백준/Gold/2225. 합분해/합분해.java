
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int N, K;
    private static final int MOD = 1_000_000_000;
    private static int[][] dp;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= K; i++) {
            dp[0][i] = 1;
        }
    }

    private static void dynamicProgramming() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                dp[i][j] = (dp[i - 1][j] % MOD + dp[i][j - 1] % MOD) % MOD;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        dynamicProgramming();

        System.out.println(dp[N][K] % MOD);
    }
}
