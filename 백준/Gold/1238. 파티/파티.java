import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int end;
        int cost;
        Node(int end,int cost){
            this.end =end;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node o) {
            //내림차순
            return this.cost-o.cost;
        }
    }
    static int N;
    static int M;
    static int X;
    static StringTokenizer st;
    static ArrayList<Node>[] arrayLists;
    static ArrayList<Node>[] reverse_arrayLists;
    static int max=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());
        arrayLists=new ArrayList[M+1];
        reverse_arrayLists=new ArrayList[M+1];
        for(int i=0;i<=N;i++){
            arrayLists[i]=new ArrayList<>();
            reverse_arrayLists[i]=new ArrayList<>();
        }
        for (int i=1;i<=M;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

            //입력
            arrayLists[start].add(new Node(end,cost));
            reverse_arrayLists[end].add(new Node(start,cost));
        }
        //거리 배열
        int[]dist1=new int[N+1];
        int[]dist2=new int[N+1];

        dist1=dijkstra(arrayLists);
        dist2=dijkstra(reverse_arrayLists);

        for (int i=1;i<=N;i++){
            int sum=dist1[i]+dist2[i];
            if(sum>max){
                max=sum;
            }
        }

        System.out.println(max);
    }
    public static int[] dijkstra(ArrayList<Node>[] arrayLists){
        Queue<Node> pq=new PriorityQueue<>();
        //출발 지점 넣기
        pq.add(new Node(X,0));

        boolean[] check=new boolean[N+1];
        int[] dist=new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[X]=0;

        while (!pq.isEmpty()){
            Node curNode=pq.poll();
            int curIdx=curNode.end;

            //방문하지 않은 경우
            if(!check[curIdx]){
                //방문 표시
                check[curIdx]=true;

                for(Node node:arrayLists[curIdx]){
                    if(!check[node.end] && dist[node.end]>dist[curIdx]+node.cost){
                        dist[node.end]=dist[curIdx]+node.cost;
                        pq.add(new Node(node.end,dist[node.end]));
                    }
                }
            }
        }
        return dist;
    }
}
