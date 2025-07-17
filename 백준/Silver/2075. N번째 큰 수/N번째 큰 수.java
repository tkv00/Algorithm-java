import java.util.*;
import java.io.*;
public class Main {
    private static PriorityQueue<Integer> pq=new PriorityQueue<>((o1,o2)->{
        return o2-o1;
    });
    private static StringTokenizer st;

    private static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }
        while(N-->1){
            pq.poll();
        }
        System.out.print(pq.poll());
    }
}
