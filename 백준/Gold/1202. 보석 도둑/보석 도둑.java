import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int N, K;
    private static int[] bags;
    private static List<Stone> list;
    private static long result=0;

    private static class Stone {
        int weight;
        int value;

        Stone(int weight, int value) {
            this.value = value;
            this.weight = weight;
        }
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bags = new int[K];
        list=new ArrayList<>();


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list.add(new Stone(weight,value));
        }

        list.sort((a,b)->a.weight-b.weight);

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);
    }

    private static void operation() {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b.compareTo(a));
        int idx=0;

        for (int bag : bags) {
            while (idx<N && bag>=list.get(idx).weight){
                pq.offer(list.get(idx).value);
                idx++;
            }

            if (!pq.isEmpty()) result+=pq.poll();
        }

    }

    public static void main(String[] args) throws IOException {
        init();
        operation();

        System.out.println(result);
    }
}
