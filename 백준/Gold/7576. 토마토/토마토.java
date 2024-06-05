import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;

    public static int[][] array;
    public static boolean[][] visited;
    public static StringTokenizer st;
    public static Queue<int[]> queue=new LinkedList<>();

    public static int day = 0;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());

            }

        }

        for (int i = 0; i < M; i++) {

            for (int j = 0; j < N; j++) {
                if(array[i][j]==1){
                    visited[i][j]=true;
                    queue.add(new int[]{i,j});

                }
            }

        }
        if(isAll()){
            System.out.println(0);
            return;
        }
        bfs();
        if(!isAll()){
            System.out.println(-1);
        }  else{
            System.out.println(day-1);
        }
        //에제3,5 틀림.





    }

    public static void bfs() {


        while(!queue.isEmpty()){
            int []now=queue.poll();
            int preX=now[0];
            int preY=now[1];
            for(int i=0;i<4;i++){
                int new_x=preX+dx[i];
                int new_y=preY+dy[i];
                if((new_x>=0 && new_x<M) && (new_y>=0 && new_y<N)&&
                        (array[new_x][new_y]==0)&&(!visited[new_x][new_y])){
                    array[new_x][new_y]=array[preX][preY]+1;
                    day=Math.max(day,array[new_x][new_y]);

                    visited[new_x][new_y]=true;
                    queue.add(new int[]{new_x,new_y});


                }
            }
        }

    }

    //모두 다 익었는가
    public static boolean isAll(){
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(array[i][j]==0)
                    return false;
            }
        }
        return true;
    }

}
