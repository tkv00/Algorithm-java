
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, K;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static final int INIT = 5;
    private static final int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    private static int[][] map;
    private static List<Integer>[][] trees;
    private static int[][] inputs; //겨울에 주는 양분 입력 값
    private static List<Integer>[][] diedTrees;//죽은 나무 관리

    private static boolean isValid(int row, int col) {
        return row > 0 && row <= N && col > 0 && col <= N;
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        trees = new List[N + 1][N + 1];
        inputs = new int[N + 1][N + 1];
        map = new int[N + 1][N + 1];
        diedTrees = new List[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = INIT;
            }
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                inputs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if (trees[x][y] == null) {
                trees[x][y] = new ArrayList<>();
            }
            trees[x][y].add(z);
        }
    }

    private static void spring() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (trees[i][j] == null) continue;

                //나이가 어린순으로 정렬
                trees[i][j].sort((a, b) -> a - b);
                List<Integer> newList=new ArrayList<>();

                for (int k = 0; k < trees[i][j].size(); k++) {
                    //양분이 부족한 경우 -> 나무 죽음
                    int nowYear = trees[i][j].get(k);
                    if (nowYear > map[i][j]) {
                        if (diedTrees[i][j]==null) diedTrees[i][j]=new ArrayList<>();
                        diedTrees[i][j].add(nowYear);
                        continue;
                    }

                    //자신의 나이만큼 양분 먹기
                    map[i][j] -= nowYear;
                    newList.add(nowYear+1);
                }
                trees[i][j]=newList;
            }
        }
    }

    private static void summer() {
        //죽은 나무 양분으로
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (diedTrees[i][j]==null || diedTrees[i][j].isEmpty()) continue;
                for (int year:diedTrees[i][j]){
                    map[i][j] += year / 2;
                }
                diedTrees[i][j]=new ArrayList<>();
            }
        }
    }

    private static void fall() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (trees[i][j] == null) continue;
                int treesSize = trees[i][j].size();

                for (int k = 0; k < treesSize; k++) {
                    int year = trees[i][j].get(k);
                    //5의 배수인가
                    if (year % 5 != 0) continue;

                    //번식 시작
                    for (int d = 0; d < 8; d++) {
                        int nr = i + dx[d];
                        int nc = j + dy[d];

                        if (!isValid(nr, nc)) continue;

                        if (trees[nr][nc] == null) trees[nr][nc] = new ArrayList<>();
                        trees[nr][nc].add(1);
                    }
                }
            }
        }
    }

    private static void winter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] += inputs[i][j];
            }
        }
    }

    //살아 남은 나무 개수
    private static int countAliveTrees() {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (trees[i][j] == null) continue;
                count += trees[i][j].size();
            }
        }

        return count;
    }

    private static void operation() {
        int year = 0;

        while (year != K) {
            spring();
            summer();
            fall();
            winter();

            year++;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        operation();

        System.out.println(countAliveTrees());
    }
}
