import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Main {
    public static class Edge {
        int start;
        int end;
        int cost;
        Edge(int start,int end,int cost){
            this.cost=cost;
            this.start=start;
            this.end=end;
        }
    }

    public static long nodeNum;
    public static long edgeNum;
    public static ArrayList<Edge> graph;
    public static long[] arr;
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        nodeNum=Integer.parseInt(st.nextToken());
        edgeNum=Integer.parseInt(st.nextToken());

        graph=new ArrayList<>();
        arr= new long[(int) (nodeNum + 1)];


        for(int i=1;i<=edgeNum;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int time=Integer.parseInt(st.nextToken());

            graph.add(new Edge(start,end,time));
        }

        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[1]=0;
        //벨만-포드 알고리즘
        for(int i=1;i<edgeNum;i++){
            for(Edge edge:graph){
                if(arr[edge.start]!= Integer.MAX_VALUE &&
                        arr[edge.end]>arr[edge.start]+edge.cost
                ){
                    arr[edge.end]=arr[edge.start]+edge.cost;
                }

            }
        }
        //System.out.println(Arrays.toString(arr));
        //음수 사이클 판단
        boolean isCase=false;
        for(Edge edge:graph){
            if(arr[edge.start]!= Integer.MAX_VALUE &&
                    arr[edge.end]>arr[edge.start]+edge.cost
            ){

                //arr[edge.end]=arr[edge.start]+edge.cost;
                isCase=true;
            }
        }
        if(isCase){
            System.out.println(-1);
            //exit(0);
        }else{
            for(int i=2;i<=nodeNum;i++){
                if(arr[i]==Integer.MAX_VALUE){
                    System.out.println("-1");
                }else{
                    System.out.println(arr[i]);
                }
            }
        }

    }
}
