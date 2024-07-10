import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node> {
        int node;
        int cost;

        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static int N;
    public static int M;

    public static boolean[] visited;
    public static int[] costArr;
    public static ArrayList<Node>[] arr;
    public static int start;
    public static int end;
    public static StringTokenizer st;
    public static int INF;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        INF = Integer.MAX_VALUE;

        arr = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];
        costArr = new int[N + 1];
        Arrays.fill(costArr, INF);


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr[start].add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.offer(new Node(start, 0));

        costArr[start] = 0;
        while (!pQ.isEmpty()) {
            Node nowNode = pQ.poll();
            if (visited[nowNode.node]) continue;
            visited[nowNode.node] = true;

            for (Node nextNode : arr[nowNode.node]) {
                
                if (costArr[nextNode.node] > costArr[nowNode.node] + nextNode.cost) {
                    costArr[nextNode.node] = costArr[nowNode.node] + nextNode.cost;

                    pQ.offer(new Node(nextNode.node, costArr[nextNode.node]));

                }

            }
        }


        System.out.println(costArr[end]);

    }
}
