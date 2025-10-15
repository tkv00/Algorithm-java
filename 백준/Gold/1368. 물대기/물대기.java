import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static class Graph {
        int start;
        int end;
        int cost;

        Graph(int start, int end, int cost) {
            this.cost = cost;
            this.start = start;
            this.end = end;
        }
    }

    private static int[] union_find;
    private static int N;
    private static BufferedReader br;
    private static StringTokenizer st;
    private static boolean[] water;
    private static PriorityQueue<Graph> pq;
    private static int result = 0;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        water = new boolean[N+1];
        pq = new PriorityQueue<>((a,b)->a.cost-b.cost);

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            pq.offer(new Graph(i,N,num));
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cost=Integer.parseInt(st.nextToken());

                if (i<j){
                    pq.offer(new Graph(i,j,cost));
                }
            }
        }
    }

    private static void operation() {
        while (!pq.isEmpty()){
            Graph now=pq.poll();

            int node1_parent=find(now.start);
            int node2_parent=find(now.end);

            //사이클이 존재하는 경우는 패스
            if (union_find[node1_parent]==union_find[node2_parent])
                continue;

            result+=now.cost;
            union(node1_parent,node2_parent);
        }
    }


    private static void init_union_find(){
        union_find=new int[N+1];
        for (int i=0;i<=N;i++){
            union_find[i]=i;
        }
    }

    private static int find(int a){
        if(a==union_find[a]) return a;
        return union_find[a]=find(union_find[a]);
    }

    private static void union(int a,int b){
        a=find(a);
        b=find(b);
        if (a<b) union_find[b]=a;
        else union_find[a]=b;
    }

    public static void main(String[] args) throws IOException {
        init();
        init_union_find();
        operation();
        System.out.println(result);
    }

}
