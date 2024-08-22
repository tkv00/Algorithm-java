import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static Queue<Point> queue;
    static int N;
    static int M;
    static boolean[][] map;
    static boolean[][] visited;
    static ArrayList<Point>[][] pointMap;

    static StringTokenizer st;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int res = 0;
    static boolean flag=false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N + 1][N + 1];
        //visited = new boolean[N + 1][N + 1];


        map[1][1] = true;
        //visited[1][1]=true;
        res++;
        //queue.add(new Point(1,1));
        pointMap = new ArrayList[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                pointMap[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            pointMap[a][b].add(new Point(c, d));
        }
        bfs(1,1);
        System.out.println(res+1);


    }

    static int bfs(int x,int y) {
        queue = new LinkedList<>();
        queue.add(new Point(x,y));
        visited=new boolean[N+1][N+1];
        visited[x][y]=true;
        flag=false;
        res=0;
        while (!queue.isEmpty()){

            Point point=queue.poll();
            //불켜기
            for(Point newPoint:pointMap[point.row][point.col]){

                //불이 꺼진상태이면
                if(!map[newPoint.row][newPoint.col]){
                    //불켜기
                    map[newPoint.row][newPoint.col]=true;
                    res++;
                    flag=true;
                }

            }
            for(int i=0;i<4;i++){
                int newRow=point.row+dx[i];
                int newCol=point.col+dy[i];
                if((newRow>0 && newRow<=N)&&(newCol>0&&newCol<=N)&&map[newRow][newCol]&&!visited[newRow][newCol]){
                    queue.add(new Point(newRow,newCol));
                    visited[newRow][newCol]=true;
                }
            }
        }
        if(flag){
           res+= bfs(1,1);
        }
        return res;
    }
}
