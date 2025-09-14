import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][]map;
    private static int[][] distMap;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int N;
    private static int min=Integer.MAX_VALUE;
    private static int[] dx=new int[]{0,0,1,-1};
    private static int[] dy=new int[]{1,-1,0,0};

    //섬 구분하기
    private static void divideMap(){
        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[N][N];
        int divide=-1;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==1){
                    q.offer(new int[]{i,j});
                    visited[i][j]=true;
                    map[i][j]=divide;

                    while(!q.isEmpty()){
                        int[] now=q.poll();
                        for(int d=0;d<4;d++){
                            int nx=now[0]+dx[d];
                            int ny=now[1]+dy[d];
                            if(isValid(nx,ny) && !visited[nx][ny] && map[nx][ny]==1){
                                q.offer(new int[]{nx,ny});
                                visited[nx][ny]=true;
                                map[nx][ny]=divide;
                            }
                        }
                    }
                    divide--;
                }
            }
        }
    }

    //섬 거리 측정
    private static void calculate(){
        Queue<int[]> q=new LinkedList<>();
        int cnt=Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]<0){
                    int value=map[i][j];
                    distMap=new int[N][N];
                    q.offer(new int[]{i,j});
                    //섬 1개씩 탐색.

                    while(!q.isEmpty()){
                        int[] now=q.poll();
                        for(int d=0;d<4;d++){
                            int nx=now[0]+dx[d];
                            int ny=now[1]+dy[d];

                            //다른 섬에 도달한 경우
                            if(isValid(nx,ny) && map[nx][ny]<0 && map[nx][ny]!=value){
                                cnt=Math.min(cnt,distMap[now[0]][now[1]]);
                            }
                            if(isValid(nx,ny) && distMap[nx][ny]==0 && map[nx][ny]!=value){
                                distMap[nx][ny]=distMap[now[0]][now[1]]+1;
                                q.offer(new int[]{nx,ny});
                            }
                        }
                    }
                    min=Math.min(min,cnt);
                }
            }
        }
    }
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];

        input();
    }

    private static void input() throws IOException {
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
    }

    private static boolean isValid(int row,int col){
        return row>=0 && row<N && col>=0 && col<N;
    }

    public static void main(String[] args) throws IOException {
        init();
        divideMap();
        calculate();

        System.out.print(min);
    }
}
