

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br;
    private static char[] input1;
    private static char[] input2;
    private static int[][] dp;
    private static int row, col;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        input1 = br.readLine().toCharArray();
        input2 = br.readLine().toCharArray();

        row = input1.length;
        col = input2.length;

        dp = new int[row + 1][col + 1];
    }

    private static void dynamicProgramming() {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (input1[i-1] == input2[j-1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        dynamicProgramming();

        System.out.println(dp[row][col]);
    }
}
