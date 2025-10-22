import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] arr;
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int[][] dp;
    private static int MAX=Integer.MIN_VALUE;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[2][N];

        dp[0][0] = arr[0];
        dp[1][0] = arr[0];

        MAX=arr[0];

        for (int i = 1; i < N; i++) {
            dp[0][i] = Math.max(dp[0][i - 1] + arr[i], arr[i]);
            dp[1][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + arr[i]);
            MAX=Math.max(dp[0][i],Math.max(dp[1][i],MAX));
        }
        System.out.println(MAX);
    }

    public static void main(String[] args) throws IOException {
        init();
    }
}
