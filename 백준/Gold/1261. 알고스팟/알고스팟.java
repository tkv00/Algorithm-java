import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.col = col;
            this.row = row;
        }
    }

    static int N;
    static int M;
    static int[][] map;
    static int[][] result;
    static boolean[][] visited;

    static Deque<Point> deque;
    static StringTokenizer st;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M+1][N+1];
        result = new int[M+1][N+1];
        visited = new boolean[M+1][N+1];
        result[1][1]=0;
        for (int i = 1; i <= M; i++) {
            String str = br.readLine();
            char[] toInteger = str.toCharArray();
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(toInteger[j-1]));
            }
        }
        //System.out.println(Arrays.deepToString(map));
        deque = new LinkedList<>();
        deque.addFirst(new Point(1, 1));
        visited[1][1] = true;
        bfs();
        //System.out.println(Arrays.deepToString(result));
        //System.out.println(Arrays.deepToString(map));
        System.out.println(result[M ][N ]);
    }

    //경계값
    static boolean Bounded(int row, int col) {
        return ((row > 0 && row <= M) && (col > 0 && col <= N)&&!visited[row][col]);
    }

    static void bfs() {

        while (!deque.isEmpty()) {
            Point nowPoint = deque.pollFirst();
            int nowCol = nowPoint.col;
            int nowRow = nowPoint.row;
            for (int i = 0; i < 4; i++) {
                int newCol = nowCol + dx[i];
                int newRow = nowRow + dy[i];
                if (Bounded(newRow, newCol)) {
                    visited[newRow][newCol] = true;
                    //벽있는 경우
                    if (map[newRow][newCol] == 1) {
                        deque.addLast(new Point(newRow, newCol));
                        result[newRow][newCol] = result[nowRow][nowCol] + 1;
                    }
                    //벽없으면 우선탐색
                    else {
                        deque.addFirst(new Point(newRow,newCol));
                        result[newRow][newCol]=result[nowRow][nowCol];
                    }
                }
            }
        }
    }
}
