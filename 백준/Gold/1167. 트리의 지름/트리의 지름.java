import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Node{
        int index;
        int cost;

        Node(int index,int cost){
            this.index=index;
            this.cost=cost;
        }
    }
    private static int V;
    private static BufferedReader br;
    private static StringTokenizer st;
    private static boolean[] visited;
    private static Map<Integer, List<Node>> tree;
    //제일 먼 노드
    private static int longIndex;
    //총 거리
    private static int maxValue;
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        V=Integer.parseInt(br.readLine());
        tree=new HashMap<>();
        maxValue=0;
        longIndex=0;
    }
    private static void input() throws IOException {
        for(int i=0;i<V;i++){
            st=new StringTokenizer(br.readLine());
            int parent=Integer.parseInt(st.nextToken());
            tree.putIfAbsent(parent,new ArrayList<>());

            while(st.hasMoreTokens()){
                int child=Integer.parseInt(st.nextToken());
                if(child==-1) break;
                int cost=Integer.parseInt(st.nextToken());
                tree.get(parent).add(new Node(child,cost));
            }
        }
    }

    private static void DFS(int now,int totalCost){
        if(totalCost>maxValue){
            maxValue=totalCost;
            longIndex=now;
        }

        visited[now]=true;

        for(Node node:tree.get(now)){
            if(!visited[node.index]){
                visited[node.index]=true;
                DFS(node.index,totalCost+node.cost);
                
            }
        }
    }
    public static void main(String[] args) throws IOException {
        init();
        input();
        visited=new boolean[V+1];
        DFS(1,0);

        visited=new boolean[V+1];
        DFS(longIndex,0);
        
        System.out.println(maxValue);
    }

}
