import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static char[] str1;
    public static char[] str2;
    public static int [][] dp;
    public static int len;

    public static Stack<Character> res;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        str1= br.readLine().toCharArray();
        str2=br.readLine().toCharArray();
        int len1=str1.length;
        int len2=str2.length;
        res=new Stack<Character>();

        dp=new int[len1+1][len2+1];
        //dp테이블 채우기
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(str1[i-1]==str2[j-1]) dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
       // System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[len1][len2]);
        int initialx=len1;
        int initialy=len2;
        //프린트(역추적)
        while (initialx>0 && initialy>0){
            if(dp[initialx][initialy]==dp[initialx-1][initialy]){
                initialx--;
            }
            else if(dp[initialx][initialy]==dp[initialx][initialy-1]){
                initialy--;
            }
            else{
                res.push(str1[initialx-1]);
                initialx--;
                initialy--;
            }
        }
        while (!res.isEmpty()){
            System.out.print(res.pop());
        }


    }
}
