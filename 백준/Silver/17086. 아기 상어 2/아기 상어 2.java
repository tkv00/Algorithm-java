import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int row;
        int col;
        int dis;

        Point(int row, int col,int dis) {
            this.row = row;
            this.col = col;
            this.dis=dis;
        }
    }

    static int N;
    static int M;
    static boolean[][] map;
    static StringTokenizer st;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static boolean[][] visited;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int t = Integer.parseInt(st.nextToken());
                if (t == 1) {
                    //상어가 있는곳
                    map[i][j] = true;
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                //상어가 없는 공간이면
                if(!map[i][j]){
                    res= Math.max(res,bfs(i,j));
                }
            }
        }
        System.out.println(res);


    }

    static int bfs(int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(row, col,0));
        visited=new boolean[N][M];
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 8; i++) {
                int newRow = now.row + dx[i];
                int newCol = now.col + dy[i];
                if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= M || visited[newRow][newCol] )
                    continue;
                //상어를 찾은 경우
                if(map[newRow][newCol])return now.dis+1;
                visited[newRow][newCol] = true;
                queue.add(new Point(newRow, newCol,now.dis+1));
            }
        }
        //상어 못찾음
        return 0;
    }
}
