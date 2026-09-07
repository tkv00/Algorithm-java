import java.util.*;
public class Main {
    static class Node{
        int idx;
        int cost;

        Node(int idx,int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
    static List<Node>[] graph;
    static int[][] dist;
    static int size;
    static final int INF =Integer.MAX_VALUE;
    static void init(int[][] edges,int n,int m){
        graph = new List[n+1];
        dist = new int[n+1][n+1];
        size=n;

        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
            Arrays.fill(dist[i],INF);
            dist[i][i]=0;
        }

        for(int[] edge:edges){
            graph[edge[0]].add(new Node(edge[1],edge[2]));
            graph[edge[1]].add(new Node(edge[0],edge[2]));
        }
    }

    static int[] djkstra(int start){
        int[] dist = new int[size+1];
        Arrays.fill(dist,INF);

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a,b)->Integer.compare(a.cost,b.cost)
        );

        pq.offer(new Node(start,0));
        dist[start]=0;

        while(!pq.isEmpty()){
            Node now = pq.poll();
            int nowCost = now.cost;
            int nowIdx = now.idx;

            if(dist[nowIdx]<nowCost) continue;

            for(Node next:graph[nowIdx]){
                if(next.cost==INF) continue;
                
                int newDist = nowCost + next.cost;

                if(newDist<dist[next.idx]){
                    dist[next.idx]=newDist;
                    pq.offer(new Node(next.idx,newDist));
                }
            }
        }

        return dist;
    }

    static void operation(int v1,int v2,int e){
        int[] distV1=djkstra(v1);
        int[] distV2=djkstra(v2);
        int[] distE=djkstra(e);
        int min = INF;

        for(int mid=1;mid<=size;mid++){
            if(distV1[e] ==INF || distV2[e]==INF) {
                System.out.print(-1);
                return;
            }

            int value=0;

            if(distV1[mid]==INF || distV2[mid]==INF){
                value = distV1[e] + distV2[e];
            }

            else{
                value = distE[mid]+distV1[mid]+distV2[mid];
            }
           
            min = Math.min(min,value);
        }

        System.out.print(min);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int v1 = sc.nextInt();//A가 출발하는 정점
        int v2 = sc.nextInt();//B가 출발하는 정점
        int e = sc.nextInt(); //도착 정점

        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }
        // Please write your code here.
        init(edges,n,m);
        operation(v1,v2,e);
    }
}