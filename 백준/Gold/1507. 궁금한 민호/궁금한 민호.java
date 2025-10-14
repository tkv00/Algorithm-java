import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] map;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static final int INF = 1_000_000_000;
    private static int min_road;
    private static int[][] originMap;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        originMap = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int getSum(){
        int sum=0;
        for (int i=0;i<N;i++){
            for (int j=i+1;j<N;j++){
                if (map[i][j]!=INF){
                    sum+=map[i][j];
                }
            }
        }
        return sum;
    }
    private static void reverse_floyd_warshall(){
        for (int k=0;k<N;k++){
            for (int i=0;i<N;i++){
                for (int j=i+1;j<N;j++){
                    if (map[i][j]==INF || i==j || i==k || j==k) continue;
                    if(map[i][j]>map[i][k]+map[k][j]){
                        System.out.println(-1);
                        System.exit(0);
                    }

                    if (map[i][j]==map[i][k]+map[k][j]){
                        map[i][j]=INF;
                        map[j][i]=INF;
                    }
                }
            }
        }
    }
    

    public static void main(String[] args) throws IOException {
        init();
        reverse_floyd_warshall();
        System.out.println(getSum());
    }
}
