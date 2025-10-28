import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int T, W;
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int[] arr;
    private static int[][] dp;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new int[T + 1];
        dp = new int[W + 1][T + 1];

        for (int i = 1; i <= T; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;


            if (num == 1) dp[0][i] = dp[0][i - 1] + 1;
            else dp[0][i] = dp[0][i - 1];
        }

    }

    private static void operation() {
        for (int w = 1; w <= W; w++) {
            //홀수번 움직임 -> 2번 트리
            //짝수번 움직임 -> 1번트리

            for (int t = 1; t <= T; t++) {
                //자두를 잡을 수 있는가
                int gain = getTree(w) == arr[t] ? 1 : 0;

                dp[w][t] = Math.max(dp[w - 1][t - 1], dp[w][t - 1]) + gain;
            }
        }
        //printMap();
    }

    private static int getTree(int w) {
        //w 홀수 -> 2번 트리
        //w 짝수 -> 1번 트리
        return (w % 2 == 0) ? 1 : 2;
    }

    private static void printMap() {
        for (int i = 0; i <= W; i++) {
            for (int j = 1; j <= T; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        operation();

        int max=0;
        for (int i=0;i<=W;i++){
            max=Math.max(max,dp[i][T]);
        }

        System.out.println(max);
    }
}
