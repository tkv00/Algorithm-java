import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static PriorityQueue<Integer> pq=new PriorityQueue<>();
    static StringTokenizer st;
    static long res=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            int input=Integer.parseInt(st.nextToken());
            pq.add(input);
        }
        long k=0;
        while (!pq.isEmpty()){
           k+=pq.poll();
           res+=k;
        }
        System.out.println(res);

    }
}
