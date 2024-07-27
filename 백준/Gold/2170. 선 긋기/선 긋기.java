import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Main {
    public static class Point implements Comparable<Point> {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o1) {
            if (o1.x == this.x) {
                return this.y - o1.y;
            }
            return this.x - o1.x;
        }
    }

    public static int N;
    public static int sum = 0;

    public static PriorityQueue<Point> pq = new PriorityQueue<Point>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.offer(new Point(x, y));
        }

        Point p = pq.poll();

        int start=p.x;
        int end=p.y;


        while (!pq.isEmpty()) {

            Point newPoint = pq.poll();
            int newX = newPoint.x;
            int newY = newPoint.y;

            if (end >= newX) {
                end = Math.max(newY,end);
                //System.out.println(end);
            } else {
                //System.out.println("start end"+start+" "+end);
                sum += end - start;
                //System.out.println("sum"+sum);
                start = newX;
                end = newY;
                //System.out.println(sum);
            }
            //sum += end - start;
        }
        sum += end - start;
        System.out.println(sum);


    }
}
