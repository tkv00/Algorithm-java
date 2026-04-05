import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int node;
        int cost;

        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    private static int n, m;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static PriorityQueue<Node> pq;
    private static int[] dist;
    private static List<Integer> path;
    private static int[] prev;
    private static Map<Integer, List<Node>> map;
    private static int start, end;
    private static final int INF = 987654321;
    private static StringBuilder sb;

    private static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        path = new ArrayList<>();
        map = new HashMap<>();
        sb = new StringBuilder();
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n + 1];
        prev = new int[n + 1];

        Arrays.fill(dist, INF);
        Arrays.fill(prev, -1);

        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map.get(s).add(new Node(e, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }

    private static void operation() {
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        //path.add(start);

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.node] < now.cost) continue;

            for (Node next : map.get(now.node)) {
                if (dist[next.node] > next.cost + dist[now.node]) {
                    dist[next.node] = next.cost + dist[now.node];
                    prev[next.node] = now.node;
                    pq.offer(new Node(next.node, dist[next.node]));
                }
            }
        }
    }

    private static void output() {
        sb.append(dist[end]).append("\n");
        getPath();
        sb.append(path.size()).append("\n");
        for (int x : path) {
            sb.append(x).append(" ");
        }
    }

    private static void getPath() {
        for (int cur = end; cur != -1;cur=prev[cur] ){
            path.add(cur);

            if(cur==start) break;
        }

        Collections.reverse(path);
    }

    public static void main(String[] args) throws IOException {
        init();
        input();
        operation();
        output();

        System.out.print(sb);

    }
}
