import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Main {
    public static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int R;
    public static int C;
    public static char[][] map;
    public static boolean[] visited;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
        }
        visited = new boolean[26];
        if(R==1 && C==1){
            System.out.println(1);
            exit(0);
        }
        dfs(0, 0, 0);
        System.out.println(res);
    }

    //    public static int bfs(int x, int y) {
//        Queue<Point> queue = new LinkedList<>();
//        queue.add(new Point(x, y));
//        visited[trans(map[x][y])] = true;
//        int cnt=1;
//        while (!queue.isEmpty()) {
//            Point nowPoint = queue.poll();
//            for (int i = 0; i < 4; i++) {
//                int nextX = nowPoint.x + dx[i];
//                int nextY = nowPoint.y + dy[i];
//                if ((nextX >= 0 && nextX < R) && (nextY >= 0 && nextY < C) && (!visited[trans(map[nextX][nextY])])){
//                    queue.add(new Point(nextX,nextY));
//                    visited[trans(map[nextX][nextY])]=true;
//                    cnt++;
//                }
//            }
//        }
//        return cnt;
//
//    }
    public static void dfs(int x, int y, int cnt) {
        if (visited[trans(map[x][y])]) {
            res = Math.max(res, cnt);
            return;
        }
        else {
            visited[trans(map[x][y])] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if ((nextX >= 0 && nextX < R) && (nextY >= 0 && nextY < C)) {
                    dfs(x + dx[i], y + dy[i], cnt+1);
                }

            }
            visited[trans(map[x][y])] = false;
        }

    }

    public static int trans(char c) {
        return (int) c - 65;
    }
}
