import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int n;
    public static long[][] dp;
    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());

        dp = new long[n + 1][10];

        // dp 테이블의 첫 행 초기화
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // dp 테이블 채우기
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % MOD;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % MOD;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum = (sum + dp[n][i]) % MOD;
        }
        System.out.println(sum);
    }
}