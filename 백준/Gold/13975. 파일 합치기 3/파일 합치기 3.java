import java.util.*;
import java.io.*;
public class Main {
    private static int T;
    private static int K;
    private static StringTokenizer st;
    private static PriorityQueue<Long> pq;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<T;i++){
            K=Integer.parseInt(br.readLine());
            st=new StringTokenizer(br.readLine());
            pq=new PriorityQueue<>();
            for(int j=0;j<K;j++){
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long sum=0;
            while(pq.size()>1){
                long x=pq.poll();
                long y=pq.poll();
                sum+=(x+y);
                pq.offer(x+y);
            }
            sb.append(sum).append("\n");
        }

        System.out.print(sb);


    }
}
