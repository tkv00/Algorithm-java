import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static int n, k;
    public static long[][] dp;
    public static Set<Long> set=new HashSet<>();
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            set.add(Long.parseLong(br.readLine()));
        }
        int setSize=set.size();
        dp = new long[setSize+1][k + 1];

        for(int i=0;i<=setSize;i++){
            Arrays.fill(dp[i], 100001);
            dp[i][0]=0;
        }


        long[] newArr=new long[setSize];
        int index=0;
        for(long i:set){
            newArr[index++]=i;
        }
        Arrays.sort(newArr);
       // System.out.println(Arrays.toString(newArr));

        for(int i=1;i<=setSize;i++){
            for(int j=1;j<=k;j++){
                if(j-newArr[i-1]>=0){
                    dp[i][j]=Math.min(1+dp[i][(int) (j-newArr[i-1])],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }

            }
        }
      //  System.out.println(Arrays.deepToString(dp));
       long res=dp[setSize][k];
       if(res==100001){
           System.out.println(-1);
       }else{
           System.out.println(res);
       }


    }
}
