import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited = new boolean[5][5];
    static int res = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            char[] str2 = str.toCharArray();
            for (int j = 0; j < 5; j++) {
                map[i][j] = str2[j];
            }
        }
        dfs(0, 0, 0);
        //조건 1.s가 4명이상
        // 조건 2. 7명 서로 인접

        System.out.println(res);

    }

    static void dfs(int n, int cnt, int scnt) {
        if (cnt > 7) return;
        if (n == 25) {
            if (cnt == 7 && scnt >= 4) {
                //7명이 인접한 지 체크
                if (check()) {
                    res += 1;
                }
            }
            return;

        }
        int row = n / 5;
        int col = n % 5;

        visited[row][col] = true;
        //포함할때
        dfs(n + 1, cnt + 1, scnt + (map[row][col] == 'S' ? 1 : 0));
        visited[row][col] = false;

        //포함하지 않을때
        dfs(n + 1, cnt, scnt);
    }

    static boolean check() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                //방문을 한 곳이라면
                if (visited[i][j]) {
                    return bfs(i, j);
                }
            }
        }
        return false;
    }

    static boolean bfs(int startRow, int startCol) {
        Queue<Point> queue = new LinkedList<>();
        //방문된 곳 탐색
        boolean[][] visit = new boolean[5][5];
        queue.add(new Point(startRow, startCol));
        visit[startRow][startCol] = true;
        int cnt = 1;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newRow = point.row + dx[i];
                int newCol = point.col + dy[i];
                //경계 처리
                if ((newRow >= 0 && newRow < 5) && (newCol >= 0 && newCol < 5) && !visit[newRow][newCol]&&visited[newRow][newCol]) {
                    visit[newRow][newCol] = true;
                    cnt += 1;
                    queue.add(new Point(newRow, newCol));
                }
            }
        }
        return cnt == 7;
    }

}

