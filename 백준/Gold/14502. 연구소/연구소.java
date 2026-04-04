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
    private static final int EMPTY = 0;
    private static final int WALL = 1;
    private static final int VIRUS = 2;
    private static int[][] map;
    private static int max = 0;

    private static int[] dx = new int[]{0, 0, 1, -1};
    private static int[] dy = new int[]{1, -1, 0, 0};

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    //바이러스가 퍼지는 시나리오 실행
    private static int scenario(int[][] map) {
        boolean[][] visited;
        Queue<int[]> virus = new LinkedList<>();


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    virus.offer(new int[]{i, j});
                }
            }
        }

        for (int[] now : virus) {
            Queue<int[]> q = new LinkedList<>();
            visited = new boolean[N][M];
            q.offer(new int[]{now[0], now[1]});
            visited[now[0]][now[1]] = true;

            while (!q.isEmpty()) {
                int[] next = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = next[0] + dx[d];
                    int ny = next[1] + dy[d];

                    if (isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] == EMPTY) {
                        map[nx][ny] = 2;
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return countSafeZone(map);
    }

    //바이러스 위치
    private static void dfs(int wallCount) {
        if (wallCount == 3) {
            int[][] newMap = copyMap();
            max = Math.max(max, scenario(newMap));

            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == EMPTY) {
                    map[i][j] = WALL;
                    dfs(wallCount + 1);
                    map[i][j] = EMPTY;
                }
            }
        }
    }

    private static int countSafeZone(int[][] map) {
        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j : map[i]) {
                if (j == 0) sum++;
            }
        }

        return sum;
    }

    private static int[][] copyMap() {
        int[][] copy = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }

    public static void main(String[] args) throws IOException {
        init();
        dfs(0);

        System.out.print(max);
    }
}

