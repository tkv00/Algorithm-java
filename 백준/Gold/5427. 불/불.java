import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int T;
    public static int w, h;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            char[][] map = new char[h][w];
            Queue<Point> fireQueue = new LinkedList<>();
            Point start = null;

            for (int j = 0; j < h; j++) {
                String str = br.readLine();
                for (int k = 0; k < w; k++) {
                    map[j][k] = str.charAt(k);
                    if (map[j][k] == '@') {
                        start = new Point(k, j);
                        map[j][k] = '.';
                    }
                    if (map[j][k] == '*') {
                        fireQueue.add(new Point(k, j));
                    }
                }
            }
            bfs(map, start, fireQueue);
        }
    }

    public static void bfs(char[][] map, Point start, Queue<Point> fireQueue) {
        Queue<Point> queue = new LinkedList<>();
        int[][] distance = new int[h][w];
        queue.add(start);
        distance[start.y][start.x] = 1;

        while (!queue.isEmpty()) {
            // 불 확산
            int fireSize = fireQueue.size();
            for (int i = 0; i < fireSize; i++) {
                Point fire = fireQueue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = fire.x + dx[d];
                    int ny = fire.y + dy[d];
                    if (nx >= 0 && nx < w && ny >= 0 && ny < h && map[ny][nx] == '.') {
                        map[ny][nx] = '*';
                        fireQueue.add(new Point(nx, ny));
                    }
                }
            }

            // 상근이 이동
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point p = queue.poll();
                if (p.x == 0 || p.x == w - 1 || p.y == 0 || p.y == h - 1) {
                    System.out.println(distance[p.y][p.x]);
                    return;
                }
                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];
                    if (nx >= 0 && nx < w && ny >= 0 && ny < h && map[ny][nx] == '.' && distance[ny][nx] == 0) {
                        distance[ny][nx] = distance[p.y][p.x] + 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}