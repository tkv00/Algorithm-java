
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int N, K;//K:가방개수
    private static List<Integer> bags;
    private static long result = 0;
    private static PriorityQueue<int[]> jewels;
    private static PriorityQueue<Integer> values;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewels = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        values = new PriorityQueue<>((a, b) -> b - a);
        bags = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            jewels.add(new int[]{M, V});
        }

        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(br.readLine());
            bags.add(n);
        }

        bags.sort((a, b) -> a - b);
    }


    private static void operation() {
        for (int i = 0; i < K; i++) {
            while (!jewels.isEmpty() && jewels.peek()[0]<=bags.get(i)) {
                int[] jewel=jewels.poll();
                values.offer(jewel[1]);
            }
            if (!values.isEmpty()){
                result+=values.poll();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        operation();

        System.out.println(result);
    }
}
