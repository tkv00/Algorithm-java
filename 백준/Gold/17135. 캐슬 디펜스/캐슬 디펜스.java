import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int N, M, D;
    private static int[][] map;
    private static boolean[] archer; //궁수 배치
    private static int MAX = 0;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        archer = new boolean[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    //거리 계산
    private static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private static int[][] copy() {
        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        return copyMap;
    }

    private static void collaboration(int depth, int count) {
        if (count == 3) {
            int cnt = 0;
            int[][] copy = copy();

            for (int time = 0; time < N; time++) {
                cnt += simulation(copy);
                move(copy);
            }
            MAX = Math.max(MAX, cnt);
            return;
        }

        for (int idx = depth; idx < M; idx++) {
            archer[idx] = true;
            collaboration(idx + 1, count + 1);
            archer[idx] = false;
        }
    }

    private static void move(int[][] map) {
        for (int row = N - 1; row >= 0; row--) {
            for (int col = M - 1; col >= 0; col--) {
                if (row == 0) {
                    map[row][col] = 0;
                    continue;
                }
                map[row][col] = map[row - 1][col];
            }
        }
    }

    private static int simulation(int[][] currMap) {
        Set<String> set = new HashSet<>();

        for (int p = 0; p < M; p++) {
            if (archer[p]) {
                PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] == b[2] ? a[1] - b[1] : a[2] - b[2]);
                for (int row = N - 1; row >= 0; row--) {
                    for (int col = 0; col < M; col++) {
                        if (currMap[row][col] == 0) continue;
                        int dis = getDistance(row, col, N, p);
                        if (dis <= D) {
                            pq.offer(new int[]{row, col, dis});
                        }
                    }
                }
                if (pq.isEmpty()) continue;
                int[] now=pq.poll();
                set.add(now[0]+" "+now[1]);
            }
        }
        if (set.isEmpty()) return 0;

        for (String p : set) {
            String[] str=p.split(" ");
            currMap[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 0;
        }

        return set.size();
    }

    private static void printMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        collaboration(0, 0);

        System.out.println(MAX);
    }
}
