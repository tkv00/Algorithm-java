import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.exit;

public class Main {
    public static int n;
    public static int m;
    public static boolean[] arr;
    public static int[] dp;
    public static int cnt = 0;
    public static int num = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new boolean[n + 1];
        dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[x] = true;
        }
        dp[0] = 1;
        dp[1] = 1;
        if(n==1){
            System.out.println(1);
            exit(0);
        }
        dp[2] = 2;
        cnt = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int sum = 1;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[i]) {
                sum *= dp[index];
                index = 0;

            } else {
                index++;
            }


        }
        sum*=dp[index];
        System.out.println(sum);
    }
}
