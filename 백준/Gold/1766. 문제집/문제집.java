import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static PriorityQueue<Integer> queue;
    static ArrayList<Integer>[] arrayLists;
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();

        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new int[N+1];
        queue=new PriorityQueue<>();
        arrayLists=new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            arrayLists[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int first=Integer.parseInt(st.nextToken());
            int second=Integer.parseInt(st.nextToken());
            //진입차수 설정
            arr[second]+=1;
            arrayLists[first].add(second);
        }
        result();
        System.out.println(sb);


    }
    static void result(){
        for(int i=1;i<=N;i++){
            if(arr[i]==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int t=queue.poll();
            sb.append(t+" ");
            for(int k:arrayLists[t]){
                arr[k]-=1;
                if(arr[k]==0){
                    queue.add(k);
                }
            }
        }
    }
}
