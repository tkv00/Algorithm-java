import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int K;
    public static int X;
    public  static int a;
    public static int b;

    public static int[] visited;
    public static StringTokenizer st;

    public static Queue<Integer> res=new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());
        visited=new int[N+1];
        List<Integer>[] edges=new List[N+1];

        for(int i=1;i<=N;i++){
            edges[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            edges[a].add(b);
        }
        

        bfs(X,edges);
        for(int i=1;i<=N;i++){
            if(visited[i]==K+1){
                res.add(i);
            }
        }
        if(res.isEmpty()){
            System.out.println(-1);
        }else{
            for(int i:res){
                System.out.println(i);
            }
        }







    }
    public  static void bfs(int node,List<Integer>[] edges){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(node);
        visited[node]=1;
        while (!queue.isEmpty()){
            int newNode=queue.poll();
            for(int i:edges[newNode]){
                if(visited[i]==0){
                    visited[i]=visited[newNode]+1;
                    queue.add(i);
                }
            }
        }
    }
}
