import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N,M,K;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[][] map;
    private static int[] dr=new int[]{0,0,1,-1};
    private static int[] dc=new int[]{1,-1,0,0};
    private static boolean[][][] visited;

    private static boolean isValid(int row,int col){
        return row>=0 && row<N && col>=0 && col<M ;
    }

    private static int BFS(){
        ArrayDeque<int[]> q=new ArrayDeque<>();
        q.offer(new int[]{0,0,K,1});
        visited[0][0][K]=true;

        while (!q.isEmpty()){
            int[] now=q.poll();

            //중단 조건
            if(now[0]==N-1 && now[1]==M-1){
                return now[3];
            }

            for (int i=0;i<4;i++){
                int nr=now[0]+dr[i];
                int nc=now[1]+dc[i];

                if(!isValid(nr,nc)) continue;
                if(visited[nr][nc][now[2]]) continue;

                //벽이 없는 경우
                if(map[nr][nc]==0){
                    q.offer(new int[]{nr,nc,now[2],now[3]+1});
                    visited[nr][nc][now[2]]=true;
                }
                //벽이 있는 경우
                else if (now[2]>0 && !visited[nr][nc][now[2]-1]){
                    q.offer(new int[]{nr,nc,now[2]-1,now[3]+1});
                    visited[nr][nc][now[2]-1]=true;
                }
            }
        }
        return -1;
    }

    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        map=new int[N][M];

        for (int i=0;i<N;i++){
            String str=br.readLine();
            for (int j=0;j<M;j++){
                map[i][j]=str.charAt(j)-'0';
            }
        }

        visited=new boolean[N][M][K+1];
    }
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(BFS());
    }
}
