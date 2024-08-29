import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class CCTV {
        int row;
        int col;
        int type;
        CCTV(int row, int col, int type) {
            this.row = row;
            this.col = col;
            this.type = type;
        }
    }
    static int row;
    static int col;
    static int[][] map;
    static StringTokenizer st;
    static int res = Integer.MAX_VALUE;
    static int[] dx = {0, 1, 0, -1};//우하좌상
    static int[] dy = {1, 0, -1, 0};//우하좌상
    static List<CCTV> cctvList;
    static int[][] directions = {
            {},//0번
            {0},//1번 cctv
            {0, 2},//2 cctv
            {0, 3},//3 cctv
            {0, 2, 3},//4 cctv
            {0, 1, 2, 3}// 5 cctv
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        cctvList = new ArrayList<>();
        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                //cctv라면
                if (map[i][j] > 0 && map[i][j] <= 5) {
                    cctvList.add(new CCTV(i, j, map[i][j]));
                }
            }
        }
        dfs(0,map);
        System.out.println(res);
    }
    static void dfs(int count, int[][] map) {
        if (count == cctvList.size()) {
            res = Math.min(res, getResult(map));
            return;
        }
        //cctv위치
        int cctvRow = cctvList.get(count).row;
        int cctvCol = cctvList.get(count).col;
        int type = cctvList.get(count).type;
        //4방향 0 90 180 270
        for (int i = 0; i < 4; i++) {
            int[][] copy = copyArr(map);
            for (int move : directions[type]) {
                int newRow = cctvRow;
                int newCol = cctvCol;
                int newDir = (move + i) % 4;
                while (true) {
                    newRow += dx[newDir];
                    newCol += dy[newDir];
                    if (!isValid(newRow,newCol))break;
                    copy[newRow][newCol]=-1;
                }
            }
            dfs(count+1,copy);
        }
    }
    //사각 지대 구하는 함수
    static int getResult(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 0) {
                    sum += 1;
                }
            }
        }
        return sum;
    }
    //배열 깊은 복사
    static int[][] copyArr(int[][] arr) {
        int[][] newArr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }
    //경계검사 함수
    static boolean isValid(int x, int y) {
        if (x < 0 || x >= row) return false;
        if (y < 0 || y >= col) return false;
        //벽
        if (map[x][y] == 6) return false;
        return true;
    }
}