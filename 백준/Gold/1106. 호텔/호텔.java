import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int C, N;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[] dp;
     private static final int MAX = 1_000_000_000;
    private static final int MAX_CUSTOMER = 1_101;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        dp = new int[MAX_CUSTOMER];

        Arrays.fill(dp, MAX);
        dp[0]=0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());

            for (int c=customer;c<MAX_CUSTOMER;c++){
                dp[c]=Math.min(dp[c],dp[c-customer]+cost);
            }
        }

    }

    private static int findMin() {
        int min = Integer.MAX_VALUE;
        for (int col = C; col < MAX_CUSTOMER; col++) {
            min = Math.min(min, dp[col]);
        }

        return min;
    }

    public static void main(String[] args) throws IOException {
        init();

        System.out.println(findMin());
    }
}
