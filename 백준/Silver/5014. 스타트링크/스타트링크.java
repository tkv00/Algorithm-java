import java.util.*;
import java.io.*;
public class Main {
    private static int F,S,G,U,D;
    private static boolean[] visited;
    private static int[] map;
    private static int[] move;
    private static int cnt=0;
    private static Queue<Integer> q=new LinkedList<>();
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        F=Integer.parseInt(st.nextToken());
        S=Integer.parseInt(st.nextToken());
        G=Integer.parseInt(st.nextToken());
        U=Integer.parseInt(st.nextToken());
        D=Integer.parseInt(st.nextToken());

        if(S==G){
            System.out.print(0);
            return;
        }
        visited=new boolean[F+1];
        move=new int[]{U,-D};
        map=new int[F+1];
        //0층과 현재위치 방문 표시
        visited[0]=true;
        visited[S]=true;
        q.offer(S);

        while(!q.isEmpty()){
            int now=q.poll();
            for(int i=0;i<2;i++){
                int newLocation=now+move[i];
                if(newLocation>0 && newLocation<=F && !visited[newLocation]){
                    map[newLocation]=map[now]+1;
                    visited[newLocation]=true;
                    q.offer(newLocation);
                }
            }
        }
        if(map[G]==0){
            System.out.print("use the stairs");
            return;
        }
        System.out.print(map[G]);
    }
}
