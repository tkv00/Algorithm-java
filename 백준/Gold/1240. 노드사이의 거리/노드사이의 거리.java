import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        int link;

        int cost;

        Node(int link, int cost) {
            this.cost = cost;
            this.link = link;

        }
    }

    public static ArrayList<Node>[] arrayLists;
    public static int n;
    public static int m;
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arrayLists = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arrayLists[start].add(new Node(end, cost));
            arrayLists[end].add(new Node(start, cost));
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bfs(start, end);
        }

    }

    public static void bfs(int start, int end) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;
        queue.offer(new Node(start,0));
        int totalCost = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int  v=node.link;
            if (v == end) {
                System.out.println(node.cost);
                break;
            }
            for (Node n : arrayLists[v]) {
                int s = n.link;

                //방문안 했을때
                if (!visited[s]) {
                    visited[s] = true;
                    queue.add(new Node(s,n.cost+node.cost));
                }

            }


        }

    }
}
