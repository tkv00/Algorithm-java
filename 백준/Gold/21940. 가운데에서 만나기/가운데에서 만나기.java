import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N,M;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[][] timeMap;

    private static StringBuilder sb;
    private static PriorityQueue<int[]> pq;
    private static final int INF=1_000_000;
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();
        pq=new PriorityQueue<>((a,b)->a[1]-b[1]);

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        timeMap=new int[N+1][N+1];
        for (int i=1;i<=N;i++){
            Arrays.fill(timeMap[i],INF);
        }
        for (int i=1;i<=N;i++){
            timeMap[i][i]=0;
        }
        for (int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int time=Integer.parseInt(st.nextToken());

            timeMap[start][end]=Math.min(time,timeMap[start][end]);
        }




    }
    private static void floyd_warshall(){
        for (int k=1;k<=N;k++){
            for (int start=1;start<=N;start++){
                for (int end=1;end<=N;end++){
                    if (start==end)continue;
                    timeMap[start][end]=Math.min(timeMap[start][end],timeMap[start][k]+timeMap[k][end]);
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {
        init();
        floyd_warshall();

        int num=Integer.parseInt(br.readLine());
        int[] friends=new int[num];

        st=new StringTokenizer(br.readLine());
        for (int i=0;i<num;i++){
            friends[i]=Integer.parseInt(st.nextToken());
        }

        List<Integer> result=new ArrayList<>();
        int min=INF;

        for (int city=1;city<=N;city++){
            int maxRound=0;
            boolean reachable=true;

            for (int friend:friends){
                if (timeMap[city][friend]==INF || timeMap[friend][city]==INF){
                    reachable=false;
                    break;
                }
                maxRound=Math.max(maxRound,timeMap[city][friend]+timeMap[friend][city]);
            }

            if (!reachable) continue;

            if (maxRound<min){
                min=maxRound;
                result.clear();
                result.add(city);

            }else if (maxRound==min) result.add(city);
        }


        for (int x:result) System.out.print(x+" ");


    }
}
