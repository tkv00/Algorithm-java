import java.util.*;
import java.io.*;
public class Main {
    private static int N;
    private static Stack<Character> stack;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++){
            String str=br.readLine();
            sb.append(solve(str)).append("\n");
        }
        System.out.print(sb);

    }
    private static String solve(String str){
        char[] arr=str.toCharArray();
        stack=new Stack<>();
        if(arr.length%2!=0)return "NO";
        stack.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]=='(')
                stack.push(arr[i]);
            if(arr[i]==')'){
                if(!stack.isEmpty() && '('==stack.peek()){
                    stack.pop();
                }else{
                    stack.push(arr[i]);
                }
            }
        }
        if(stack.isEmpty())return "YES";
        return "NO";
    }

}
