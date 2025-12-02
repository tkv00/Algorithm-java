import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N,M;
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int[] indegree;
    private static StringBuilder sb;
    private static Map<Integer, List<Integer>> map;
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        map=new HashMap<>();
        sb=new StringBuilder();

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        indegree=new int[N+1];

        for (int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());

            int studentA=Integer.parseInt(st.nextToken());
            int studentB=Integer.parseInt(st.nextToken());

            indegree[studentB]++;
            map.putIfAbsent(studentA,new ArrayList<>());
            map.get(studentA).add(studentB);
        }
    }

    private static void operation(){
        Queue<Integer> q=new LinkedList<>();

        for (int i=1;i<=N;i++){
            if (indegree[i]==0) q.offer(i);
        }

        while(!q.isEmpty()){
            int now=q.poll();
            sb.append(now).append(" ");

            if (!map.containsKey(now)) continue;

            for (int next:map.get(now)){
                indegree[next]--;
                if (indegree[next]==0){
                    q.offer(next);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        init();
        operation();

        System.out.println(sb);
    }
}
