import java.io.*;
import java.util.*;
public class Main {
    private static int N;
    private static int[][] dp;
    private static final int INF=10007;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        dp=new int[N+1][10];
        for(int i=0;i<10;i++){
            dp[1][i]=1;
        }

        for(int i=2;i<=N;i++){
            for(int j=0;j<10;j++){
                for(int k=j;k<10;k++){
                   
                    dp[i][j]+=dp[i-1][k]%INF;
                    
                }
            }
        }
        int sum=0;
        for(int i=0;i<10;i++){
            sum+=dp[N][i];
            sum%=INF;
        }
        System.out.print(sum);

    }
}
