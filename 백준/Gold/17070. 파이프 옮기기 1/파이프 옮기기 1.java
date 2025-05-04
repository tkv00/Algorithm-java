import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static class Pipe{
        int row1;
        int col1;
        int row2;
        int col2;
        int state;
        //0 : 가로 1 : 세로 2 : 대각
        Pipe(int row1,int col1,int row2,int col2,int state){
            this.row1=row1;
            this.col1=col1;
            this.row2=row2;
            this.col2=col2;
            this.state=state;
        }
    }
    private static int N;
    private static StringTokenizer st;
    private static int[][] map;
    private static int result=0;
    //파이프 상태관리
    private static boolean isValid(int row,int col){
        if(row<0 || row>=N || col<0 || col>=N || map[row][col]==1)
            return false;
        return true;
    }
    //오른쪽 경계
    private static boolean rightValid(int row2,int col2){
        if(isValid(row2,col2+1))
            return true;
        return false;
    }

    //아래 경계
    private static boolean downValid(int row2,int col2){
        if(isValid(row2+1,col2))
            return true;
        return false;
    }
    //대각 경계
    private static boolean crossValid(int row2,int col2){
        if(isValid(row2+1,col2) && isValid(row2+1,col2+1)&&isValid(row2,col2+1))
            return true;
        return false;
    }
    private static void dfs(Pipe pipe){
        if(pipe.row2==N-1 && pipe.col2==N-1){
            result++;
            return;
        }

        int state=pipe.state;
        switch(state){
            //가로
            case 0:
                if(rightValid(pipe.row2,pipe.col2)){
                    dfs(new Pipe(pipe.row1,pipe.col1+1,pipe.row1,pipe.col2+1,0));
                } if(crossValid(pipe.row2,pipe.col2))   {
                    dfs(new Pipe(pipe.row2,pipe.col2,pipe.row2+1,pipe.col2+1,2));
                }
                break;
                //세로
            case 1:
                if(downValid(pipe.row2,pipe.col2)){
                    dfs(new Pipe(pipe.row2,pipe.col2,pipe.row2+1,pipe.col2,1));
                } if(crossValid(pipe.row2,pipe.col2)){
                    dfs(new Pipe(pipe.row2,pipe.col2,pipe.row2+1,pipe.col2+1,2));
                }
                break;
            case 2:
                if(rightValid(pipe.row2,pipe.col2)){
                    dfs(new Pipe(pipe.row2,pipe.col2,pipe.row2,pipe.col2+1,0));
                } if(downValid(pipe.row2,pipe.col2)){
                    dfs(new Pipe(pipe.row2,pipe.col2,pipe.row2+1,pipe.col2,1));
                } if(crossValid(pipe.row2,pipe.col2)){
                    dfs(new Pipe(pipe.row2,pipe.col2,pipe.row2+1,pipe.col2+1,2));
                }
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        Pipe pipe=new Pipe(0,0,0,1,0);
        dfs(pipe);

        System.out.print(result);
    }
}
