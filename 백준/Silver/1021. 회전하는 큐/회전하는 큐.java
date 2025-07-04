import java.util.*;
import java.io.*;
public class Main {
    private static int N;
    private static int M;
    private static StringTokenizer st;
    private static int cnt=0;
    private static LinkedList<Integer> dq=new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        //큐 크기
        N=Integer.parseInt(st.nextToken());
        //뽑으려는 수 크기
        M=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());

        int[] numbers=new int[M];
        for(int i=0;i<M;i++){
            numbers[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;i++){
            dq.addLast(i);
        }

        for(int i=0;i<M;i++){
            int target=numbers[i];
            while(true){
                if(target==dq.getFirst()){
                    dq.pollFirst();
                    break;
                }
                int size=dq.size()/2;
                if(dq.indexOf(target)<=size){
                    dq.addLast(dq.pollFirst());
                }else{
                    dq.addFirst(dq.pollLast());
                }
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
