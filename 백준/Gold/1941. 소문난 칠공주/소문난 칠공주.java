import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final int SIZE = 5;
    private static int[] dx = new int[]{0, 0, 1, -1};
    private static int[] dy = new int[]{1, -1, 0, 0};
    private static char[][] map;
    private static BufferedReader br;
    private static int result = 0;
    private static boolean[] selected;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[SIZE][SIZE];
        selected = new boolean[SIZE * SIZE];

        for (int i = 0; i < SIZE; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray();
        }

    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    private static boolean BFS(boolean[] selected) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[SIZE][SIZE];

        for (int i = 0; i < SIZE * SIZE; i++) {
            if (selected[i]) {
                int row = i / SIZE;
                int col = i % SIZE;
                visited[row][col] = true;
                q.offer(new int[]{row, col});
                break;
            }
        }
        int cnt = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            cnt++;

            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dx[d];
                int nc = now[1] + dy[d];

                if (!isValid(nr, nc) || visited[nr][nc]) continue;

                if (selected[nr * SIZE + nc]) {
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

        return cnt == 7;
    }

    private static void combination(int count, int num, int idx, boolean[] selected) {
     
        if (count == 7) {
            if (num >= 4) {
                if (BFS(selected)) result++;
            }
            return;
        }

        if (idx >= SIZE * SIZE) return;
        
        int row = idx / SIZE;
        int col = idx % SIZE;


        //선택하는 경우
        selected[idx] = true;
        combination(count + 1, map[row][col] == 'S' ? num + 1 : num, idx + 1, selected);

        //선택하지 않는 경우
        selected[idx] = false;
        combination(count, num, idx + 1, selected);

    }

    public static void main(String[] args) throws IOException {
        init();
        combination(0, 0, 0, selected);

        System.out.println(result);
    }
}
