import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;
    public static StringTokenizer st;
    public static int[][] graph;
    public static final int MAX_COST = 10000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], MAX_COST);
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start][end] = Math.min(graph[start][end], cost);

        }
        //System.out.println(Arrays.deepToString(graph));

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                for (int k = 1; k <= n; k++) {
                    if (i == k || k == j) continue;
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == MAX_COST) {
                    sb.append("0 ");
                } else {
                    sb.append(graph[i][j] + " ");
                }

            }
            sb.append("\n");
        }
        System.out.println(sb);


    }

}
