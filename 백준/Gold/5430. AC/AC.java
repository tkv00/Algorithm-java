import java.util.*;
import java.io.*;
public class Main {
    private static int T;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(br.readLine());
        sb=new StringBuilder();

        for(int i=0;i<T;i++){
            String str=br.readLine();
            int num=Integer.parseInt(br.readLine());
            String numbers=br.readLine();
            numbers=numbers.replace("[","");
            numbers=numbers.replace("]","");
            String[] cleaned=numbers.split(",");
            solve(str.toCharArray(),num,cleaned);
        }

        System.out.print(sb);


    }
    private static void solve(char[] orders,int num,String[] nums){
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<num;i++){
            dq.addFirst(Integer.parseInt(nums[i]));
        }
        boolean status=false;
        for(char c:orders){
            if(c=='R'){
                status=!status;
            }
            if(c=='D'){
                if(dq.isEmpty()){
                    sb.append("error").append("\n");
                    return;
                }
                if(!status){
                    dq.pollLast();
                }else{
                    dq.pollFirst();
                }
            }
        }
        sb.append("[");
        while(!dq.isEmpty()){
            if(status){
                sb.append(dq.pollFirst());
                if(!dq.isEmpty()){
                    sb.append(",");
                }
            }else{
                sb.append(dq.pollLast());
                if(!dq.isEmpty()){
                    sb.append(",");
                }
            }
        }

        sb.append("]").append("\n");
    }

}
