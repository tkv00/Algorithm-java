import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   private static int N;
   private static int M;
   private static int startRow;
   private static int startCol;
   private static int startDir;
   /*
   * 0 : 북쪽
   * 1 : 동쪽
   * 2 : 남쪽
   * 3 : 서쪽
   * */
    private static int[] dx=new int[]{0,1,0,-1};
    private static int[] dy=new int[]{-1,0,1,0};
    private static int[][] map;
    private static int result=0;
    private static StringTokenizer st;
    //경계값 체크
    private static boolean isValid(int row,int col){
        if(row>=N || row<0 || col>=M || col<0 )
            return false;
        return true;
    }

    //빈 칸 체크
    private static boolean isEmpty(int row,int col){
        for(int i=0;i<4;i++){
            int newRow=row+dy[i];
            int newCol=col+dx[i];

            if(isValid(newRow,newCol)&&map[newRow][newCol]==0){
                return true;
            }
        }
        return false;
    }

    private static void cleanRoom(int row,int col,int dir){
        //현재 칸이 아직 청소되지 않은 경우 -> 청소
        if(map[row][col]==0){
            result++;
            map[row][col]=2;
        }
        //4칸에 빈 칸이 없는 경우
        if(!isEmpty(row,col)){
            //후진하는 경우
            int backRow=row+dy[(dir+2)%4];
            int backCol=col+dx[(dir+2)%4];
            //후진 가능
            if(isValid(backRow,backCol)&&map[backRow][backCol]!=1){
                cleanRoom(backRow,backCol,dir);
            }
        }
        //4칸에 빈 칸이 있는 경우
        else {
            int newDir=(dir+3)%4;
            int newRow=row+dy[newDir];
            int newCol=col+dx[newDir];
            if(isValid(newRow,newCol) && map[newRow][newCol]==0){
                cleanRoom(newRow,newCol,newDir);
            }else{
                cleanRoom(row,col,newDir);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];

        st=new StringTokenizer(br.readLine());
        startRow=Integer.parseInt(st.nextToken());
        startCol=Integer.parseInt(st.nextToken());
        startDir=Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        cleanRoom(startRow,startCol,startDir);

        System.out.print(result);

    }
}
