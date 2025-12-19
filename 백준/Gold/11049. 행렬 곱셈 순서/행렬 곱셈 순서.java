
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int[][] inputs;
    private static int[][] dp;
    private static int N;
    private static final int INF = 1_500_00000;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        inputs = new int[N][2];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            inputs[i][0] = row;
            inputs[i][1] = col;

            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
        }
    }

    private static void operation() {
        for (int len = 2; len <= N; len++) {
            for (int start = 0; start + len - 1 < N; start++) {
                int end = start + len - 1;


                for (int mid = start; mid < end; mid++) {
                    dp[start][end] = Math.min(dp[start][end],
                            dp[start][mid] + dp[mid + 1][end] + (inputs[start][0] * inputs[mid][1] * inputs[end][1]));
                }
            }
        }

        System.out.println(dp[0][N - 1]);
    }

    public static void main(String[] args) throws IOException {
        init();
        operation();
    }
}
