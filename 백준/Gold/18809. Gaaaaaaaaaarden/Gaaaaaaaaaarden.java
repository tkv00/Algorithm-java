import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N,M,G,R;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int[][] initMap;
    private static int max;
    private static final int NONE=0,GREEN=1,RED=2;
    //G : 초록색 배양액 개수 / R : 빨간색 배양액 개수
    //최대 꽃의 개수

    private static int[] dy=new int[]{1,-1,0,0};

    //배양액 뿌리는 모든 경우의 수
    private static int[] dx=new int[]{0,0,1,-1};

    //배양액 지도
    private static boolean[][] redMap;
    private static boolean[][] greenMap;
    private static Queue<Point> totalQ;

    private static class Point{
        int row;
        int col;
        int color;
        int time;

        Point(int row,int col,int color,int time){
            this.row=row;
            this.col=col;
            this.color=color;
            this.time=time;
        }
    }

    //배양액 뿌릴 수 있는 좌표
    private static List<int[]> list=new ArrayList<>();

    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        G=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());

        initMap=new int[N][M];
        redMap=new boolean[N][M];
        greenMap=new boolean[N][M];

        max=0;

        //0 : 호수 / 1 : 배양액을 뿌릴 수 없는 땅 / 2 : 배양액 뿌릴 수 있는 땅.
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                initMap[i][j]=Integer.parseInt(st.nextToken());
                if(initMap[i][j]==2) list.add(new int[]{i,j});
            }
        }

    }

    private static boolean isValid(int row,int col){
        return row>=0 && row<N && col>=0 && col<M && initMap[row][col]!=0;
    }


    private static int simulation(){
        boolean[][] flowerMap=new boolean[N][M];
        int[][] colorMap=new int[N][M];
        int[][] timeMap=new int[N][M];
        for(int i=0;i<N;i++){
            Arrays.fill(timeMap[i],-1);
        }

        int cnt=0;

        totalQ=new LinkedList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                //녹색 배양액 위치 담기
                if(greenMap[i][j]) {
                    //행,열,color,time
                    totalQ.offer(new Point(i,j,GREEN,0));
                    colorMap[i][j]=1;
                    timeMap[i][j]=0;
                }
                //빨간색 배양액 위치 담기
                if(redMap[i][j]){
                    totalQ.offer(new Point(i,j,RED,0));
                    colorMap[i][j]=2;
                    timeMap[i][j]=0;
                }
            }
        }


        while(!totalQ.isEmpty()){
            Point now=totalQ.poll();

            if(flowerMap[now.row][now.col]) continue;

            for(int d=0;d<4;d++){
                int nx=now.row+dx[d];
                int ny=now.col+dy[d];

                if(!isValid(nx,ny)) continue;

                //아직 방문하지 않은 경우
                if(timeMap[nx][ny]==-1){
                    int nextTime=now.time+1;
                    timeMap[nx][ny]=nextTime;
                    colorMap[nx][ny]=now.color;
                    totalQ.offer(new Point(nx,ny,now.color,nextTime));
                }
                //이미 방문한 경우
                else if(now.time+1==timeMap[nx][ny] && 
                        (colorMap[nx][ny]!=NONE &&colorMap[nx][ny]!=now.color)){
                    //꽃이 생성되는 경우 :  그린과 레드가 만나야함 + 시간이 동일해야함.
                    if(!flowerMap[nx][ny]){
                        cnt++;
                        flowerMap[nx][ny]=true;
                    }
                }
            }
        }
        return cnt;
    }

    private static void backTracking(int idx,int redCnt,int greenCnt){

        if(redCnt==R && greenCnt==G){
            //시뮬레이션 시작.
            max=Math.max(max,simulation());
            return;
        }
        if(idx>list.size()-1) return;

        int[] now=list.get(idx);

        //1.Red 배양액 뿌리는 경우
        redMap[now[0]][now[1]]=true;
        backTracking(idx+1,redCnt+1,greenCnt);
        redMap[now[0]][now[1]]=false;

        //2.Green 배양액 뿌리는 경우
        greenMap[now[0]][now[1]]=true;
        backTracking(idx+1,redCnt,greenCnt+1);
        greenMap[now[0]][now[1]]=false;

        //3.아무것도 안뿌리는 경우
        backTracking(idx+1,redCnt,greenCnt);
    }
    public static void main(String[] args) throws IOException {
        init();
        backTracking(0,0,0);
        System.out.print(max);
    }
}
