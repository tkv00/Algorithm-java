import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int end;
        //아이템 개수
        int dis;
        Node(int end,int dis){
            this.end=end;
            this.dis=dis;
        }

        @Override
        public int compareTo(Node o) {
            return this.dis-o.dis;
        }
    }
    static int n;
    static int m;
    static int r;
    static StringTokenizer st;
    static int[] items;
    static ArrayList<Node>[] arrayLists;
    static int maxItemNum=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        r=Integer.parseInt(st.nextToken());

        items=new int[n+1];
        arrayLists=new ArrayList[n+1];
        for (int i=0;i<=n;i++){
            arrayLists[i]=new ArrayList<>();
        }
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            int item=Integer.parseInt(st.nextToken());
            items[i]=item;
        }
        //입력값 받기
        for (int i=1;i<=r;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

            arrayLists[start].add(new Node(end,cost));
            arrayLists[end].add(new Node(start,cost));
        }
        for(int i=1;i<n;i++){
            int num=dijkstra(i);
            maxItemNum=Math.max(maxItemNum,num);
        }
        System.out.println(maxItemNum);

    }
    public static int dijkstra(int num){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(num,0));
        //방문 배열
        boolean[]visited=new boolean[n+1];
        

        //거리
        int[] distance=new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[num]=0;

       int res=0;

        while (!pq.isEmpty()){
            Node curNode=pq.poll();
            int idx=curNode.end;
            //방문하지 않으면
            if(!visited[idx]){
                //방문 표시
                visited[idx]=true;
                for (Node node:arrayLists[idx]){
                    //수색 범위랑 방문표시
                    if(!visited[node.end] && distance[idx]+node.dis<distance[node.end]){
                        distance[node.end]=distance[idx]+node.dis;
                        pq.add(new Node(node.end, distance[node.end]));
                    }
                }
            }
        }
        for (int i=1;i<=n;i++){
            if(distance[i]<=m){
                res+=items[i];
            }
        }
        return res;
    }
}
