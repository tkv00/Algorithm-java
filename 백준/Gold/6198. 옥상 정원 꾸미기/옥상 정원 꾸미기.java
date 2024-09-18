import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int N;

    static long res=0;
    static Stack<Integer> stack=new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            int height=Integer.parseInt(br.readLine());
            while (!stack.isEmpty()){
                //입력받을 건물 높이가 이전 건물높이 보다 높을떄
                if(stack.peek()<=height){
                    //스택에서 제외
                    stack.pop();
                }
                else break;
            }
            
            res+=stack.size();
            stack.push(height);

        }

        System.out.println(res);

    }
}
