import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] arrayLists;
    static int[][] dp;
    static int n;
    static boolean[] visited;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        //1열은 자신이 얼리어답터인 경우,2열은 자신이 얼리어답터가 아닌 경우
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];
        arrayLists = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arrayLists[start].add(end);
            arrayLists[end].add(start);
        }
        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));

    }

    static void dfs(int n) {
        //방문 처리
        visited[n] = true;

        //얼리인경우
        dp[n][0] = 1;
        //아닌 경우
        dp[n][1] = 0;

        for (int child : arrayLists[n]) {
            if (!visited[child]) {
                //우선 자식 탐색
                dfs(child);
                //얼리인 경우 -> 자식은 얼리가 아니여도 됨
                dp[n][0] += Math.min(dp[child][0], dp[child][1]);
                //아닌 경우 -> 자식은 무조건 얼리여야함
                dp[n][1] += dp[child][0];
            }
        }
    }
}
