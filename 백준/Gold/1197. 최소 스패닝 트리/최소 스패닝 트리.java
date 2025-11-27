import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int V, E;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static PriorityQueue<int[]> pq;
    private static long result = 0L;
    private static int[] parent;
    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{node1, node2, weight});
        }
    }

    private static int find(int a) {
        if (a == parent[a]) return a;

        return parent[a]=find(parent[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    private static void operation() {
        int cnt = 0;

        while (!pq.isEmpty()) {
            if (cnt == V - 1) break;

            int[] info = pq.poll();
            int parent1 = find(info[0]);
            int parent2 = find(info[1]);

            //사이클 판단
            if (parent1 == parent2) continue;

            result += info[2];
            union(info[0], info[1]);
            cnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        operation();

        System.out.println(result);
    }
}
