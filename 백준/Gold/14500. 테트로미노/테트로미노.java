import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int [][] map;
    static StringTokenizer st;
    static boolean[][]visited;
    static int[]dx={1,-1,0,0};
    static int[]dy={0,0,1,-1};
    static int res=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        visited=new boolean[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                visited[i][j]=true;
                dfs(j,i,1,map[i][j]);
                visited[i][j]=false;
            }
        }
        System.out.println(res);


    }
     static void dfs(int x,int y,int depth,int hap){
        if(depth==4){
            res=Math.max(res,hap);
            return;
        }
        for(int i=0;i<4;i++){
            int newx=x+dx[i];
            int newy=y+dy[i];
            if((newx>=0 && newx<M)&&(newy>=0 && newy<N)&&!visited[newy][newx]){
                //ㅗ모양 탐색
                if(depth==2){
                    visited[newy][newx]=true;
                    dfs(x,y,depth+1,hap+map[newy][newx]);
                    visited[newy][newx]=false;
                }

                visited[newy][newx]=true;
                dfs(newx,newy,depth+1,hap+map[newy][newx]);
                visited[newy][newx]=false;
            }
        }
    }
}
