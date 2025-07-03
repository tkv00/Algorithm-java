import java.io.*;
import java.util.*;
public class Main {
    // 1 2 3 4
    private static ArrayDeque<Integer> dq=new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        for(int i=1;i<=N;i++){
            dq.addFirst(i);
        }
        while(dq.size()>1){
            dq.pollLast();
            dq.addFirst(dq.pollLast());
        }
        System.out.print(dq.pollLast());
    }
}
