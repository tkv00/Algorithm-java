import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[][]arr;
    public static StringTokenizer st;
    public static int []dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        arr=new int[2][n+2];
        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine());
            int day=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            arr[0][i]=day;
            arr[1][i]=cost;
        }
        dp=new int[n+2];
        int max=-1;

        for(int i=1;i<=n+1;i++){
            if(dp[i]>max){
                max=dp[i];
            }
            int next=i+arr[0][i];
            if(next<n+2){
                dp[next]=Math.max(dp[next],max+arr[1][i] );
            }

        }
        System.out.println(max);
    }
}



