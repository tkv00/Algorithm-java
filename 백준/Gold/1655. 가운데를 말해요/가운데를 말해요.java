
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static PriorityQueue<Integer> minHeap;
    private static PriorityQueue<Integer> maxHeap;
    private static BufferedReader br;
    private static int N;
    private static StringBuilder sb;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        minHeap = new PriorityQueue<>((a, b) -> a - b);
        maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            operation(n);
        }
    }

    private static void operation(int n) {

        int minSize = minHeap.size();
        int maxSize = maxHeap.size();

        if (maxSize == minSize) {
            maxHeap.offer(n);
        }else minHeap.offer(n);

        if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
            if (maxHeap.peek()>minHeap.peek()){
                int k=maxHeap.poll();
                int t=minHeap.poll();
                minHeap.offer(k);
                maxHeap.offer(t);
            }
        }

        sb.append(maxHeap.peek()).append("\n");
    }

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(sb);
    }
}
