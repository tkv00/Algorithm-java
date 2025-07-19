import java.io.*;
import java.util.*;
public class Main {
    private static int N;
    private static int[] dp;
    private static final int INF=15746;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        dp=new int[N+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=N;i++){
            dp[i]=(dp[i-1]+dp[i-2])%INF;
        }
        System.out.print(dp[N]%INF);
    }
}
