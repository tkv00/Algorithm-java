import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int N;
    public static int []dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        dp=new int[N+1];
        dp[0]=0;
        for(int i=1;i<N+1;i++){
            dp[i]=i-1;
        }

        for(int i=2;i<N;i++){
            dp[i+1]=dp[i]+1;
            if((i+1)%3==0){

                dp[i+1]=Math.min(dp[i+1],dp[(i+1)/3]+1);
               // System.out.println(i+1+" "+dp[i+1]);
            }
            if((i+1)%2==0){
                dp[i+1]=Math.min(dp[i+1],dp[(i+1)/2]+1);
            }

        }
        //System.out.println(Arrays.toString(dp));

        System.out.println(dp[N]);


    }

}
