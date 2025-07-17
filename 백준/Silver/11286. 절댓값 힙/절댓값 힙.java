import java.io.*;
import java.util.*;
public class Main {
    private static PriorityQueue<Integer> pq=new PriorityQueue<>((o1,o2)->{
        Integer x=Math.abs(o1);
        Integer y=Math.abs(o2);
        if(x.equals(y)){
            return o1-o2;
        }
        return x-y;
    });
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<N;i++){
            int num=Integer.parseInt(br.readLine());
            if(num==0 && !pq.isEmpty()){
                sb.append(pq.poll()).append("\n");
                continue;
            }else if(num==0 && pq.isEmpty()){
                sb.append(0).append("\n");
                continue;
            }
            pq.offer(num);
        }

        System.out.print(sb);
    }
}
