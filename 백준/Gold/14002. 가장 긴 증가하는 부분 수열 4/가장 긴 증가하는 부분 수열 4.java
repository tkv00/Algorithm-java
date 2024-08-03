import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Main {
    public static int max;
    public static int[] arr;
    public static int[] dp;
    public static int n;
public static int[]res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if(n==1){
            System.out.println(n);
            System.out.println(arr[0]);
            exit(0);
        }
        dp = new int[n];
        int v = 0;
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, dp[j]);
                }
                dp[i] = max + 1;
            }
            if (v < dp[i]) {
                v = dp[i];
            }

        }


        int k=v;

        res=new int[v+1];
        for (int i = n-1; i >= 0; i--) {
            if (dp[i] == k) {
                res[k]=arr[i];
                k--;

                continue;
            }
        }

        System.out.println(v);
        for(int i=1;i<=v;i++){
            System.out.print(res[i]+" ");
        }

    }
}
