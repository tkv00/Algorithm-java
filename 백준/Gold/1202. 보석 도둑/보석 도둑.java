import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int N,K;
    //보석
    private static PriorityQueue<Integer> pq;
    //가방
    private static int[] bags;
    //무게 - 가격

    private static int[][] infos;
    private static long result;

    private static void init() throws IOException {
        result=0;
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());


        bags=new int[K];
        infos=new int[N][2];

        for (int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            //무게
            int weight=Integer.parseInt(st.nextToken());
            //가격
            int cost=Integer.parseInt(st.nextToken());
            infos[i]=new int[]{weight,cost};
        }

        for (int i=0;i<K;i++){
            int num=Integer.parseInt(br.readLine());
            bags[i]=num;
        }
        Arrays.sort(bags);
        Arrays.sort(infos,(a,b)->a[0]-b[0]);
    }

    private static void operation(){
        pq=new PriorityQueue<>((a,b)->b-a);
        int idx=0;

        for (int bag:bags){
            while (idx<N && bag>=infos[idx][0]){
                pq.offer(infos[idx][1]);
                idx++;
            }

            if(!pq.isEmpty()){
                result+=pq.poll();
            }
        }
    }
    public static void main(String[] args) throws IOException {
        init();
        operation();
        System.out.println(result);
    }
}
