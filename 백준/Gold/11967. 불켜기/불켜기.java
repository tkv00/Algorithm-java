import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static final int[] dr = new int[]{0, 0, 1, -1};
    private static final int[] dc = new int[]{1, -1, 0, 0};
    private static boolean[][] visited;
    private static boolean[][] light;
    private static int result = 1;
    private static List<int[]>[] map;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new List[N * N + 1];

        for (int i = 1; i <= N * N; i++) {
            map[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1][N + 1];
        light = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int row1 = Integer.parseInt(st.nextToken());
            int col1 = Integer.parseInt(st.nextToken());
            int row2 = Integer.parseInt(st.nextToken());
            int col2 = Integer.parseInt(st.nextToken());

            map[(row1 - 1) * N + col1].add(new int[]{row2, col2});
        }
    }

    private static int calculateDistance(int row1, int col1, int row2, int col2) {
        return Math.abs(row1 - row2) + Math.abs(col1 - col2);
    }

    private static void operation() {
        Queue<int[]> q = new LinkedList<>();

        visited[1][1] = true;
        light[1][1] = true;
        q.offer(new int[]{1, 1});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int idx = (now[0] - 1) * N + now[1];
            int row = now[0];
            int col = now[1];

            for (int[] next : map[idx]) {
                int nr = next[0];
                int nc = next[1];

                if (light[nr][nc]) continue;

                light[nr][nc] = true;
                result++;

                for (int d = 0; d < 4; d++) {
                    int ar = nr + dr[d];
                    int ac = nc + dc[d];

                    if (ar < 1 || ar > N || ac < 1 || ac > N) continue;

                    if (visited[ar][ac] && !visited[nr][nc]) {
                        q.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }

            for (int d = 0; d < 4; d++) {
                int nr = row + dr[d];
                int nc = col + dc[d];
                if (nr < 1 || nr > N || nc < 1 || nc > N) continue;
                if (!light[nr][nc]) continue;
                if (visited[nr][nc]) continue;

                visited[nr][nc]=true;
                q.offer(new int[]{nr,nc});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        operation();

        System.out.println(result);
    }
}
