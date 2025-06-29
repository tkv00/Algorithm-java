import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.*;

public class Main {
    private static int K;
    private static Stack<Integer> stack=new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        K=Integer.parseInt(br.readLine());
        for(int i=0;i<K;i++){
            int input=Integer.parseInt(br.readLine());
            if(input==0){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(input);
            }
        }
        int sum=0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }

        System.out.print(sum);
    }
}
