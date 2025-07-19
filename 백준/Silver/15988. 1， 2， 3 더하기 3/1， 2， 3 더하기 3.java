import java.io.*;
import java.util.*;
public class Main {
    private static int INF=1000000009;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int N=Integer.parseInt(br.readLine());
        long[]dp;
        int MAX=-1;
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            int num=Integer.parseInt(br.readLine());
            arr[i]=num;
            MAX=Math.max(MAX,num);
        }
        dp=new long[MAX+1];
        dp[0]=1;
        dp[1]=1;
        if(MAX>=2){
            dp[2]=2;
        }
        for(int i=3;i<=MAX;i++){
            dp[i]=(dp[i-1]+dp[i-2]+dp[i-3])%INF;
            
        }
        for(int x:arr){
            sb.append(dp[x]).append("\n");
        }
        System.out.print(sb);
    }
}
