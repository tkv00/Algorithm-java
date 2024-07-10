import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

import static java.lang.System.exit;

public class Main {
    public static int N;
    public static PriorityQueue<Long>pQ=new PriorityQueue<>();
    public static long sum=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
           pQ.offer(Long.parseLong(br.readLine()));
        }
        while(pQ.size()>1){
            long temp1=pQ.poll();
            long temp2=pQ.poll();
            sum+=temp1+temp2;
            pQ.offer(temp1+temp2);
        }
//        while (!pQ.isEmpty()){
//            sum+=pQ.poll();
//        }
        System.out.println(sum);
      
    }

}
