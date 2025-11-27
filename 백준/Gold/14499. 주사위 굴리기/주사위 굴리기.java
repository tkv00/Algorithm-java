import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, K;
    private static int x, y;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[][] map;
    private static int[] dr = new int[]{0, 0, -1, 1}; //동서 북남
    private static int[] dc = new int[]{1, -1, 0, 0}; //동서북남

    private static int[] dice = new int[]{0, 0, 0, 0, 0, 0};
    private static int[] orders;
    private static StringBuilder sb;

    private static void swap(int idx1, int idx2) {
        int tmp = dice[idx1];
        dice[idx1] = dice[idx2];
        dice[idx2] = tmp;
    }

    //동쪽 이동
    private static void moveEast() {
        swap(1, 2);
        swap(2, 3);
        swap(3, 5);
    }

    //서쪽 이동
    private static void moveWest() {
        swap(1, 2);
        swap(1, 3);
        swap(1, 5);
    }

    //남쪽 이동
    private static void moveSouth() {
        swap(0, 2);
        swap(2, 4);
        swap(4, 5);
    }

    //북쪽 이동
    private static void moveNorth() {
        swap(0, 5);
        swap(2, 4);
        swap(2, 5);
    }

    //상단 인덱스 = 2
    private static void saveTop() {
        sb.append(dice[5]).append("\n");
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < M;
    }

    private static void simulation() {
        for (int order : orders) {
            int nr = x + dr[order];
            int nc = y + dc[order];

            if (!isValid(nr, nc)) continue;

            //이동
            switch (order) {
                case 0:
                    moveEast();
                    break;
                case 1:
                    moveWest();
                    break;
                case 2:
                    moveNorth();
                    break;
                case 3:
                    moveSouth();
                    break;
            }

            if (map[nr][nc]==0){
                map[nr][nc]=dice[2];
            }else{
                dice[2]=map[nr][nc];
                map[nr][nc]=0;
            }

            saveTop();

            x = nr;
            y = nc;
        }
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        orders = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st=new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            orders[i] = Integer.parseInt(st.nextToken()) - 1;
        }
    }


    public static void main(String[] args) throws IOException {
        init();
        simulation();

        System.out.println(sb);
    }
}
