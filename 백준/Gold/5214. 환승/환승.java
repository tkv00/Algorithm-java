import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, K, M;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static final int DONT = -1;
    private static List<Integer>[] graph;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N + M + 1];

        for (int i = 1; i <= N + M; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= K; j++) {
                int num = Integer.parseInt(st.nextToken());
                //양방향 연결
                graph[i + 1 + N].add(num);
                graph[num].add(i + 1 + N);
            }
        }

    }

    private static int distance(int end) {
        if (end==1) return 1;
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N + M + 1];
        visited[1] = true;
        q.offer(new int[]{1, 1,0});


        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (Integer next : graph[now[0]]) {
                if (visited[next]) continue;

                if (next == end) {
                    return now[1]+1-now[2];
                }

                q.offer(new int[]{next, now[1]+1,next>N ? now[2]+1 : now[2]});
                visited[next] = true;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(distance(N));
    }
}
