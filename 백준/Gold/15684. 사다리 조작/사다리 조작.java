import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N,M;//N : 세로선  M : 가로선
    private static int H;
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int[] nowArr;
    private static int[][] map;
    private static int min=Integer.MAX_VALUE;
    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        N=Integer.parseInt(input.split(" ")[0]);
        M=Integer.parseInt(input.split(" ")[1]);
        H=Integer.parseInt(input.split(" ")[2]);
        map=new int[H+1][N+1];

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());

            //가로선 정보
            int a=Integer.parseInt(st.nextToken());
            //연결 번호
            int b=Integer.parseInt(st.nextToken());
            //왼쪽->오른쪽 연결
            map[a][b]=1;
            //오른쪽->왼쪽 연결
            map[a][b+1]=2;
        }

    }
    //사다리 타기
    private static boolean simulation(){
        nowArr=new int[N+1];
        for(int i=1;i<=N;i++){
            nowArr[i]=i;
        }
        //1번부터 N번까지 차례대로 사다리 타기 시작.
        for(int i=1;i<=H;i++){
            for(int j=1;j<=N;j++){
                //left -> right
                if(map[i][j]==1){
                    int temp=nowArr[j];
                    nowArr[j]=nowArr[j+1];
                    nowArr[j+1]=temp;
                }
            }
        }

        return isEnd(nowArr);
    }

    private static boolean isEnd(int[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=i) return false;
        }
        return true;
    }

    //DFS
    private static void DFS(int cnt,int row,int col){
        if(cnt>=min) return;
        //중단 조건 : 다 제자리로 도착하는 경우
        if(simulation()){
            min=cnt;
            return;
        }

        if(cnt==3){
            return;
        }


        for(int i=row;i<=H;i++){
            for(int j=(i==row ? col : 1);j<N;j++){
                if(map[i][j]==0 && map[i][j+1]==0){
                    map[i][j]=1;
                    map[i][j+1]=2;
                    DFS(cnt+1,i,j+2);
                    map[i][j]=0;
                    map[i][j+1]=0;
                }
            }

        }


    }
    public static void main(String[] args) throws IOException {
        init();
        simulation();
        DFS(0,1,1);

        System.out.print(min == Integer.MAX_VALUE ? -1 : min);
    }
}
