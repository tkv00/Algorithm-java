
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static final int MAX = 50_001;
    private static int[] dp = new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp[1]=1;

        for (int i=2;i<MAX;i++){
            int min=4;
            for (int j=1;j*j<=i;j++){
                min=Math.min(min,dp[i-j*j]);
            }
            dp[i]=min+1;
        }

       // System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);
    }
}
