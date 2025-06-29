import java.util.*;
import java.io.*;
public class Main {
    private static Stack<Character> stack;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        while(true){
            String input=br.readLine();
            if(input.equals(".")) break;

            sb.append(solve(input)).append("\n");
        }
        System.out.print(sb);
    }
    private static String solve(String str){
        char[] arr=str.toCharArray();
        stack=new Stack<>();
        for(char c:arr){
            if(c=='[' || c=='(')
                stack.push(c);
            if(c==']'){
                if(stack.isEmpty() || stack.peek()!='['){
                    return "no";

                }
                stack.pop();
            }
            if(c==')'){
                if(stack.isEmpty() || stack.peek()!='('){
                    return "no";
                }
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            return "yes";
        }
        return "no";
    }
}
