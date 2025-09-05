import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    /**
     * 회의 수
     */
    private static int N;
    private static class Meeting{
        int start;
        int end;

        Meeting(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    private static int cnt=0;
    private static PriorityQueue<Meeting> pq;
    private static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        pq=new PriorityQueue<>((a,b)->a.end==b.end ? a.start-b.start : a.end - b.end);

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            pq.offer(new Meeting(start,end));
        }

        while(!pq.isEmpty()){
            int now=pq.poll().end;
            while(!pq.isEmpty() && pq.peek().start<now){
                pq.poll();
            }
            cnt++;
        }

        System.out.print(cnt);
    }
}
