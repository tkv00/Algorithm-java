import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[][] office;
    private static List<CCTV> cctvs;
    private static int min = Integer.MAX_VALUE;
    //우,아래,좌,위
    private static int[] dr = new int[]{0, 1, 0, -1};
    private static int[] dc = new int[]{1, 0, -1, 0};

    private static class CCTV {
        int row;
        int col;
        int num;

        CCTV(int row, int col, int num) {
            this.col = col;
            this.row = row;
            this.num = num;
        }
    }

    private static void combination(int depth, int[][] map) {
        //중단 조건
        if (depth >= cctvs.size()) {
            min = Math.min(min, count(map));
            return;
        }

        CCTV now = cctvs.get(depth);

        for (int dir = 1; dir <= 4; dir++) {
            int[][] newMap = operation(map, now, dir);
            combination(depth+1,newMap);
        }
    }

    private static int[][] operation(int[][] map, CCTV now, int direction) {
        int[][] newMap = copy(map);

        int[] selectedDirection = choice(now.num, direction);

        //CCTV가 보는 경로 표시
        for (int s : selectedDirection) {
            int row = now.row;
            int col = now.col;

            while (true) {
                row += dr[s];
                col += dc[s];

                if (row < 0 || row >= N || col < 0 || col >= M) break;
                if (newMap[row][col] == 6) break; //벽인 경우

                //CCTV로 채우기
                newMap[row][col] = now.num;
            }
        }

        return newMap;
    }


    private static int[] choice(int cctv, int dir) {
        switch (cctv) {
            case 1: {
                switch (dir) {
                    case 1:
                        return new int[]{0};
                    case 2:
                        return new int[]{1};
                    case 3:
                        return new int[]{2};
                    case 4:
                        return new int[]{3};
                }
            }
            break;

            case 2: {
                switch (dir) {
                    case 1:
                    case 3:
                        return new int[]{0, 2};
                    case 2:
                    case 4:
                        return new int[]{1, 3};
                }

            }
            break;

            case 3: {
                switch (dir) {
                    case 1:
                        return new int[]{0, 3};
                    case 2:
                        return new int[]{0, 1};
                    case 3:
                        return new int[]{1, 2};
                    case 4:
                        return new int[]{2, 3};
                }
                break;
            }

            case 4: {
                switch (dir) {
                    case 1:
                        return new int[]{2, 3, 0};
                    case 2:
                        return new int[]{0, 1, 3};
                    case 3:
                        return new int[]{0, 1, 2};
                    case 4:
                        return new int[]{1, 2, 3};
                }
                break;
            }

            case 5:
                switch (dir) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        return new int[]{0, 1, 2, 3};
                }
                break;
        }
        return new int[]{};
    }


    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        office = new int[N][M];
        cctvs=new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] != 0 && office[i][j] < 6) cctvs.add(new CCTV(i, j, office[i][j]));
            }
        }
    }


    private static int[][] copy(int[][] origin) {
        int[][] copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = origin[i][j];
            }
        }
        return copyMap;
    }

    //사각지대 구하기
    private static int count(int[][] map) {
        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        init();
        combination(0,office);

        System.out.println(min);
    }
}
