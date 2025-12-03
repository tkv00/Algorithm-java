
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, H;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static boolean[][] map;
    private static int[] endPoint;
    private static final int MAX = 3;
    private static int result = -1;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new boolean[H + 1][N + 1];
        endPoint = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());//깊이 정보
            int n = Integer.parseInt(st.nextToken());//가로 시작 위치

            map[h][n] = true;
        }
    }

    //각 번호별 도착 위치 찾기
    private static void getEndPoint(int start) {
        int tmp = start;

        for (int row = 1; row <= H; row++) {
            if (tmp < N && map[row][tmp]) {
                tmp++;
            } else if (tmp > 1 && map[row][tmp - 1]) {
                tmp--;
            }
        }

        endPoint[start] = tmp;
    }

    //모든 번호들에 대해서 도착 위치 찾기
    private static void getAllEndPoint() {
        for (int start = 1; start <= N; start++) {
            getEndPoint(start);
        }
    }

    //사다리 조작 여부
    private static boolean isFinished() {
        getAllEndPoint();

        for (int i = 1; i <= N; i++) {
            if (endPoint[i] != i) return false;
        }

        return true;
    }

    private static boolean canPut(int h, int n) {
        if (map[h][n]) return false;
        if (n > 1 && map[h][n - 1]) return false;
        if (n < N && map[h][n + 1]) return false;
        return true;
    }

    private static void dfs(int cnt, int row, int col) {
        if (result != -1 && result <= cnt) return;

        if (cnt > MAX) {
            return;
        }

        if (isFinished()) {
            result = cnt;
            return;
        }

        for (int h = row; h <= H; h++) {
            for (int n = (h == row ? col : 1); n < N; n++) {
                if (!canPut(h, n)) continue;

                map[h][n] = true;

                dfs(cnt + 1, h, n);

                map[h][n] = false;

                if (result == cnt + 1) return;
            }
        }

    }


    public static void main(String[] args) throws IOException {
        init();
        dfs(0, 1, 1);

        System.out.println(result);
    }
}

