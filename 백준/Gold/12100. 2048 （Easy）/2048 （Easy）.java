import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int MOVE = 5;
    private static int N;
    private static int[][] map;
    private static StringTokenizer st;
    private static BufferedReader br;
    private static int result = Integer.MIN_VALUE;

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    /*
     * 왼쪽 이동
     */
    private static int[][] moveLeft(int[][]map) {
        //왼쪽으로 밀기
        for (int row=0;row<N;row++){
            int targetCol=0;
            for (int col=0;col<N;col++){
                if (map[row][col]!=0){
                    int value=map[row][col];
                    map[row][col]=0;
                    map[row][targetCol]=value;
                    targetCol++;
                }
            }
        }

        //숫자 합치기
        for (int row=0;row<N;row++){
            for (int col=0;col<N-1;){
                if (map[row][col]==map[row][col+1] && map[row][col]!=0){
                    map[row][col]*=2;
                    map[row][col+1]=0;
                    col+=2;
                }else
                    col++;
            }
        }

        //왼쪽으로 밀기
        for (int row=0;row<N;row++){
            int targetCol=0;
            for (int col=0;col<N;col++){
                if (map[row][col]!=0){
                    int value=map[row][col];
                    map[row][col]=0;
                    map[row][targetCol]=value;
                    targetCol++;
                }
            }
        }

        return map;
    }

    /**
     * 오른쪽 이동
     */
    private static int[][] moveRight(int[][]map) {
       //오른쪽이동
        for (int row=0;row<N;row++){
            int targetCol=N-1;
            for (int col=N-1;col>=0;col--){
                if (map[row][col]!=0){
                    int value=map[row][col];
                    map[row][col]=0;
                    map[row][targetCol]=value;
                    targetCol--;
                }
            }
        }

        //숫자 합치기
        for (int row=0;row<N;row++){
            for (int col=N-1;col>0;){
                if (map[row][col]==map[row][col-1] && map[row][col]!=0){
                    map[row][col]*=2;
                    map[row][col-1]=0;
                    col-=2;
                }else {
                    col--;
                }

            }
        }

        for (int row=0;row<N;row++){
            int targetCol=N-1;
            for (int col=N-1;col>=0;col--){
                if (map[row][col]!=0){
                    int value=map[row][col];
                    map[row][col]=0;
                    map[row][targetCol]=value;
                    targetCol--;
                }
            }
        }
        return map;
    }

    /**
     * 위로 이동
     */
    private static int[][] moveUp(int[][] map) {
        //빈 칸 없이 위로 쭉 밀기
        for (int col = 0; col < N; col++) {
            int targetRow=0;
            for (int row = 0; row < N; row++) {
                if (map[row][col] != 0) {
                    int value=map[row][col];
                    map[row][col]=0;
                    map[targetRow][col]=value;
                    targetRow++;
                }
            }
        }


        //숫자 합치기
        for (int col = 0; col < N; col++) {
            for (int row = 0; row < N - 1; ) {
                if (map[row][col] == map[row + 1][col] && map[row][col]!=0) {
                    map[row][col] *= 2;
                    map[row + 1][col] = 0;
                    row += 2;
                }else {
                    row++;
                }

            }
        }

        //다시 이동
        for (int col = 0; col < N; col++) {
            int targetRow=0;
            for (int row = 0; row < N; row++) {
                if (map[row][col] != 0) {
                    int value=map[row][col];
                    map[row][col]=0;
                    map[targetRow][col]=value;
                    targetRow++;
                }
            }
        }
        return map;
    }

    /**
     * 아래로 이동
     */
    private static int[][] moveDown(int[][] map) {
        //아래로 쭉밀기
        for (int col=0;col<N;col++){
            int targetRow=N-1;
            for (int row=N-1;row>=0;row--){
                if (map[row][col]!=0){
                    int value=map[row][col];
                    map[row][col]=0;
                    map[targetRow][col]=value;
                    targetRow--;
                }
            }
        }

        //숫자 합치기
        for (int col = 0; col < N; col++) {
            for (int row = N-1; row >0;) {
                if (map[row][col] == map[row - 1][col] && map[row][col]!=0) {
                    map[row][col] *= 2;
                    map[row - 1][col] = 0;
                    row -= 2;
                }else {
                    row--;
                }

            }
        }

        //다시 이동
        for (int col=0;col<N;col++){
            int targetRow=N-1;
            for (int row=N-1;row>=0;row--){
                if (map[row][col]!=0){
                    int value=map[row][col];
                    map[row][col]=0;
                    map[targetRow][col]=value;
                    targetRow--;
                }
            }
        }
        return map;
    }

    //가장 큰 블럭
    private static int maxValue(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                max = Math.max(max, arr[i][j]);
            }
        }
        return max;
    }



    private static void DFS(int depth, int[][] arr) {
        if (depth == MOVE) {
            result = Math.max(result, maxValue(arr));
            return;
        }

        //왼쪽 이동
        int[][] leftMap=copy(arr);
        leftMap=moveLeft(leftMap);
        DFS(depth+1,leftMap);

        //오른쪽 이동
        int[][] rightMap=copy(arr);
        rightMap=moveRight(rightMap);
        DFS(depth+1,rightMap);

        //위 이동
        int[][] upMap=copy(arr);
        upMap=moveUp(upMap);
        DFS(depth+1,upMap);

        //아래 이동
        int[][] downMap=copy(arr);
        downMap=moveDown(downMap);
        DFS(depth+1,downMap);
    }

    private static int[][] copy(int[][]arr){
        int[][] copy=new int[N][N];
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                copy[i][j]=arr[i][j];
            }
        }
        return copy;
    }

    public static void main(String[] args) throws IOException {
        init();
        DFS(0,map);
        System.out.println(result);
    }
}
