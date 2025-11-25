import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[][] map;
    private static int[] dx = new int[]{0, 0, 1, -1};
    private static int[] dy = new int[]{1, -1, 0, 0};
    private static Queue<int[]> q;
    private static int[][][] distMap;
    private static boolean[][][] visited;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        distMap = new int[N][M][2];
        visited = new boolean[N][M][2];

        q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < M;
    }

    private static void BFS() {
        q.offer(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        distMap[0][0][0] = 1;
        distMap[0][0][1] = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dx[d];
                int nc = now[1] + dy[d];

                if (!isValid(nr, nc) || visited[nr][nc][now[2]]) continue;
                if (now[2] == 1 && map[nr][nc] == 1) continue;

                visited[nr][nc][now[2]] = true;
                distMap[nr][nc][now[2]+map[nr][nc]] = distMap[now[0]][now[1]][now[2]] + 1;
                q.offer(new int[]{nr, nc, now[2] + map[nr][nc]});
            }
        }

    }

    public static void main(String[] args) throws IOException {
        init();
        BFS();

        if (distMap[N - 1][M - 1][0] == 0 && distMap[N - 1][M - 1][1] == 0) {
            System.out.println(-1);
            return;
        }

        if (distMap[N - 1][M - 1][0] == 0) {
            System.out.println(distMap[N - 1][M - 1][1]);
            return;
        }

        if (distMap[N - 1][M - 1][1] == 0) {
            System.out.println(distMap[N - 1][M - 1][0]);
            return;
        }

        System.out.println(Math.min(distMap[N - 1][M - 1][0], distMap[N - 1][M - 1][1]));
    }
}
