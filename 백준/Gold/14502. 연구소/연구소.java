import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int N;
    public static int M;
    public static int[][] map;
    public static StringTokenizer st;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static Queue<Point> queue;
    public static int max=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
       // System.out.println(Arrays.deepToString(map));
        dfs(0);
        System.out.println(max);

    }

    //벽 3개 배치
    public static void dfs(int cnt) {
        if (cnt == 3) {
           virus();
           return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    //바이러스 퍼뜨리는 함수
    public static void virus() {
        queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==2){
                    queue.add(new Point(i,j));
                }
            }
        }
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            temp[i] = map[i].clone();
        }


        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int nowx = point.x;
            int nowy = point.y;
            for (int i = 0; i < 4; i++) {
                int nextX = nowx + dx[i];
                int nextY = nowy + dy[i];
                if ((nextX >= 0 && nextX < N) && (nextY >= 0 && nextY < M) && temp[nextX][nextY] == 0) {
                    temp[nextX][nextY] = 2;
                    queue.add(new Point(nextX, nextY));
                }
            }
        }
       safezone(temp);
    }

    //안전영력 계산함수
    public static void safezone(int[][] map) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    sum += 1;
                }
            }
        }
       max=Math.max(max,sum);
    }
}
