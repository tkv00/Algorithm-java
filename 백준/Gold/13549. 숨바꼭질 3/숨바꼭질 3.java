import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int N, K;
    private static int[] time;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static final int SIZE = 100_001;
    private static final int INF = 987654321;
    private static PriorityQueue<Node> q;
    private static boolean[] visited;

    private static class Node {
        int node;
        int time;

        public Node(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    private static void init() throws IOException {
        time = new int[SIZE];
        visited = new boolean[SIZE];
        Arrays.fill(time, INF);

        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        q = new PriorityQueue<>((a, b) -> a.time - b.time);

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        q.offer(new Node(N, 0));

        time[N] = 0;
    }

    private static boolean isValid(int k) {
        return k >= 0 && k < SIZE;
    }

    private static void operation() {
        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.time > time[now.node]) continue;
            ;

            int p1 = now.node + 1;
            if (isValid(p1) && time[now.node] + 1 < time[p1]) {
                time[p1] = time[now.node] + 1;
                q.offer(new Node(p1, time[p1]));
            }

            int p2 = now.node - 1;
            if (isValid(p2) && time[now.node] + 1 < time[p2]) {
                time[p2] = time[now.node] + 1;
                q.offer(new Node(p2, time[p2]));
            }

            int p3 = now.node * 2;
            if (isValid(p3) && time[now.node] < time[p3]) {
                time[p3] = time[now.node];
                q.offer(new Node(p3, time[p3]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        operation();

        System.out.println(time[K]);
    }
}
