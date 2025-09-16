import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br;
    private static int[][] map;
    private static final int INF=9;
    private static void init() throws IOException {
        map=new int[INF][INF];
        br=new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<INF;i++){
            String input=br.readLine();
            for(int j=0;j<INF;j++){
                map[i][j]=Integer.parseInt(input.split("")[j]);
            }
        }
    }

    private static boolean isValid(int row,int col){
        return row>=0 && row<INF && col>=0 && col<INF;
    }

    private static boolean existSameValue(int[] arr,int value){
        for(int x:arr){
            if(x==value) return true;
        }
        return false;
    }

    //열 행렬 변환
    private static int[] getColArray(int col){
        int[] arr=new int[INF];
        for(int i=0;i<INF;i++){
            arr[i]=map[i][col];
        }

        return arr;
    }

    //3X3 박스 검사
    private static boolean isValid3By3Box(int row,int col,int value){
        int startRow=(row/3)*3;
        int startCol=(col/3)*3;

        for(int i=startRow;i<startRow+3;i++){
            for(int j=startCol;j<startCol+3;j++){
                if(value==map[i][j]) return true;
            }
        }
        return false;
    }

    private static void printMap(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<INF;i++){
            for(int j=0;j<INF;j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void backTracking(int row,int col){
        if(row==INF){
            printMap();
            System.exit(0);
        }

        if(col==INF){
            backTracking(row+1,0);
            return;
        }

        if(map[row][col]==0){
            for(int value=1;value<=INF;value++){
                if(isValid(row,col) &&
                   !existSameValue(map[row],value) &&
                   !existSameValue(getColArray(col),value) &&
                   !isValid3By3Box(row,col,value)){
                    map[row][col]=value;
                    backTracking(row,col+1);
                    map[row][col]=0;
                }
            }
        }else{
            backTracking(row,col+1);
        }

    }

    public static void main(String[] args) throws IOException {
        init();
        backTracking(0,0);
    }
}
