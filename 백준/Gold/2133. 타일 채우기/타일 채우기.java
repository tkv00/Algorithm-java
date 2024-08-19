import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.exit;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        if(n%2==1){
           System.out.println(0);
           exit(0);
        }
        int k=n/2;
        dp=new int[k+1];
        dp[1]=3;
        if(k>1){
          dp[2]=11;
        }
        int sum=0;
        if(k==1){
            System.out.println(dp[1]);
            exit(0);
        }
        int tmp=0;
        for(int i=3;i<=k;i++){
            dp[i]=dp[i-1]*3+2+(tmp+=dp[i-2]*2);
        }

        System.out.println(dp[k]);
    }
}
