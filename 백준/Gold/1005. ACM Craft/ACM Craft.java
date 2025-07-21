import java.io.*;
import java.util.*;
public class Main {
    private static int T;
    private static int N,K;
    private static StringTokenizer st;
    private static int[] indegree;
    private static int[] times;
    private static int[] resultTimes;
    private static HashMap<Integer,ArrayList<Integer>> map;
    private static Queue<Integer> q;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<T;i++){
            st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            K=Integer.parseInt(st.nextToken());
            indegree=new int[N+1];
            times=new int[N+1];
            resultTimes=new int[N+1];
            map=new HashMap<>();
            st=new StringTokenizer(br.readLine());

            for(int j=1;j<=N;j++){
                int time=Integer.parseInt(st.nextToken());
                times[j]=time;
                map.putIfAbsent(j,new ArrayList<>());
            }
            q=new LinkedList<>();

            for(int j=0;j<K;j++){
                st=new StringTokenizer(br.readLine());
                int start=Integer.parseInt(st.nextToken());
                int end=Integer.parseInt(st.nextToken());
                map.get(start).add(end);
                indegree[end]++;
            }

            topological();

            //건설해야 할 번호
            int W=Integer.parseInt(br.readLine());
            sb.append(resultTimes[W]).append("\n");
        }
        System.out.print(sb);
    }
    private static void topological(){
        for(int i=1;i<=N;i++){
            if(indegree[i]==0) {
             q.offer(i);
             resultTimes[i]=times[i];
            }
        }

        while(!q.isEmpty()){
            int now=q.poll();
            for(int next:map.get(now)){
                indegree[next]--;
                resultTimes[next]=Math.max(resultTimes[now]+times[next],resultTimes[next]);
                if(indegree[next]==0){
                    q.offer(next);
                }
            }
        }
    }
}
