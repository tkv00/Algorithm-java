import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node>{
        int num;
        int cost;
        Node(int num,int cost){
            this.cost=cost;
            this.num=num;
        }


        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }
    public static int node;
    public static int edge;
    public static int startNum;
    public static ArrayList<Node>[] graph;
    public static int[] dp;
    public static final int INF= (int)1e9;
    public static StringTokenizer st;
    public static PriorityQueue<Node> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb=new StringBuilder();
        st=new StringTokenizer(br.readLine());

        node=Integer.parseInt(st.nextToken());
        edge=Integer.parseInt(st.nextToken());
        startNum=Integer.parseInt(br.readLine());

        graph=new ArrayList[node+1];
       // visit=new boolean[node+1];
        dp=new int[node+1];
        for(int i=0;i<=node;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<=node;i++){
            dp[i]=INF;
        }
        dp[startNum]=0;
        queue=new PriorityQueue<>();

       // visit[startNum]=true;
        queue.add(new Node(startNum,0));

        for(int i=0;i<edge;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end,cost));
        }

        //다익스트라 알고리즘
        while (!queue.isEmpty()){
            Node nowNode=queue.poll();
            int v=nowNode.num;
            for(Node node:graph[v]){
                if( dp[node.num]>dp[v]+ node.cost){
                    int num= node.num;;
                    int cost=node.cost;
                    dp[num]= nowNode.cost+cost;
                    queue.add(new Node(num,dp[num]));
                    
                }

            }

        }
        for(int i=1;i<=node;i++){
            sb.append(dp[i] == INF ? "INF" : dp[i]).append('\n');
        }
        System.out.println(sb);


    }
}
