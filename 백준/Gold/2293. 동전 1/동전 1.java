
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n, k;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[] dp;
    private static int[] inputs;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        inputs = new int[n];
        dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(inputs);
    }

    private static void operation() {
        for (int i = 0; i < n; i++) {
            for (int money = inputs[i]; money <= k; money++) {
                dp[money]+=dp[money-inputs[i]];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        operation();

        System.out.println(dp[k]);
    }
}
