import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static BufferedReader br;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        T=Integer.parseInt(br.readLine());
        dp=new int[11];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i=4;i<=10;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        for (int i=0;i<T;i++){
            int n=Integer.parseInt(br.readLine());
            sb.append(dp[n]+"\n");
        }
        System.out.println(sb);
    }
}
