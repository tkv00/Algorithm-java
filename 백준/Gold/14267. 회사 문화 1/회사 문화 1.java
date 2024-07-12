import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;
    public static int[] score;
    public static ArrayList<Integer>[] graph;
    public static StringTokenizer st;
    //public static boolean []visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());


        score=new int[n+1];
        graph=new ArrayList[n+1];

        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        st=new StringTokenizer(br.readLine());
        st.nextToken();
        for(int i=2;i<=n;i++){
            int v=Integer.parseInt(st.nextToken());
            graph[v].add(i);
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int idx=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            score[idx]+=cost;
        }
        dfs(1);

        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(score[i]).append(" ");
        }
        System.out.println(sb);
    }
    public static void dfs(int v){


        for(int x:graph[v]){
                score[x]+=score[v];
                dfs(x);
        }
    }
}
