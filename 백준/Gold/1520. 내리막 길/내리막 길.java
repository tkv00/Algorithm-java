import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.col = col;
            this.row = row;
        }
    }

    static Queue<Point> queue;
    static int row;
    static int col;
    static int[][] map;
    static StringTokenizer st;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] visited;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        visited = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = -1;
            }
        }


        System.out.println(dfs(0, 0));
    }

    static int dfs(int x, int y) {
        if (x == row - 1 && y == col - 1) {
            return 1;
        }
        //방문 한 경우
        if (visited[x][y] != -1) return visited[x][y];

        //방문 표시
        visited[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int newRow = x + dx[i];
            int newCol = y + dy[i];
            if (isValid(newRow, newCol) && map[x][y] > map[newRow][newCol]) {

                visited[x][y] += dfs(newRow, newCol);

            }
        }
        return visited[x][y];

    }

    //경계
    static boolean isValid(int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= col) return false;

        return true;
    }
}

