import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static Queue<Integer> queue;
    static int[] arr;
    static StringTokenizer st;
    static ArrayList<Integer>[] arrayLists;

    static int[] dp;
    static int[] times;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        queue = new LinkedList<>();
        arr = new int[N + 1];
        arrayLists = new ArrayList[N + 1];
        dp = new int[N + 1];
        times = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());

            int first = Integer.parseInt(st.nextToken());
            arr[i] = first;
            int max = 0;
            if (arr[i] == 0) {
                queue.add(i);
                dp[i] = times[i];
            }


            for (int j = 0; j < first; j++) {
                int k = Integer.parseInt(st.nextToken());
                arrayLists[k].add(i);
            }
        }
        result();

    }

    static void result() {
        while (!queue.isEmpty()) {
            int p = queue.poll();
            for (int next : arrayLists[p]) {
                arr[next] -= 1;

                dp[next] = Math.max(dp[next], times[next] + dp[p]);
                if (arr[next] == 0) {
                    queue.add(next);
                }

            }

        }
        int res = 0;
        for (int i = 1; i <= N; i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);


    }
}
