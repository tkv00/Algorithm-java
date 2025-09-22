import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Point {
        int row;
        int col;
        int dist;

        Point(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }

    }


    /**
     * 아기 상어 크기 > 물고기 크기 : 잡아먹을 수 있음.
     * 아기 상어 크기 = 물고기 크기 : 지나갈 수 있고 잡아먹을 수 없음.
     * 아기 상어 크기 < 물고기 크기 : 지나갈 수 없음.
     */
    private static int[] dx = new int[]{-1, 0, 1, 0};
    private static int[] dy = new int[]{0, 1, 0, -1};
    private static int sharkSize;
    private static boolean[][] fish;
    private static int N;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int time;
    private static int[][] map;
    private static int sharkRow;
    private static int sharkCol;
    //현재 상어가 먹은 고기 개수
    private static int eatFishCnt;

    private static void eating() {
        while (true) {
            Point now = bfs();
            if (now == null) break;

            map[now.row][now.col] = 0;
            eatFishCnt += 1;
            time += now.dist;

            //상어의 움직임 좌표? 업데이트 필수!
            sharkRow = now.row;
            sharkCol = now.col;

            if (eatFishCnt == sharkSize) {
                eatFishCnt = 0;
                sharkSize += 1;
            }
        }
    }

    //각 물고기별 도착 시간 측정 함수
    private static Point bfs() {
        boolean[][] visited = new boolean[N][N];
        Queue<Point> q = new LinkedList<>();

        q.offer(new Point(sharkRow, sharkCol, 0));
        visited[sharkRow][sharkCol] = true;
        List<Point> list = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.row + dx[i];
                int nc = now.col + dy[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] > sharkSize || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                q.offer(new Point(nr, nc, now.dist + 1));

                //먹을 수 있으면
                if (map[nr][nc] != 0 && map[nr][nc] < sharkSize) {
                    if (now.dist + 1 < minDist) {
                        minDist = now.dist + 1;
                        list.clear();
                        list.add(new Point(nr, nc, minDist));
                    } else if (now.dist + 1 == minDist) {
                        list.add(new Point(nr, nc, minDist));
                    }
                }
            }
        }

        list.sort((a, b) -> {
            if (a.row == b.row) {
                return a.col - b.col;
            } else {
                return a.row - b.row;
            }
        });

        return list.isEmpty() ? null : list.get(0);
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        fish = new boolean[N][N];
        time = 0;
        eatFishCnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int size = Integer.parseInt(st.nextToken());
                map[i][j] = size;
                if (size == 9) {
                    sharkRow = i;
                    sharkCol = j;
                    map[i][j] = 0;
                }
            }
        }


        sharkSize = 2;


    }


    public static void main(String[] args) throws IOException {
        init();
        eating();
        System.out.print(time);
    }

}
