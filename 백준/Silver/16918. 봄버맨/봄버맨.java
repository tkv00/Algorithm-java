import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int R, C, N;
    private static int[] dr = new int[]{0, 0, 1, -1};
    private static int[] dc = new int[]{1, -1, 0, 0};
    private static char[][] map;

    //폭탄이 설치되었는가.
    private static int[][] bombMap;

    private static boolean isValid(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }

    //폭탄 +1초 증가
    private static void increase() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                //폭탄이 아닌 경우
                if (map[i][j] == '.') continue;
                //폭탄인 경우
                bombMap[i][j]++;
            }
        }
    }

    //과정 3
    private static void operation_3() {

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '.') {
                    map[i][j] = 'O';
                    bombMap[i][j] = 0;
                }
            }
        }
    }

    //과정 4
    private static void operation_4() {
        boolean[][] boom = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bombMap[i][j] == 3) {
                    boom[i][j] = true;

                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        //폭탄인 경우
                        if (isValid(nr, nc)) {
                            boom[nr][nc] = true;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (boom[i][j]) {
                    bombMap[i][j] = 0;
                    map[i][j] = '.';
                }
            }
        }
    }

    private static void printMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());


        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        bombMap = new int[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = input.toCharArray()[j];
                map[i][j] = c;
                if (c == 'O') {
                    bombMap[i][j] = 1;
                }

            }
        }
    }

    private static void explode() {
        int time = 1;
        while (time < N) {
            time++;
            increase();
            if (time % 2 == 0) {
                operation_3();
            }
            if (time % 2 == 1) {
                operation_4();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        init();
        explode();
        printMap();
    }
}
