import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int nodeNum;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visit;
    static String [] input;
    static int deleteNum;
    static int start=0;
    static int res=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        graph=new ArrayList<ArrayList<Integer>>();

        nodeNum=Integer.parseInt(br.readLine());
        for(int i=0;i<nodeNum;i++){
            graph.add(new ArrayList<Integer>());
        }
        input=br.readLine().split(" ");
        for(int i=0;i<nodeNum;i++){
           if(Integer.parseInt(input[i])!=-1){
               graph.get(Integer.parseInt(input[i])).add(i);
           }else{
               start=i;
           }
        }
        visit=new int[nodeNum+1];

        deleteNum=Integer.parseInt(br.readLine());



        
        for(ArrayList<Integer> node:graph){
            node.remove(Integer.valueOf(deleteNum));
        }
       

        if(deleteNum==start){
            System.out.println(0);
            return;
        }else{
            dfs(start);
        }

        System.out.println(res);


    }
    public static void dfs(int node){
        visit[node]=1;
        if(graph.get(node).isEmpty()){
            res++;
            return;
        }
        for(int i:graph.get(node)){
            if(visit[i]==0){
                dfs(i);
            }

        }
    }
}
