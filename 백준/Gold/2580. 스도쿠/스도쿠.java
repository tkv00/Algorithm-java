import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int SIZE=9;
    private static int[][] map;
    private static Queue<int[]> q;
    private static StringTokenizer st;
    private static BufferedReader br;

    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        map=new int[SIZE][SIZE];
        q=new LinkedList<>();

        for (int i=0;i<SIZE;i++){
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<SIZE;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if (map[i][j]==0) q.offer(new int[]{i,j});
            }
        }

    }

    private static void printMap(){
        for (int i=0;i<SIZE;i++){
            for (int j=0;j<SIZE;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void BruteForce(int row,int col){
        if (col==SIZE){
            BruteForce(row+1,0);
            return;
        }

        if (row==SIZE){
            printMap();
            System.exit(0);
        }

        if (map[row][col]==0){
            for (int num=1;num<=SIZE;num++){
                if (isValidOfRow(row,num) && isValidOfCol(col,num) && isValid3By3Array(row,col,num)){
                    map[row][col]=num;
                    BruteForce(row,col+1);
                }

            }
            map[row][col]=0;
            return;
        }

        BruteForce(row,col+1);
    }

    //세로 체크
    private static boolean isValidOfCol(int col,int num){
        for (int i=0;i<SIZE;i++){
            if (map[i][col]==num) return false;
        }
        return true;
    }
    //가로 체크
    private static boolean isValidOfRow(int row,int num){
        for (int i=0;i<SIZE;i++){
            if (map[row][i]==num) return false;
        }
        return true;
    }

    //3X3 체크
    private static boolean isValid3By3Array(int row,int col,int num){
        row=(row/3)*3;
        col=(col/3)*3;

        for (int i=row;i<row+3;i++){
            for (int j=col;j<col+3;j++){
                if (map[i][j]==num) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        init();
        BruteForce(0,0);
    }
}
