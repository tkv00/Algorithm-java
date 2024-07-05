import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static ArrayList<Integer>[] arr;
    public static int N;
    public static int[] cost;
    public static int[] origin;
    public static int[] cnt;

    public static StringTokenizer st;
    public static Queue<Integer> queue;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        origin=new int[N+1];
        visit = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        cost = new int[N + 1];
        cnt = new int[N + 1];
        queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            origin[i]=cost[i];

            while (true) {
                int input = Integer.parseInt(st.nextToken());
                if (input == -1) break;
                arr[input].add(i);
                cnt[i]++;
            }
        }
       // System.out.println(Arrays.toString(cnt));
        for (int i = 1; i <= N; i++) {
            if (cnt[i] == 0) {
                queue.add(i);
                visit[i] = true;
            }
        }
        result();
        for (int i = 1; i <= N; i++) {
            System.out.println(cost[i]);
        }

    }

    public static void result() {
        while (!queue.isEmpty()) {
            int v = queue.poll();

            for (int indx : arr[v]) {
               // System.out.println(indx + " " + Arrays.toString(cost));

                cost[indx] =Math.max(cost[indx],cost[v]+ origin[indx]);
                cnt[indx]--;
                if (cnt[indx] == 0) queue.add(indx);
               // System.out.println("queue" + queue);


            }
        }
    }
}
