import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N,M;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static char[][] map;
    private static final String DONT="TT";
    private static boolean[][]visited;
    private static int[] dx=new int[]{0,0,1,-1};
    private static int[] dy=new int[]{1,-1,0,0};
    private static int meetCount;
    private static Queue<int[]> q;
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        q=new LinkedList<>();
        meetCount=0;

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new char[N][M];
        visited=new boolean[N][M];

        for (int i=0;i<N;i++){
            String input=br.readLine();
            map[i]=input.toCharArray();
            for (int j=0;j<M;j++){
                if(map[i][j]=='I') {
                    q.offer(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
        }
    }

    private static void BFS(){
       while (!q.isEmpty()){
           int[] now=q.poll();

           for (int d=0;d<4;d++){
               int nr=now[0]+dx[d];
               int nc=now[1]+dy[d];

               if (nr <0 || nr>=N || nc<0 || nc>=M || visited[nr][nc]) continue;
               if (map[nr][nc]=='X') continue;

               q.offer(new int[]{nr,nc});
               visited[nr][nc]=true;

               if (map[nr][nc]=='P') meetCount++;
           }
       }

    }
    public static void main(String[] args) throws IOException {
        init();
        BFS();

        System.out.println(meetCount == 0 ? DONT : meetCount);
    }
}
