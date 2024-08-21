import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N;
    static int money;
    static StringTokenizer st;
    static long[]dp;
    static int[] sub;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            N=Integer.parseInt(br.readLine());
            sub=new int[N+1];
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<N+1;j++){
                sub[j]=Integer.parseInt(st.nextToken());
            }
            money=Integer.parseInt(br.readLine());
            dp=new long[money+1];

            for(int j=1;j<=N;j++){
                for(int k=1;k<=money;k++){
                    if(sub[j]<k){
                        dp[k]=dp[k]+dp[k-sub[j]];
                    }else if(k-sub[j]==0){
                        dp[k]++;
                    }
                }
            }
            System.out.println(dp[money]);
        }
    }

}
