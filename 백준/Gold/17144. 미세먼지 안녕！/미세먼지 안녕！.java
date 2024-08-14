import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int R;
    public static int C;
    public static int T;
    public static int[][] map;

    public static StringTokenizer st;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        queue = new LinkedList<>();
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    stack.push(i);
                }
            }
        }

        int x2 = stack.pop();
        int x1 = stack.pop();

        while (T > 0) {
            queue.clear();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] > 0) {
                        queue.add(new Point(i, j));
                    }
                }
            }
            diffuse();
            air(x1, x2);
            T--;
        }
        System.out.println(sum());
    }

    // 공기청정기 작동
    public static void air(int x1, int x2) {
        // 위쪽 공기청정기 (반시계 방향)
        for (int i = x1 - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        for (int i = 0; i < x1; i++) {
            map[i][C - 1] = map[i + 1][C - 1];
        }
        for (int i = C - 1; i > 0; i--) {
            map[x1][i] = map[x1][i - 1];
        }
        map[x1][1] = 0;

        // 아래쪽 공기청정기 (시계 방향)
        for (int i = x2 + 1; i < R - 1; i++) {
            map[i][0] = map[i + 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            map[R - 1][i] = map[R - 1][i + 1];
        }
        for (int i = R - 1; i > x2; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }
        for (int i = C - 1; i > 0; i--) {
            map[x2][i] = map[x2][i - 1];
        }
        map[x2][1] = 0;
    }

    // 확산 함수
    public static void diffuse() {
        int[][] temp = new int[R][C];

        // 공기청정기 위치 복사
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    temp[i][j] = -1;
                }
            }
        }
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int nowx = p.x;
            int nowy = p.y;
            int amount = map[nowx][nowy] / 5;
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int newx = nowx + dx[i];
                int newy = nowy + dy[i];
                if ((newx >= 0 && newx < R) && (newy >= 0 && newy < C) && map[newx][newy] != -1) {
                    cnt++;
                    temp[newx][newy] += amount;
                }
            }
            temp[nowx][nowy] += map[nowx][nowy] - (amount * cnt);
        }
        map = temp;
    }

    // 남아있는 미세먼지 계산
    public static int sum() {
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    sum += map[i][j];
                }
            }
        }
        return sum;
    }
}
