import java.io.*;
import java.util.*;

public class Main {
    private static int N,M;
    private static HashMap<String,Integer> indegree=new HashMap<>();
    private static HashMap<String,ArrayList<String>> resultMap=new HashMap<>();
    private static HashMap<String,ArrayList<String>> map=new HashMap<>();
    private static ArrayList<String> parent=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        String[] inputs=br.readLine().split(" ");
        for(int i=0;i<N;i++){
            map.put(inputs[i],new ArrayList<>());
            resultMap.put(inputs[i],new ArrayList<>());
            indegree.put(inputs[i],0);
        }
        M=Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            String[] names=br.readLine().split(" ");
            map.get(names[1]).add(names[0]);
            indegree.put(names[0],indegree.get(names[0])+1);
        }
        Queue<String> q=new LinkedList<>();
        StringBuilder sb=new StringBuilder();

        for(String key:indegree.keySet()){
            if(indegree.get(key)==0){
                parent.add(key);
                q.offer(key);
            }
        }

        topological(q);

        //시조 이름 삽입
        Collections.sort(parent);
        sb.append(parent.size()).append("\n");
        for(String name:parent){
            sb.append(name).append(" ");
        }
        sb.append("\n");
        List<String> namesKeySet=new ArrayList<>(resultMap.keySet());
        Collections.sort(namesKeySet);

        for(String name:namesKeySet){
            int size=resultMap.get(name).size();
            sb.append(name).append(" ").append(size).append(" ");
            Collections.sort(resultMap.get(name));
            for(int i=0;i<size;i++){
                sb.append(resultMap.get(name).get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void topological(Queue<String> q){
        while(!q.isEmpty()){
            String nowName=q.poll();
            ArrayList<String> names=map.get(nowName);
            for(String name:names){
                indegree.put(name,Math.max(indegree.getOrDefault(name,0)-1,0));
                if(indegree.get(name)==0){
                    q.offer(name);
                    resultMap.get(nowName).add(name);
                }
            }
        }
    }
}
