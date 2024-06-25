import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<ArrayList<Integer>> graph;
    public static int node;
    public static int x;
    public static int y;
    public static int[] parent;
    public static int[] visited;
    public static void main(String[] args) throws IOException {
        graph=new ArrayList<ArrayList<Integer>>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        node=Integer.parseInt(br.readLine());
        parent=new int[node+1];
        visited=new int[node+1];
        visited[0]=1;
        parent[1]=1;

        for(int i=0;i<=node;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0;i<node-1;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            x=Integer.parseInt(st.nextToken());
            y=Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);

        }

        dfs(1);
        for(int i=2;i<=node;i++){
            System.out.println(parent[i]);
        }

    }
    public static void dfs(int node){
        visited[node]=1;
        for(int i: graph.get(node)){
            if(visited[i]==0){
                parent[i]=node;
                visited[i]=1;
                dfs(i);
            }
        }
    }

}
