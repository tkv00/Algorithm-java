import java.io.*;
import java.util.*;
public class Main {
    private static int N;
    private static int INF=10007;
    private static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        dp=new int[N+1];
        if(N<=1){
            System.out.print(1);
            return;
        }
        dp[1]=1;
        dp[2]=3;

        for(int i=3;i<=N;i++){
            dp[i]=(dp[i-1]+2*dp[i-2])%INF;
        }

        System.out.print(dp[N]);
    }

}
