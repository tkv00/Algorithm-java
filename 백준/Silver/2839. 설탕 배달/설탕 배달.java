import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static final int INF=5_001;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        dp=new int[INF];
        Arrays.fill(dp,INF);

        dp[3]=1;
        dp[5]=1;

        for (int i=6;i<=N;i++){
            dp[i]=Math.min(dp[i-3],dp[i-5])+1;
        }

        System.out.println(dp[N]>=INF ? -1 : dp[N]);
    }
}
