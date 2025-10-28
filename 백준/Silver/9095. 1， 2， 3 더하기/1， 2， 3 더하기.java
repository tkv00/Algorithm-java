
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        int T=Integer.parseInt(br.readLine());

        for (int i=0;i<T;i++){
            int num=Integer.parseInt(br.readLine());
            dynamicProgramming(num);
        }

        System.out.println(sb);
    }

    private static void dynamicProgramming(int num){
        int[] dp=new int[12];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;

        for (int i=4;i<=num;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }

        sb.append(dp[num]).append("\n");
    }
}
