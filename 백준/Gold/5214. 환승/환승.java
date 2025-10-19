

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N,K,M;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[] visited;
    private static Queue<Integer> q;
    private static Map<Integer, List<Integer>> graph;

    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        graph=new HashMap<>();
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        visited=new int[N+1+M];
        q=new LinkedList<>();

        for (int i=1;i<=N+M;i++){
            graph.putIfAbsent(i,new ArrayList<>());
        }

        for (int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());

            for (int j=1;j<=K;j++){
                int num=Integer.parseInt(st.nextToken());
                graph.get(N+i+1).add(num);
                graph.get(num).add(N+i+1);
            }

        }

    }


    private static void operation(){
        visited[1]=1;
        q.offer(1);

        while (!q.isEmpty()){
            int now=q.poll();

            for (int next:graph.get(now)){
                if (visited[next]==0){
                    visited[next]=visited[now]+1;
                    q.offer(next);
                }
            }
        }
    }
    //N:역 개수 / K:서로 연결된 역 개수 / M:하이퍼튜브 개수
    public static void main(String[] args) throws IOException {
        init();
        operation();
        //System.out.println(Arrays.toString(visited));
        System.out.println(visited[N] == 0 ? -1 : visited[N]/2+1);
    }
}
