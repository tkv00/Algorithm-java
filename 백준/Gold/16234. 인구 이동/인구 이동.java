import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, L, R;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[][] map;
    private static ArrayList<int[]> list;
    private static boolean[][] visited;
    private static int[] dx = new int[]{0, 0, 1, -1};
    private static int[] dy = new int[]{1, -1, 0, 0};


    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int operation() {
        int day = 0;
        while (true) {
            boolean isMove = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        list = new ArrayList<>();
                        list.add(new int[]{i, j});
                        int sum = dfs(i, j);

                        if (list.size() > 1) {
                            changeValue(sum);
                            isMove = true;
                        }
                    }
                }
            }
            if (!isMove) return day;
            day++;
        }
    }

    private static int dfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        int sum = map[x][y];

        visited[x][y] = true;


        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = dx[d] + now[0];
                int ny = dy[d] + now[1];

                if (isValidPosition(nx, ny) && !visited[nx][ny]) {
                    int nowValue = map[now[0]][now[1]];
                    int newValue = map[nx][ny];
                    int diff = Math.abs(nowValue - newValue);
                    if (diff < L || R < diff) continue;

                    q.offer(new int[]{nx, ny});
                    sum += map[nx][ny];
                    list.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return sum;
    }

    private static boolean isValidPosition(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static void changeValue(int sum) {
        int avg = sum / list.size();

        for (int[] point : list) {
            map[point[0]][point[1]] = avg;
        }
    }


    public static void main(String[] args) throws IOException {
        init();
        System.out.print(operation());
    }
}
