import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Node{
        int index;
        int dis;

        Node(int index,int dis){
            this.index=index;
            this.dis=dis;
        }
    }
    private static int N,M;
    private static BufferedReader br;
    private static StringTokenizer st;
    private static List<Node>[] map;
    private static int[] dist;
    private static PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->a.dis-b.dis);
    private static int cityStart;
    private static int cityEnd;
    private static final int INF=1_000_000_000;

    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        M=Integer.parseInt(br.readLine());

        map=new List[N+1];
        dist=new int[N+1];

        for (int i=1;i<=N;i++){
            map[i]=new ArrayList<>();
        }

        Arrays.fill(dist,INF);

        for (int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

            map[start].add(new Node(end,cost));

        }
        // printMap();

        st=new StringTokenizer(br.readLine());

        cityStart=Integer.parseInt(st.nextToken());
        cityEnd=Integer.parseInt(st.nextToken());

        dist[cityStart]=0;
        pq.offer(new Node(cityStart,0));
    }

    private static void Dijkstra(){
        boolean[] visited=new boolean[N+1];


        while (!pq.isEmpty()){
            Node now=pq.poll();
            List<Node> nextList=map[now.index];
            if (visited[now.index]) continue;

            visited[now.index]=true;

            for (Node next:nextList){
                if (!visited[next.index] &&
                    next.dis+dist[now.index]<dist[next.index]){

                    dist[next.index]=dist[now.index]+next.dis;
                    pq.offer(new Node(next.index,dist[next.index]));
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        init();
        Dijkstra();
        //printMap();
        System.out.println(dist[cityEnd]);
    }
}
