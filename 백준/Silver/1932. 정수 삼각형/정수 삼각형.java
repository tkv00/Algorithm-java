import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static long[][] arr;
    public static long[][] dp;
    public static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        arr=new long[N+1][N+1];
        dp=new long[N+1][N+1];
        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=i;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=i;j++){
                dp[i][j]=+arr[i][j]+Math.max(dp[i-1][j-1],dp[i-1][j]);
            }
        }
        long Max=0;
        for(int i=1;i<=N;i++){
            Max=Math.max(dp[N][i],Max);
        }
        System.out.println(Max);
    }
}
