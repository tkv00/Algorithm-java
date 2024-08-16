import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][]map;
    static int[][]dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n+1][m+1];
        dp=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
           String str=br.readLine();
           for(int j=1;j<=m;j++){
              int curr=str.charAt(j-1)-'0';
              map[i][j]=curr;
           }

        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=map[i][j];
            }
        }

        int res=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){

                if(map[i][j]!=0){
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1])+1;
                    res=Math.max(res,dp[i][j]);
                }else{
                    dp[i][j]=0;
                }
            }
        }
      //  System.out.println(Arrays.deepToString(dp));
        System.out.println(res*res);


    }
}
