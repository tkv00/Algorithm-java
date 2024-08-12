import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    public static int M;
    public static int N;
    public static int[][][] map;
    public static int H;
    public static StringTokenizer st;
    public static int res = 0;
    public static int[] dx = {1, -1, 0, 0, 0, 0};
    public static int[] dy = {0, 0, 1, -1, 0, 0};
    public static int[] dz = {0, 0, 0, 0, 1, -1};
    public static int[][][] date;
    public static Queue<Point> queue = new LinkedList<>();

    public static class Point {
        int x;
        int y;
        int z;

        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[M][N][H];
        date = new int[M][N][H];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int x = Integer.parseInt(st.nextToken());
                    map[k][j][i] = x;
                    if (x == 1) {
                        queue.add(new Point(k, j, i));
                    }
                }
            }
        }
        bfs();

        //System.out.println(Arrays.deepToString(map));
        if (isAllTomato()) {
            System.out.println(res);
            exit(0);
        } else {
            System.out.println(-1);
        }
    }

    public static void bfs() {

        while (!queue.isEmpty()) {
            Point nowPoint = queue.poll();
            for (int i = 0; i < 6; i++) {
                int newX = nowPoint.x + dx[i];
                int newY = nowPoint.y + dy[i];
                int newZ = nowPoint.z + dz[i];
                //경계범위 설정 및 방문
                if ((newX >= 0 && newX < M) && (newY >= 0 && newY < N) && (newZ >= 0 && newZ < H)
                        && (map[newX][newY][newZ] == 0)
                ) {
                    map[newX][newY][newZ] = 1;
                    date[newX][newY][newZ] = date[nowPoint.x][nowPoint.y][nowPoint.z] + 1;
                    res = Math.max(date[newX][newY][newZ], res);
                    queue.add(new Point(newX, newY, newZ));
                }
            }
        }
    }

    //모든 토마토가 익었는지 판단
    public static boolean isAllTomato() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < H; k++) {
                    if (map[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
