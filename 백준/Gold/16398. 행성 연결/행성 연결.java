import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Point implements Comparable<Point> {
        int start;
        int end;
        int cost;

        public Point(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }

    static PriorityQueue<Point> pq = new PriorityQueue<>();
    static int N;
    static int[][] map;
    static StringTokenizer st;
    static long res = 0;
    static int[]arr;
    static void union(int a, int b, int[] arr) {
        a = find(a, arr);
        b = find(b, arr);
        if (a > b) arr[a] = b;
        else arr[b] = a;
    }

    static int find(int a, int[] arr) {
        if (arr[a] == a) return a;
        return arr[a] = find(arr[a], arr);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int t = Integer.parseInt(st.nextToken());
                if (i < j) {
                    pq.add(new Point(i, j, t));
                }
            }
        }

        while (!pq.isEmpty()) {
            //if(!isValid(arr))return;
            Point now = pq.poll();
            //같은 집합이 아닐 경우
            if (find(now.start, arr) != find(now.end, arr)) {
                res += now.cost;
                union(now.start, now.end, arr);
            }
        }
        System.out.println(res);
    }
}
