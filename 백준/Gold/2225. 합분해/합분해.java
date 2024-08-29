import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int col;
    static int row;
    static int res=0;
    static long[][]dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        col=Integer.parseInt(st.nextToken());
        row=Integer.parseInt(st.nextToken());
        dp=new long[row+1][col+1];
        for(int i=0;i<=col;i++){
            dp[1][i]=1;
        }
        for(int j=0;j<=row;j++){
            dp[j][0]=1;
        }
        for(int i=2;i<=row;i++){
            for(int j=1;j<=col;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
                dp[i][j]%=1000000000;
            }
        }
        System.out.println(dp[row][col]);





    }

}
