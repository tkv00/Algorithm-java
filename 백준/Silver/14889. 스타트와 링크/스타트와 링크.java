import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Main {
    static int n;
    static int[][] map;
    static StringTokenizer st;
    //결과값 (최소)
    static int res = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n];
        //절반만 체크하고 나머지 수들 더하기
        dfs(0, 0);
        System.out.println(res);

    }

    static void dfs(int depth, int k) {
        if (depth == n / 2) {
            diff();
            return;
        }
        for (int i = k; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }

    }

    static void diff() {
        int startTeam = 0;
        int linkTeam = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //체크된 사람들
                if (visited[i] && visited[j]) {
                    startTeam += map[i][j];
                    startTeam += map[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkTeam += map[i][j];
                    linkTeam += map[j][i];
                }
            }
        }
        //처ㅣ솟값 비교
        int k = Math.abs(startTeam - linkTeam);
        res = Math.min(res, k);
        if (res == 0) {
            System.out.println(res);
            exit(0);
        }
    }

}
