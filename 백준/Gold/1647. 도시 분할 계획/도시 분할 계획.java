import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N,M;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[] arr;
    private static PriorityQueue<int[]> pq;
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        pq=new PriorityQueue<>((a,b)->a[2]-b[2]);

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new int[N+1];

        for (int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int home1=Integer.parseInt(st.nextToken());
            int home2=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

             pq.offer(new int[]{home1,home2,cost});
        }


        for (int i=1;i<=N;i++){
            arr[i]=i;
        }
    }

    private static int findParent(int a){
        if(a==arr[a]) return a;
        return arr[a]=findParent(arr[a]);
    }

    private static void union(int a,int b){
        a=findParent(a);
        b=findParent(b);
        if (a<b) arr[b]=a;
        else arr[a]=b;
    }

    private static int operation(){
        int cost=0;
        int maxCost=0;

        while (!pq.isEmpty()){
            int[] now=pq.poll();
            int home1=now[0];
            int home2=now[1];

            //사이클 판단
            if (findParent(home1)!=findParent(home2)){
                cost+=now[2];
                maxCost=Math.max(now[2],maxCost);
                union(home1,home2);
            }
        }

        return cost-maxCost;
    }

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(operation());
    }
}
