import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    private static final int[] dr = new int[]{0, -1, 0, 1};
    private static final int[] dc = new int[]{1, 0, -1, 0};
    private static int N;
    private static int x, y, d, g;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static boolean[][] map;
    private static List<Point> list;
    private static boolean isValid(int row,int col){
        return row>=0 && row<=100 && col>=0 && col<=100;
    }

    private static void operation(int dir, int row, int col, int stage) {

        map[row][col]=true;
        map[row+dr[dir]][col+dc[dir]]=true;

        //기준 꺼내기

        while (stage!=0){
            Point center=list.get(list.size()-1);
            int size=list.size();
            for (int i=size-2;i>=0;i--){
                Point now=list.get(i);

                int dRow=center.row-now.row;
                int dCol=center.col-now.col;

                int nRow=center.row-dCol;
                int nCol=center.col+dRow;

                if (isValid(nRow,nCol)){
                    list.add(new Point(nRow,nCol));
                    map[nRow][nCol]=true;
                }
            }
            stage--;
        }
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[101][101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            list=new ArrayList<>();
            list.add(new Point(y,x));
            list.add(new Point(y+dr[d],x+dc[d]));
            operation(d,y,x,g);

        }
        System.out.println(count());
    }

    private static int count(){
        int cnt=0;
        for (int i=0;i<100;i++){
            for (int j=0;j<100;j++){
                if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1])
                    cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        init();
    }
}
