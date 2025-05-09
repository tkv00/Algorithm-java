import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[]arr;
    private static int[]dp;
    private static int N;
    private static int Q;
    private static StringTokenizer st;
    public static void main(String[]args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N+1];
        dp=new int[N+1];
        st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        for(int i=1;i<=N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<N;i++){
            if(arr[i]>arr[i+1]){
                dp[i]=1;
            }
            dp[i]+=dp[i-1];
        }

        Q=Integer.parseInt(br.readLine());
        for(int i=1;i<=Q;i++){
            st=new StringTokenizer(br.readLine());
            int num1=Integer.parseInt(st.nextToken());
            int num2=Integer.parseInt(st.nextToken());
            int sum=0;

            sum=dp[num2-1]-dp[num1-1];
            sb.append(sum+"\n");
        }
        System.out.print(sb);
    }
}
