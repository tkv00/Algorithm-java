import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    private static class Node{
        int data;
        int idx;
        Node(int data,int idx){
            this.data=data;
            this.idx=idx;
        }
    }
    private static Stack<Node> stack=new Stack<>();
    private static StringTokenizer st;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        for(int i=1;i<=N;i++){
            int height=Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && stack.peek().data<height){
                stack.pop();
            }
            if(stack.isEmpty()){
                sb.append("0 ");
            }else{
                sb.append(stack.peek().idx+" ");
            }
            stack.push(new Node(height,i));

        }
        System.out.print(sb);

    }
}
