import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][][] dp;
    public static int[] arr;
    public static int N;
    public static int T;
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[T + 1];
        dp = new int[T + 1][N + 1][3];

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= T; i++) {
            for (int j = 0; j <= N; j++) {
                if (j == 0) {
                    dp[i][j][1] = dp[i - 1][j][1] + (arr[i] == 1 ? 1 : 0);
                } else {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]) + (arr[i] == 1 ? 1 : 0);
                    dp[i][j][2] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j][2]) + (arr[i] == 2 ? 1 : 0);
                }
            }
        }
        int max = 0;
        for (int i = 0; i <= N; i++) {
            max = Math.max(max, Math.max(dp[T][i][1], dp[T][i][2]));
        }
        System.out.println(max);
    }
}
