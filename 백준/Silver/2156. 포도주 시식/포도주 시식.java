import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.exit;

public class Main {
    public static int N;
    public static int[] arr;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[N + 1];
        int sum = 0;
        int idx = 0;

        if (N < 3) {
            if(N==1){
                System.out.println(arr[1]);
                exit(0);
            }else if(N==2){
                System.out.println(arr[1]+arr[2]);
                exit(0);
            }
        }
        dp[1]=arr[1];
        dp[2]=arr[1]+arr[2];
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i], dp[i - 1]);
            sum = Math.max(dp[i], sum);
        }
        System.out.println(dp[N]);
    }


}
