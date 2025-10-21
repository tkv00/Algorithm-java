import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int INF = 1_000_000_000;
    private static int N;
    private static BufferedReader br;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int num = 0;
        if (N==0){
            System.out.println(0);
            System.out.println(0);
            System.exit(0);
        }
        if (N < 0) {
            if (N % 2 != 0) {
                num = 1;
            } else num = -1;
        } else num = 1;

        N = Math.abs(N);

        dp = new int[N + 1];

        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 1] % INF + dp[i - 2] % INF) % INF;
        }

        System.out.println(num);
        System.out.println(dp[N]);
    }
}
