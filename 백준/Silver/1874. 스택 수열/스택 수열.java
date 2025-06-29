import java.util.*;
import java.io.*;
public class Main {
    private static int N;
    private static int[] arr;
    private static Stack<Integer> stack=new Stack<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        int idx=0;
        int now=1;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        while (now <= N || idx < N) {
            if (!stack.isEmpty()) {
                if (stack.peek() == arr[idx]) {
                    stack.pop();
                    idx++;
                    sb.append("-").append("\n");
                    continue;
                }else if(stack.peek()>arr[idx]){
                    System.out.print("NO");
                    return;
                }
            }
            stack.push(now);
            now++;
            sb.append("+").append("\n");
        }
        System.out.print(sb);
    }

}
