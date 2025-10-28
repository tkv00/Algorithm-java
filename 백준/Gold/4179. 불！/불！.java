
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int R, C;
    private static final String DONT_EXIT = "IMPOSSIBLE";
    private static char[][] map;

    private static int[] dx = new int[]{0, 0, 1, -1};
    private static int[] dy = new int[]{1, -1, 0, 0};
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[][] distMap;
    private static int[][] fireMap;
    private static Queue<int[]> fires;
    private static Queue<int[]> jihoon;
    private static int startRow = 0, startCol = 0;

    /**
     * 종료 시점 -> row=0 || row=R+1 || col=0 || col=C+1
     */

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fireMap = new int[R][C];
        distMap = new int[R][C];

        fires = new LinkedList<>();
        jihoon = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'F') {
                    fires.offer(new int[]{i, j});
                    fireMap[i][j] = 1;
                }
                ;
                if (map[i][j] == 'J') {
                    jihoon.offer(new int[]{i, j});
                    distMap[i][j] = 1;
                }
                ;
            }
        }
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < R && col >= 0 && col < C;
    }

    private static void BFS() {
        while (!fires.isEmpty()) {
            int[] now = fires.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                //범위 벗어난 경우
                if (!isValid(nx, ny)) continue;
                if (map[nx][ny] == '#' || fireMap[nx][ny] > 0) continue;

                fires.offer(new int[]{nx, ny});
                fireMap[nx][ny] = fireMap[now[0]][now[1]] + 1;
            }
        }
        while (!jihoon.isEmpty()) {
            int[] now = jihoon.poll();

            //탈출 가능한 경우
            if (now[0] == 0 || now[0] == R - 1 || now[1] == 0 || now[1] == C - 1) {
                System.out.println(distMap[now[0]][now[1]]);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = dx[d] + now[0];
                int ny = dy[d] + now[1];
                if (!isValid(nx, ny)) continue;
                if (map[nx][ny] == '#' || distMap[nx][ny] > 0) continue;

                //불보다 먼저 도착해야함
                if (fireMap[nx][ny] != 0 && fireMap[nx][ny] <= distMap[now[0]][now[1]] + 1) continue;


                jihoon.offer(new int[]{nx, ny});
                distMap[nx][ny] = distMap[now[0]][now[1]] + 1;
            }
        }

        System.out.println(DONT_EXIT);
    }


    public static void main(String[] args) throws IOException {
        init();
        BFS();
    }
}
