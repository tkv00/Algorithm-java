import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public  static StringBuilder res=new StringBuilder();
    public static int s;

    public static int TestCase;
    public static boolean [][]check;
    public static int[][] map;
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        TestCase=Integer.parseInt(br.readLine());


        check=new boolean[TestCase][TestCase];

        for(int i=0;i<TestCase;i++){
            Queue<int []>queue=new LinkedList<>();
            int sum=0;
            s=Integer.parseInt(br.readLine());
            map=new int[s][s];
            check=new boolean[s][s];

            st=new StringTokenizer(br.readLine());
            int nowX= Integer.parseInt(st.nextToken());
            int nowY=Integer.parseInt(st.nextToken());

            st=new StringTokenizer(br.readLine());
            int nextX=Integer.parseInt(st.nextToken());
            int nextY=Integer.parseInt(st.nextToken());

            sum=bfs(nowX,nowY,queue,nextX,nextY);
            res.append(sum).append('\n');


        }
        System.out.println(res);

    }
    public static int bfs(int x, int y, Queue<int[]> q, int endx, int endy){

        int []xy={x,y};
        q.add(xy);
        check[x][y]=true;
        map[x][y]=0;
        int []dx={1,2,2,1,-1,-2,-2,-1};
        int []dy={2,1,-1,-2,-2,-1,1,2};

        while (!q.isEmpty()){
            int[] pre=q.poll();
            int preX=pre[0];
            int preY=pre[1];

            for(int i=0;i<8;i++){
                int nowX=preX+dx[i];
                int nowY=preY+dy[i];
                if((0<=nowX && nowX<s) &&(0<=nowY&&nowY<s)&&
                        (!check[nowX][nowY])){
                    q.add(new int[]{nowX,nowY});
                    check[nowX][nowY]=true;
                    map[nowX][nowY]=map[preX][preY]+1;
                    if(nowX==endx&&nowY==endy){
                        return map[nowX][nowY];
                    }

                }

            }
        }
        return map[endx][endy];

    }
    public static  void initialCheck(){

    }
}
