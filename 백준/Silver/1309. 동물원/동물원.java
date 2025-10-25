import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] dp;
    private static final int MOD=9901;
    private static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        dp=new int[N+1][2];

        dp[1][0]=1;
        dp[1][1]=2;

        for (int i=2;i<=N;i++){
            dp[i][0]=(dp[i-1][0]%MOD+dp[i-1][1]%MOD)%MOD;
            dp[i][1]=((dp[i-1][0]%MOD*2)%MOD+dp[i-1][1]%MOD)%MOD;
        }

        System.out.println((dp[N][0]+dp[N][1])%MOD);
    }
}
