import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static List<Integer>[] graph;
    private static List<Integer> result;
    private static int[] score;
    private static StringBuilder sb;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb=new StringBuilder();

        graph = new List[N + 1];
        score = new int[N + 1];
        result=new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        while (true) {
            st = new StringTokenizer(br.readLine());

            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            if (p1 == -1 && p2 == -1) break;

            graph[p1].add(p2);
            graph[p2].add(p1);
        }
    }

    private static void search() {
        for (int standard = 1; standard <= N; standard++) {
            boolean[] visited = new boolean[N + 1];
            visited[standard] = true;
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{standard,0});
            int dis=0;

            while (!q.isEmpty()) {
                int []now = q.poll();
                dis=Math.max(dis,now[1]);

                for (int next : graph[now[0]]) {
                    if (visited[next]) continue;

                    q.offer(new int[]{next,now[1]+1});
                    visited[next]=true;
                }
            }

            score[standard]=dis;
        }
    }

    private static void result(){
        int min=Integer.MAX_VALUE;

        for (int i=1;i<=N;i++){
            min=Math.min(min,score[i]);
        }
        sb.append(min).append(" ");


        for (int i=1;i<=N;i++){
            if (min==score[i]){
                result.add(i);
            }
        }

        sb.append(result.size()).append("\n");

        for (int x:result){
            sb.append(x).append(" ");
        }
    }
    public static void main(String[] args) throws IOException {
        init();
        search();
        result();

        System.out.println(sb);
    }
}
