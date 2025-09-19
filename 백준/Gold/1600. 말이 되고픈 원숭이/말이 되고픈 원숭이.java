import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Point {
        int row;
        int col;
        int move;
        int chance;

        Point(int row, int col, int move, int chance) {
            this.row = row;
            this.col = col;
            this.chance = chance;
            this.move = move;
        }
    }

    private static boolean[][][] visited;
    private static int[] dx = new int[]{0, 0, 1, -1};
    private static int[] dy = new int[]{1, -1, 0, 0};
    //말처럼 이동
    private static int[] hdx = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] hdy = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

    private static StringTokenizer st;
    private static BufferedReader br;
    private static int K, W, H;
    private static int[][] map;
    private static int move;
    private static Queue<Point> q;

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < H && col >= 0 && col < W && map[row][col] != 1;
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        move = -1;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        q = new LinkedList<>();
        map = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void BFS() {
        Point start = new Point(0, 0, 0, K);
        q.offer(start);
        visited[0][0][K] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.row == H - 1 && now.col == W - 1) {
                move = now.move;
                break;
            }
            //찬스가 남아 있는 경우
            if (now.chance > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = hdx[i] + now.row;
                    int ny = hdy[i] + now.col;

                    if (!isValid(nx, ny) || visited[nx][ny][now.chance - 1]) continue;

                    visited[nx][ny][now.chance - 1] = true;
                    q.offer(new Point(nx, ny, now.move + 1, now.chance - 1));
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.row + dx[i];
                int ny = now.col + dy[i];

                if (!isValid(nx, ny) || visited[nx][ny][now.chance]) continue;

                visited[nx][ny][now.chance] = true;
                q.offer(new Point(nx, ny, now.move + 1, now.chance));
            }

        }
    }

    public static void main(String[] args) throws IOException {
        init();
        BFS();
        System.out.print(move);
    }
}
