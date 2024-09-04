import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static StringTokenizer st;
    static int[][] map;
    static int[] dx = {1, 0, 0};
    static int[] dy = {0, 1, -1};
    static boolean[][] visited;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = map[1][1];

        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                for (int j = 2; j <= M; j++) dp[1][j] = dp[1][j - 1] + map[i][j];
            } else {
                //왼쪽->오른쪽
                int[] leftToRight = new int[M + 1];
                //오른쪽=>왼쪽
                int[] rightToLeft = new int[M + 1];

                leftToRight[1] = map[i][1]+dp[i-1][1];
                for (int j = 2; j <= M; j++) {
                    leftToRight[j] = Math.max(leftToRight[j - 1],dp[i-1][j]) + map[i][j];
                }

                rightToLeft[M] = map[i][M]+dp[i-1][M];
                for (int j = M-1; j >=1; j--) {
                    rightToLeft[j] = Math.max(rightToLeft[j+1],dp[i-1][j]) + map[i][j];
                }

                for (int j = 1; j <= M; j++) {
                    dp[i][j] = Math.max(leftToRight[j], rightToLeft[j]);
                }
            }

        }
        System.out.println(dp[N][M]);


    }
}
