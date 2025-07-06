import java.util.*;
import java.io.*;
public class Main {
    private static int N;
    private static int K;
    private static StringTokenizer st;
    private static int[] map;
    private static int[] prev;
    private static boolean[] visited;
    private static Queue<Integer> q=new LinkedList<>();
    private static int[] move=new int[]{1,-1};
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        int size=Math.max(N,K)*2+1;
        map=new int[size];
        visited=new boolean[size];
        prev=new int[size];
        visited[N]=true;
        q.offer(N);

        while(!q.isEmpty()){
            int now=q.poll();
            if(now==K) break;
            for(int i=0;i<2;i++){
                int newPosition=now+move[i];
                if(newPosition>=0 && newPosition<size && !visited[newPosition]){
                    q.offer(newPosition);
                    visited[newPosition]=true;
                    map[newPosition]=map[now]+1;
                    prev[newPosition]=now;
                }
            }
            int newPosition = now*2;
            if(newPosition>=0 && newPosition<size && !visited[newPosition]){
                q.offer(newPosition);
                visited[newPosition]=true;
                map[newPosition]=map[now]+1;
                prev[newPosition]=now;
            }
        }
        Stack<Integer> stack=new Stack<>();
        for(int i=K;i!=N;i=prev[i]){
            stack.push(i);
        }
        stack.push(N);

        System.out.print(map[K]+"\n");
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
