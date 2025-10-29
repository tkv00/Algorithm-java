import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N,M;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[][]map;
    private static int[][]distMap;
    private static Queue<int[]> tomatoes;
    private static int[] dr=new int[]{0,0,1,-1};
    private static int[] dc=new int[]{1,-1,0,0};
    private static int day=0;

    private static boolean isValid(int row,int col){
        return row>=0 && row<N && col>=0 && col<M && map[row][col]!=-1;
    }
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        tomatoes=new LinkedList<>();

        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());

        map=new int[N][M];
        distMap=new int[N][M];

        for (int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if (map[i][j]==1) {
                    tomatoes.offer(new int[]{i, j});
                    distMap[i][j]=1;
                }
            }
        }
    }

    private static void BFS(){
        if (tomatoes.isEmpty()) return;

        while (!tomatoes.isEmpty()){
            int[]now=tomatoes.poll();

            for (int d=0;d<4;d++){
                int nr=now[0]+dr[d];
                int nc=now[1]+dc[d];

                if (!isValid(nr,nc)) continue;
                if (distMap[nr][nc]!=0) continue;

                distMap[nr][nc]=distMap[now[0]][now[1]]+1;
                tomatoes.offer(new int[]{nr,nc});
                map[nr][nc]=1;
                day=Math.max(day,distMap[nr][nc]-1);
            }
        }
    }

    private static void printMap(){
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                System.out.print(distMap[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean isEnd(){
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (map[i][j]==0) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        init();
        BFS();
        //printMap();
        System.out.println(isEnd() ? day : -1);
    }
}
