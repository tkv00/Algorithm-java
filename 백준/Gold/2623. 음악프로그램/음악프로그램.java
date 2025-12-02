
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N,M;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static Queue<Integer> q;
    private static Map<Integer, List<Integer>> graph;
    private static int[] indegree;
    private static StringBuilder sb;
    private static int count=0;
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        q=new LinkedList<>();
        sb=new StringBuilder();

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        indegree=new int[N+1];
        graph=new HashMap<>();


        for (int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int num=Integer.parseInt(st.nextToken());
            int[] inputs=new int[num];

            for (int j=0;j<num;j++){
                inputs[j]=Integer.parseInt(st.nextToken());
                if (j>0){
                    indegree[inputs[j]]++;
                }
            }

            for (int j=0;j<num-1;j++){
                graph.putIfAbsent(inputs[j],new ArrayList<>());
                graph.get(inputs[j]).add(inputs[j+1]);
            }
        }
    }

    private static void operation(){
        for (int i=1;i<=N;i++){
            if (indegree[i]==0) q.offer(i);
        }

        while(!q.isEmpty()){
            int now=q.poll();
            count++;
            sb.append(now).append("\n");

            if (!graph.containsKey(now)) continue;
            for (int next:graph.get(now)){
                indegree[next]--;
                if (indegree[next]==0) q.offer(next);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        init();
        operation();
        if (count!=N){
            System.out.println(0);
            System.exit(0);
        }
        System.out.println(sb);
    }
}
