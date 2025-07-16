import java.io.*;
import java.util.*;
public class Main {
    private static StringTokenizer st;
    private static int n,m;
    private static HashMap<Integer,ArrayList<Integer>> map;
    private static boolean[] visited;
    private static boolean flag;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int caseNum=1;

        while(true){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            if(n==0 && m==0) break;
            map=new HashMap<>();
            visited=new boolean[n+1];
            int count=0;
            flag=false;
            for(int i=1;i<=n;i++){
                map.put(i,new ArrayList<>());
            }
            for(int i=0;i<m;i++){
                st=new StringTokenizer(br.readLine());
                int first=Integer.parseInt(st.nextToken());
                int second=Integer.parseInt(st.nextToken());

                map.get(first).add(second);
                map.get(second).add(first);
            }
            for(int i=1;i<=n;i++){
                if(!visited[i]){
                    flag=false;
                    DFS(i,0);
                    if(!flag){
                        count++;
                    }
                }
            }

            switch(count){
                case 0:
                    sb.append("Case "+caseNum+": No trees.").append("\n");
                    break;
                case 1:
                    sb.append("Case "+caseNum+": There is one tree.").append("\n");
                    break;
                default:
                    sb.append("Case "+caseNum+": A forest of "+count+" trees.").append("\n");
                    break;
            }
            caseNum++;
        }
        System.out.print(sb);

    }
    private static void DFS(int current,int parent){
        ArrayList<Integer> list=map.get(current);
        if(list==null) return;
        visited[current]=true;
        for(int next:list){
            if(next==parent) continue;
            if(visited[next]){
                flag=true;
                continue;
            }
            DFS(next,current);
        }
    }
}
