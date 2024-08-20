import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;

    static StringTokenizer st;
    static PriorityQueue<Long> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        queue = new PriorityQueue<>();
        //arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.add(Long.parseLong(st.nextToken()));
        }
        while (m > 0) {
            long x = queue.poll();
            long y = queue.poll();

            long sum1 = x + y;
            long sum2 = x + y;
            queue.add(sum1);
            queue.add(sum2);
            m--;
        }
        long sum = 0;
        while (!queue.isEmpty()){
            sum+=queue.poll();
        }
        System.out.println(sum);


    }


}
