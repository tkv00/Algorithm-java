
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] dp = new int[num + 1];

        if (num > 1) {
            dp[2] = 1;
            if (num > 2) {
                dp[3] = 1;
            }

        }

        for (int i = 4; i <= num; i++) {
            if (i%6==0) dp[i]=Math.min(dp[i/2]+1,Math.min(dp[i/3]+1,dp[i-1]+1));
            else if (i % 2 == 0) dp[i] = Math.min(dp[i / 2] + 1, dp[i - 1] + 1);
            else if (i % 3 == 0) dp[i] = Math.min(dp[i / 3] + 1, dp[i - 1] + 1);
            else dp[i] = dp[i - 1] + 1;
        }
        System.out.println(dp[num]);
    }
}
