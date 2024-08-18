import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
   static ArrayList<Integer[]>[] graph;
   static int n;
   static StringTokenizer st;
   static boolean[]visited;
   static int max=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        graph=new ArrayList[n+1];
        visited=new boolean[n+1];
        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

            graph[start].add(new Integer[]{end,cost});
            graph[end].add(new Integer[]{start,cost});
        }

        for(int i=1;i<=n;i++){
            Arrays.fill(visited,false);
            searchMaxCost(i,0);
        }
        System.out.println(max);


    }
    static void searchMaxCost(int root,int sum){
        visited[root]=true;
        max=Math.max(sum,max);
        for(Integer[] item:graph[root]){
            int cost=item[1];
            int next=item[0];
            if(!visited[next]){
                searchMaxCost(next,sum+cost);
            }
        }

    }
}
