import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            dp[i]=arr[i];
        }
        
        dp[1] = arr[1];
        
        int Max=dp[1];
        for (int i = 2; i <= n; i++) {


            for (int j = 1; j < i; j++) {
                if (arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+arr[i]);
                }
            }
            Max=Math.max(dp[i],Max);

        }

        System.out.println(Max);
    }

}
