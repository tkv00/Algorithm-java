import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Node {
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private static int V, E, K;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static final int INF = 987654321;
    private static int[] dist;
    private static Map<Integer, List<Node>> map;
    private static PriorityQueue<Node> pq;
    private static StringBuilder sb = new StringBuilder();

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        map = new HashMap<>();
        sb = new StringBuilder();
        pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int x = 1; x <= V; x++) {
            map.put(x, new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        dist = new int[V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map.get(start).add(new Node(end, weight));
        }

        Arrays.fill(dist, INF);
    }

    private static void operation() {
        dist[K] = 0;
        pq.offer(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (Node next : map.get(now.node)) {
                if (dist[next.node] > next.weight + dist[now.node]) {
                    dist[next.node] = next.weight + dist[now.node];
                    pq.offer(new Node(next.node, dist[next.node]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        operation();

        for(int i=1;i<=V;i++){
            if(dist[i]==INF) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }

        System.out.print(sb);
    }
}
