import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[][] map;
    private static int[] dr = new int[]{0, 0, 1, -1};
    private static int[] dc = new int[]{1, -1, 0, 0};
    private static int time=0;

    //주변 바다 계산
    private static int countOcean(int row, int col) {
        int cnt = 0;

        for (int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];

            if (isValid(row, col) && map[nr][nc] == 0) cnt++;
        }

        return cnt;
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < M;
    }

    //덩어리 개수 세기
    private static int countMash() {
        int cnt=0;
        boolean[][] visited=new boolean[N][M];

        for (int row=0;row<N;row++){
            for (int col=0;col<M;col++){
                if (map[row][col]!=0 && !visited[row][col]){
                    dfs(row,col,visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void dfs(int row, int col, boolean[][] visited) {
        if (visited[row][col]) return;

        visited[row][col]=true;

        for (int d=0;d<4;d++){
            int nr=row+dr[d];
            int nc=col+dc[d];

            if (nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]!=0){
                dfs(nr,nc,visited);
            }
        }
    }

    //배열 복사
    private static int[][] copy(int[][] arr) {
        int rowSize = arr.length;
        ;
        int colSize = arr[0].length;

        int[][] copyMap = new int[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                copyMap[i][j] = arr[i][j];
            }
        }
        return copyMap;
    }

    //빙산이 다 녹늑지 판단 함수
    private static boolean isEmptyMap(){
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (map[i][j]!=0) return false;
            }
        }
        return true;
    }
    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
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
    }

    private static void operation(){
        boolean flag=true;
        Queue<int[]> q=new LinkedList<>();

        while(true){
            //두 덩어리 이상 분리된 경우
            if (countMash()>=2) break;

            //빙산이 다 녹는 경우
            if (isEmptyMap()){
                flag=false;
                break;
            }

            for (int i=0;i<N;i++){
                for (int j=0;j<M;j++){
                    if (map[i][j]==0) continue;
                    q.offer(new int[]{i,j,countOcean(i,j)});
                }
            }

            while (!q.isEmpty()){
                int[] now=q.poll();
                map[now[0]][now[1]]=Math.max(0,map[now[0]][now[1]]-now[2]);
            }
            time++;
        }

        if (!flag) time=0;
    }


    public static void main(String[] args) throws IOException {
        init();

        operation();
        System.out.println(time);

    }
}
