import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int n,k;
    private static int[] coins;
    private static int[] dp;
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        dp=new int[k+1];
        coins=new int[n];
        dp[0]=1;

        for (int i=0;i<n;i++){
            coins[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins);
    }

    private static void dynamicProgramming(){
        for (int coin=0;coin<n;coin++){
            for (int j=coins[coin];j<=k;j++){
                dp[j]+=dp[j-coins[coin]];
            }
        }
    }


    public static void main(String[] args) throws IOException {
        init();
        dynamicProgramming();
        System.out.println(dp[k]);
    }
}
