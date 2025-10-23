import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int[] arr;
    private static int[] dp;
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        arr=new int[N+1];
        dp=new int[N+1];

        for (int i=1;i<=N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

    }
    public static void main(String[] args) throws IOException {
        init();
        dp[1]=arr[1];
        for (int i=2;i<=N;i++){
            for (int j=1;j<=i;j++){
                dp[i]=Math.max(dp[i],arr[j]+dp[i-j]);
            }
        }

        System.out.println(dp[N]);
    }
}
