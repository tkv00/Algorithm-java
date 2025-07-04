import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static ArrayDeque<Node> pq=new ArrayDeque<>();
    private static int N;
    private static int L;
    private static class Node{
        int data;
        int index;
        Node(int data,int index){
            this.data=data;
            this.index=index;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            int num=Integer.parseInt(st.nextToken());
            while(!pq.isEmpty() && pq.peekFirst().data>num) pq.pollFirst();

            pq.addFirst(new Node(num,i));

            if(pq.peekLast().index<=i-L){
                pq.pollLast();
            }
            sb.append(pq.peekLast().data).append(" ");
        }

        System.out.print(sb);
    }
}
