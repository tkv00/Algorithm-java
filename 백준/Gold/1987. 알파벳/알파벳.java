import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static int R, C;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static char[][] map;
    private static boolean[][] visited;
    private static int[] dx = new int[]{0, 0, 1, -1};
    private static int[] dy = new int[]{1, -1, 0, 0};
    private static int result = 0;
    private static Set<Character> duplicated;

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < R && col >= 0 && col < C && !visited[row][col];
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        duplicated = new HashSet<>();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }
    }

    private static void operation(int row, int col, int cnt) {
        result=Math.max(result,cnt);
        for (int d = 0; d < 4; d++) {
            int nr = row + dx[d];
            int nc = col + dy[d];

            if (!isValid(nr,nc) || duplicated.contains(map[nr][nc])) continue;

            duplicated.add(map[nr][nc]);
            visited[nr][nc] = true;

           
            operation(nr, nc, cnt + 1);

            duplicated.remove(map[nr][nc]);
            visited[nr][nc] = false;

        }
    }

    public static void main(String[] args) throws IOException {
        init();
        visited[0][0]=true;
        duplicated.add(map[0][0]);
        operation(0, 0, 1);

        System.out.println(result);
    }
}
