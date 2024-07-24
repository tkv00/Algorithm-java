import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Point{
        int start,end;
        Point(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    public static class PointComparator implements Comparator<Point> {

        @Override
        public int compare(Point o1, Point o2) {
            if(o1.end==o2.end){
                return o1.start-o2.start;
            }
            return o1.end-o2.end;
        }
    }
    public static int N;
    public static StringTokenizer st;
    public static PriorityQueue<Point> pq;
    public static void main(String[] args) throws IOException {

        pq=new PriorityQueue<>(1,new PointComparator());

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            pq.offer(new Point(start,end));
        }

        int cnt=1;
        Point pre=pq.poll();
        int preEnd=pre.end;

        while (!pq.isEmpty()){

            Point now=pq.poll();
            int nowStart=now.start;
            int nowEnd=now.end;
            if(nowStart==nowEnd){
                cnt++;

            }
            else if(nowStart>=preEnd){
                preEnd=nowEnd;
                cnt++;
            }else{
                continue;
            }

        }
        System.out.println(cnt);

    }
}
