import java.io.*;
import java.util.*;
public class Main {
    private static int N;
    private static int R;
    private static int Q;
    private static StringTokenizer st;
    private static boolean[] visited;
    private static int[] cnt;
    private static HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        Q=Integer.parseInt(st.nextToken());

        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine());
            int first=Integer.parseInt(st.nextToken());
            int second=Integer.parseInt(st.nextToken());

            map.putIfAbsent(first,new ArrayList<>());
            map.putIfAbsent(second,new ArrayList<>());

            map.get(first).add(second);
            map.get(second).add(first);
        }

        cnt=new int[N+1];
        visited=new boolean[N+1];
        StringBuilder sb=new StringBuilder();
        DFS(R);

        for(int i=0;i<Q;i++){
            int q=Integer.parseInt(br.readLine());
            sb.append(cnt[q]).append("\n");
        }

        System.out.print(sb);
    }

    private static int DFS(int now){
        cnt[now]=1;
        visited[now]=true;

        ArrayList<Integer> list=map.get(now);
        for(int i:list){
            if(!visited[i]){
                cnt[now]+=DFS(i);
            }
        }
        return cnt[now];
    }
}
