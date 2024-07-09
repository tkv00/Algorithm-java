import java.util.*;

import static java.lang.System.exit;

public class Main {
    public static int N;
    public  static int res=0;
    public static int[]arr;

    public static Queue<Integer> Negative=new LinkedList<>();
    public static Stack<Integer> Positive=new Stack<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=Integer.parseInt(sc.nextLine());
        arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(sc.nextLine());
        }
        //입력값이 1개인 경우
        if(N==1) {
            System.out.println(arr[0]);
            exit(0);
        }
        Arrays.sort(arr);
        for(int i=0;i<N;i++){
            if(arr[i]>1) Positive.push(arr[i]);
            else if(arr[i]<=0) Negative.add(arr[i]);
            else res+=1;
        }

        res+=CalculatorPlus(Positive)+CalculatorMinus(Negative);
        System.out.println(res);



    }

    public static int CalculatorPlus(Stack<Integer> stack){

        int result=0;
        while (stack.size()>1){
            result+=stack.pop()*stack.pop();
        }
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }
    public static int CalculatorMinus(Queue<Integer> queue){
        int result=0;
        while(queue.size()>1){
            result+=queue.poll()*queue.poll();
        }
        while(!queue.isEmpty()){
            result+=queue.poll();
        }
        return result;
    }
}
