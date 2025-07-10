import java.util.*;
import java.io.*;

public class Main {
    private static StringTokenizer st;
    private static HashMap<Integer,ArrayList<Integer>> map;
    private static int N;
    private static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new HashMap<>();
        parent=new int[N+1];

        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine());
            int first=Integer.parseInt(st.nextToken());
            int second=Integer.parseInt(st.nextToken());

            map.putIfAbsent(first,new ArrayList<>());
            map.putIfAbsent(second,new ArrayList<>());

            map.get(first).add(second);
            map.get(second).add(first);
        }
        StringBuilder sb=new StringBuilder();
        DFS(1);
        for(int i=2;i<=N;i++){
            sb.append(parent[i]).append("\n");
        }

        System.out.print(sb);
    }
    private static void DFS(int now){
        ArrayList<Integer> list=map.get(now);
        for(int next:list){
            if(parent[next]==0){
                parent[next]=now;
                DFS(next);
            }
        }
    }
}
