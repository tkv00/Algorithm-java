import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static StringBuilder rootS;
    private static int n, m;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[][] distMap;
    private static int[][] next;
    private static final int INF = 1_000_000;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        distMap = new int[n + 1][n + 1];
        next = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                distMap[i][j] = INF;
            }
        }

        for (int i = 1; i <= n; i++) {
            distMap[i][i] = 0;
        }

        //버스 정보
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            //시작 도시
            int start_node = Integer.parseInt(st.nextToken());
            ///도착 도시
            int end_node = Integer.parseInt(st.nextToken());
            //비용
            int cost = Integer.parseInt(st.nextToken());

            distMap[start_node][end_node] = Math.min(distMap[start_node][end_node], cost);
            next[start_node][end_node] = end_node;
        }
    }

    private static void floyd_warshall() {
        for (int k = 1; k <= n; k++) {
            for (int row = 1; row <= n; row++) {
                for (int col = 1; col <= n; col++) {
                    if (distMap[row][col] > distMap[row][k] + distMap[k][col]) {
                        next[row][col] = next[row][k];
                        distMap[row][col] = distMap[row][k] + distMap[k][col];
                    }
                }
            }
        }
    }


    //경로 역추적
    private static List<Integer> reverse_find(int start, int end) {
        List<Integer> path = new ArrayList<>();

        if (next[start][end] == 0) {
            return path;
        }

        path.add(start);
        while (start != end) {
            start = next[start][end];
            path.add(start);
        }

        return path;
    }

    private static void result() {
        for (int start = 1; start <= n; start++) {
            for (int end = 1; end <= n; end++) {
                if (start == end) sb.append("0").append("\n");
                else {
                    reverse_find(start, end);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        floyd_warshall();

        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                if (distMap[i][j]==INF) {
                    sb.append("0").append(" ");
                    continue;
                }
                sb.append(distMap[i][j]).append(" ");
            }
            sb.append("\n");
        }


        for (int row=1;row<=n;row++){
            for (int col=1;col<=n;col++){
                if (row==col){
                    sb.append("0");
                }else {
                    List<Integer> path=reverse_find(row,col);
                    if (path.isEmpty()){
                        sb.append("0").append(" ");
                        continue;
                    }
                    sb.append(path.size()).append(" ");

                    for (int k:path){
                        sb.append(k).append(" ");
                    }
                }

                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
