import java.io.*;
import java.util.*;
public class Main {
    private static int T;
    private static int[][] dp;
    private static StringBuilder sb=new StringBuilder();
    private static void fibonacci(int num){
       dp=new int[2][num+1];
       
       if(num<=1){
        sb.append(Math.abs(num-1)).append(" ").append(num).append("\n");
        return;
        }

       dp[0][0]=1;
       dp[1][0]=0;
       dp[0][1]=0;
       dp[1][1]=1;
       
       for(int i=2;i<=num;i++){
        dp[0][i]=dp[0][i-1]+dp[0][i-2];
        dp[1][i]=dp[1][i-1]+dp[1][i-2];
       }

       sb.append(dp[0][num]).append(" ").append(dp[1][num]).append("\n"); 
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            int input=Integer.parseInt(br.readLine());
            fibonacci(input);
        }
        System.out.println(sb);
    }
    
}
