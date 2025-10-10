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
    private static int[][][] distMap;
    private static boolean[][][] visited;
    private static Queue<int[]> q;
    private static int[] dr = new int[]{0, 0, 1, -1};
    private static int[] dc = new int[]{1, -1, 0, 0};

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];
        distMap = new int[N][M][2];
        q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            char[] chArr = input.toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = chArr[j] - '0';
            }
        }
    }

    private static boolean isValid(int row, int col, int w) {
        return row >= 0 && row < N && col >= 0 && col < M && !visited[row][col][w];
    }


    private static void BFS() {
        visited[0][0][0] = true;
        distMap[0][0][0] = 1;
        q.offer(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == N - 1 && now[1] == M - 1) {
                System.out.println(distMap[now[0]][now[1]][now[2]]);
                System.exit(0);
            }
            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if (!isValid(nr, nc, now[2])) continue;
                //벽인 경우
                if (map[nr][nc] == 1 && now[2] == 0) {
                    //이전 값이 벽을
                    visited[nr][nc][1] = true;
                    distMap[nr][nc][1] = distMap[now[0]][now[1]][0] + 1;
                    q.offer(new int[]{nr, nc, 1});
                } else if (map[nr][nc] == 0) {
                    visited[nr][nc][now[2]] = true;
                    distMap[nr][nc][now[2]] = distMap[now[0]][now[1]][now[2]] + 1;
                    q.offer(new int[]{nr, nc, now[2]});
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        BFS();
        System.out.println(-1);
    }
}
