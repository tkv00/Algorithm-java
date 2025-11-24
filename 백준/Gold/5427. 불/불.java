import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final char WALL = '#';
    private static final char START = '@';
    private static final char FIRE = '*';
    private static final String DONT = "IMPOSSIBLE";

    private static StringBuilder sb;
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int T;

    private static int[] dx = new int[]{0, 0, 1, -1};
    private static int[] dy = new int[]{1, -1, 0, 0};

    private static boolean isValid(int row, int col, int h, int w, char[][] map) {
        return row >= 0 && row < h && col >= 0 && col < w && map[row][col] != WALL;
    }

    private static void BFS(char[][] map, int startX, int startY, Queue<int[]> fires,boolean[][] fireVisited,int[][] fireTimeMap) {
        int rowSize = map.length;
        int colSize = map[0].length;
        boolean[][] peopleVisited = new boolean[rowSize][colSize];


        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY,0});
        peopleVisited[startX][startY]=true;

        while (!fires.isEmpty()) {
            //불 이동
            int[] now = fires.poll();

            for (int d = 0; d < 4; d++) {
                int nr = dx[d] + now[0];
                int nc = dy[d] + now[1];

                if (isValid(nr, nc, rowSize, colSize, map) && map[nr][nc]!=FIRE&& !fireVisited[nr][nc]) {
                    fireVisited[nr][nc] = true;
                    fireTimeMap[nr][nc]=fireTimeMap[now[0]][now[1]]+1;
                    fires.offer(new int[]{nr, nc});
                }

            }
        }
        //printMap(fireTimeMap);


        while (!q.isEmpty()){
            //상근이 이동
            int[] now=q.poll();

            for (int d=0;d<4;d++){
                int nr=dx[d]+now[0];
                int nc=dy[d]+now[1];

                //탈출 조건
                if (nr<0 || nr>= rowSize || nc<0 || nc>=colSize) {
                    sb.append(now[2]+1).append("\n");
                    return;
                }

                if (isValid(nr,nc,rowSize,colSize,map) && !peopleVisited[nr][nc] &&
                    (now[2]+1<fireTimeMap[nr][nc] || fireTimeMap[nr][nc]==-1)
                ){
                    q.offer(new int[]{nr,nc,now[2]+1});
                    peopleVisited[nr][nc]=true;
                }
            }
        }

        sb.append(DONT).append("\n");
    }

    private static void init() throws IOException {
        sb = new StringBuilder();
        br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
    }

    private static void escape(int w, int h) throws IOException {
        char[][] map = new char[h][w];
        int startX=0;
        int startY=0;
        Queue<int[]> fires=new LinkedList<>();

        int[][] fireTimeMap = new int[h][w];
        boolean[][] fireVisited = new boolean[h][w];
        for (int row=0;row<h;row++){
            Arrays.fill(fireTimeMap[row],-1);
        }

        for (int i = 0; i < h; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray();

            for (int j=0;j<map[i].length;j++){
                if (map[i][j]==START){
                    startX=i;
                    startY=j;
                }else if (map[i][j]==FIRE){
                    fires.offer(new int[]{i,j});
                    fireTimeMap[i][j]=0;
                    fireVisited[i][j]=true;
                }
            }
        }

        BFS(map,startX,startY,fires,fireVisited,fireTimeMap);
    }

    private static void operation() throws IOException {
        st=new StringTokenizer(br.readLine());
        int w=Integer.parseInt(st.nextToken());
        int h=Integer.parseInt(st.nextToken());

        escape(w,h);
    }

    private static void printMap(int[][]map){
        for (int row=0;row<map.length;row++){
            System.out.print(Arrays.toString(map[row]));
            System.out.println();
        }

    }
    public static void main(String[] args) throws IOException {
        init();
        for (int i=0;i<T;i++){
            operation();
        }

        System.out.println(sb);
    }
}
